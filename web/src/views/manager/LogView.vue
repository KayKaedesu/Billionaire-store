<template>

  <n-space class="top-content">
  <n-text class="text"> ประวัติการซื้อ-ขาย </n-text>
</n-space>
  <n-tabs type="segment">
    <n-tab-pane name="buy" tab="ประวัติการซื้อ">
  <n-space vertical>
    <n-data-table
        ref="table"
        :columns="Buycolumns"
        :data="Buydata"
        :pagination="pagination"
    />
  </n-space>
    </n-tab-pane>
    <n-tab-pane name="sell" tab="ประวัติการขาย">
      <n-space vertical>
        <n-data-table
            ref="table"
            :columns="Sellcolumns"
            :data="Selldata"
            :pagination="pagination"
        />
      </n-space>
    </n-tab-pane>
  </n-tabs>
</template>

<script lang="ts">
import { Refresh } from '@vicons/ionicons5'
import { defineComponent, reactive, ref } from 'vue'
import router from '@/router'

export default defineComponent({
  methods: {
    router() {
      return router
    },
  },

  setup() {
    const Buycolumns = [
      {
        title: 'ชื่อผู้ซื้อ',
        key: 'name',
        width: '250px',
        align: 'center',
      },
      {
        title: 'สินค้า',
        key: 'product',
        width: '150',
        align: 'center',
      },
      {
        title: 'รหัสสินค้า',
        key: 'productid',
        width: '150',
        align: 'center',
        sorter: (row1: any, row2: any) => row1.productid - row2.productid,
      },
      {
        title: 'ราคา',
        key: 'price',
        width: '200px',
        align: 'center',
        sorter: (row1: any, row2: any) => row1.price - row2.price,
      },
      {
        title: 'จำนวน',
        key: 'quantity',
        width: '250px',
        align: 'center',
        sorter: (row1: any, row2: any) => row1.quantity - row2.quantity,
      },
      {
        title: 'วันและเวลา',
        key: 'date',
        width: '250px',
        align: 'center',
        sorter: (row1: any, row2: any) => row1.date - row2.date,
      },
    ]

    const Buydata = Array.from({ length: 46 }).map((_, index) => ({
      key: index,
      name: `นาย A นามสกุล B`,
      product: 'ไก่',
      productid: '0001',
      price: Math.floor(Math.random() * 1000),
      quantity: Math.floor(Math.random() * 100),
      date: '30 มกราคม 2564 เวลา 12:00',
    }))

    const Sellcolumns = [
      {
        title: 'ชื่อผู้ขาย',
        key: 'name',
        width: '250px',
        align: 'center',
      },
      {
        title: 'สินค้า',
        key: 'product',
        width: '150',
        align: 'center',
      },
      {
        title: 'รหัสสินค้า',
        key: 'productid',
        width: '150',
        align: 'center',
        sorter: (row1: any, row2: any) => row1.productid - row2.productid,
      },
      {
        title: 'ราคา',
        key: 'price',
        width: '200px',
        align: 'center',
        sorter: (row1: any, row2: any) => row1.price - row2.price,
      },
      {
        title: 'จำนวน',
        key: 'quantity',
        width: '250px',
        align: 'center',
        sorter: (row1: any, row2: any) => row1.quantity - row2.quantity,
      },
      {
        title: 'วันและเวลา',
        key: 'date',
        width: '250px',
        align: 'center',
        sorter: (row1: any, row2: any) => row1.date - row2.date,
      },
    ]

    const Selldata = Array.from({ length: 46 }).map((_, index) => ({
      key: index,
      name: `นาย A นามสกุล B`,
      product: 'กระทะ',
      productid: '0002',
      price: Math.floor(Math.random() * 1000),
      quantity: Math.floor(Math.random() * 100),
      date: '30 มกราคม 2564 เวลา 12:00',
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
      location.reload()
    }

    return {
      pagination: paginationReactive,
      Refresh,
      Buydata,
      Buycolumns,
      Selldata,
      Sellcolumns,
      refreshPage,
    }
  },
})
</script>

<style>
.top-content {
  margin-left: 43%;
  width: 950px;
  display: flex;
  align-items: center;
}
.text {
  font-weight: bold;
  font-size: 30px;
  display: flex;
  justify-content: center;
}
</style>