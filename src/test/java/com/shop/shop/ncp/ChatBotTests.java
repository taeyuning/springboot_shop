package com.shop.shop.ncp;

import com.shop.shop.util.ChatBotUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class ChatBotTests {

	@Test
	void contextLoads() throws IOException {
		String str = "굉장하다";
		String result = ChatBotUtil.chat(str);
		System.out.println(result);
	}

}
