const { codegen } = require('swagger-axios-codegen')

// ตอน gen ต้องเปลี่ยน port ตามขึ้นใน intellij
// เสร็จแล้ว ต้องไปแก้ baseUrl ให้เป็น :8080/{service-name} ในไฟล์ที่ gen มาอยู่ใน ../service/{fileName}
// เพิ่ม auth ตามข้างล่าง
// if (!localStorage.getItem('token')) {
//   console.error('no auth')
//   throw new Error('no auth')
// }
// configs.headers = {
//   ...options.headers,
//   'Content-Type': contentType,
//   Authorization: 'Bearer ' + localStorage.getItem('token'),
// }


codegen({
  fileName: 'productService.ts',
  remoteUrl: 'http://127.0.0.1:65522/v3/api-docs',
})





