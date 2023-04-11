package com.shop.shop.ncp;

import com.shop.shop.util.CFRCUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CFRCTest {
@Value("${imglocation}")
	String imgpath;

@Test
	void contextLoads() throws ParseException {
	String imgname = "snapshot_412.jpg";
	String result = CFRCUtil.getText(imgpath, imgname);
	System.out.println(result);


	JSONParser jsonparser = new JSONParser();             //내려온 json 데이터(String)를 JSONParser라는 객체를 통해서 자바의object로 변경...?이게 맞나?
	JSONObject global = (JSONObject)jsonparser.parse(result);

	JSONArray ja1 = (JSONArray) global.get("faces");        //전체 jo에서 images를 꺼낸다 json array로 받는다
	JSONObject jo1 = (JSONObject) ja1.get(0);                // 배열안의 하나의 object가,,,,,된당??? 맞는걸까....,.,.,


	JSONObject info = (JSONObject) jo1.get("celebrity");
	String value = (String)info.get("value");
	System.out.println(value);
}

}
