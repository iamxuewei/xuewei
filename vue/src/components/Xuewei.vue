<template>
  <div id="xuewei">
    这是我的页面：<a class="mess">{{message}}</a>
    <router-view></router-view>
    <router-link to="/aa">aaa</router-link>
    <router-link to="/bb">bbb</router-link>
  </div>
</template>
<script>
  export default {
    name: '#xuewei',
    data(){
      return{
        message:"我的页面"
      }
    }
  }
</script>
<style scoped>
.mess{
  color: #1e6abc;
}
</style>
