package com.example.dulich.controller;//package com.example.qldl.controller;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//
//
//@Controller
//@RestController
//@RequestMapping("/upload-pdf-api")
//public class FilePDFUplpadController {
//    @PostMapping("/uploadPDF")
//    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
//        try {
//            // Đường dẫn tới thư mục images trong src/main/resources
//            String uploadDir = "src/main/resources/static/images/filePDF/";
//
//            // Tạo đường dẫn đầy đủ tới file
//            Path upload = Paths.get(uploadDir);
//            //nếu có thư mục rồi thì thêm vào___chưa thì tạo thư mục mới
//            if(!Files.exists(upload)){
//                Files.createDirectories(upload);
//            }
//            // Lưu file vào vị trí được chỉ định
//            Path filPath = upload.resolve(file.getOriginalFilename());
//            Files.copy(file.getInputStream(), filPath, StandardCopyOption.REPLACE_EXISTING);
//
//            return ResponseEntity.ok().body("File uploaded successfully!");
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while uploading the file: " + e.getMessage());
//        }
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleException(Exception e) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while processing the request: " + e.getMessage());
//    }
//}
