const { codegen } = require('swagger-axios-codegen')
codegen({
  methodNameMode: 'operationId',
  remoteUrl: 'http://localhost:4444/v3/api-docs',
})
