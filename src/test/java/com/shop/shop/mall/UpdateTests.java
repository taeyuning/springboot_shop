package com.shop.shop.mall;

import com.shop.shop.dto.ItemDTO;
import com.shop.shop.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UpdateTests {
	@Autowired
	ItemService Service;
	@Test
	void contextLoads() {
		ItemDTO obj = new ItemDTO(113,"후드티",3000000,"h.jpg",null,null);
		try {
			Service.modify(obj);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("수정 시 오류");
		}
	}

}
