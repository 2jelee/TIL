리액트 18v 변경점

Automatic Bathcing
Concurrent Feature
RSC

1. Automatic Bathcing

리액트 18부터 모든 업데이트(setState)를 하나로 묶고, 리렌더링한다.
기존에는 이벤트 핸들러 내부에서 발생하는 업데이트에 대한 배칭만 진행했다.

사실 기존 리액트 17에서도 자동 배칭은 있었다. 다음 코드에서 리액트는 자동 배칭하여 한 번만 리렌더링한다.


function App () {
    const [number, setNumber] = useState(0);
    const [toggle, setToggle] = useState(false);

    function onClickToggle () {
        // 딱 한 번 리렌더링~
        setNumber(prev => prev + 1);
        setToggle(prev => !prev);
    }

    return <button onClick={onClickToggle}>button</button>
}

그런데 만약 fetch 콜백을 받아 처리해야 하는 상황은 어떨까?


function App () {
    const [number, setNumber] = useState(0);
    const [toggle, setToggle] = useState(false);

    function onClickToggle () {
        fetchSomething().then(() => {
            // 한 번 리렌더링?
            setNumber(prev => prev + 1);
            setToggle(prev => !prev);
        });
    }

    return <button onClick={onClickToggle}>button</button>
}

이벤트 핸들러 내부에 있기 때문에 이것도 한 번만 렌더링 될까?


이 상황에서는 안타깝지만 자동 배칭이 적용되지 않는다. 기존 리액트 17버전의 자동 배칭은 이벤트 핸들러 내부의 콜백이 모두 완료된 후에는 실행되지 않는다. fetch()의 경우 이벤트 핸들러 콜백(스택)이 호출 완료된 후 실행되는 콜백(큐)이기 때문에 해당되지 않는 것이다.


그래서 리액트팀은 이번 18버전부터 모든 콜백에 자동 배칭을 적용시킬 수 있게 만들었다.


function App () {
    const [number, setNumber] = useState(0);
    const [toggle, setToggle] = useState(false);

    function onClickToggle () {
        fetchSomething().then(() => {
            // 17v은 2번 리렌더링, 18v부터는 1번 리렌더링.
            setNumber(prev => prev + 1);
            setToggle(prev => !prev);
        });
    }

    return <button onClick={onClickToggle}>button</button>
}

만약 콜백 함수 내에 두 가지 형태의 콜백이 같이 존재하면 어떨까? 이때는 딱 한 번 렌더링 될까 아니면 각각 총 2번 렌더링될까?


function onClickToggle () {
    // 1번째 리렌더링
    setNumber(prev => prev + 1);

    fetchSomething().then(() => {
        // 2번째 리렌더링
        setToggle(prev => !prev);
    });
}

답은 2번 리렌더링 된다. 자동 배칭 시스템은 기존 콜스택에서 태스크 큐까지로 범위를 넓혔을 뿐, 싸잡아서 렌더링하는 건 아니라는 사실~


배칭은 아주 안전하다고 한다. 다만, 배칭을 하고 싶지 않을 경우 flushSync()를 사용하면 된다.



react가 아니라 react-dom이다.



import { flushSync } from "react-dom"; // react-dom임.

function onClickToggle() {
  flushSync(() => {
    setNumber(prev => prev + 1);
  });
    // 업데이트 됨.
  flushSync(() => {
    setToggle(prev => !prev);
  });
    // 업데이트 됨.
}


2. Concurrent Feature

지금까지 Concurrent Mode라고 명명됐던 기능의 명칭이 feature로 바뀌면서 ‘동시성 기능’이 되었다.

2-0. createRoot

18버전을 뜯고 씹고 맛보고 즐기려면 createRoot API를 사용해야 한다. (그리고 18v 부터는 적극적으로 권장된다.)
왜 굳이 render 안쓰고 새로 만들었나 싶었다. 동시성을 지원하는 API라고 보면 된다.
자동 배칭도 createRoot API를 사용해야 한다.

2-1. startTransition

기존에 검색 결과 등에서 사용했던 setTimeout, Debounce ,Throttle 기능들을 대체할 수 있다.
일단 setTimeout과는 다르게 스케쥴링에 포함이 되지 않아 더 빠르다.
태스크큐 X, 즉시 실행되고 동기적이지만 리액트가 렌더링할때 transition으로 입력된 값을 활용한다.
useTransition의 경우, isPending 상태값을 받아 렌더링 결과를 분기 처리할 수 있다.
startTransition만 사용도 가능하다.

startTransition이 구현되면서, 검색시 API 요청 시 간격을 두는 것 기능을 손쉽게 만들 수 있게 됐다.


import { useTransition } from 'react';

const [isPending, startTransition] = useTransition();

function onChange(e) {
        const input = e.target.value;

        // 긴급 업데이트: 타이핑 결과를 보여준다.
        setInputValue(input);

        // 이 안의 모든 상태 업데이트는 전환 업데이트가 된다.
        startTransition(() => {
          // 전환 업데이트: 결과를 보여준다.
          setSearchQuery(input);
        });
}

<input onChange={onChange} />
<button disabled={isPending}>button</button> // 이렇게 하면 버튼을 두번 클릭하지 못하게 할 수 있음.

이 훅을 사용하면 isPending 값을 가져올 수 있고, 이를 활용해 로딩 중임을 표시하기도 수월하다. (특히 Suspense를 곁들이면 효과가 좋아 보인다.)


또, 최대 얼마까지 기다릴 것인지 timeoutMs로 설정이 가능하다. 다음 코드는 3초 동안 렌더링을 기다리다가 3초가 지나도 결과를 갖지 못한다면 강제로 렌더링된다.


const [isPending, startTransition] = useTransition({ timeoutMs: 3000 });

이 기능의 장점은 항상 일정한 시간을 기다려야 된다는 걸 없앴다는 점에 있다. 이제 완료가 되면 결과를 보여준다. 그러므로 사용자의 컴퓨터가 엄청 빠르면 결과도 엄청 빨리 서빙된다. 디바운스, 스로틀처럼 일정 시간을 기다릴 필요가 없어진다.


2-2. Suspense와 SSR 구조

기존 리액트에서의 SSR 구조는 다음과 같다. (like waterfall)
서버가 리액트 코드 가져옴 → HTML로 만듦 → 리액트가 HTML 받음 → hydrate (자바스크립트 붙이는 작업)
모든 데이터를 불러오고, html로 만들고 또 이걸 리액트로 내려보내야 하기 때문에 어느 지점에서 병목현상이 일어나면 (한없이) 느려지게 된다.
이걸 해결하고자 독립적으로 각각 렌더링할 수 있게 구조를 다시 짰다.

리액트 18부터 HTML 스트리밍 API와 Suspense를 연계해 SSR을 설계할 수 있다. 기존 방식의 단점을 해결하고자 참 고민이 많았던게 느껴진다.


여기서는 createRoot 가 아니라 hydrateRoot를 사용한다.


<Layout>
  <NavBar />
  <Sidebar />
  <RightPane>
    <Post />
    <Suspense fallback={<Spinner />}>
      <Comments />
    </Suspense>
  </RightPane>
</Layout>

서버에서는 renderToString 대신, pipeToNodeWritable로 HTML을 클라이언트로 스트리밍하고, Suspense로 선택적 hydration을 진행한다.



pipeToNodeWritable은 API의 이름이 아니므로 리액트의 문서를 확인하시길.



pipeToNodeWritable를 사용하면 Suspense로 감싸진 이외의 다른 HTML 파일들은 즉시 스트리밍되며 렌더링된다. 그 후 Comments 컴포넌트가 서버에서 렌더링되며 끝나게 된다. (렌더링 동안은 fallback이 렌더링 된다.)


Lazy 컴포넌트도 이제 서버 사이드가 가능해지면서, 코드 스플리팅도 지원된다. (귀찮게 load 머시기 안해도댐 ^^)


더 엄청난건, Suspense가 두개 이상 있을 때 나타난다. 일단 이미 서버로부터 HTML을 다 받았고, Suspense로 감싼 부분에 hydration은 아직 되지 않은 상태라고 가정해보자.


<Layout>
  <NavBar />
        // hydration 중
  <Suspense fallback={<Spinner />}>
    <Sidebar />
  </Suspense>
  <RightPane>
    <Post />
    // hydration 중
    <Suspense fallback={<Spinner />}>
      <Comments />
    </Suspense>
  </RightPane>
</Layout>

hydration은 동시에 일어나는게 아니라 비동기로 일어나는데, 위에서부터 순서대로 발견된 Suspense부터 처리한다.


그런데 만약 유저가 댓글을 너무 빨리 달고 싶어 댓글을 먼저 클릭한다면, 리액트는 이를 알아차리고 Comments부터 hydration을 처리한다.


Suspense가 어떻게 서버 요청을 기다리는지는 리액트가 알아서 판단한다. axios나 fetch같은 AJAX 통신을 자기가 알아서 파악하고 fallback을 출력한다.



3. React Server Component

이번 리액트의 핵심 개념
파일을 3개로 구성할 수 있다. .client.jsx, .server.jsx, .jsx

SSR과는 같은 개념이라 헷갈릴 수 있겠으나, 실은 SSR과는 근본적으로 다른 개념이다. 그 이유는 리액트 서버 컴포넌트는 HTML 파일을 가져오지 않고 JSON 형식의 데이터를 가져오기 때문이다.


RSC는 브라우저가 받아오는 용량을 줄이기 위해 서버에서 실행되는 컴포넌트이며 브라우저는 0kb로 이 컴포넌트를 불러올 수 있다.


또한 API를 사용하지않고 직접 DB에 접근 가능하며, 클라이언트 컴포넌트를 import할때면 dynamic하게 import할 수 있다. (코드 스플리팅) 또한 DB 접근 뿐만 아니라 API 요청을 fetch 할 수 있다.



이해하기 쉽게 설명하면 node.js로써 할 수 있는 역할을 한다고 보면 된다.



다음은 리액트 팀의 서버 컴포넌트 코드다.


// Note.server.js - Server Component import db from 'db.server';
// (A1) We import from NoteEditor.client.js - a Client Component.
import NoteEditor from 'NoteEditor.client';

function Note(props) {
    const {id, isEditing} = props;
    // (B) Can directly access server data sources during render, e.g. databases 
    const note = db.posts.get(id);
     return (
        <div>
                <h1>{note.title}</h1>
                <section>{note.body}</section>
                {/* (A2) Dynamically render the editor only if necessary */}
                    {isEditing ? <NoteEditor note={note} /> : null }
        </div>
        );
}

정리해 보자면 server component는 서버에게서 JSON 데이터를 받거나, 클라이언트단에서 하기 부담스러운 전처리 과정, 그리고 파일 시스템이 필요한 부분을 위해 적용할 수 있겠고, client component는 그외 것들로 사용하면 되겠다.



클라이언트 컴포넌트를 기존에 사용하던 리액트 컴포넌트와 다를바 없다고 생각해도 좋을 거 같다.



마지막으로 서버 컴포넌트를 위한 몇 가지 룰이 있는데, 그 룰은 다음과 같다.


서버컴포넌트는 요청 당 한번만 수행되기 때문에 상태 변화 훅을 지원하지 않는다. useState, useReducer, useEffect, useLayoutEffect
폴리필 하지 않는 한 브라우저 API (DOM)을 지원하지않는다.
state or effect가 포함된 커스텀 훅을 지원하지 않고 브라우저 API를 활용한 함수들을 지원하지 않는다.
데이터베이스에 접근 가능하다. 또는 파일시스템에 접근 가능하다. (like node)
다른 서버 컴포넌트 혹은 다른 클라이언트 컴포넌트 혹은 html 태그를 렌더링할 수 있다.


4. 이외 훅

1 ) useSyncExternalStore
-> 기존 useMutableSource에서 변경
-> 동시성 기능 발생 시, 전역 상태 관리 라이브러리의 상태가 업데이트 되지 않을 경우 강제로 업데이트 시킴
-> 라이브러리 제작 때 사용하면 되는 듯.


2 ) useInsertionEffect
-> Css-in-Js를 위한 훅이다.
-> 몰라도 될 거 같아 넘어감.


3 ) useId
-> 난수의 id를 생성하는 훅

--------

React 팀이 18 버전 Release 를 통해 해결하고자 했던 문제들?
3월 29일, React 18 버전이 세간에 등장하였습니다. React 18 버전에는 크게 아래와 같은 변화가 있었습니다.

New Root API
Automatic Batching
New Concept “Transition”
SSR support for Suspence
React 팀이 18 버전을 통해서 개선하고자 했던 내용은 무엇일까요?

 

여러 가지 개선 사항이 있지만 그중 두 가지만 살펴보자면, 첫 번째는 Batching 작업을 통한 Rendering 퍼포먼스 향상, 두 번째는 새로운 기능인 Transition 을 통해 UI 업데이트에 우선순위를 부여하거나, 느린 네트워크 환경에서의 UX 향상을 살펴볼 수 있을 것 같습니다

 

 

 

해당 포스팅에서 다루는 것
새로운 Root API
Automatic Batching
Transition
 
 
다루지 않는 것
Server side rendering support for Suspense
저희 팀에서는 별도의 SSR (Server Side Rendering) 기술을 사용하지 않고 있습니다. 그렇기 때문에 이번 개선사항 중 SSR 기술에 관한 내용은 포스팅에서 제외하였습니다.

 
 

새로운 Root API 의 등장
18 버전이 등장하면서 새로운 Root API 가 등장하였습니다. 그렇다면 여기서 말하는 Root 란 무엇을 의미하는지 알아봅시다! 아래에서 자주 언급할 Root는 React 가 Render를 위해 트리를 추적하는 데 사용하는 최 상단에 위치한 데이터 구조의 포인터를 의미합니다. 쉽게 말해서 public 폴더 하에 index.html 을 살펴보면 <div id=”root”></div> 라는 요소를 살펴볼 수 있는데, 해당 요소가 Root 요소입니다!

기존의 Legacy Root API (ReactDOM.render)는 18 버전 등장 이전의 Legacy 모드에서 돌아가는 Root (React 17 혹은 그 이전 버전에서 작동하는) 를 생성했습니다.
18 버전 이후의 새로운 Root API는 ReactDOM.createRoot 으로 React 18 버전에서 사용하는 Root 를 생성할 수 있는데, 새로운 Root API 를 통해서 React 18 버전의 새로운 기능 및 API 를 사용할 수 있습니다.
// 18v 이전의 루트
ReactDOM.render(, document.getElementById(‘root’));

// 18v 이후의 루트 API
import * as ReactDOMClient from ‘react-dom/client’;

const container = document.getElementById(‘app’);
const root = ReactDOMClient.createRoot(container);

root.render();
 
React Team은 왜 새로운 Root API를 적용하게 되었을까?
18 버전 이전의 React 에서는 Root 가 되는 컨테이너에 변화가 없더라도 render 하기 위해서는 Root 를 반드시 체크하고 Root 를 통과 했어야만 했습니다. 이 과정은 React 가 Virtual DOM을 사용하기 때문에 반드시 거쳐야 하는 작업입니다. React 팀에서는 Root 가 되는 컨테이너를 매 Rendering 과정마다 체크하며 통과할 필요가 없다는 사실을 알고 있었고, 이런 반복되고 무의미한 과정을 개선하기 위해서 새로운 Root API 를 18 버전에 적용하게 되었습니다.

 

 
New API “ ReactDOMClient “
새로운 API의 createRoot() 함수를 사용하면 Root 를 반환합니다. 새로운 Root 를 통해서 React Node를 DOM에 Render 할 수 있습니다. 또한 원한다면 Unmount 도 할 수 있답니다.

import * as ReactDOMClient from "react-dom/cleint";

const root = ReactDOMClient.createRoot(container);

root.render();
root.unmount();
 
“ Root API ” 에서의 콜백 함수의 삭제
기존의 Root (ReactDOM.render) 에서는 컴포넌트가 Rendering 되거나 업데이트될 때 주로 콜백 함수를 render 함수 내부에서 매개변수로 사용하지 않고 생략했었지만, 만약 콜백 함수가 필요한 상황이라면 render 함수의 매개변수로 넣어서 사용할 수 있었습니다. 하지만 새로운 Root API에서는 인자로 넣어주며 사용할 수 있는 콜백 함수를 삭제했답니다.

 

이러한 이유는 hydration, SSR 과 함께 콜백 함수를 사용하면, 해당 콜백 함수를 호출하는 타이밍이 개발자의 예상과는 다르게 매칭이 안 될 수 있는 상황이 있었기에, 이런 당황스러운 상황을 피하기 위해 매개 변수로 받을 수 있는 콜백 함수를 삭제하였고, 대신에 콜백 함수 기능을 활용하고자 한다면 requestIdleCallback, setTimeout 혹은 루트에서 ref 콜백을 통해 사용할 수 있게 되었습니다.

// 18v 이전 render() 에서 콜백 함수의 사용
import * as ReactDOM from "react-dom";
import App from "App";

const root = document.getElementById('root');

ReactDOM.render(, root, () => {
  console.log('rendered')
});

// 18v 에서 콜백 함수를 사용하고자 한다면
import * as ReactDOMClient from "react-dom/client";

const container = document.getElementById('root');
const root = ReactDOMClient.createRoot(root);

root.render( console.log("rendered")}/>);
 
Automatic Batching
 

React 에서 Batching 이란?
React에서 언급한 배칭 (Batching) 이란 무엇일까요? 이는 더 나은 Rendering 퍼포먼스를 위하여 여러 state 업데이트를 하나의 Rendering으로 그룹화하는 것을 의미합니다.

 

React 팀이 18 버전을 출시하기 이전의 React에서는 React Event Handler만이 state 업데이트를 Batching 처리했습니다. 하지만 18 버전 이후로는 React Event Handler뿐만 아니라 promise, setTimeout, native event handler 등 다양한 로직에서도 Batching 작업이 가능하게 되었습니다.

 
18 버전 이후 Batching 되는 방법
18 버전 이후부터는 새로운 Root API인 createRoot를 통해서 브라우저 이벤트뿐만 아니라 어떠한 이벤트에서 발생하는 state 업데이트들을 어디서 발생했는지를 신경 쓰지 않고 자동으로 업데이트들이 배칭 시킵니다. setTimeout, promise, native event handler 등에서 발생하는 모든 state 업데이트는 React 에서 발생하는 이벤트 내부의 업데이트와 동일한 방식으로 state 업데이트 들을 Batching 하여 여러 번 수행했어야 했던 Rendering 을 단 한 번만 처리할 수 있게 해줬고, 이는 Rendering 횟수를 최소화하여, 애플리케이션의 성능 향상을 기대할 수 있게 되었습니다.

function handleClick() {
  setCount((prev) => prev + 1);
  setFlag((f) => !f);

  //위 두 업데이트 모두 배칭되어서 단 한번 리랜더링 된다!
}

setTimeout(() => {
  setCount((prev) => prev + 1);
  setFlag((f) => !f);

  //setTimeout 내에서 업데이트도 배칭되어 한번의 리렌더링을 하게된다.
}, 1000);

fetch("api").then(() => {
  setCount((prev) => prev + 1);
  setFlag((f) => !f);

  //fetch api에서 또한 배칭되어 한번의 리렌더링을 하게된다.

});

Batching 을 원하지 않는 경우..
만약 Batching 을 원하지 않는 코드 (state 변경 후 즉시 DOM으로부터 값을 가져와야 하는 경우 등..)일 경우엔 ReactDOM.flusySync() 를 사용하면 state 업데이트를 진행할 때 Batching 하지 않고 업데이트를 진행할 수 있습니다.

import {flushSync} from 'react-dom';

function handleClick() {
  flushSync(() => {
    setCount(prev => prev + 1);
  });
  
  flushSync(() => {
    setFlag(f => !f);
  });

}
 
New Feature : Transition
Transition 은 React 18 버전이 출시하며 새롭게 등장한 콘셉트입니다. 개발자는 Transition 기능을 활용한다면 보다 빠르게 업데이트되어야 하는 상황과 그렇지 않은 업데이트 상황을 구별하면서 개발을 할 수 있게 됩니다.

 

18 버전 이전의 버전에서는 state를 업데이트하는데 있어서 우선순위를두는 게 어려웠습니다. 예를 들어서 Throttling, Debounce 기법을 활용하여 우선순위를 두는 식으로 해결했지만, 두 방법 모두 예상하지 않았던 몇 초 이상의 작업 시간이 소요된다는 문제점이 발생했습니다. 또한 위의 기법을 활용하는 동안엔 어떤 Component 는 반응을 하지 않는다는 문제도 발생하고는 하였습니다.

 

이런 상황에서 React 팀은 18 버전에서 Transition 이라는 기능을 출시했습니다. 이 새로운 기능은 특수한 업데이트들을 직접 마킹하면서 의도된 방식으로 작업을 지연시켜 사용자와의 상호작용 및 UX 를 지속적으로 향상시켜 줍니다.

 


Transition 활용법
Transition API를 활용하기 위해서는 먼저 새로운 Root API 를 사용해야 합니다.

 


useTransition Hook
useTransition Hook 을 사용하면 Transition 기능을 쉽게 사용할 수 있습니다. useTransition 은 배열을 반환하는데 이는 각각 isPending, startTransition입니다.

 

또한 useTransition 의 매개변수로 객체를 넘겨줄 수 있는데 이를 활용한다면 Transition 을 활용한 결과를 불러올 때까지 설정한 시간까지는 이전 화면을 보여주고, 그 이후에는 isPending 을 활용해 다른 UI 를 보이게 끔 설정할 수 있습니다.

 

공식문서 확인 >

const [isPending, startTransition] = useTransition({ timeoutMs: 3000 }); 

isPending
isPending 은 boolean 값이며, Transition이 활용중 인지 알 수 있는 정보를 제공합니다.

 

isPending 을 활용한다면 백그라운드에서 컴포넌트가 Rendering 되는 동안 유저가 페이지와 상호작용할 수 있도록 UI를 쉽게 설정할 수 있으며 이는 사용자들에게 지금 화면이 로딩 중이거나 업데이트되고 있다는 정보를 쉽게 제공할 수 있습니다.

{isPending && }
 
startTransition
startTransition 함수는 React에 서 Transition 기능을 구현할 때 사용합니다. startTransition 함수 내부에서 state 업데이트를 하면 자동으로 Transition 처리가 되며, state 업데이트될 때 우선순위 큐 내부에서 뒤로 밀려나 업데이트가 이뤄집니다.

 

startTransition 은 React가 UI 업데이트를 위해 복잡한 로직을 수행하면서 대기 시간이 발생하거나, 느린 네트워크 환경에서 데이터를 받아오기 위해 사용자가 기다려야 하는 상황에서 사용할 수 있습니다.

 

startTransition 에 넘겨지는 콜백 함수는 동기적으로 호출되며 콜백 함수 안에서 내부에서 일어나는 state 업데이트는 Transition 으로 마킹되어 React 가 업데이트를 진행할 때 후 순위로 밀려나게 됩니다.

 
 
Transition 예제
간단한 예제를 활용해 Transition 개념을 살펴봤습니다.

 

해당 예제에서 사용자는 검색 기능을 활용하여 무엇인가 검색하려고 합니다. 사용자가 입력하게 될 키보드 이벤트의 결과물(input 값) 은 즉각적으로 화면에 업데이트되어야 하며, 그에 비해서 보편적으로 사용자는 검색 결과가 즉시 업데이트되는 것을 기대하지 않습니다.

 

해당 컴포넌트에서 관리될 state는 두 가지입니다. “input value”, “search result”입니다.

 

useTransition 훅을 활용해 isPending 과 startTransition 을 반환받았고, isPending 을 활용해 결과 화면에 대한 UI를 활용할 수 있었으며, startTransition 을 활용해 state 업데이트의 우선순위를 구현해 Component의 효율적인 렌더링을 기대할 수 있게 됩니다.

 

CodeSandbox 를 통해서 살펴보기

 

느꼈던 점(회고)
18 버전을 통해서 React 팀이 React 를 얼마나 사랑하며 문제점을 개선하고자 하는지 느껴볼 수 있게 되었습니다. 16.8 버전에 출시된 hook 만큼 놀랄 만한 개선사항 (breaking change) 은 아니지만 다양한 부분에서 세심하게 신경 쓰고 있다는 점을 느끼게 되었습니다.

 

이렇게 다양한 팀 혹은 개인이 신경 쓰고 사랑하는 라이브러리 라면 이미 성숙기에 접어든 상태지만 꾸준히 안정적으로 롱런 하는 라이브러리로 남지 않을까 생각해 봅니다.

 

읽어봐주셔서 감사합니다. React Forever!!

 

참고자료
React 18 v Official Document
