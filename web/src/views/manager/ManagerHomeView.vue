<script lang="ts">
import { defineComponent } from 'vue'
import { NCard, NGrid, NGridItem } from 'naive-ui'
import { Bar } from 'vue-chartjs'
import {
  Chart as ChartJS,
  Title,
  Tooltip,
  Legend,
  BarElement,
  CategoryScale,
  LinearScale,
} from 'chart.js'

ChartJS.register(Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale)

export default defineComponent({
  name: 'ManagerHomeView',
  components: {
    NCard,
    Bar,
    NGrid,
    NGridItem,
  },
  data() {
    return {
      revenueOptions: {
        responsive: true,
        maintainAspectRatio: false,
        plugins: {
          legend: {
            position: 'bottom',
          },
        },
      },
      revenueData: {
        labels: [
          'January',
          'February',
          'March',
          'April',
          'May',
          'June',
          'July',
        ],
        datasets: [
          {
            label: 'Revenue',
            data: [65, 59, 80, 81, 56, 55, 40],
            fill: false,
            borderColor: 'rgb(75, 192, 192)',
            tension: 0.1,
          },
        ],
      },
      ordersOptions: {
        responsive: true,
        maintainAspectRatio: false,
        plugins: {
          legend: {
            position: 'bottom',
          },
        },
      },
      ordersData: {
        labels: [
          'January',
          'February',
          'March',
          'April',
          'May',
          'June',
          'July',
        ],
        datasets: [
          {
            label: 'Orders',
            data: [12, 19, 3, 5, 2, 3, 7],
            fill: false,
            borderColor: 'rgb(75, 192, 192)',
            tension: 0.1,
          },
        ],
      },
      customersOptions: {
        responsive: true,
        maintainAspectRatio: false,
        plugins: {
          legend: {
            position: 'bottom',
          },
        },
      },
      customersData: {
        labels: [
          'January',
          'February',
          'March',
          'April',
          'May',
          'June',
          'July',
        ],
        datasets: [
          {
            label: 'Customers',
            data: [10, 20, 30, 40, 50, 60, 70],
            fill: false,
            borderColor: 'rgb(75, 192, 192)',
            tension: 0.1,
          },
        ],
      },
    }
  },
})
</script>
<template>
  <NGrid x-gap="12" :cols="3">
    <NGridItem>
      <n-card title="Revenue">
        <Bar :options="revenueOptions" :data="revenueData" />
      </n-card>
    </NGridItem>
    <NGridItem>
      <n-card title="Orders"> </n-card>
    </NGridItem>
    <NGridItem>
      <n-card title="Customers"> </n-card>
    </NGridItem>
  </NGrid>
</template>

<style scoped>
/* Add any custom styles here */
</style>
