package com.shop.shop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  //uploadPath프로퍼티값을 읽어온다
  @Value("${uploadpath}")
  String uploadPath;
  //C:/projectimg/img/

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/img/**").addResourceLocations(uploadPath);
    //로컬컴퓨터에 저장된 파일을 읽어올 root경로
    //upload를 html에서 img로 사용해라??ㅎ....ㅎ...ㅎ
  }
}