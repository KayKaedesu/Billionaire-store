import express from 'express'
import multer from 'multer'
import * as fs from "node:fs";


const app = express()

app.use(express.json())
app.use(express.urlencoded({ extended: true }));

const multerStorage = multer.diskStorage({
    destination: (req, file, callback) => {
        const {path} = req.body
        const pathPrefix = 'uploads/images/'
        const pathMap = {
            'user-images': 'user/',
            'product-images': 'product/',
        }

        const realPath = pathMap[path] ? pathPrefix + pathMap[path] : null

        if (!realPath) {
            callback(new Error('Invalid path'))
            return
        }
        if (!fs.existsSync(realPath)) {
            fs.mkdirSync(realPath, {recursive: true})
        }
        callback(null, realPath)

    },
    filename(req, file, callback) {
        callback(null, file.originalname)
    }
})

const upload = multer({
    storage: multerStorage,
})
app.get('/uploads/*', (req, res) => {
    return res.sendFile(req.params[0], {
        root: 'uploads/'
    }, (err) => {
        if (err) {
            res.status(404).json({
                success: false,
                message: 'File not found'
            })
        }
    })
})

app.post('/upload', upload.single('file'), (req, res) => {
    res.status(201).send(req.file.destination + req.file.originalname)
})

app.listen(3000, () => {
    console.log('UploadsService listening on port 3000')
})