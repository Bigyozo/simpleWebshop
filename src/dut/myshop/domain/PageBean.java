package dut.myshop.domain;

import java.util.Map;

public class PageBean {
	Map<String, Product> map;
	int currentPage;	
	String category;
	int pageSize;
	String name;
	public PageBean(Map<String, Product> map, int currentPage, String category,int pageSize,String name) {
		super();
		this.map = map;
		this.currentPage = currentPage;		
		this.category=category;
		this.pageSize=pageSize;
		this.name=name;
	}
	public PageBean() {
		super();
	}
	public Map<String, Product> getMap() {
		return map;
	}
	public void setMap(Map<String, Product> map) {
		this.map = map;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
