<template>
  <div>
    <h1>Welcome to {{title}}!</h1> <!-- 아래 script안의 data가 binding 된다. -->
    <input type="text" v-model="input1" /> <!-- html : value / Vue.js : v-model 로 데이터를 바인딩 -->
    <button type="button" @click="getData">Get</button> <!-- html : onclick / Vue.js : @click 으로 바인딩 -->
    <!-- Vue.js에서 모든 메소드는 script내 methods에 정의하게 되어있다. -->
    <button type="button" @click="setData">Set</button> 

    <!-- 
    list형태인 경우 v-for를 통해 배열을 돌린다. (for문)
    d : data
    i : index
    + in + 실제 데이터 변수명

    -component의 object마다 key를 반드시 넣어주어야 한다.
      :key '유일'한 키값
    
    - :value >> option이 for문 돌리면서 생기면서 v값들이 value에 할당되는.
    
    -html안에서 접근 시 중괄호 2개로 접근.
    -element 안의 attribute 접근 시 colne(:) 사용 시 바로 데이터 변수에 접근 可

    - value는 무조건 v-model로 데이터 바인딩 처리가능.

    [정리]
    v-model : 데이터 바인딩 (html > value)
    v-for : 배열형태로 처리 시 사용 (멀티 데이터/다중 데이터)
    @ : event를 걸 수 있다.   >> @change="changeRegion" 확인

    v-if : 조건 만족 시 element를 렌더링하겠다. (실제 렌더링할지말지 결정)
    v-show : 위와 유사하나, 구동하는 방식이 다르므로 용도에 맞게 적절히 사용하자!
            v-show 조건 만족/불만족에 상관없이 렌더링 O (화면에만 보여주지 않을뿐)
            v-if는 조건이 만족하지 않으면 아예 랜더링 자체를 X (리소스를 적게 잡아먹는다.)
    -->
    <select class="form-control" v-model="region" @change="changeRegion">
      <option :key="i" :value="d.v" v-for="(d, i) in options ">{{d.t}}</option>
    </select>

    <table class="table table-bordered" v-if="tableShow"> <!-- v-show -->
      <tr :key="i" v-for="(d, i) in options">
      <tr :key="i" v-for="(d, i) in options">
        <td>{{d.v}}</td>
        <td>{{d.t}}</td>
      </tr>
    </table>
  </div>
</template>
<script>
//데이터를 핸들링(control, binding, 가져오고)이 중요!  *핵심*
export default {
  data(){
    return {
      title: "2jelee",
      title2: "Seoul",
      input1: "abc",
      //배열형태의 DataSet
      options: [
        {
          v:"S", t:"Seoul",
        },
        {
          v:"I", t:"Incheon",
        },
        {
          v:"J", t:"Jeju",
        }
      ],
      region: "I",
      tableShow: false,
    };
    //One-way 방식 : 단방향으로 데이터를 넣어주면 끝.        >>One-way binding
    //Two-way 방식 : 사용자가 값을 바꾸면 데이터가 변하는.   >>Two-way binding
  },
  // Vue.js에서 중요한 개념 두 번째 : watch     << 일종의 모니터링 개념
  // 만약 inpu1이라는 data가 조금이라도 변경이 일어날 경우(data명하고 동일하게 만들어놓은 function명 안에서) 데이터가 변경되는 것을 catch해서 알 수 있다.
  // 앞에서 해본 button이나 특정 event를 걸어, 메소드를 호출하고 메소드에서 데이터를 접근하여 받지만 watch 메소드를 사용하므로써 데이터 변경을 모니터링 可
  watch:{
    input1(){
      console.log(this.input1);
    }
  },
  /*
  특정 데이터를 계속 관찰하고 있다가 그 데이터의 변경이 일어날 경우 catch해서 사용할 수 있다.
  사용법 : 데이터를 선언한 변수명하고 동일한 이름으로 메소드를 만들면 된다.
  */

  // Here!
  methods: {
    getData(){
      alert(this.input1);
    },
    setData(){
      this.input1="12345";
    }, changeRegion(){
      alert(this.region);
    }
  },
  /////////////
  beforeCreate(){
    console.log("beforeCreate")
  },
  created(){
    console.log("created")
  },
  /////////////

  beforeMount(){
    //console.log("beforeMount : 데이터 변경 전")
  },
  mounted(){
    //console.log("mounted : 데이터 변경 후")
  },

  ///////////////////////////////////////////////////////////////
  /*
  화면을 랜더링하는 불필요한 작업이 일어나므로 만약 특정 화면에서 화면을 여는 순간 가져와야할 데이터가 있을 경우,
  데이터를 가져오는 beforeCreate나 created에서 정의를 해서 미리 데이터를 가져오자.
  마운트될 때 한번에 화면에 렌더링되며 데이터가 같이 적용된다.
  */
  beforeUpdate(){
    console.log("beforeUpdate")
  },
  updated(){
    console.log("updated")
  },
  ///////////////////////////////////////////////////////////////

  beforeDestroy(){
    console.log("beforeDestroy")
  },
  destroyed(){
    console.log("destroyed")
  }
};
</script>