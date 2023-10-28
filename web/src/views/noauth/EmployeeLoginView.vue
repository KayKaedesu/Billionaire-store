<template>
  <div class="login-container">
    <n-card class="login-card">
      <n-form-item label="Username">
        <n-input v-model="username" placeholder="Enter your username" />
      </n-form-item>
      <n-form-item label="Password">
        <n-input
          v-model="password"
          type="password"
          placeholder="Enter your password"
        />
      </n-form-item>
      <n-form-item>
        <n-button type="primary" @click="login">Login</n-button>
      </n-form-item>
    </n-card>
  </div>
</template>

<script lang="ts">
export default {
  name: 'EmployeeLoginView',
  data() {
    return {
      username: '',
      password: '',
    }
  },
  methods: {
    login() {
      // Perform login logic here
    },
  },
}
</script>

<style scoped>
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.login-card {
  width: 400px;
  padding: 20px;
}
</style>
