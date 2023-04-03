package com.shop.shop.controller;

import com.github.pagehelper.PageInfo;
import com.shop.shop.dto.CustDTO;
import com.shop.shop.dto.ItemDTO;
import com.shop.shop.dto.MallDTO;
import com.shop.shop.service.MallService;
import com.shop.shop.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/mall")
public class MallController {
  @Value("${imglocation}")
  String custdir;
  @Autowired
  MallService mallService;
  String dir= "/mall/";

  @RequestMapping("")
  public String mall(Model model){ //left 와 center 영역만 바꿔줌
    model.addAttribute("left",dir+"left");
    model.addAttribute("center",dir+"center");
    return "main";
  }
  @RequestMapping("/add")
  public String add(Model model){ //left 와 center 영역만 바꿔줌
    model.addAttribute("left",dir+"left"); //item의 left html
    model.addAttribute("center",dir+"add");
    return "main";
  }
  @RequestMapping("/addimpl")
  public String addimpl(Model model, MallDTO obj) {
    String imgname = obj.getImg().getOriginalFilename();
    obj.setImgname(imgname);

    try {
      FileUploadUtil.saveFile(obj.getImg(), custdir);
      mallService.register(obj);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "redirect:/mall/getpage";
  }

  @RequestMapping("/get")
  public String get(Model model){ //left 와 center 영역만 바꿔줌
    List<MallDTO> list =null;
    try {
      list = mallService.get();
      model.addAttribute("mlist",list);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    model.addAttribute("left",dir+"left");
    model.addAttribute("center",dir+"get");

    return "main";
  }
  @GetMapping("/getpage")
  public String getpage(@RequestParam(required = false, defaultValue = "1") int pageNum, Model model) throws Exception {
    PageInfo<MallDTO> p = new PageInfo<>(mallService.getPage(pageNum), 5);
    model.addAttribute("malls", p);
    model.addAttribute("left", dir+"left");
    model.addAttribute("center", dir+"getpage");
    return "/main";
  }
  @RequestMapping("/detail")
  public String detail(Model model, Long id){
    model.addAttribute("left", dir+"left");
    model.addAttribute("center", dir+"detail");
    MallDTO obj = null;
    try {
      obj = mallService.get(id);
      model.addAttribute("dmall",obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return "main";
  }
  @RequestMapping("/updateimpl")
  public String updateimpl(Model model, MallDTO mall) {
    try {
      mallService.modify(mall);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    model.addAttribute("left", dir+"left");
    model.addAttribute("center", dir+"add");
    return "redirect:/mall/detail?id="+mall.getId();
  }

  @RequestMapping("/deleteimpl")
  public String deleteimpl(Model model, Long id) {
    try {
      mallService.remove(id);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    model.addAttribute("left", dir+"left");
    model.addAttribute("center", dir+"add");
    return "redirect:/mall/getpage";
  }
}
