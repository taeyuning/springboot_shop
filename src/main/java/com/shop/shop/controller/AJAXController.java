package com.shop.shop.controller;

import com.shop.shop.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class AJAXController {
    @Value("${imglocation}")
    String imgdir;
    @PostMapping("/saveimg")
    public String saveimg(Model model, MultipartFile file){
        String filename = file.getOriginalFilename();
        FileUploadUtil.saveFile(file, imgdir);
        return filename;
    }
}
