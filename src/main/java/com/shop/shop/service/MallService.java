package com.shop.shop.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.shop.dto.MallDTO;
import com.shop.shop.frame.MyService;
import com.shop.shop.mapper.MallMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MallService implements MyService<Long, MallDTO> {
  @Autowired
  MallMapper mallMapper;
  @Override
  public void register(MallDTO mallDTO) throws Exception {
    mallMapper.insert(mallDTO);
  }

  @Override
  public void modify(MallDTO mallDTO) throws Exception {
    mallMapper.update(mallDTO);
  }

  @Override
  public void remove(Long id) throws Exception {
    mallMapper.delete(id);
  }

  @Override
  public MallDTO get(Long id) throws Exception {
    return mallMapper.select(id);
  }

  @Override
  public List<MallDTO> get() throws Exception {
    return mallMapper.selectall();
  }

  public Page<MallDTO> getPage(int pageNo) throws Exception {
    PageHelper.startPage(pageNo, 5);
    return mallMapper.getPage();
  }
}
