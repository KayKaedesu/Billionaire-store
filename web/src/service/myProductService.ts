import getAxiosInstance from "@/service/axiosInstance";

const axios = getAxiosInstance('http://localhost:8080/product-service')


export async function createProduct(body: CreateProductRestModel) {
    return axios.post('/products', body)
}

export async function deleteProduct(body: DeleteProductRestModel) {
    return axios.delete('/products', body)
}

export async function putProduct(body: PutProductRestModel) {
    return axios.put('/products', body)

}
export async function imageUpload(body: CreateProductImageRestModel) {
    return axios.post('/image', body)
}

export async function getProduct() {
    return axios.get('/products')
}


export interface CreateProductRestModel {
    name?: string;
    category?: string;
    sellPrice?: number;
}

export interface DeleteProductRestModel {
    productId?: string;
}

export interface PutProductRestModel {
    productId?: string;
    name?: string;
    category?: string;
    sellPrice?: number;
}

export interface CreateProductImageRestModel {
    productId?: string;
    image?: any;
}



