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
    {
      path: 'shelf',
      name: 'EmployeeShelf',
      component: () => import('@/views/employee/ShelfView.vue'),
    },
  ],
}

export default employeeModule
