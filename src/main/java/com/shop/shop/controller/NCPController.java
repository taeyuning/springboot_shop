package com.shop.shop.controller;

import com.shop.shop.dto.NCPDTO;
import com.shop.shop.util.CFRUtil;
import com.shop.shop.util.FileUploadUtil;
import com.shop.shop.util.OCRUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class NCPController {
  @Value("${imglocation}")
  String imgpath;             //C:.projectimg/img

  @RequestMapping("/ocr")
  public String ocr(Model model){
    model.addAttribute("center", "ocr");
    return "main";
  }
  @RequestMapping("/ocrimpl")
  public String ocrimpl(Model model, NCPDTO ncpdto){          //파일 업로드
    String imgname = ncpdto.getImg().getOriginalFilename();

    FileUploadUtil.saveFile(ncpdto.getImg(), imgpath);        //파일 세이브
    String result = OCRUtil.getText(imgpath, imgname);        //결과 받기 json문자열로 반환함

    Map<String, String> map = null;                           //파싱해서 결과를 받기
    try {
      map = OCRUtil.getCompanyinfo(result);                   //result에는 json객체가 들어있다
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    model.addAttribute("imgname",imgname);
    model.addAttribute("name",map.get("name"));              //화면에 뿌리기
    model.addAttribute("num",map.get("num"));
    model.addAttribute("center", "ocrimpl");
    return "main";
  }
  @RequestMapping("/ocr2")
  public String ocr2(Model model){
    model.addAttribute("center", "ocr2");
    return "main";
  }
  @RequestMapping("/ocrimpl2")
  public String ocrimpl2(Model model, NCPDTO ncpdto){          //파일 업로드
    String imgname = ncpdto.getImg().getOriginalFilename();

    FileUploadUtil.saveFile(ncpdto.getImg(), imgpath);        //파일 세이브
    String result = OCRUtil.getText(imgpath, imgname);        //결과 받기 json문자열로 반환함

    Map<String, String> map = null;                           //파싱해서 결과를 받기
    try {
      map = OCRUtil.getCardinfo(result);                   //result에는 json객체가 들어있다
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    model.addAttribute("imgname",imgname);
    model.addAttribute("num",map.get("num"));                   //화면에 뿌리기
    model.addAttribute("name",map.get("name"));
    model.addAttribute("name1",map.get("name1"));
    model.addAttribute("center", "ocrimpl2");
    return "main";
  }

  @RequestMapping("/cfrimpl")
  public String cfrimpl(Model model, String imgname) throws Exception {
    String result = CFRUtil.getText(imgpath, imgname);
    Map<String, String> map = CFRUtil.getFaceInfo(result);

    model.addAttribute("gender",map.get("gender"));
    model.addAttribute("age",map.get("age"));
    model.addAttribute("emotion",map.get("emotion"));
    model.addAttribute("pose",map.get("pose"));
    model.addAttribute("imgname", imgname);

    model.addAttribute("center", "cfrimpl");

    return "main";
  }

  }