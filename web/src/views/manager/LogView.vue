<template>
  <n-tabs type="segment">
    <n-tab-pane name="employee" tab="ประวัติการซื้อ">
  <n-space vertical>
    <n-space class="top-content">
      <n-text class="text"> ประวัติการซื้อขาย </n-text>
      </n-space>

    <n-data-table
        ref="table"
        :columns="columns"
        :data="data"
        :pagination="pagination"
    />
  </n-space>
    </n-tab-pane>
  </n-tabs>
</template>

<script lang="ts">
import { Refresh, SearchOutline } from '@vicons/ionicons5'
import { defineComponent, reactive, ref } from 'vue'
import { NButton } from 'naive-ui'
import router from '@/router'

export default defineComponent({
  methods: {
    router() {
      return router
    },
  },

  setup() {
    const columns = [
      {
        title: 'ลำดับ',
        key: 'order',
        width: '150px',
        align: 'center',
        sorter: (row1: any, row2: any) => row1.order - row2.order,
      },
      {
        title: 'ชื่อพนักงาน',
        key: 'name',
        width: '250px',
        align: 'center',
      },
      {
        title: 'รหัสพนักงาน',
        key: 'id',
        width: '150',
        align: 'center',
        sorter: (row1: any, row2: any) => row1.id - row2.id,
      },
      {
        title: 'ตำแหน่ง',
        key: 'role',
        width: '200px',
        align: 'center',
      },
      {
        title: 'อีเมล',
        key: 'email',
        width: '250px',
        align: 'center',
      },
    ]

    const data = Array.from({ length: 46 }).map((_, index) => ({
      key: index,
      order: `${index + 1}`,
      name: `นาย A นามสกุล B`,
      id: Math.floor(Math.random() * 100),
      role: 'Role',
      email: 'billionaire@gmail.com',
    }))


    const paginationReactive = reactive({
      page: 1,
      pageSize: 12,
      showSizePicker: true,
      pageSizes: [12, 24, 36],
      onChange: (page: number) => {
        paginationReactive.page = page
      },
      onUpdatePageSize: (pageSize: number) => {
        paginationReactive.pageSize = pageSize
        paginationReactive.page = 1
      },
    })

    const refreshPage = () => {
      location.reload() // Reloads the current page
    }

    return {
      pagination: paginationReactive,
      Refresh,
      SearchOutline,
      data,
      columns,
      refreshPage,
    }
  },
})
</script>

<style>
.top-content {
  margin-left: 45%;
  width: 950px;
  display: flex;
  align-items: center;
}
.text {
  font-weight: bold;
  font-size: 30px;
  display: flex;
  align-items: center;
  justify-content: center;
}

</style>