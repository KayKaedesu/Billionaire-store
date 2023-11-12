<template>
  <n-layout has-sider sider-placement="right">
    <n-layout>
      <n-space vertical>
        <n-input-group style="padding: 1rem">
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
              placeholder="ค้นหารายชื่อสินค้า"
          >
          </n-input>
        </n-input-group>
      </n-space>
      <n-space justify="center">
        <template :key="index" v-for="(a, index) in Array.from(Array(20))">
          <n-card :bordered="true" class="card" title="Name">
            <template #cover>
              <img
                  src="https://07akioni.oss-cn-beijing.aliyuncs.com/07akioni.jpeg"
              />
            </template>
            <template #footer> xxx THB </template>
          </n-card>
        </template>
      </n-space>
    </n-layout>
    <n-layout-sider
        width="400"
        content-style="padding: 0.5rem 1rem; background-color: rgb(209, 209, 209);"
    >
      <h2 style="text-align: center; padding-bottom: 1rem">List Order</h2>
      <NScrollbar style="max-height: 500px;">
        <n-space vertical>
          <template :key="index" v-for="(a, index) in Array.from(Array(20))">
            <n-card title="Name" style="display: flex; justify-content: center; max-height: 100%">
              <n-space align="center">
                xxx THB
                <n-button class="btn" strong type="success"
                >-</n-button
                >
                5
                <n-button class="btn" strong type="success"
                >+</n-button
                >
              </n-space>
              template</n-card
            >
          </template>
        </n-space>
      </NScrollbar><n-space style="display: flex; justify-content: center;">
      <p>Total xxx THB</p>
      <n-button type="success" @click="a" style="display: flex; justify-content: center;"> ยืนยันรายการสินค้า </n-button>
      <n-button type="success" @click="navigateToShelf" style="display: flex; justify-content: center;"> ชั้นวางสินค้า </n-button>
    </n-space>

    </n-layout-sider>
  </n-layout>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
import {
  NSpace,
  NCard,
  NButton,
  NLayout,
  NLayoutSider,
  NScrollbar,
} from 'naive-ui'
import { SearchOutline } from '@vicons/ionicons5'
import { useRouter } from 'vue-router';

export default defineComponent({
  methods: {},
  data() {
    return {
      SearchOutline,
    }
  },
  components: {
    NSpace,
    NLayoutSider,
    NCard,
    NButton,
    NLayout,
    NScrollbar,
  },
  setup() {
    // data:[]
    // cart:[]

    const router = useRouter();
    const navigateToShelf = () => {
      router.push('/employee/shelf'); // Navigate to the specified route
    };

    return{
      navigateToShelf
    }
  },
})
</script>
<style>
.card {
  border-radius: 10mm;
  background-color: rgb(209, 209, 209);
  box-shadow: 1cm;
  width: 200px;
  height: 250px;
  color: green;
  font-weight: bold;
}
.blist {
}
/* .list {
  background-color: white;
  box-shadow: 1cm;
  width: 250px;
  height: 110px;
  color: green;
  font-weight: bold;
} */
.n-button {
  border-radius: 10mm;
  padding: 5mm;
  width: 50mm;
  font-size: 5mm;
}
.btn {
  width: 50px;
  height: 10px;
}
p {
  font-weight: bolder;
  font-size: 30px;
}
</style>
