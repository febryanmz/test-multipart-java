package com.bni.testmultipart.controller;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("/test")
@Slf4j
@Validated
public class TestController {

    @PostMapping(value = "/upload-object", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadObject(
            @RequestPart("file") @NotNull MultipartFile file,
            @RequestPart("appMsgId") @NotNull String appMsgId){
        log.info("Received file upload request: appMsgId={}",
                appMsgId);

        // Simulate processing the uploaded file
        String originalFileName = file.getOriginalFilename();
        log.info("Processing file: {}", originalFileName);

        // Return a success response
        String responseMessage = String.format("File '%s' processed successfully with appMsgId=%s",
                originalFileName, appMsgId);
        return ResponseEntity.ok(responseMessage);

    }
}
