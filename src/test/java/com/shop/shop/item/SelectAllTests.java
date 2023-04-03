package com.shop.shop.item;

import com.shop.shop.dto.CartsDTO;
import com.shop.shop.service.CartsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SelectAllTests {
	@Autowired
	CartsService Service;
	@Test
	void contextLoads() {
		List<CartsDTO> list = null;
		try {
			list = Service.get();
			for(CartsDTO c:list){
				System.out.println(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("입력 시 오류");
		}
	}

}
