package com.shop.shop.controller;

import com.shop.shop.dto.WeatherDTO;
import com.shop.shop.util.WeatherUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Controller
public class WeatherController {

    @Value("${weather_service_key}")
    String weather_service_key;

    String dir = "/weather/";

    @RequestMapping("/weather")
    public String wea(Model model) {
        model.addAttribute("center",  "weather"); // 가운데를 weather.html로
        return "main";
    }

    @RequestMapping("/weatherimpl")
    public String weatherimpl(Model model, String loc) throws Exception {
        String result = WeatherUtil.getWeatherInfo(loc);
        System.out.println("result = " + result);
        model.addAttribute("result",result); //받은 결과를 string으로 받음
        model.addAttribute("center", "weather");
        return "main";
    }
}