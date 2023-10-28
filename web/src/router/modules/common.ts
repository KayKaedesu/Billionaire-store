import type { RouteRecordRaw } from 'vue-router'
import type { RouteModule } from '../types'

const commonModule: RouteModule = {
  path: '/',
  children: [
    {
      path: '/',
      name: 'home',
      component: () => import('@/views/common/HomeView.vue'),
    },
    {
      path: '/404',
      name: '404',
      component: () => import('@/views/common/Error404.vue'),
    },
  ],
}

export default commonModule
