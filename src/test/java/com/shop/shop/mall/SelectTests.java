package com.shop.shop.mall;

import com.shop.shop.dto.MallDTO;
import com.shop.shop.service.MallService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SelectTests {
	@Autowired
	MallService Service;
	@Test
	void contextLoads() {
		MallDTO obj = null;
		try {
			obj = Service.get(1l);
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("입력 시 오류");
		}
	}

}
