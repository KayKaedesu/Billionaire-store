<template>
  <TimeRangePicker
    @update:model-value="(newTime) => (time = newTime)"
    style="padding-bottom: 1rem"
  />
  <NSpace>
    {{ time }}
    <n-date-picker
      v-if="isCustomTime"
      type="datetimerange"
      clearable
      v-model:value="customTime"
      :actions="['confirm']"
      :default-time="['00:00:00', '23:59:59']"
    />
  </NSpace>
  <NSpace vertical>
    <GraphTemplateVue />
  </NSpace>
</template>
<script lang="ts">
import { defineComponent } from 'vue'
import TimeRangePicker from '@/components/manager/report/TimeRangePicker.vue'
import type { TimeRange } from '@/components/manager/report/types'
import { NSpace, NDatePicker } from 'naive-ui'
import GraphTemplateVue from '@/components/manager/report/GraphTemplate.vue'
export default defineComponent({
  name: 'ManagerHomeView',
  data() {
    return {
      time: undefined as TimeRange | undefined,
      customTime: undefined as [number, number] | undefined,
    }
  },
  methods: {
    formatTime(dateNumber: number) {
      return new Date(dateNumber)
    },
  },
  components: {
    TimeRangePicker,
    NSpace,
    NDatePicker,
    GraphTemplateVue,
  },
  computed: {
    isCustomTime() {
      return !this.time
    },
  },
  watch: {
    customTime(newTime) {
      this.time = {
        startTime: this.formatTime(newTime[0]),
        endTime: this.formatTime(newTime[1]),
      }
    },
  },
})
</script>
