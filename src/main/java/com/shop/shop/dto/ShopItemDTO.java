package com.shop.shop.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ShopItemDTO {
  private int id;
  private String name;
  private int price;
  private String imgname;
  private MultipartFile img;
}
