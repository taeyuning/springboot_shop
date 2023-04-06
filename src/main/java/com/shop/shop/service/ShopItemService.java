//package com.shop.shop.service;
//
//import com.shop.shop.dto.ShopDTO;
//import com.shop.shop.dto.ShopItemDTO;
//import com.shop.shop.frame.MyService;
//import com.shop.shop.mapper.ShopItemMapper;
//import com.shop.shop.mapper.ShopMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ShopItemService implements MyService<String, ShopItemDTO> {
//  @Autowired
//  ShopMapper shopMapper;
//  @Override
//  public void register(ShopItemDTO shopDTO) throws Exception {
//  }
//  @Override
//  public void modify(ShopItemDTO shopDTO) throws Exception {
//  }
//  @Override
//  public void remove(String s) throws Exception {
//  }
//  @Override
//  public ShopItemDTO get(String id) throws Exception {
//    return ShopItemMapper.select(id);
//  }
//  @Override
//  public List<ShopItemDTO> get() throws Exception {
//    return null;
//  }
//
//}