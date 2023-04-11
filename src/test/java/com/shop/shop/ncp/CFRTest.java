package com.shop.shop.ncp;

import com.shop.shop.util.CFRUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;


import org.springframework.beans.factory.annotation.Value;

@SpringBootTest
class CFRTests {

    @Value("${imglocation}")
    String imgpath;
    @Test
    void contextLoads() throws Exception {
        String imgname = "ma02.jpg";
        String result = CFRUtil.getText(imgpath, imgname);
        System.out.println(result);

        Map<String,String> map = CFRUtil.getFaceInfo(result);

        System.out.println(map.get("gender"));
        System.out.println(map.get("age"));
        System.out.println(map.get("emotion"));
        System.out.println(map.get("pose"));
    }

}
