gh-pages : 웹사이트를 github의 github page 도메인에 나타나게 해줌.
>> github는 무료 웹사이트를 제공함. static 웹사이트, HTML, CSS, JS 웹사이트는 무료로 제공됨.

terminal]
npm i gh-pages

Web]
https://github.com/2jelee/movie_app
변
2jelee.github.io/movie_app

T]
git remote -v

VS code]
package.jason 설정 >> "homepage": "2jelee.github.io/movie_app" 설정 +
"scripts": {
    "start": "react-scripts start",
    "build": "react-scripts build",
    "deploy":"gh-pages" 		<< 이것 추가
  },

T]
npm run build 하면 build 폴더가 생성됨.
이 폴더를 gh-pages에 업로드할 것임.
package.json에서 "deploy":"gh-pages"를 "gh-pages -d build"로 변경하기 +
"predeploy": "npm run build" 추가

이는 기본적으로 매 순간 우리가 deploy를 호출할 때마다 
npm이 pre-를 먼저 호출하게 된다.
그다음, build는 build script를 호출하게 됨. 그다음 script는 folder를 줌.

여기서 deploy 역할 : gh-pages를 호출, 그리고 이것을 붙임.

T ]
npm run deploy
(단, 이름이 같아야 한다. 그래야 pre가 동작함. 만약 이름이 같지 않으면 동작 X)



----------------------결론----------------------
더이상 state를 갖기 위해 class component를 가질 필요가 없다.
>> 이는 react hook이라는 것 때문.
이는 새로운 것임. 대체물이 X
이는 일을 하는 다른 방식임. 그러나 대체물은 아님.
즉, class component가 구식이 아니라는 말.
