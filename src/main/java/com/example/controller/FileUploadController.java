package com.example.controller;

import com.example.model.Result;
import com.example.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author danny
 * @date 2020/6/2下午2:48
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("/file/upload/formdata")
    public Result fileUploadFormData(@RequestParam("file") MultipartFile file){
        return fileUploadService.fileUploadFormData(file);
    }
}
