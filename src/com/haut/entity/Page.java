package com.haut.entity;
import java.util.List;
public class Page {
 
	// 当前页要展示的数据集合  List<Student>
	private List<Comment> listComment;
	//总记录数
	private Integer totalNum;
	
	//当前是第几页
	private Integer currentPage;
	
	//一页要显示多少条
	private Integer maxmun;
	
	//总页数
	private Integer totalPages;


	public List<Comment> getListComment() {
		return listComment;
	}

	public void setListComment(List<Comment> listComment) {
		this.listComment = listComment;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getMaxmun() {
		return maxmun;
	}

	public void setMaxmun(Integer maxmun) {
		this.maxmun = maxmun;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Page(List<Comment> listComment, Integer totalNum, Integer currentPage, Integer maxmun) {
		super();
		this.listComment = listComment;//这个是传进来的
		this.totalNum = totalNum;//查询数据库总记录数  select count(*) from student
		this.currentPage = currentPage;//这个当前为第几页是动态传进来的
		this.maxmun = maxmun;//一页最多显示多少条  这个写死
		
		if(totalNum % maxmun==0){
			//除尽了
			this.totalPages =  (int) (totalNum/maxmun);// 总记录数  %  每页显示的数据数量  
		}else{
			this.totalPages =  (int) ((totalNum/maxmun)+1);
		}
	}

	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
