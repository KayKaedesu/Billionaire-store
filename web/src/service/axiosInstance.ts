import axios from 'axios'

function getAxiosInstance(path: string) {
    const token: string | undefined = localStorage.getItem('token')
    if (!path) {
        throw new Error('ใส่ path ด้วย')
    }
    if (!token) {
        throw new Error('ใส่ token ด้วย')
    }
    const axiosInstance = axios.create({
        baseURL: path,
        headers: {
            Authorization: 'Bearer + '
        }
    })
    return axiosInstance
}


export default getAxiosInstance