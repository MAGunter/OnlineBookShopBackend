package com.kazakhi.onlinebookshop.controller;

import com.kazakhi.onlinebookshop.service.impl.FileStorageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload")
@RequiredArgsConstructor
@Tag(name = "File Upload", description = "File upload operations")
@CrossOrigin(origins = "http://localhost:3000")

public class FileUploadController {

    private final FileStorageService fileStorageService;

    @PostMapping
    @Operation(summary = "Upload a file", description = "Upload a file to the server")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String fileUrl = fileStorageService.storeFile(file);
        return ResponseEntity.ok(fileUrl);
    }
}

