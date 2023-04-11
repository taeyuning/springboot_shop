//package com.shop.shop.ncp;
//
//import com.shop.shop.util.WeatherUtil;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//
//@SpringBootTest
//class WeatherTests {
//
//	@Value("${weather_service_key}")
//	String weather_service_key;
//
//	@Test
//	void contextLoads() throws Exception {
//		// System.out.println(weather_service_key);
//
//		String result = WeatherUtil.getInfo("159", LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")), weather_service_key);
//		System.out.println(result);
//	}
//
//}
//
//
////		String skey="dFCVBK5RIFVeiH3UJcGAEbc579loczH%2FGRgqtlozrG0pg3r6LUPbq7zEA7Qx3mymw6CbWKxttAAjCGbe0EzVMA%3D%3D";
////		String loc="108";
////
////		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/MidFcstInfoService/getMidFcst"); /*URL*/
////		urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + skey); /*Service Key*/
////		urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
////		urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
////		urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON)Default: XML*/
////		urlBuilder.append("&" + URLEncoder.encode("stnId","UTF-8") + "=" + URLEncoder.encode(loc, "UTF-8")); /*108 전국, 109 서울, 인천, 경기도 등 (활용가이드 하단 참고자료 참조)*/
////		urlBuilder.append("&" + URLEncoder.encode("tmFc","UTF-8") + "=" + URLEncoder.encode("202304070600", "UTF-8")); /*-일 2회(06:00,18:00)회 생성 되며 발표시각을 입력 YYYYMMDD0600 (1800)-최근 24시간 자료만 제공*/
////		URL url = new URL(urlBuilder.toString());
////		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
////		conn.setRequestMethod("GET");
////		conn.setRequestProperty("Content-type", "application/json");
////		System.out.println("Response code: " + conn.getResponseCode());
////		BufferedReader rd;
////		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
////			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
////		} else {
////			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
////		}
////		StringBuilder sb = new StringBuilder();
////		String line;
////		while ((line = rd.readLine()) != null) {
////			sb.append(line);
////		}
////		rd.close();
////		conn.disconnect();
////		System.out.println(result);
////
////
////		JSONParser jsonparser = new JSONParser();             //내려온 json 데이터(String)를 JSONParser라는 객체를 통해서 자바의object로 변경...?이게 맞나?
////		JSONObject jo = (JSONObject) jsonparser.parse(result);
////
////		JSONObject response = (JSONObject) jo.get("response");
////		JSONObject body = (JSONObject) response.get("body");// 배열안의 하나의 object가,,,,,된당??? 맞는걸까....,.,.,
////		JSONObject items = (JSONObject) body.get("items");
////		JSONArray item = (JSONArray) items.get("item");
////		JSONObject obj = (JSONObject) item.get(0);
////		String wfSv = (String) obj.get("wfSv");
////		System.out.println(wfSv);
////	}
//
//
