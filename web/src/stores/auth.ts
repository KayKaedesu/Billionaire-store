import { defineStore } from 'pinia'

interface AuthState {
  token: string | null
}

export const useAuthStore = defineStore({
  id: 'auth',
  state: (): AuthState => ({
    token: localStorage.getItem('token') || null,
  }),
  getters: {
    isAuthenticated: (state) => !!state.token,
  },
  actions: {
    login(token: string) {
      this.token = token
      localStorage.setItem('token', token)
    },
    logout() {
      this.token = null
      localStorage.removeItem('token')
    },
  },
})
