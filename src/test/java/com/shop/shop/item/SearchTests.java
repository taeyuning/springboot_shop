package com.shop.shop.item;

import com.shop.shop.dto.ItemDTO;
import com.shop.shop.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SearchTests {
  @Autowired
  ItemService Service;
  @Test
  void contextLoads() {
    List<ItemDTO> list= null;
    try {
      list = Service.search("바");
      for (ItemDTO obj : list) {
        System.out.println(obj);
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("입력 시 오류");
    }
  }
}
