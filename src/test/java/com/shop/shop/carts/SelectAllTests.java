package com.shop.shop.carts;

import com.shop.shop.dto.ItemDTO;
import com.shop.shop.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SelectAllTests {
	@Autowired
	ItemService Service;
	@Test
	void contextLoads() {
		List<ItemDTO> list = null;
		try {
			list = Service.get();
			for(ItemDTO c:list){
				System.out.println(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("입력 시 오류");
		}
	}

}
