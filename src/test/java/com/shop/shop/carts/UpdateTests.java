package com.shop.shop.carts;

import com.shop.shop.dto.CartsDTO;
import com.shop.shop.service.CartsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UpdateTests {
	@Autowired
	CartsService Service;
	@Test
	void contextLoads() {
		CartsDTO obj = new CartsDTO(101,null,100, 100, null);
		try {
			Service.modify(obj);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("수정 시 오류");
		}
	}

}
