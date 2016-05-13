package com.shop.model;

import java.util.*;
import com.shop.model.ProductVO;

public interface ProductDAO_interface {
	      public void insert(ProductVO deptVO);
          public void update(ProductVO deptVO);
          public void delete(String deptno);
          public ProductVO findByPrimaryKey(String deptno);
	      public List<ProductVO> getAll();
	      //�d�߬Y���������u(�@��h)(�^�� Set)
	      public Set<ProductVO> getEmpsByDeptno(String deptno);
}
