import getAxiosInstance from "@/service/axiosInstance";

const axios = getAxiosInstance('http://localhost:8080/shelf-service')


export async function createShelf(body: CreateShelfRestModel) {
    return axios.post('/shelf', body)
}

export async function deleteShelf(body: DeleteShelfRestModel) {
    return axios.delete('/shelf', body)
}

export async function putShelf(body: UpdateShelfRestModel) {
    return axios.put('/shelf', body)

}
export async function addShelf(body: InventoryToShelfRestModel) {
    return axios.post('/toShelf', body)
}

export async function addInventory(body: ShelfToInventoryRestModel) {
    return axios.post('/toInventory', body)
}

export async function getInventory() {
    return axios.get('/shelf')
}


export interface CreateShelfRestModel {
    productId?: string;

    quantity?: number;
}

export interface DeleteShelfRestModel {
    productId?: string;

    quantity?: number;
}

export interface UpdateShelfRestModel {
    productId?: string;

    quantity?: number;
}

export interface InventoryToShelfRestModel {
    productId?: string;

    quantity?: number;
}

export interface ShelfToInventoryRestModel {
    aggregateId?: string;

    productId?: string;

    quantity?: number;
}

