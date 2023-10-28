import type { RouteRecordRaw } from 'vue-router'

export type RouteModule = RouteRecordRaw & {
  path: RouteRecordRaw['path']
  children: Array<RouteRecordRaw>
}
