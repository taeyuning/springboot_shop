package com.shop.shop.mapper;

import com.github.pagehelper.Page;
import com.shop.shop.dto.CustDTO;
import com.shop.shop.frame.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
@Mapper
public interface CustMapper extends MyMapper<String, CustDTO>{
  Page<CustDTO> getPage() throws Exception;
}