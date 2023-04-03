package com.shop.shop.mapper;

import com.github.pagehelper.Page;
import com.shop.shop.dto.CustDTO;
import com.shop.shop.dto.ItemDTO;
import com.shop.shop.frame.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ItemMapper extends MyMapper<Integer, ItemDTO> {
  public List<ItemDTO> search(String txt) throws Exception;
  Page<ItemDTO> getPage() throws Exception;
}
