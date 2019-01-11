package com.haut.servlet;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haut.entity.Comment;
import com.haut.entity.Page2;
import com.haut.util.JSONUtil;
import com.haut.util.UtilHelper;

@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
    public CommentServlet() {
        super();
    
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id=Integer.parseInt(request.getParameter("typeId")) ;	
			int step=0;
		
			if(request.getParameter("step")==null){
				step=0;
				
			}else{
				step=Integer.parseInt(request.getParameter("step")) ;
		
			}
		System.out.println(step);
			if(id==0){
				int countNum = countNum(1,5);
				Page2 p2 = new Page2(selComment(1,5,step),step+1,countNum);
				JSONUtil.writeJSON("200", p2, response);
			}else if(id==4){
				int countNum = countNum(4,5);
				
				Page2 p2 = new Page2(selComment(4,5,step),step+1,countNum);
				JSONUtil.writeJSON("200", p2, response);
			}else if(id==2){
				int countNum = countNum(2,3);
				
				Page2 p2 = new Page2(selComment(2,3,step),step+1,countNum);
				JSONUtil.writeJSON("200", p2, response);
			}else if(id==1){
				int countNum = countNum(0,1);
				
				Page2 p2 = new Page2(selComment(0,1,step),step+1,countNum);
				
				JSONUtil.writeJSON("200", p2, response);
			}
			
			
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Comment> selComment(int a,int b,int c){
		List<Comment> list=new ArrayList<Comment>();
		List li=new ArrayList();
		UtilHelper util = new UtilHelper();
		String sql="select * from comment where cline between ? and ? limit ?,5";
		li.add(a);
		li.add(b);
		li.add(c);
	
		ResultSet rs = util.selectDB(sql, li);
			try {
				while(rs.next()){
					Comment co = new Comment(rs.getInt("cid"),rs.getInt("cline"),rs.getString("cdetail"),
									rs.getString("cname"),format.format(rs.getDate("cdate")));
					list.add(co);
				}
			} catch (SQLException e) {
				System.out.println("sql错误");
				e.printStackTrace();
			}
		return list;
	}
	
	
	//总记录数
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public int  countNum(int c ,int d){
			int i=0;
			List li=new ArrayList();
			UtilHelper util = new UtilHelper();
			String sql="select count(*) from comment where cline between ? and ?";
			li.add(c);
			li.add(d);
			ResultSet rs = util.selectDB(sql, li);
			try {
				while(rs.next()){
					i=rs.getInt(1);
				}
			} catch (SQLException e) {
				System.out.println("sql错误");

			}
			if(i%5==0){
				return i/5;
			}else{
				return i/5+1;
			}	
		}

}
