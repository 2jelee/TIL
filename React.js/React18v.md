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
