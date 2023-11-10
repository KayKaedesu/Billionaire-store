<template>
  <n-space vertical>
    <n-space
        vertical
        :style="{
            position: 'fixed',
            top: 0,
            left: 0,
            width: '100%',
            zIndex: 100,
            background: 'white',
            padding: '10px',
          }"
    >
      <n-input-group class="serch">
        <n-icon :component="SearchOutline" size="35" :depth="1" style="margin-right: 20px" />
        <n-input style="border-radius: 25px; width: 50%; justify-content: center; height: 35px"
                 clearable maxlength="50" show-count
                 placeholder="ค้นหารายชื่อพนักงาน, รหัสพนักงาน">
        </n-input>
      </n-input-group>
    </n-space>

    <n-space class="top-content">
      <n-text class="text">
        รายชื่อพนักงาน
      </n-text>
      <n-space class="butt">
        <Icon icon="iconoir:sort-up" width="35px"/>
        <n-select class="select"
                  default-value="เรียงตามลำดับ"
                  :options="[
                   {
                    label: 'เรียงตามลำดับ',
                    value: '1',
                  },
                  {
                    label: 'เรียงตามชื่อ',
                    value: '2',
                  },
                  {
                    label: 'เรียงตามรหัสพนักงาน',
                    value: '3',
                  },
                  {
                    label: 'เรียงตามตำแหน่ง',
                    value: '4',
                  },
                ]"
        />
        <n-button round class="button" type="success"  @click="showModal = true" >เพิ่มพนักงาน</n-button>
        <n-button round quaternary dashed @click="" ><n-icon :component="Refresh" size="25" :depth="1" /></n-button>
        <n-modal v-model:show="showModal" preset="dialog" title="Dialog">
          <template #header>
            <div>เพิ่มพนักงาน</div>
          </template>
          <template #action>
            <n-space vertical  style=" margin-right: 20px; width: 100%;">
              <n-input style="border-radius: 25px; margin-bottom: 10px;" clearable maxlength="50" show-count placeholder="ระบุชื่อพนักงาน"></n-input>
              <n-input style="border-radius: 25px; margin-bottom: 10px;" clearable maxlength="10" show-count placeholder="ระบุรหัสพนักงาน"></n-input>
              <n-input style="border-radius: 25px; margin-bottom: 10px;" clearable maxlength="50" show-count placeholder="ระบุอีเมล"></n-input>
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
              <n-button round style="margin-left: 39%;margin-top: 25px; width: 110px; height: 35px" type="success"  @click="showModal = false" >เพิ่มพนักงาน</n-button>
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
      <n-space vertical  style=" margin-right: 20px; width: 100%;">
        <n-input style="border-radius: 25px; margin-bottom: 10px;" clearable maxlength="50" show-count placeholder="ระบุชื่อพนักงาน"></n-input>
        <n-input style="border-radius: 25px; margin-bottom: 10px;" clearable maxlength="10" show-count placeholder="ระบุรหัสพนักงาน"></n-input>
        <n-input style="border-radius: 25px; margin-bottom: 10px;" clearable maxlength="50" show-count placeholder="ระบุอีเมล"></n-input>
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
        <n-space style="margin-top: 30px; margin-left: 35%;">
          <n-button round type="info" @click="handleConfirmEdit, showEditModal = false">ยืนยัน</n-button>
          <n-button round @click="showEditModal = false">ยกเลิก</n-button>
        </n-space>
      </n-space>
    </template>
  </n-modal>

  <n-modal v-model:show="showDeleteModal" preset="dialog" title="ยืนยันการลบ">
    <template #header>
      <div>ยืนยันการลบพนักงาน</div>
    </template>
    <template #action>
      <n-button round type="error" @click="handleConfirmDelete, showDeleteModal = false">ยืนยัน</n-button>
      <n-button round @click="showDeleteModal = false">ยกเลิก</n-button>
    </template>
  </n-modal>

</template>

<script lang="ts">
import { Refresh, SearchOutline} from '@vicons/ionicons5'
import { h,defineComponent, reactive, ref } from 'vue'
import {NButton, NModal  } from 'naive-ui'

export default defineComponent({
  setup () {

    const showEditModal = ref(false);
    const editedEmployee = ref(null);

    const showDeleteModal = ref(false);
    const DeleteEmployee = ref(null);

    const handleEditButton = (row: any) => {
      showEditModal.value = true;
      editedEmployee.value = row;
    };

    const handleConfirmEdit = () => {
      showModal.value = false;
    };

    const handleDeleteButton = (row: any) => {
      showDeleteModal.value = true;
      DeleteEmployee.value = row;
    };

    const handleConfirmDelete = () => {
      showModal.value = false;
    };

    const columns = [
      {
        title: 'ลำดับ',
        key: 'order',
        width: '50px',
        align: 'center',
      },
      {
        title: 'ชื่อพนักงาน',
        key: 'name',
        width: '150px',
        align: 'center',
      },
      {
        title: 'รหัสพนักงาน',
        key: 'id',
        width: '150px',
        align: 'center',
      },
      {
        title: 'ตำแหน่ง',
        key: 'role',
        width: '150px',
        align: 'center',
      },
      {
        title: 'อีเมล',
        key: 'email',
        width: '200px',
        align: 'center',
      },
      {
        title: 'จัดการ',
        key: 'actions',
        align: 'center',
        width: '100px',
        fixed: 'left',
        render: (row: any) => {
          return h('div', [
            h(NButton, {
              secondary: true,
              round: true,
              type: 'info',
              size: 'small',
              onClick: () => {
                handleEditButton(row);
              },
              style: {
                marginRight: '5px',
              },
            }, 'แก้ไข'),
            h(NButton, {
              secondary: true,
              round: true,
              type: 'error',
              size: 'small',
              onClick: () => {
                handleDeleteButton(row);}
            }, 'ลบ'),
          ])
        },
      },
    ]

    const data = Array.from({ length: 46 }).map((_, index) => ({
      key: index,
      order: `${index + 1}`,
      name: `Edward King ${index + 1 }`,
      id: `${index + 1}`,
      role: `Role`,
      email: `woker@gmail.com`
    }))

    const paginationReactive = reactive({
      page: 1,
      pageSize: 10,
      showSizePicker: true,
      pageSizes: [10, 15, 20],
      onChange: (page: number) => {
        paginationReactive.page = page
      },
      onUpdatePageSize: (pageSize: number) => {
        paginationReactive.pageSize = pageSize
        paginationReactive.page = 1
      }
    })

    const showModal = ref(false);
    const EditEmployee = ref(null);

    return {
      data,
      columns,
      pagination: paginationReactive,
      Refresh,
      SearchOutline,
      showModal,
      showEditModal,
      EditEmployee,
      handleConfirmEdit,
      handleEditButton,
      showDeleteModal,
      DeleteEmployee,
      handleDeleteButton,
      handleConfirmDelete
    }
  }
})
</script>

<style>
#app {
  padding: 10px;
}
.button {
  width: 110px;
  height: 35px;
  font-size: 15px;
}
.top-content {
  margin-top: 50px;
  margin-left: 45%;
  width: 1000px;
  display: flex;
  align-items: center;
}
.butt{
  margin-left: 250px;
}
.select{
  width: 180px;
}
.text{
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