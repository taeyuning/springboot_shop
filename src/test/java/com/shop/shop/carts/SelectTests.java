package com.shop.shop.carts;

import com.shop.shop.dto.CartsDTO;
import com.shop.shop.service.CartsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SelectTests {
	@Autowired
	CartsService Service;
	@Test
	void contextLoads() {
		CartsDTO obj = null;
		try {
			obj = Service.get(101);
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("입력 시 오류");
		}
	}

}
