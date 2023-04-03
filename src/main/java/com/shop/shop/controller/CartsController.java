package com.shop.shop.controller;

import com.github.pagehelper.PageInfo;
import com.shop.shop.dto.CartsDTO;
import com.shop.shop.dto.CustDTO;
import com.shop.shop.service.CartsService;
import com.shop.shop.service.CustService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartsController {
  @Autowired
  CartsService cartsService;
  String  dir = "/cart/";


//  @RequestMapping("")
//  public String cart(Model model, String id) {
//      model.addAttribute("center", dir+"center");
//    return "main";
//  }

  @GetMapping("")
  public String getpage(@RequestParam(required = false, defaultValue = "1") int pageNum, Model model, String id) throws Exception {
    PageInfo<CartsDTO> p = new PageInfo<>(cartsService.cartsallpage(pageNum, id), 3);
    model.addAttribute("items", p);
    model.addAttribute("center", dir+"getpage");
    return "/main";
  }

  //  @RequestMapping("")
//  public String cart(Model model, HttpSession session) {
//    model.addAttribute("left",dir+"left"); //cust의 left html
//    model.addAttribute("center",dir+"get");
//      CustDTO logincust = (CustDTO) session.getAttribute("logincust");
//      String custId = logincust.getId();
//    try {
//      List<CartsDTO> cartsall = cartsService.cartsall(custId);
//      model.addAttribute("cartsall",cartsall);
//    } catch (Exception e) {
//      throw new RuntimeException(e);
//    }
//    return "main";
//  }
}