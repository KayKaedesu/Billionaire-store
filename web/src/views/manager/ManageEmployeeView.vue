<template>
  <n-tabs type="segment">
    <n-tab-pane name="employee" tab="รายชื่อพนักงาน">
      <n-space vertical>
        <n-space
          vertical
          :style="{
            top: 0,
            left: 0,
            width: '100%',
            zIndex: 0,
            background: 'white',
          }"
        >
          <n-input-group class="serch">
            <n-icon
              :component="SearchOutline"
              size="35"
              :depth="1"
              style="margin-right: 20px"
            />
            <n-input
              style="
                border-radius: 25px;
                width: 90%;
                justify-content: center;
                height: 35px;
              "
              clearable
              maxlength="70"
              placeholder="ค้นหารายชื่อพนักงาน, รหัสพนักงาน"
            >
            </n-input>
          </n-input-group>
        </n-space>

        <n-space class="top-content">
          <n-text class="text"> รายชื่อพนักงาน </n-text>
          <n-space class="butt">
            <n-button
              round
              class="button"
              type="success"
              @click="showModal = true"
              >เพิ่มพนักงาน</n-button
            >
            <n-button round quaternary dashed @click="refreshPage"
              ><n-icon :component="Refresh" size="25" :depth="1"
            /></n-button>

            <n-modal v-model:show="showModal" preset="dialog" title="Dialog">
              <template #header>
                <div>เพิ่มพนักงาน</div>
              </template>
              <template #action>
                <n-space vertical style="margin-right: 20px; width: 100%">
                  <n-input
                    style="border-radius: 25px; margin-bottom: 10px"
                    clearable
                    maxlength="50"
                    show-count
                    placeholder="ระบุชื่อพนักงาน"
                  ></n-input>
                  <n-input
                    style="border-radius: 25px; margin-bottom: 10px"
                    clearable
                    maxlength="10"
                    show-count
                    placeholder="ระบุรหัสพนักงาน"
                  ></n-input>
                  <n-input
                    style="border-radius: 25px; margin-bottom: 10px"
                    clearable
                    maxlength="50"
                    show-count
                    placeholder="ระบุอีเมล"
                  ></n-input>
                  <n-select
                    default-value="ระบุุตำแหน่ง"
                    :options="[
                      {
                        label: 'แคชเชียร์',
                        value: '1',
                      },
                      {
                        label: 'จัดการสินค้าหน้าร้าน',
                        value: '2',
                      },
                    ]"
                  />
                  <n-button
                    round
                    style="
                      margin-left: 39%;
                      margin-top: 25px;
                      width: 110px;
                      height: 35px;
                    "
                    type="success"
                    @click="handleConfirmEdit"
                    >ยืนยันการเพิ่ม</n-button
                  >
                </n-space>
              </template>
            </n-modal>
          </n-space>
        </n-space>

        <n-data-table
          ref="table"
          :columns="columns"
          :data="data"
          :pagination="pagination"
        />
      </n-space>
    </n-tab-pane>

    <n-tab-pane name="product" tab="รายชื่อสินค้า">
      <n-space vertical>
        <n-space
          vertical
          :style="{
            top: 0,
            left: 0,
            width: '100%',
            zIndex: 0,
            background: 'white',
          }"
        >
          <n-input-group class="serch">
            <n-icon
              :component="SearchOutline"
              size="35"
              :depth="1"
              style="margin-right: 20px"
            />
            <n-input
              style="
                border-radius: 25px;
                width: 90%;
                justify-content: center;
                height: 35px;
              "
              clearable
              maxlength="50"
              placeholder="ค้นหาสินค้า, รหัสสินค้า"
            >
            </n-input>
          </n-input-group>
        </n-space>

        <n-space class="top-content">
          <n-text class="text"> รายการสินค้า </n-text>
          <n-space class="butt">
            <n-button
              round
              class="button"
              type="success"
              @click="showModal = true"
              >เพิ่มสินค้า</n-button
            >
            <n-button round quaternary dashed @click="refreshPage"
              ><n-icon :component="Refresh" size="25" :depth="1"
            /></n-button>

            <n-modal v-model:show="showModal" preset="dialog" title="Dialog">
              <template #header>
                <div>เพิ่มสินค้า</div>
              </template>
              <template #action>
                <n-space vertical style="margin-right: 20px; width: 100%">
                  <n-input
                    style="border-radius: 25px; margin-bottom: 10px"
                    clearable
                    maxlength="50"
                    placeholder="ระบุชื่อสินค้า"
                  ></n-input>
                  <n-input
                    style="border-radius: 25px; margin-bottom: 10px"
                    clearable
                    maxlength="10"
                    placeholder="ระบุรหัสสินค้า"
                  ></n-input>
                  <n-input
                    style="border-radius: 25px; margin-bottom: 10px"
                    clearable
                    maxlength="10"
                    placeholder="ระบุราคา"
                    ><template #suffix> บาท </template></n-input
                  >
                  <n-input
                    style="border-radius: 25px; margin-bottom: 10px"
                    clearable
                    placeholder="ระบุจำนวน"
                    ><template #suffix> หน่วย </template></n-input
                  >
                  <n-button
                    round
                    style="
                      margin-left: 39%;
                      margin-top: 25px;
                      width: 110px;
                      height: 35px;
                    "
                    type="success"
                    @click="handleConfirmEdit"
                    >ยืนยันการเพิ่ม</n-button
                  >
                </n-space>
              </template>
            </n-modal>
          </n-space>
        </n-space>

        <n-data-table
          ref="table"
          :columns="products"
          :data="dataProduct"
          :pagination="pagination"
        />
      </n-space>
    </n-tab-pane>
  </n-tabs>

  <n-modal v-model:show="showEditModal" preset="dialog" title="ยืนยันการแก้ไข">
    <template #header>
      <div>แก้ไขข้อมูลสินค้า</div>
    </template>
    <template #action>
      <n-space vertical style="margin-right: 20px; width: 100%">
        <n-input
          style="border-radius: 25px; margin-bottom: 10px"
          clearable
          maxlength="50"
          placeholder="ระบุชื่อสินค้า"
        ></n-input>
        <n-input
          style="border-radius: 25px; margin-bottom: 10px"
          clearable
          maxlength="10"
          placeholder="ระบุรหัสสินค้า"
        ></n-input>
        <n-input
          style="border-radius: 25px; margin-bottom: 10px"
          clearable
          maxlength="10"
          placeholder="ระบุราคา"
          ><template #suffix> บาท </template></n-input
        >
        <n-input
          style="border-radius: 25px; margin-bottom: 10px"
          clearable
          placeholder="ระบุจำนวน"
          ><template #suffix> หน่วย </template></n-input
        >
        <n-space style="margin-top: 30px; margin-left: 35%">
          <n-button
            round
            type="info"
            @click="handleConfirmEdit, (showEditModal = false)"
            >ยืนยันการแก้ไข</n-button
          >
          <n-button round @click="showEditModal = false">ยกเลิก</n-button>
        </n-space>
      </n-space>
    </template>
  </n-modal>

  <n-modal v-model:show="showDeleteModal" preset="dialog" title="ยืนยันการลบ">
    <template #header>
      <div>ยืนยันการลบสินค้า</div>
    </template>
    <template #action>
      <n-button
        round
        type="error"
        @click="handleConfirmDelete, (showDeleteModal = false)"
        >ยืนยันการลบ</n-button
      >
      <n-button round @click="showDeleteModal = false">ยกเลิก</n-button>
    </template>
  </n-modal>
</template>

<script lang="ts">
import { Refresh, SearchOutline } from '@vicons/ionicons5'
import { h, defineComponent, reactive, ref } from 'vue'
import { NButton, NModal } from 'naive-ui'
import router from '@/router'

export default defineComponent({
  methods: {
    router() {
      return router
    },
  },
  setup() {
    const showEditModal = ref(false)
    const editedEmployee = ref(null)

    const showDeleteModal = ref(false)
    const DeleteEmployee = ref(null)

    const handleEditButton = (row: any) => {
      showEditModal.value = true
      editedEmployee.value = row
    }

    const handleConfirmEdit = () => {
      showModal.value = false
    }

    const handleDeleteButton = (row: any) => {
      showDeleteModal.value = true
      DeleteEmployee.value = row
    }

    const handleConfirmDelete = () => {
      showModal.value = false
    }

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
      {
        title: 'จัดการ',
        key: 'actions',
        align: 'center',
        width: '200px',
        fixed: 'left',
        render: (row: any) => {
          return h('div', [
            h(
              NButton,
              {
                secondary: true,
                round: true,
                type: 'info',
                size: 'small',
                onClick: () => {
                  handleEditButton(row)
                },
                style: {
                  marginRight: '5px',
                },
              },
              'แก้ไข'
            ),
            h(
              NButton,
              {
                secondary: true,
                round: true,
                type: 'error',
                size: 'small',
                onClick: () => {
                  handleDeleteButton(row)
                },
              },
              'ลบ'
            ),
          ])
        },
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

    const products = [
      {
        title: 'ลำดับ',
        key: 'order',
        width: '150px',
        align: 'center',
        sorter: (row1: any, row2: any) => row1.order - row2.order,
      },
      {
        title: 'ชื่อสินค้า',
        key: 'name',
        width: '250px',
        align: 'center',
      },
      {
        title: 'รหัสสินค้า',
        key: 'id',
        width: '150',
        align: 'center',
        sorter: (row1: any, row2: any) => row1.id - row2.id,
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
        title: 'จัดการ',
        key: 'actions',
        align: 'center',
        width: '200px',
        fixed: 'left',
        render: (row: any) => {
          return h('div', [
            h(
              NButton,
              {
                secondary: true,
                round: true,
                type: 'info',
                size: 'small',
                onClick: () => {
                  handleEditButton(row)
                },
                style: {
                  marginRight: '5px',
                },
              },
              'แก้ไข'
            ),
            h(
              NButton,
              {
                secondary: true,
                round: true,
                type: 'error',
                size: 'small',
                onClick: () => {
                  handleDeleteButton(row)
                },
              },
              'ลบ'
            ),
          ])
        },
      },
    ]

    const dataProduct = Array.from({ length: 46 }).map((_, index) => ({
      key: index,
      order: `${index + 1}`,
      name: `ฮาตาริ`,
      id: Math.floor(Math.random() * 1000),
      price: 200,
      quantity: Math.floor(Math.random() * 100),
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

    const showModal = ref(false)
    const EditEmployee = ref(null)

    const refreshPage = () => {
      location.reload() // Reloads the current page
    }

    return {
      pagination: paginationReactive,
      Refresh,
      SearchOutline,
      data,
      columns,
      products,
      dataProduct,
      showModal,
      showEditModal,
      EditEmployee,
      showDeleteModal,
      DeleteEmployee,
      handleConfirmEdit,
      handleEditButton,
      handleDeleteButton,
      handleConfirmDelete,
      refreshPage,
    }
  },
})

import { ProductRestControllerService } from '../../service/productService'

await ProductRestControllerService.createProduct({
  body: {
    name: 'string',
    category: 'test',
    sellPrice: 30,
  },
})
</script>

<style>
.button {
  width: 150px;
  height: 35px;
  font-size: 15px;
}
.top-content {
  margin-left: 45%;
  width: 950px;
  display: flex;
  align-items: center;
}
.butt {
  width: 100%;
  margin-left: 250px;
}
.text {
  font-weight: bold;
  font-size: 30px;
  display: flex;
  align-items: center;
  justify-content: center;
}
.serch {
  margin-top: 10px;
  width: 100%;
  height: 35px;
  display: flex;
  align-items: center;
  justify-content: center;
}
</style>
../../service/productService
