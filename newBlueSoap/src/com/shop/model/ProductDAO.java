package com.shop.model;

import java.util.*;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.sql.rowset.serial.SerialBlob;



public class ProductDAO implements ProductDAO_interface {

	// �@�����ε{����,�w��@�Ӹ�Ʈw ,�@�Τ@��DataSource�Y�i
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO product (pdnumber,pdname,description,discount,valdateto,photo) VALUES (?, ?, ?,?,?,?)";
	private static final String GET_ALL_STMT = "SELECT pdnumber,pdname,description,discount,valdateto,photo FROM product";
	private static final String GET_ONE_STMT = "SELECT pdnumber , pdname FROM product where pdnumber = ?";
	private static final String DELETE_Product = "DELETE FROM product where pdnumber = ?";		
	private static final String UPDATE = "UPDATE product set   pdnumber=?, pdname=?, description=?, discount=?, valdateto=?,  photo=? where pdnumber = ?";

	@Override
	public void insert(ProductVO productVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			//InputStream productFileUploadStream=new FileInputStream(productVO.getFileUpload());
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, productVO.getPdnumber());
			pstmt.setString(2, productVO.getPdname());
			pstmt.setString(3, productVO.getDescription());
			pstmt.setInt(4, productVO.getDiscount());
			pstmt.setDate(5, productVO.getValdateto());
			//pstmt.setBinaryStream(6,productFileUploadStream);
			pstmt.setBlob(6, productVO.getPhotoStream());

			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(ProductVO productVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			
			//InputStream productFileUploadStream=new FileInputStream(productVO.getFileUpload());
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, productVO.getPdnumber());
			pstmt.setString(2, productVO.getPdname());
			pstmt.setString(3, productVO.getDescription());
			pstmt.setInt(4, productVO.getDiscount());
			pstmt.setDate(5, productVO.getValdateto());
			pstmt.setBlob(6, productVO.getPhotoStream());
			pstmt.setString(7, productVO.getPdnumber());
			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void delete(String pdnumber) {
		

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			con.setAutoCommit(false);

			pstmt = con.prepareStatement(DELETE_Product);
			pstmt.setString(1, pdnumber);
			
	
			pstmt.executeUpdate();

			con.commit();
			con.setAutoCommit(true);
			System.out.println("已刪除" + pdnumber );
			
			// Handle any SQL errors
		} catch (SQLException se) {
			if (con != null) {
				try {
					// 3���]�w���exception�o�ͮɤ�catch�϶���
					con.rollback();
				} catch (SQLException excep) {
					throw new RuntimeException("rollback error occured. "
							+ excep.getMessage());
				}
			}
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public ProductVO findByPrimaryKey(String pdnumber) {

		ProductVO productVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

				pstmt.setString(1, pdnumber);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// ProductVO �]�٬� Domain objects
				InputStream in=rs.getBinaryStream("photo");
				//FileInputStream photoStream= new FileInputStream(fileUpload);
				
				//File photofile=new File("photo.jpg");
				//OutputStream f=new FileOutputStream(photofile);
				ByteArrayOutputStream bytestream = new ByteArrayOutputStream();    
				int c=0;
 				while ((c = in.read()) > -1) {
 					bytestream.write(c);
				}
 				bytestream.close();
 				byte[] imgdata = bytestream.toByteArray(); 
 				Blob blob = new SerialBlob(imgdata);
				//in.close();
				productVO = new ProductVO();
				productVO.setPdnumber(rs.getString("pdnumber"));
				productVO.setPdname(rs.getString("pdname"));
				//productVO.setFileUpload(photofile);
				productVO.setPhotoStream(blob);
				
			}

			// Handle any SQL errors
		} catch (SQLException | IOException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return productVO;
	}

	@Override
	public List<ProductVO> getAll() {
		List<ProductVO> list = new ArrayList<ProductVO>();
		ProductVO productVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				InputStream in=rs.getBinaryStream("photo");			
				ByteArrayOutputStream bytestream = new ByteArrayOutputStream();    
				int c=0;
 				while ((c = in.read()) > -1) {
 					bytestream.write(c);
				}
 				bytestream.close();
 				byte[] imgdata = bytestream.toByteArray(); 
 				Blob blob = new SerialBlob(imgdata);
 				
				productVO = new ProductVO();
				productVO.setPhotoStream(blob);
				productVO.setPdnumber(rs.getString("pdnumber"));
				productVO.setPdname(rs.getString("pdname"));
				productVO.setDescription(rs.getString("description"));
				productVO.setValdateto(rs.getDate("valdateto"));
				
				
				list.add(productVO); // Store the row in the list
			}

			// Handle any SQL errors
		} catch (SQLException | IOException  se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	@Override
//	public Set<ProductVO> getEmpsByProductno(Integer Productno) {
//		Set<ProductVO> set = new LinkedHashSet<ProductVO>();
//		ProductVO productVO = null;
//	
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//	
//		try {
//	
//			con = ds.getConnection();
//			pstmt = con.prepareStatement(GET_Emps_ByProductno_STMT);
//			pstmt.setInt(1, Productno);
//			rs = pstmt.executeQuery();
//	
//			while (rs.next()) {
//				productVO = new ProductVO();
//				productVO.setEmpno(rs.getInt("empno"));
//				productVO.setEname(rs.getString("ename"));
//				productVO.setJob(rs.getString("job"));
//				productVO.setHiredate(rs.getDate("hiredate"));
//				productVO.setSal(rs.getDouble("sal"));
//				productVO.setComm(rs.getDouble("comm"));
//				productVO.setProductno(rs.getInt("Productno"));
//				set.add(productVO); // Store the row in the vector
//			}
//	
//			// Handle any SQL errors
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. "
//					+ se.getMessage());
//		} finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (Exception e) {
//					e.printStackTrace(System.err);
//				}
//			}
//		}
//		return set;
//	}


	public Set<ProductVO> getEmpsByDeptno(String deptno) {
		// TODO Auto-generated method stub
		return null;
	}
}