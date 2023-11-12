/** Generate by swagger-axios-codegen */
// @ts-nocheck
/* eslint-disable */

/** Generate by swagger-axios-codegen */
/* eslint-disable */
// @ts-nocheck
import axiosStatic, { AxiosInstance, AxiosRequestConfig } from 'axios'

export interface IRequestOptions extends AxiosRequestConfig {
  /** only in axios interceptor config*/
  loading?: boolean
  showError?: boolean
}

export interface IRequestConfig {
  method?: any
  headers?: any
  url?: any
  data?: any
  params?: any
}

// Add options interface
export interface ServiceOptions {
  axios?: AxiosInstance
  /** only in axios interceptor config*/
  loading: boolean
  showError: boolean
}

// Add default options
export const serviceOptions: ServiceOptions = {}

// Instance selector
export function axios(
  configs: IRequestConfig,
  resolve: (p: any) => void,
  reject: (p: any) => void
): Promise<any> {
  if (serviceOptions.axios) {
    return serviceOptions.axios
      .request(configs)
      .then((res) => {
        resolve(res.data)
      })
      .catch((err) => {
        reject(err)
      })
  } else {
    throw new Error('please inject yourself instance like axios  ')
  }
}

export function getConfigs(
  method: string,
  contentType: string,
  url: string,
  options: any
): IRequestConfig {
  const configs: IRequestConfig = {
    loading: serviceOptions.loading,
    showError: serviceOptions.showError,
    ...options,
    method,
    url,
  }
  if (!localStorage.getItem('token')) {
    console.error('no auth')
    throw new Error('no auth')
  }
  configs.headers = {
    ...options.headers,
    'Content-Type': contentType,
    Authorization: 'Bearer ' + localStorage.getItem('token'),
  }
  return configs
}

export const basePath = 'http://localhost:8080/product-service'

export interface IList<T> extends Array<T> {}
export interface List<T> extends Array<T> {}
export interface IDictionary<TValue> {
  [key: string]: TValue
}
export interface Dictionary<TValue> extends IDictionary<TValue> {}

export interface IListResult<T> {
  items?: T[]
}

export class ListResultDto<T> implements IListResult<T> {
  items?: T[]
}

export interface IPagedResult<T> extends IListResult<T> {
  totalCount?: number
  items?: T[]
}

export class PagedResultDto<T = any> implements IPagedResult<T> {
  totalCount?: number
  items?: T[]
}

// customer definition
// empty

export class ProductQueryControllerService {
  /**
   *
   */
  static getShelf(options: IRequestOptions = {}): Promise<any> {
    return new Promise((resolve, reject) => {
      let url = basePath + '/products'

      const configs: IRequestConfig = getConfigs(
        'get',
        'application/json',
        url,
        options
      )

      /** 适配ios13，get请求不允许带body */

      axios(configs, resolve, reject)
    })
  }
}

export class ProductRestControllerService {
  /**
   *
   */
  static putProduct(
    params: {
      /** requestBody */
      body?: PutProductRestModel
    } = {} as any,
    options: IRequestOptions = {}
  ): Promise<any> {
    return new Promise((resolve, reject) => {
      let url = basePath + '/products'

      const configs: IRequestConfig = getConfigs(
        'put',
        'application/json',
        url,
        options
      )

      let data = params.body

      configs.data = data

      axios(configs, resolve, reject)
    })
  }
  /**
   *
   */
  static createProduct(
    params: {
      /** requestBody */
      body?: CreateProductRestModel
    } = {} as any,
    options: IRequestOptions = {}
  ): Promise<any> {
    return new Promise((resolve, reject) => {
      let url = basePath + '/products'

      const configs: IRequestConfig = getConfigs(
        'post',
        'application/json',
        url,
        options
      )

      let data = params.body

      configs.data = data

      axios(configs, resolve, reject)
    })
  }
  /**
   *
   */
  static deleteProduct(
    params: {
      /** requestBody */
      body?: DeleteProductRestModel
    } = {} as any,
    options: IRequestOptions = {}
  ): Promise<any> {
    return new Promise((resolve, reject) => {
      let url = basePath + '/products'

      const configs: IRequestConfig = getConfigs(
        'delete',
        'application/json',
        url,
        options
      )

      let data = params.body

      configs.data = data

      axios(configs, resolve, reject)
    })
  }
  /**
   *
   */
  static imageUpload(
    params: {
      /** requestBody */
      body?: CreateProductImageRestModel
    } = {} as any,
    options: IRequestOptions = {}
  ): Promise<any> {
    return new Promise((resolve, reject) => {
      let url = basePath + '/products/image'

      const configs: IRequestConfig = getConfigs(
        'post',
        'application/json',
        url,
        options
      )

      let data = params.body

      configs.data = data

      axios(configs, resolve, reject)
    })
  }
}

export interface PutProductRestModel {
  /**  */
  productId?: string

  /**  */
  name?: string

  /**  */
  category?: string

  /**  */
  sellPrice?: number
}

export interface CreateProductRestModel {
  /**  */
  name?: string

  /**  */
  category?: string

  /**  */
  sellPrice?: number
}

export interface CreateProductImageRestModel {
  /**  */
  productId?: string

  /**  */
  file?: string
}

export interface ProductRestModel {
  /**  */
  productId?: string

  /**  */
  quantity?: number
}

export interface DeleteProductRestModel {
  /**  */
  productId?: string
}
