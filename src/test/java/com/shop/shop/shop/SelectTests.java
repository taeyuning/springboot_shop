package com.shop.shop.shop;

import com.shop.shop.dto.ShopDTO;
import com.shop.shop.service.ShopService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SelectTests {
	@Autowired
	ShopService service;
	@Test
	void contextLoads() {
		ShopDTO obj = null;
		try {
			obj = service.get("s001");
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("입력 시 오류");
		}
	}

}