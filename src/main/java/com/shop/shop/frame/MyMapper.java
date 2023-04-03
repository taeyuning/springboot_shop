package com.shop.shop.frame;

import java.util.List;

public interface MyMapper<K,V> {
  //CRUD
  public void insert(V v) throws Exception;
  public void update(V v) throws Exception;
  public void delete(K k) throws Exception;
  public V select(K k) throws Exception;
  public List<V> selectall() throws Exception;

}
