package com.shop.shop.mall;

import com.shop.shop.dto.MallDTO;
import com.shop.shop.service.MallService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Time;

@SpringBootTest
class InsertTests {
	@Autowired
	MallService Service;
	@Test
	void contextLoads() {
		MallDTO obj = new MallDTO(null,"민지버거샵","민지공듀","011515745","우리집","06:00:00","20:00:00","mall05.jpg",null);
		try {
			Service.register(obj);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("입력 시 오류");
		}
	}

}
