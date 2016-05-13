package com.shop.model;

import java.io.File;
import java.util.List;
import java.util.Set;
import com.shop.model.ProductVO;

public class ProductService {

	private ProductDAO_interface dao;

	public ProductService() {
		dao = new ProductDAO();
	}

	public List<ProductVO> getAll() {
		return dao.getAll();
	}
	public ProductVO addPd(String pdnumber, String pdname, File photo){
		ProductVO productVO=new ProductVO();
		productVO.setPdnumber(pdnumber);
		productVO.setPdnumber(pdname);
		productVO.setFileUpload(photo);
		dao.insert(productVO);
		return productVO;
	}
	
	public void addPd(ProductVO productVO){
		dao.insert(productVO);
	}
	
	public void updatePd(ProductVO productVO){
		dao.update(productVO);
	}
	
	public void deletePd(String pdnumber){
		dao.delete(pdnumber);
	}
	
	public void getProductList(){
		dao.getAll();
	}

	public ProductVO getOneDept(String deptno) {
		return dao.findByPrimaryKey(deptno);
	}

	public Set<ProductVO> getEmpsByDeptno(String deptno) {
		return dao.getEmpsByDeptno(deptno);
	}

	public void deleteDept(String deptno) {
		dao.delete(deptno);
	}
}
