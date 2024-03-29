import type { RouteModule } from '../types'

const noAuthModule: RouteModule = {
  path: '',
  children: [
    {
      path: '/employee/login',
      name: 'EmployeeLogin',
      component: () => import('@/views/noauth/EmployeeLoginView.vue'),
    },
    {
      path: '/manager/login',
      name: 'ManagerLogin',
      component: () => import('@/views/noauth/ManagerLoginView.vue'),
    },
  ],
}

export default noAuthModule
