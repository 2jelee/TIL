<template>
  <div id="app"> 
    <Header />
    <div id="content" class="content">
      <router-view></router-view> <!-- 현재 이부분만 변경되는. -->
    </div>
  </div>
</template>

<script>
import Header from './components/layout/Header.vue';

export default {
  name: 'App',
  components: {
    Header,
  },
};
</script>

<style> 
</style>
