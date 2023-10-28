<template>
  <main>
    <router-link :to="{ name: 'ManagerHome' }">
      <n-button type="primary"> Owner </n-button>
    </router-link>
    <router-link :to="{ name: 'ManagerHome' }">
      <n-button type="info"> Info </n-button>
    </router-link>
  </main>
</template>
