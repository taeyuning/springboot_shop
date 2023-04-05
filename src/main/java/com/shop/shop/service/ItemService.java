package com.shop.shop.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.shop.dto.CustDTO;
import com.shop.shop.dto.ItemDTO;
import com.shop.shop.frame.MyService;
import com.shop.shop.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService implements MyService<Integer, ItemDTO> {
  @Autowired
  ItemMapper itemMapper;
  @Override
  public void register(ItemDTO itemDTO) throws Exception {
    itemMapper.insert(itemDTO);
  }

  @Override
  public void modify(ItemDTO itemDTO) throws Exception {
    itemMapper.update(itemDTO);
  }

  @Override
  public void remove(Integer id) throws Exception {
    itemMapper.delete(id);
  }

  @Override
  public ItemDTO get(Integer id) throws Exception {
    return itemMapper.select(id);
  }

  @Override
  public List<ItemDTO> get() throws Exception {
    return itemMapper.selectall();
  }
  public List<ItemDTO> search(String txt) throws Exception {
    return itemMapper.search(txt);
  }
  public Page<ItemDTO> getPage(int pageNo) throws Exception {
    PageHelper.startPage(pageNo, 4);
    return itemMapper.getPage();
  }
}