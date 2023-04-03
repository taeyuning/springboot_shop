package com.shop.shop.mapper;

import com.github.pagehelper.Page;
import com.shop.shop.dto.ItemDTO;
import com.shop.shop.dto.MallDTO;
import com.shop.shop.frame.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MallMapper extends MyMapper<Long, MallDTO> {
  Page<MallDTO> getPage() throws Exception;
}
