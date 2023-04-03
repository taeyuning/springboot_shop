package com.shop.shop.controller;

import com.github.pagehelper.PageInfo;
import com.shop.shop.dto.CustDTO;
import com.shop.shop.dto.ItemDTO;
import com.shop.shop.service.ItemService;
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
@RequestMapping("/item")
public class ItemController {
  @Value("${imglocation}")
  String custdir;
  @Autowired
  ItemService itemService;

  String  dir = "/item/";

  @RequestMapping("")
  public String cust(Model model) {
    model.addAttribute("left", dir+"left");
    model.addAttribute("center", dir+"center");
    return "main";
  }

  @RequestMapping("/add")
  public String add(Model model) {
    model.addAttribute("left", dir+"left");
    model.addAttribute("center", dir+"add");
    return "main";
  }
  @RequestMapping("/get")
  public String get(Model model){ //left 와 center 영역만 바꿔줌
    model.addAttribute("left",dir+"left"); //item의 left html
    model.addAttribute("center",dir+"get");
    List<ItemDTO> list = null;
    try {
      list = itemService.get();
      model.addAttribute("ilist",list);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return "main";
  }
  @GetMapping("/getpage")
  public String getpage(@RequestParam(required = false, defaultValue = "1") int pageNum, Model model) throws Exception {
    PageInfo<ItemDTO> p = new PageInfo<>(itemService.getPage(pageNum), 5);
    model.addAttribute("items", p);
    model.addAttribute("left", dir+"left");
    model.addAttribute("center", dir+"getpage");
    return "/main";
  }

  @RequestMapping("/addimpl")
  public String addimpl(Model model, ItemDTO obj) {

    String imgname = obj.getImg().getOriginalFilename();
    obj.setImgname(imgname);

    try {
      FileUploadUtil.saveFile(obj.getImg(), custdir);
      itemService.register(obj);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "redirect:/item/getpage";
  }
  @RequestMapping("/detail")
  public String detail(Model model, Integer id){
    model.addAttribute("left", dir+"left");
    model.addAttribute("center", dir+"detail");
    ItemDTO obj = null;
    try {
      obj = itemService.get(id);
      model.addAttribute("ditem",obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return "main";
  }
  @RequestMapping("/updateimpl")
  public String updateimpl(Model model, ItemDTO item) {
    try {
      itemService.modify(item);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    model.addAttribute("left", dir+"left");
    model.addAttribute("center", dir+"add");
    return "redirect:/item/detail?id="+item.getId();
  }

  @RequestMapping("/deleteimpl")
  public String deleteimpl(Model model, Integer id) {
    try {
      itemService.remove(id);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    model.addAttribute("left", dir+"left");
    model.addAttribute("center", dir+"add");
    return "redirect:/item/getpage";
  }
}
