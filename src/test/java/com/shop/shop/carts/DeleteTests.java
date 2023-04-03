package com.shop.shop.carts;

import com.shop.shop.service.CartsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DeleteTests {
	@Autowired
    CartsService Service;
	@Test
	void contextLoads() {

		try {
			Service.remove(136);
			System.out.println("삭제 완료");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("삭제 시 오류");
		}
	}

}
