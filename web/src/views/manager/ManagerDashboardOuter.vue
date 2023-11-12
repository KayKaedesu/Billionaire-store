<template>
  <NLayout>
    <NLayoutHeader
      style="padding: 0.5rem; display: flex; flex-direction: row-reverse"
      :inverted="inverted"
      bordered
    >
      <!-- avatar -->
      <n-popover trigger="click">
        <template #trigger>

          <n-avatar>
            <n-icon>
              <md-cash />
            </n-icon>
          </n-avatar>

        </template>
        <template #header>

          <n-text strong depth="1">สวัสดี {NAME}</n-text>
        </template>
        <template #footer>
          <n-button quaternary style="width: 100px" @click="navigateToLogin"> Logout </n-button>
        </template>
      </n-popover>
    </NLayoutHeader>
    <n-layout has-sider >
      <NLayoutSider
        bordered
        show-trigger
        collapse-mode="width"
        :collapsed-width="64"
        :width="240"
        :native-scrollbar="false"
        :inverted="inverted"
      >
        <NMenu
          :inverted="inverted"
          :collapsed-width="64"
          :collapsed-icon-size="22"
          :options="menuOptions"
        />
      </NLayoutSider>
      <NLayoutContent
        :content-style="{
          padding: '24px',
        }"
      >
        <router-view />
      </NLayoutContent>
    </n-layout>
    <NLayoutFooter :inverted="inverted" bordered>
Billionaire Store
    </NLayoutFooter>
  </NLayout>
</template>

<script lang="ts">
import { h, defineComponent, ref } from 'vue'
import {
  NIcon,
  NLayout,
  NLayoutContent,
  NLayoutFooter,
  NLayoutHeader,
  NLayoutSider,
  NMenu,
} from 'naive-ui'
import { Icon, type IconifyIconProps } from '@iconify/vue'
import type { MenuMixedOption } from 'naive-ui/es/menu/src/interface'
import {RouterLink, useRouter} from 'vue-router'


function renderIcon(iconProps: IconifyIconProps) {
  return () => h(NIcon, null, { default: () => h(Icon, iconProps) })
}

const menuOptions: MenuMixedOption[] = [
  {
    label: 'จัดการ',
    key: 'manage',
    icon: renderIcon({ icon: 'material-symbols:edit-square-outline-rounded' }),
    children: [
      {
        label: () =>
            h(
                RouterLink,
                {
                  to: {
                    path: '/manager/home',
                  }
                },
                { default: () => 'หน้าหลัก' }
            ),
        key: 'manage-home',
        icon: renderIcon({ icon: 'material-symbols:home' }),
      },
      {
        label: () =>
            h(
                RouterLink,
                {
                  to: {
                    path: '/manager/employee',
                  }
                },
                { default: () => 'พนักงาน' }
            ),
        key: 'manage-employee',
        icon: renderIcon({ icon: 'mdi:account-group' }),
      },
      {
        label: () =>
            h(
                RouterLink,
                {
                  to: {
                    path: '/manager/log',
                  }
                },
                { default: () => 'รายการสินค้า' }
            ),
        key: 'manage-product',
        icon: renderIcon({ icon: 'material-symbols:shopping-cart-rounded' }),
      },
      {
        label: () =>
            h(
                RouterLink,
                {
                  to: {
                    path: '/manager/import',
                  }
                },
                { default: () => 'เพิ่มรายการสินค้า' }
            ),
        key: 'buy-product',
        icon: renderIcon({ icon: 'vaadin:stock' }),
      },
    ],
  },
]

export default defineComponent({
  components: {
    NLayout,
    NLayoutHeader,
    NLayoutSider,
    NLayoutFooter,
    NMenu,
    NLayoutContent,
  },
  setup() {
    const router = useRouter();
    const navigateToLogin = () => {
      router.push('/manager/login'); // Navigate to the specified route
    }

    return {
      inverted: ref(true),
      menuOptions,
      navigateToLogin
    }
  },
})
</script>

<style scoped>
.full {
  height: 400px;
  position: relative;
}
</style>
