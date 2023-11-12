import getAxiosInstance from './axiosInstance'

export type LoginRequestModel = {
  username: string
  password: string
}
export type LoginResponse = {
  accessToken: string
  refreshToken: string
}

const axios = getAxiosInstance('http://localhost:8080/auth-service', false)

export async function login(body: LoginRequestModel) {
  return axios.post<LoginResponse>('/auth/login', body)
}
