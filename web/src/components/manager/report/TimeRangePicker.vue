<template>
  <n-tabs type="line" @update-value="handleTabChange">
    <n-tab
      v-for="(data, name) in availableDateRanges"
      :key="name"
      :name="name"
      >{{ capitalize(name) }}</n-tab
    >
    <n-tab name="custom"> กำหนดเอง </n-tab>
  </n-tabs>
</template>
<script lang="ts">
import moment from 'moment'
import { NTabs, NTab } from 'naive-ui'
import type { TimeRange } from './types'
import { defineComponent, type PropType } from 'vue'
export default defineComponent({
  name: 'TimeRangePicker',
  emits: {
    'update:modelValue': (timeRange: TimeRange) => true,
  },
  props: {
    modelValue: {
      type: Object as PropType<TimeRange>,
    },
  },
  components: {
    NTabs,
    NTab,
  },
  methods: {
    handleTabChange(tabName: string) {
      const timeRange = this.availableDateRanges[tabName]
      this.$emit('update:modelValue', timeRange)
    },
    capitalize(str: string, lower = false) {
      return (lower ? str.toLowerCase() : str).replace(
        /(?:^|\s|["'([{])+\S/g,
        (match) => match.toUpperCase()
      )
    },
  },
  data() {
    const currentDate = moment()
    const availableDateRanges: Record<string, TimeRange> = {
      วันนี้: {
        startTime: currentDate.clone().startOf('day').toDate(),
        endTime: currentDate.clone().endOf('day').toDate(),
      },
      เมื่อวาน: {
        startTime: currentDate
          .clone()
          .subtract(1, 'day')
          .startOf('day')
          .toDate(),
        endTime: currentDate.clone().subtract(1, 'day').endOf('day').toDate(),
      },
      สัปดาห์นี้: {
        startTime: currentDate.clone().startOf('week').toDate(),
        endTime: currentDate.clone().endOf('week').toDate(),
      },
      สัปดาห์ที่แล้ว: {
        startTime: currentDate
          .clone()
          .subtract(1, 'week')
          .startOf('week')
          .toDate(),
        endTime: currentDate.clone().subtract(1, 'week').endOf('week').toDate(),
      },

      เดือนนี้: {
        startTime: currentDate.clone().startOf('month').toDate(),
        endTime: currentDate.clone().endOf('month').toDate(),
      },
      เดือนที่แล้ว: {
        startTime: currentDate
          .clone()
          .subtract(1, 'month')
          .startOf('month')
          .toDate(),
        endTime: currentDate
          .clone()
          .subtract(1, 'month')
          .endOf('month')
          .toDate(),
      },
    }
    return {
      availableDateRanges,
    }
  },
  created() {
    console.log(this.availableDateRanges.วันนี้)
    this.$emit('update:modelValue', this.availableDateRanges.วันนี้)
  },
})
</script>
