<h1>Vue.js</h1>
웹 프론트엔드 프레임워크 <br/>
- Component 기반의 SPA(Single Page Application)를 구축할 수 있게 해주는 프레임워크 <br/>
 
<h2>Component</h2>
- 웹을 구성하는 로고, 메뉴바, 버튼, 모달창 등 웹 페이지 내의 다양한 UI요소 <br/>
- 재사용 가능하도록 구조화한 것 <br/>
 
<h2>SPA(Single Page Application)</h2>
***장점*** <br/>
- 단일 페이지 어플리케이션 <br/>
- 하나의 페이지 안에서 필요한 영역 부분만 로딩되는 형태 <br/>
- 빠른 페이지 변환 <br/>
- 적은 트래픽 양 <br/>
<br/>
***단점*** <br/>
최초 로딩 시 모든 JS, CSS파일을 모두 가져와 로딩하므로 파일 사이즈가 크면 클수록 초기 로딩 속도 ↓ 
 
<h3>***React.js VS Vue.js VS Angular.js*** </h3>
어설프게 3개를 동시에 하기보단 하나를 먼저 깊이있게 학습해보자! <br/>
1가지를 확실히 익히면 나머지도 쉽게 익힐 수 있다.

---
Vue 프로젝트를 만들 때 'Vue CLI(Command Line Interface)'를 이용.
이는, 빠르게 개발, 빌드, 서비스 런칭이 가능하게 함.
CLI를 이용하면 기본적으로 프로젝트 구조를 자동적으로 세팅해주므로 구조나 라이브러리, 웹팩 설정을 어떻게 할지에 대한 고민 필요 X.

CLI 설치
```
TERMINAL)
npm install -g @vue/cli
```
```
*WINDOW
vue.cmd create 프로젝트명
```
```
local 실행
npm run serve
```

<h4>필요한 module 설치(Vue Router)</h4>
<br/>
Vue Router : Vue에서 라우팅 기능을 구현할 수 있도록 지원해주는 공식 라이브러리
<br/>
라우팅 : 웹페이지간 이동하는 방법을 일컬음.
<br/>
기존) 서버에 요청 → 새로운 페이지를 받아오는 형식
<br/>
라우터) SPA. 즉, 해당하는 모든 컴포넌트 페이지를 다 받아놓고 라우팅을 이용하여 그 부분만 화면을 갱신하는 것.
<br/>
Vue, React, Angular 모두 라우팅을 이용하여 화면전환 O.
```
npm install vue-router
```
<h3></h3>
<h3>Vue용 Bootstrap 사용하기</h3>
https://bootstrap-vue.org/docs > Using module bundler
```
TERMINAL)
npm install vue bootstrap bootstrap-vue
```
install하더라도 바로 쓸 수는 X. <br/>
main.js에 추가해주자.
```
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
```

Component > Navbar
```
<div>
  <b-navbar toggleable="lg" type="dark" variant="info">
    <b-navbar-brand href="#">NavBar</b-navbar-brand>

    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

    <b-collapse id="nav-collapse" is-nav>
      <b-navbar-nav>
        <b-nav-item href="#">Link</b-nav-item>
        <b-nav-item href="#" disabled>Disabled</b-nav-item>
      </b-navbar-nav>

      <!-- Right aligned nav items -->
      <b-navbar-nav class="ml-auto">
        <b-nav-form>
          <b-form-input size="sm" class="mr-sm-2" placeholder="Search"></b-form-input>
          <b-button size="sm" class="my-2 my-sm-0" type="submit">Search</b-button>
        </b-nav-form>

        <b-nav-item-dropdown text="Lang" right>
          <b-dropdown-item href="#">EN</b-dropdown-item>
          <b-dropdown-item href="#">ES</b-dropdown-item>
          <b-dropdown-item href="#">RU</b-dropdown-item>
          <b-dropdown-item href="#">FA</b-dropdown-item>
        </b-nav-item-dropdown>

        <b-nav-item-dropdown right>
          <!-- Using 'button-content' slot -->
          <template #button-content>
            <em>User</em>
          </template>
          <b-dropdown-item href="#">Profile</b-dropdown-item>
          <b-dropdown-item href="#">Sign Out</b-dropdown-item>
        </b-nav-item-dropdown>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
</div>
```
이를 Component 폴더의 Header.vue에 추가.
template : html 코드가 들어간다. 즉, 디자인 담당.
script : 그 디자인에 data를 binding하거나 이벤트를 catch하거나 서버랑 통신하기 위한 js 코드가 들어간다.


App.vue 확인.

