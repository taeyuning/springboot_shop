package com.shop.shop.mapper;

import com.github.pagehelper.Page;
import com.shop.shop.dto.CartsDTO;
import com.shop.shop.dto.ItemDTO;
import com.shop.shop.frame.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CartsMapper extends MyMapper<Integer, CartsDTO> {
  public List<CartsDTO> cartsall(String cust_id) throws Exception;

  Page<CartsDTO> cartsallpage(String cust_id) throws Exception;

}
