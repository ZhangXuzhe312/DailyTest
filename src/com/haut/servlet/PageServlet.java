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
@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public PageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		
	}
	
	public  void  fenPage( HttpServletRequest request ,HttpServletResponse response,int a,int b,int c,int d){
		List list=new ArrayList();
		List li=new ArrayList();
		UtilHelper util = new UtilHelper();
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
		String sql ="select * from comment where cline between ? and ? limit ?,?";
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		
		ResultSet rs = util.selectDB(sql, list);
		try {
			while(rs.next()){
				Comment co = new Comment(rs.getInt("cid"),rs.getInt("cline"),rs.getString("cdetail"),
								rs.getString("cname"),rs.getDate("cdate"));
				System.out.println(rs.getDate("cdate"));
				System.out.println(rs.getInt("cid"));
				li.add(co);
			}
		} catch (SQLException e) {
			System.out.println("sql错误");
			e.printStackTrace();
		}
		
		
		//总记录数
		String sql2="select count(*) from comment where cline between ? and ?";
		List list2=new ArrayList();
		ResultSet rs2 =util.selectDB(sql, list2);
		int totalNum=0;  //总页数
		try {
		while(rs2.next()){
				totalNum=rs2.getInt(1); //获得当前条件下的总页数
			} 
		Page pageList = new Page(listComment,totalNum,currentPage,maxmun);
		request.setAttribute("pageList",pageList);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
	}
	
	

}
*/