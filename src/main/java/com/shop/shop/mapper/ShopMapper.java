package com.shop.shop.mapper;


import com.shop.shop.dto.ShopDTO;
import com.shop.shop.frame.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ShopMapper extends MyMapper<String, ShopDTO> {

}