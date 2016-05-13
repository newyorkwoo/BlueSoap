package com.shop.model;

import java.io.File;
import java.sql.Blob;
import java.sql.Date;

public class ProductVO implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pdnumber;
	//private InputStream photo;
	private Date valdatefrom;
	private Date valdateto;
	private int discount;
	private String pdname;
	private String description;
	private File fileUpload;
	private Blob photoStream;
	
	
	
	
public Blob getPhotoStream() {
		return photoStream;
	}
	public void setPhotoStream(Blob photoStream) {
		this.photoStream = photoStream;
	}
	//	public ProductVO() {
//		super();
//		pdnumber = "";
//		photo =null;
//		valdatefrom ="";
//		valdateto ="";
//		discount =0;
//		productname = "";
//		description = "";
//	}
	public String getPdnumber() {
		return pdnumber;
	}
	public void setPdnumber(String pdnumber) {
		this.pdnumber = pdnumber;
	}
	public File getFileUpload() {
		return fileUpload;
	}
   //photo  binary fileStream
	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}
	public Date getValdatefrom() {
		return valdatefrom;
	}
	public void setValdatefrom(Date valdatefrom) {
		this.valdatefrom = valdatefrom;
	}
	public Date getValdateto() {
		return valdateto;
	}
	public void setValdateto(Date valdateto) {
		this.valdateto = valdateto;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	public String getPdname() {
		return pdname;
	}
	public void setPdname(String pdname) {
		this.pdname = pdname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
