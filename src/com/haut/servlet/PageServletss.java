/*package com.haut.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haut.entity.Comment;
import com.haut.entity.Page;
import com.haut.util.UtilHelper;

*//**
 * Servlet implementation class PageServletss
 *//*
@WebServlet("/PageServletss")
public class PageServletss extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    *//**
     * @see HttpServlet#HttpServlet()
     *//*
    public PageServletss() {
        super();
        // TODO Auto-generated constructor stub
    }

	*//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//进到这个方法了   分页代码
		//获取当前要查第几页 
		int currentPage;//当前要看第几页
		String requestCurrentPage = request.getParameter("currentPage");
		if(requestCurrentPage == null){
			//当直接访问 没有传currentPage=？参数的时候 
			currentPage =1;
		}else{
			currentPage = Integer.parseInt( requestCurrentPage);
		}
		//一页想看几条
		int maxmun = 5;
		
		//数据库
		UtilHelper util = new UtilHelper();
		//当前查询第一页
		// 2个参数 
		//第一个参数  当前要看的页-1   然后乘以  一页想看几条这个数
		//第二个参数 是不是就是 maxmun 
		@SuppressWarnings("rawtypes")
		List list=new ArrayList();
		String sql ="SELECT * FROM  comment limit ?,?";
		
		try {
			
			list.add((currentPage-1)*maxmun);
			list.add(maxmun);
			ResultSet rs = util.selectDB(sql, list);
			
			List<Comment> listComment = new ArrayList<Comment>();
			while(rs.next()){
				Comment com=new Comment(rs.getInt("cid"),rs.getInt("cline"),rs.getString("cdetail"),
						rs.getString("cname"),rs.getDate("cdate"));
//				Student studentNew = new Student(id,name,age,sex,birth);
				listComment.add(com);
			}
			
			//总记录数
			String sql2 ="SELECT count(*) from comment";
			ResultSet rs2 = util.selectDB(sql2, null);
			int totalNum= 0;
			while(rs2.next()){
				totalNum = rs2.getInt(1);
			}
			
			//List<Student> listStudent, Long totalNum, Integer currentPage, Integer maxmun
			Page pageList = new Page(listComment,totalNum,currentPage,maxmun);
			request.setAttribute("pageList",pageList);
			request.getRequestDispatcher("splitPage.jsp").forward(request, response);
		} catch (SQLException e) {
			System.out.println(maxmun);
		}
		
		
	}
}

*/