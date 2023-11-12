import getAxiosInstance from "@/service/axiosInstance";

const axios = getAxiosInstance('http://localhost:8080/inventory-service')


export async function createInventory(body: CreateImportRestModel) {
    return axios.post('/inventory', body)
}

export async function deleteInventory(body: DeleteInventoryRestModel) {
    return axios.delete('/inventory', body)
}

export async function getInventory() {
    return axios.get('/inventory')
}


export interface CreateInventoryRestModel {
    /**  */
    productId?: string;

    /**  */
    quantity?: number;
}

export interface DeleteInventoryRestModel {
    /**  */
    productId?: string;

    /**  */
    quantity?: number;
}

