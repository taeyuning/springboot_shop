package com.shop.shop.carts;

import com.shop.shop.dto.CartsDTO;
import com.shop.shop.service.CartsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InsertTests {
	@Autowired
    CartsService Service;
	@Test
	void contextLoads() {
		CartsDTO obj = new CartsDTO(0,"tykim",101, 5, null);
		try {
			Service.register(obj);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("입력 시 오류");
		}
	}

}
