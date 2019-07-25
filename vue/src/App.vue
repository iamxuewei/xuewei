<template>
  <div id="app">
    <router-link to="/">首页</router-link>
    <router-link to="/xw">我的页面</router-link>
    <router-view></router-view>
    <button @click="goxw()">跳转</button>
  </div>
</template>
<script>
  import Xuewei from './components/Xuewei'
  import HelloWorld from './components/HelloWorld'
  import aa from './components/aa'
  import bb from './components/bb'
export default {
  name: 'App',
  components: {Xuewei,HelloWorld,aa,bb},
  comments(){
    Xuewei
    HelloWorld
    aa
    bb
  },
  methods:{
    goxw(){
        this.$router.push({path:'/xw/zhangxuewei'})
    }
  }
}
</script>
<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
