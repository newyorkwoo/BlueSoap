package com.shop.controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.struts2.ServletActionContext;

import com.shop.model.ProductService;
import com.shop.model.ProductVO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductVO productVO;
	
	private File fileUpload;      
	private String fileUploadContentType;
	private String fileUploadFileName;
	private String saveDirectory;
	
	public ProductVO getProductVO() {
		return productVO;
	}

	public void setProductVO(ProductVO productVO) {
		this.productVO = productVO;
	}
	public File getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File fileUpload) throws IOException, SQLException, SQLException {
//		FileInputStream photoStream= new FileInputStream(fileUpload);
//		int fileLength = (int) fileUpload.length();
//		byte[] incoming_file_data = new byte[fileLength];			
//		photoStream.read(incoming_file_data, 0, fileLength);			
//		photoStream.close();
//		Blob blob = new SerialBlob(incoming_file_data);
//		productVO.setPhotoStream(blob);
//		
//		BufferedImage inputImage = ImageIO.read(fileUpload);
//		int scaledWidth = (int) (inputImage.getWidth() * 0.5);
//        int scaledHeight = (int) (inputImage.getHeight() * 0.5);
//        BufferedImage outputImage = new BufferedImage(scaledWidth,
//                scaledHeight, inputImage.getType());
//        // scales the input image to the output image
//        Graphics2D g2d = outputImage.createGraphics();
//        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
//        g2d.dispose();
//     // extracts extension of output file
//        File file=new File(getSaveDirectory());
//        String formatName = getSaveDirectory().substring(getSaveDirectory()
//                .lastIndexOf(".") + 1);
//        ImageIO.write(outputImage,formatName, file);
		this.fileUpload = fileUpload;
//        this.fileUpload = file;
		
	}

	public String getFileUploadContentType() {
		return fileUploadContentType;
	}

	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}

	public String getFileUploadFileName() {
		return fileUploadFileName;
	}

	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}
	
	public String getSaveDirectory() {
		return saveDirectory;
	}

	public void setSaveDirectory(String saveDirectory) {
		this.saveDirectory = saveDirectory;
	
	}
	
	public String addProduct() throws Exception{		
		File fsaveDirectory = new File(ServletActionContext.getServletContext().getRealPath(saveDirectory));
		if (!fsaveDirectory.exists()) fsaveDirectory.mkdirs(); 
		
	//	for(int i=0 ; i<fileUpload.length ; i++){
			//File file2 = new File(getSaveDirectory());
			BufferedImage inputImage = ImageIO.read(fileUpload);
			 
			int scaledWidth = (int) (inputImage.getWidth() * 0.5);
	        int scaledHeight = (int) (inputImage.getHeight() * 0.5);
	        
	       // System.out.println("scaledWidth="+scaledWidth);
			// creates output image
	        BufferedImage outputImage = new BufferedImage(scaledWidth,
	                scaledHeight, inputImage.getType());
	 
	        // scales the input image to the output image
	        Graphics2D g2d = outputImage.createGraphics();
	        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
	        g2d.dispose();
	 
	        // extracts extension of output file
	        String formatName = fileUploadFileName.substring(fileUploadFileName
	                .lastIndexOf(".") + 1);
	        
	 
	        // writes to output file
	        File file=new File(fsaveDirectory,fileUploadFileName);
	        ImageIO.write(outputImage,formatName,file);
			FileInputStream photoStream= new FileInputStream(file);
			int fileLength = (int) file.length();
			
			byte[] incoming_file_data = new byte[fileLength];			
			photoStream.read(incoming_file_data, 0, fileLength);			
			photoStream.close();
			Blob blob = new SerialBlob(incoming_file_data);
			productVO.setPhotoStream(blob);
			//fileUpload.renameTo(file2);
			productVO.setFileUpload(file);
			
		//}
			ProductService pdSvc=new ProductService();
			pdSvc.addPd(productVO);
			
			
			
		return SUCCESS;
	}
	
	public String updateProduct()throws Exception{
		File fsaveDirectory = new File(ServletActionContext.getServletContext().getRealPath(saveDirectory));
		if (!fsaveDirectory.exists()) fsaveDirectory.mkdirs();
		File file2 = new File(fsaveDirectory,fileUploadFileName);
		fileUpload.renameTo(file2); 
		productVO.setFileUpload(file2);
		
		ProductService pdSvc=new ProductService();
		pdSvc.updatePd(productVO);
		return SUCCESS;
	}
	
	public String deleteProduct(){
		ProductService pdSvc=new ProductService();
		pdSvc.deletePd(productVO.getPdnumber());
		return SUCCESS;
	}
	
	public String getProductList(){
		ProductService pdSvc=new ProductService();
		pdSvc.getAll();
		return SUCCESS;
	}
	
}
