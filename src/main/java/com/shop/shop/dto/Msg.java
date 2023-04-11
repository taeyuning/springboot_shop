package com.shop.shop.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Msg {

    private String sendid;
    private String receiveid;
    private String content1; // 메시지 내용
}
