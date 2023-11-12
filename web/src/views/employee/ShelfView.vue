<template>
  <n-space vertical>
    <n-space vertical :style="{
      position: 'fixed',
      top: 0,
      left: 0,
      width: '100%',
      zIndex: 100,
      background: 'white',
      padding: '10px',
    }">
      <n-input-group class="serch">
        <n-icon :component="SearchOutline" size="35" :depth="1" style="margin-right: 20px" />
        <n-input style="border-radius: 25px; width: 50%; justify-content: center; height: 35px" clearable maxlength="50"
          show-count placeholder="ค้นหาสินค้าหน้าร้าน">
        </n-input>
      </n-input-group>
    </n-space>

    <n-space class="top-content" justify="space-around">
      <n-space>
        <n-h1>
          รายการสินค้าหน้าร้าน
        </n-h1>
      </n-space>
      <n-space></n-space>
      <n-space justify="end">
        <n-button round quaternary dashed @click="refreshPage"><n-icon :component="Refresh" size="25"
            :depth="1" /></n-button>
        <n-button round class="button" type="success" @click="showModal = true">เพิ่มสินค้าเข้าหน้าร้าน</n-button>
        <n-button round class="button" type="success" @click="navigateToCashier">หน้าแคชเชียร์</n-button>
        <n-modal v-model:show="showModal" preset="dialog" title="Dialog">
          <template #header>
            <div>เพิ่มสินค้าเข้าหน้าร้าน</div>
          </template>
          <n-space vertical>
            <n-select filterable placeholder="เลือกสินค้า" v-model:value="selectedInvenValue" :options="shelfItems" />
            <n-input clearable placeholder="จำนวน"></n-input>
          </n-space>
          <template #action>
            <n-button 
              round style="margin: auto;" 
              type="success" @click="showModal = false">เพิ่มสินค้า
            </n-button>
          </template>
        </n-modal>
      </n-space>
    </n-space>

    <n-space justify="center" style="margin-left: 40px; margin-right: 40px;">
      <n-card :title="item.name" hoverable v-for="(item, index) in items" :key="index">
        <template #cover>
          <img :src="item.image">
        </template>
        <template #header-extra>
          x{{ item.amount }}
        </template>
        {{ item.price }} บาท
      </n-card>
    </n-space>
  </n-space>
</template>

<script lang="ts">
import { Refresh, SearchOutline } from '@vicons/ionicons5'
import { defineComponent, ref } from 'vue'
import router from "@/router";
import {useRouter} from "vue-router";

export default defineComponent({
  methods: {
    router() {
      return router
    }
  },
  setup() {
    const showModal = ref(false);

    const items = [
      {
        id: 1,
        name: 'Product 1',
        image: 'https://07akioni.oss-cn-beijing.aliyuncs.com/07akioni.jpeg',
        amount: 10,
        price: 100
      },
      {
        id: 2,
        name: 'Product 2',
        image: 'https://07akioni.oss-cn-beijing.aliyuncs.com/07akioni.jpeg',
        amount: 20,
        price: 200
      },
      {
        id: 3,
        name: 'Product 3',
        image: 'https://07akioni.oss-cn-beijing.aliyuncs.com/07akioni.jpeg',
        amount: 30,
        price: 300
      },
      {
        id: 4,
        name: 'Product 4',
        image: 'https://07akioni.oss-cn-beijing.aliyuncs.com/07akioni.jpeg',
        amount: 40,
        price: 400
      },
      {
        id: 5,
        name: 'Product 5',
        image: 'https://07akioni.oss-cn-beijing.aliyuncs.com/07akioni.jpeg',
        amount: 50,
        price: 500
      },
      {
        id: 6,
        name: 'Product 6',
        image: 'https://07akioni.oss-cn-beijing.aliyuncs.com/07akioni.jpeg',
        amount: 60,
        price: 600
      },
      {
        id: 7,
        name: 'Product 7',
        image: 'https://07akioni.oss-cn-beijing.aliyuncs.com/07akioni.jpeg',
        amount: 70,
        price: 700
      },
      {
        id: 8,
        name: 'Product 8',
        image: 'https://07akioni.oss-cn-beijing.aliyuncs.com/07akioni.jpeg',
        amount: 80,
        price: 800
      }
    ];

    const shelfItems = [
      {
        label: 'InventoryItem 1 | 50 บาท | 5x',
        value: '1',
      },
      {
        label: 'InventoryItem 2 | 50 บาท | 5x',
        value: '2',
      },
    ];

    const selectedInvenValue = ref(null);


    const router = useRouter();
    const navigateToCashier = () => {
      router.push('/employee/cashier');
    }

    const refreshPage = () => {
      location.reload();
    }

    return {
      items,
      shelfItems,
      selectedInvenValue,
      Refresh,
      SearchOutline,
      showModal,
      refreshPage,
      navigateToCashier,
    }
  }
})
</script>

<style>
#app {
  padding: 10px;
}

.button {
  /* width: 150px; */
  height: 35px;
  font-size: 15px;
}

.top-content {
  margin-top: 60px;
}

.n-card {
  max-width: 300px;
}

.n-grid {
  display: flex;
  justify-content: center;
  flex-direction: column;
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