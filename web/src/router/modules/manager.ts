import type { RouteModule } from '../types'

const managerModule: RouteModule = {
  path: '/manager',
  name: 'ManagerOuter',
  component: () => import('@/views/manager/ManagerDashboardOuter.vue'),
  children: [
    {
      path: 'home',
      name: 'managerHome',
      component: () => import('@/views/manager/ManagerHomeView.vue'),
    },
    // {
    //   path: 'inventory',
    //   name: 'ManagerInventory',
    //   component: () => import('@/views/manager/ManagerInventoryView.vue'),
    // },
    // {
    //   path: 'orders',
    //   name: 'ManagerOrders',
    //   component: () => import('@/views/manager/ManagerOrdersView.vue'),
    // },
  ],
}

export default managerModule
