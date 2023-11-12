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

        <template #footer> a </template>
      </n-popover>
    </NLayoutHeader>
    <n-layout has-sider>
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
      Footer Footer Footer
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
        label: 'พนักงาน',
        key: 'manage-employee',
        icon: renderIcon({ icon: 'mdi:account-group' }),
      },
      {
        label: 'รายชื่อสินค้า',
        key: 'manage-product',
        icon: renderIcon({ icon: 'material-symbols:shopping-cart-rounded' }),
      },
    ],
  },

  // {
  //   label: 'Hear the Wind Sing',
  //   key: 'hear-the-wind-sing',
  //   icon: renderIcon({ icon: 'material-symbols:book' }),
  // },
  // {
  //   label: 'Pinball 1973',
  //   key: 'pinball-1973',
  //   icon: renderIcon({ icon: 'material-symbols:book' }),
  //   disabled: true,
  //   children: [
  //     {
  //       label: 'Rat',
  //       key: 'rat',
  //     },
  //   ],
  // },
  // {
  //   label: 'A Wild Sheep Chase',
  //   key: 'a-wild-sheep-chase',
  //   disabled: true,
  //   icon: renderIcon({ icon: 'material-symbols:book' }),
  // },
  // {
  //   label: 'Dance Dance Dance',
  //   key: 'Dance Dance Dance',
  //   icon: renderIcon({ icon: 'material-symbols:book' }),
  //   children: [
  //     {
  //       type: 'group',
  //       label: 'People',
  //       key: 'people',
  //       children: [
  //         {
  //           label: 'Narrator',
  //           key: 'narrator',
  //           icon: renderIcon({ icon: 'material-symbols:person' }),
  //         },
  //         {
  //           label: 'Sheep Man',
  //           key: 'sheep-man',
  //           icon: renderIcon({ icon: 'material-symbols:person' }),
  //         },
  //       ],
  //     },
  //     {
  //       label: 'Beverage',
  //       key: 'beverage',
  //       icon: renderIcon({ icon: 'material-symbols:wine-bar' }),
  //       children: [
  //         {
  //           label: 'Whisky',
  //           key: 'whisky',
  //         },
  //       ],
  //     },
  //     {
  //       label: 'Food',
  //       key: 'food',
  //       children: [
  //         {
  //           label: 'Sandwich',
  //           key: 'sandwich',
  //         },
  //       ],
  //     },
  //     {
  //       label: 'The past increases. The future recedes.',
  //       key: 'the-past-increases-the-future-recedes',
  //     },
  //   ],
  // },
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
    return {
      inverted: ref(true),
      menuOptions,
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
