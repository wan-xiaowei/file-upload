package com.me.Controller;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by admin on 2017/8/15.
 */
@RestController
public class FileUploadController {
    @PostMapping(value = "upload")
    public String handleFileUpload(@RequestParam(value = "file", required = true) MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            File fileToSave = new File(file.getOriginalFilename());
            FileCopyUtils.copy(bytes, fileToSave);
            return fileToSave.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
