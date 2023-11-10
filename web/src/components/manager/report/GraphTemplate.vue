<!-- eslint-disable vue/no-reserved-component-names -->
<template>
  <Line :data="data" :options="options" />
</template>

<script lang="ts">
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  PointElement,
  LineElement,
  Title,
  Tooltip,
  Legend,
  type ChartData,
} from 'chart.js'
import { defineComponent } from 'vue'
import { Line } from 'vue-chartjs'

ChartJS.register(
  CategoryScale,
  LinearScale,
  PointElement,
  LineElement,
  Title,
  Tooltip,
  Legend
)

export default defineComponent({
  name: 'GraphTemplate',
  components: {
    Line,
  },
  data() {
    const data: ChartData = {
      labels: [
        'January',
        'February',
        'March',
        'April',
        'May',
        'June',
        NaN,
        'July',
        'August',
        'September',
        'October',
        'November',
        'December',
      ],
      datasets: [
        {
          label: 'Cubic interpolation (monotone)',
          data: [0, 20, 20, 60, 60, 120, NaN, 180, 120, 125, 105, 110, 170],
          backgroundColor: '#f87979',
          cubicInterpolationMode: 'monotone',
          tension: 0.4,
        },
      ],
    }
    const options = {
      responsive: true,
      // maintainAspectRatio: false,
      layout: {
        // padding: 20,
      },
    }

    return {
      data,
      options,
    }
  },
})
</script>
