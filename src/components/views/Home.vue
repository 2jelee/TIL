<template>
  <div>
    <h1>Welcome to {{title}}!</h1> <!-- 아래 script안의 data가 binding 된다. -->
    <input type="text" v-model="input1" /> <!-- html : value / Vue.js : v-model 로 데이터를 바인딩 -->
    <button type="button" @click="getData">Get</button> <!-- html : onclick / Vue.js : @click 으로 바인딩 -->
    <!-- Vue.js에서 모든 메소드는 script내 methods에 정의하게 되어있다. -->
    <button type="button" @click="setData">Set</button> 
  </div>
</template>
<script>
//데이터를 핸들링(control, binding, 가져오고)이 중요! *핵심*
export default {
  data(){
    return {
      title: "2jelee",
      title2: "Seoul",
      input1: "abc",
    };
    //oneway 방식 : 단방향으로 데이터를 넣어주면 끝
    //twoway 방식 : 사용자가 값을 바꾸면 데이터가 변하는. >> twoway binding
  },
  // Here!
  methods: {
    getData(){
      alert(this.input1);
    },
    setData(){
      this.input1="12345";
    }
  }
};
</script>