package com.shop.shop.controller;

import com.github.pagehelper.PageInfo;
import com.shop.shop.dto.CartsDTO;
import com.shop.shop.service.CartsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartsController {
  @Autowired
  CartsService cartsService;
  String  dir = "/cart/";

  @GetMapping("")
  public String getpage(@RequestParam(required = false, defaultValue = "1") int pageNum, Model model, String id) throws Exception {
    //사용자 id의 모든 카트리스트
    List<CartsDTO> mycarts = null;
    mycarts = cartsService.cartsall(id);
    //페이지에 있는 카트리스트
    PageInfo<CartsDTO> p = new PageInfo<>(cartsService.cartsallpage(pageNum, id), 3);
    model.addAttribute("items", p);
    model.addAttribute("mycarts", mycarts);
    model.addAttribute("center", dir+"getpage");
    return "/main";
  }

  @RequestMapping("/addcartimpl")
  public String addcartimpl( Model model, CartsDTO carts) throws Exception {
    cartsService.register(carts);
    return "redirect:/cart?id="+carts.getCust_id();
  }
  //카트담기

  @RequestMapping("/deleteimpl")
  public String deleteimpl(Model model, int id, String cid) throws Exception {
      cartsService.remove(id);
    return "redirect:/cart?id="+cid;
  }
  //카트 지우기
}


//  @RequestMapping("")
//  public String cart(Model model, String id) {
//      model.addAttribute("center", dir+"center");
//    return "main";
//  }
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
