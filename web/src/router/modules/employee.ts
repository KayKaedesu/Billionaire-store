import type { RouteModule } from '../types'

const employeeModule: RouteModule = {
  path: '/employee',
  name: 'CashierOuter',
  children: [
    {
      path: 'cashier',
      name: 'EmployeeCashier',
      component: () => import('@/views/employee/CashierView.vue'),
    },
  ],
}

export default employeeModule
