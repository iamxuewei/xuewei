import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import XueWei from '@/components/Xuewei'
import aa from '@/components/aa'
import bb from '@/components/bb'
Vue.use(Router)
export default new Router({
  routes: [
    {
      path: '/xw/:id',
      name: 'XueWei',
      component: XueWei
    }, {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    }, {
      path: '/xw',
      name: 'XueWei',
      component: XueWei,
      children: [
        {
          // 当 /user/:id/profile 匹配成功，
          // UserProfile 会被渲染在 User 的 <router-view> 中
          path: '/aa',
          component: aa
        },
        {
          // 当 /user/:id/posts 匹配成功
          // UserPosts 会被渲染在 User 的 <router-view> 中
          path: '/bb',
          component: bb
        }]
    }
  ]
})
