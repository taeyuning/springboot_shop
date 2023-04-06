package com.shop.shop.controller;

import com.shop.shop.dto.ShopDTO;
import com.shop.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MapController {
  @Autowired
  ShopService shopService;
  String dir= "/shop/";

  @RequestMapping("/map1")
  public String map1(Model model){
    model.addAttribute("center", "map1");
    return "main";
  }
  @RequestMapping("/map2")
  public String map2(Model model){
    model.addAttribute("center", "map2");
    return "main";
  }

  @RequestMapping("/shopdetail")
  public String shopdetail(Model model, String id) {
    ShopDTO obj = null;//받을 준비

    try {
      obj = shopService.get(id);
      System.out.println(obj);
      model.addAttribute("shop", obj);
      System.out.println(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    model.addAttribute("center", dir + "shopdetail");
    return "main";
  }
}

