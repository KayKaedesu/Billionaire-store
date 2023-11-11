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
    {
      path: '/employee',
      name: 'managerEmployee',
      component: () => import('@/views/noauth/ManageEmployeeView.vue'),
    },
    {
      path: '/shelf',
      name: 'employeeShelf',
      component: () => import('@/views/noauth/ManageShelfView.vue'),
    },
  ],
}

export default noAuthModule
