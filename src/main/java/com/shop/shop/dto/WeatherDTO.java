package com.shop.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDTO {

    // 화면에서 선택한 위치 코드
    private Integer locCode;
}