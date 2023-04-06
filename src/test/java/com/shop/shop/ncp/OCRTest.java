package com.shop.shop.ncp;

import com.shop.shop.util.OCRUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;

@SpringBootTest
class OCRTest {
@Value("${imglocation}")
	String imgpath;
	@Test
	void contextLoads() {
		String imgname = "receipt03.jpg";
		String result = OCRUtil.getText(imgpath, imgname);
		System.out.println(result);
	}

}
