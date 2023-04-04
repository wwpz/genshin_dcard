import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/dictType',
      name: 'DictType',
      component: () => import('@/components/dict/DictType'),
    },
    {
      path: '/dictData',
      name: 'DictData',
      component: () => import('@/components/dict/DictData'),
    },
  ]
})
