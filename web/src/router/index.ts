// mainRouter.ts
import { createRouter, createWebHistory } from 'vue-router'
import type { RouteModule } from './types'
import commonModule from '@/router/modules/common'
import ownerModule from './modules/manager'
import noAuthModule from './modules/noauth'
import employeeModule from './modules/employee'
import EmployeeLoginView from "@/views/noauth/EmployeeLoginView.vue";
import ManagerLoginView from "@/views/noauth/ManagerLoginView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'employeelogin',
      component: EmployeeLoginView,
    },
    commonModule,
    noAuthModule,
    ownerModule,
    employeeModule,
  ] as Array<RouteModule>,
})

export default router
