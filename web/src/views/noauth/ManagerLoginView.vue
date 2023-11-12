<template>
  <div class="login-container">
    <div class="svg-container">
      <img
        src="https://i.ytimg.com/vi/XJ2XnxIBWVk/maxresdefault.jpg"
        alt="Corporate Logo"
      />
    </div>
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
import { login as loginFunc } from '../../service/myAuthService'
import {useNotification} from 'naive-ui'
export default {
  name: 'ManagerLoginView',
  data() {
    return {
      username: '',
      password: '',
    }
  },
  methods: {
    async login() {
      try {
        const response = await loginFunc({
          username: this.username,
          password: this.password
        })
        console.log(response)
        localStorage.setItem('token', response.data.accessToken)
        this.$router.push('/manager/home')
      } catch {
        const notif = useNotification()
        notif.error({
          content: 'Username หรือ Password ผิด',
          keepAliveOnHover: true
        })
      }
      // Perform login logic here
    },
  },
}
</script>

<style scoped>
.login-container {
  padding: 10rem;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.svg-container {
  width: 50%;
  display: flex;
  justify-content: center;
  align-items: center;
}

.svg-container img {
  max-width: 100%;
  max-height: 100%;
}

.login-card {
  width: 50%;
  padding: 20px;
}
</style>
