package com.shop.shop.carts;

import com.shop.shop.dto.CartsDTO;
import com.shop.shop.service.CartsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CartsAllTest {
  @Autowired
  CartsService service;
  @Test
  void contextLoads() {
    List<CartsDTO> list = null;
    try {
      list = service.cartsall("id01");
      for(CartsDTO c:list){
        System.out.println(c);
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("입력 시 오류");
    }
  }
}
