<template>
  <n-tabs type="segment">

<!--    // ******************************************* ส่วนหนักงาน ***************************************************//-->

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
        <n-text class="text"> รายชื่อพนักงาน </n-text>
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

      <n-space class="butt">
        <n-button round class="button" type="success" @click="showModal = true">เพิ่มพนักงาน</n-button>
        <n-button round quaternary dashed @click="refreshPage"><n-icon :component="Refresh" size="25" :depth="1"
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

      <n-modal v-model:show="showEditModal" preset="dialog" title="ยืนยันการแก้ไข">
        <template #header>
          <div>แก้ไขข้อมูลพนักงาน</div>
        </template>
        <template #action>
          <n-space vertical style="margin-right: 20px; width: 100%">
            <n-input
                style="border-radius: 25px; margin-bottom: 10px"
                clearable
                maxlength="50"
                placeholder="ระบุชื่อชื่อพนักงาน"
            ></n-input>
            <n-input
                style="border-radius: 25px; margin-bottom: 10px"
                clearable
                maxlength="10"
                placeholder="ระบุรหัสพนักงาน"
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
            <n-input
                style="border-radius: 25px; margin-bottom: 10px"
                clearable
                placeholder="ระบุอีเมล"
            ></n-input>
            <n-space style="margin-top: 30px; margin-left: 25%">
              <n-button
                  round
                  type="info"
                  @click="handleConfirmProductEdit, (showEditModal = false)"
              >ยืนยันการแก้ไข</n-button
              >
              <n-button round @click="showEditModal = false">ยกเลิก</n-button>
            </n-space>
          </n-space>
        </template>
      </n-modal>


      <n-modal v-model:show="showDeleteModal"  preset="dialog" title="ยืนยันการลบ">
        <template #header>
          <div>ยืนยันการลบพนักงาน</div>
        </template>
        <template #action>
          <n-button
              round
              type="error"
              @click="handleConfirmDelete, showDeleteModal= false"
          >ยืนยันการลบ</n-button>
          <n-button round @click="showDeleteModal = false">ยกเลิก</n-button>
        </template>
      </n-modal>

    </n-tab-pane>
<!--    // ******************************************* ส่วนหนักงาน ***************************************************//-->
<!--    // ******************************************* ส่วนสินค้า *****************************************************//-->
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
          <n-text class="text"> รายการสินค้า </n-text>
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

          <n-space class="butt">
            <n-button round class="button" type="success" @click="showModal = true"
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
                  ><template #suffix>
                    บาท
                  </template></n-input>
                  <n-input
                      style="border-radius: 25px; margin-bottom: 10px"
                      clearable
                      placeholder="ระบุจำนวน"
                  ><template #suffix>
                    หน่วย
                  </template></n-input>
                  <n-button
                      round
                      style="
                  margin-left: 39%;
                  margin-top: 25px;
                  width: 110px;
                  height: 35px;
                "
                      type="success"
                      @click="handleConfirmProductEdit"
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

      <n-modal v-model:show="showEditProductModal" preset="dialog" title="ยืนยันการแก้ไข">
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
            ><template #suffix>
              บาท
            </template></n-input>
            <n-input
                style="border-radius: 25px; margin-bottom: 10px"
                clearable
                placeholder="ระบุจำนวน"
            ><template #suffix>
              หน่วย
            </template></n-input>
            <n-space style="margin-top: 30px; margin-left: 25%">
              <n-button
                  round
                  type="info"
                  @click="handleConfirmProductEdit, (showEditProductModal = false)"
              >ยืนยันการแก้ไข</n-button
              >
              <n-button round @click="showEditProductModal = false">ยกเลิก</n-button>
            </n-space>
          </n-space>
        </template>
      </n-modal>


      <n-modal v-model:show="showDeleteProductModal"  preset="dialog" title="ยืนยันการลบ">
        <template #header>
          <div>ยืนยันการลบสินค้า</div>
        </template>
        <template #action>
          <n-button
              round
              type="error"
              @click="handleConfirmDelete, showDeleteProductModal= false"
          >ยืนยันการลบ</n-button>
          <n-button round @click="showDeleteProductModal = false">ยกเลิก</n-button>
        </template>
      </n-modal>
    </n-tab-pane>
  </n-tabs>

  <!--  // ******************************************* ส่วนสินค้า *****************************************************//-->
</template>



<script lang="ts">
import { Refresh, SearchOutline } from '@vicons/ionicons5'
import { h, defineComponent, reactive, ref } from 'vue'
import { NButton, NModal } from 'naive-ui'
import router from '@/router'

// import { ProductRestControllerService } from '../../../service/productService'
//
// await ProductRestControllerService.createProduct({
//   body: {
//     name: 'string',
//     category: 'test',
//     sellPrice: 30,
//   },
// })

export default defineComponent({
  methods: {
    router() {
      return router
    },
  },

  setup() {


    // ******************************************* ส่วนหนักงาน ***************************************************//
    const showEditModal = ref(false)
    const editedEmployee = ref(null)
    const handleEditButton = (row: any) => {
      showEditModal.value = true
      editedEmployee.value = row
    }
    const handleConfirmEdit = () => {
      showModal.value = false
    }


    const showDeleteModal = ref(false)
    const DeleteEmployee = ref(null)
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

    // ******************************************* ส่วนหนักงาน ***************************************************//
    // ******************************************* ส่วนสินค้า *****************************************************//

    const showEditProductModal = ref(false)
    const editedProduct = ref(null)

    const handleEditProductButton = (row: any) => {
      showEditProductModal.value = true
      editedProduct.value = row
    }
    const handleConfirmProductEdit = () => {
      showModal.value = false
    }

    const showDeleteProductModal = ref(false)
    const DeleteProduct = ref(null)

    const handleDeleteProductButton = (row: any) => {
      showDeleteProductModal.value = true
      DeleteProduct.value = row
    }
    const handleConfirmProductDelete = () => {
      showModal.value = false
    }

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
                    handleEditProductButton(row)
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
                    handleDeleteProductButton(row)
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
    // ******************************************* ส่วนสินค้า ***************************************************//


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

    const refreshPage = () => {
      location.reload()
    }

    return {
      pagination: paginationReactive,
      Refresh,
      SearchOutline,
      showModal,

      columns,
      data,
      showEditModal,
      showDeleteModal,
      DeleteEmployee,

      products,
      dataProduct,
      showEditProductModal,
      showDeleteProductModal,
      DeleteProduct,

      handleConfirmEdit,
      handleEditButton,
      handleDeleteButton,
      handleConfirmDelete,
      handleConfirmProductEdit,
      handleEditProductButton,
      handleDeleteProductButton,
      handleConfirmProductDelete,
      refreshPage,
    }
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
  margin-left: 68%;
  width: 950px;
  display: flex;
  align-items: center;
}
.butt {
  width: 100%;
  margin-left: 250px;
  margin-top: 10px;
  margin-bottom: 10px;
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