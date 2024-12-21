package com.kazakhi.onlinebookshop.controller;

import com.kazakhi.onlinebookshop.service.impl.FileStorageService;
import com.kazakhi.onlinebookshop.utility.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload")
@RequiredArgsConstructor
@Tag(name = "File Upload", description = "File upload operations")
public class FileUploadController {

    private final FileStorageService fileStorageService;

    @PostMapping
    @Operation(summary = "Upload a file", description = "Upload a file to the server")
    public ResponseEntity<ApiResponse<String>> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String fileUrl = fileStorageService.storeFile(file);
            return ResponseEntity.ok(new ApiResponse<>(fileUrl, "File uploaded successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(null, "File upload failed: " + e.getMessage()));
        }
    }
}


