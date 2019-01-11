package com.haut.entity;
import java.util.List;
public class Page2 {
 
	// 当前页要展示的数据集合  List<Student>
	@SuppressWarnings("rawtypes")
	private List listComment;
	
	//当前是第几页
	private Integer step;
	
	//一页要显示5条

	//总页数
	private Integer countNum;

	@SuppressWarnings("rawtypes")
	public List getListComment() {
		return listComment;
	}

	@SuppressWarnings("rawtypes")
	public void setListComment(List listComment) {
		this.listComment = listComment;
	}

	public Integer getStep() {
		return step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}

	public Integer getCountNum() {
		return countNum;
	}

	public void setCountNum(Integer countNum) {
		this.countNum = countNum;
	}

	@SuppressWarnings("rawtypes")
	public Page2(List listComment, Integer step, Integer countNum) {
		super();
		this.listComment = listComment;
		this.step = step;
		this.countNum = countNum;
	}

	public Page2() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	
}
