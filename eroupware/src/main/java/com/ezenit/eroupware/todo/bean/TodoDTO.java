package com.ezenit.eroupware.todo.bean;

public class TodoDTO {
	
	private int todoNo;			// 고유번호
	private String id;			// 작성자 아이디
	private String title;			// 제목
	private String content;	// 내용
	private String color; 		// 라벨 색상
	private int sort;		// 정렬 순서
	private String regdate;   // 투두 생성일
	
	@Override
	public String toString() {
		return "TodoDTO [todoNo=" + todoNo + ", id=" + id + ", title=" + title + ", content=" + content + ", color="
				+ color + ", sort=" + sort + ", regdate=" + regdate + "]";
	}
	
	public int getTodoNo() {
		return todoNo;
	}
	public void setTodoNo(int todoNo) {
		this.todoNo = todoNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
	
	

}
