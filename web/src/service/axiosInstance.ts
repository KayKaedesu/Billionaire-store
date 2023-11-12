import axios from 'axios'

function getAxiosInstance(path: string, withToken: boolean = true) {
  const token: string | null = localStorage.getItem('token')
  if (!path) {
    throw new Error('ใส่ path ด้วย')
  }
  if (!token && withToken) {
    throw new Error('ใส่ token ด้วย')
  }
  const axiosInstance = axios.create({
    baseURL: path,
    headers: {
      Authorization: token ? 'Bearer + ' + token : undefined,
    },
  })
  return axiosInstance
}

export default getAxiosInstance
