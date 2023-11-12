import getAxiosInstance from "@/service/axiosInstance";

const axios = getAxiosInstance('http://localhost:8080/import-service')


export async function createProduct(body: CreateImportRestModel) {
    return axios.post('/imports', body)
}

export async function buyProduct(body: BuyProductRestModel) {
    return axios.post('/buy', body)
}
export async function getImport(){
    return axios.get('/imports')
}


export interface BuyProductRestModel {
    /**  */
    productId?: string;

    /**  */
    userId?: string;

    /**  */
    name?: string;

    /**  */
    category?: string;

    /**  */
    buyPrice?: number;

    /**  */
    quantity?: number;
}

export interface CreateImportRestModel {
    /**  */
    productId?: string;

    /**  */
    name?: string;

    /**  */
    category?: string;

    /**  */
    buyPrice?: number;
}
