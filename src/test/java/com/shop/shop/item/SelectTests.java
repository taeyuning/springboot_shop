package com.shop.shop.item;

import com.shop.shop.dto.ItemDTO;
import com.shop.shop.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SelectTests {
	@Autowired
	ItemService Service;
	@Test
	void contextLoads() {
		ItemDTO obj = null;
		try {
			obj = Service.get(110);
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("입력 시 오류");
		}
	}

}
