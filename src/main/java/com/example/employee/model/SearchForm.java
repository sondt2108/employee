package com.example.employee.model;

public class SearchForm {
    private String fullname;
    private int page;
    private String orderBy;
    private boolean sortOrder;
    
    
    public SearchForm(String fullname, int page, String orderBy, boolean sortOrder) {
		super();
		this.fullname = fullname;
		this.page = page;
		this.orderBy = orderBy;
		this.sortOrder = sortOrder;
	}
	
	public SearchForm() {
		this.fullname = "";
		this.page = 0;
		this.orderBy = "productId";
		this.sortOrder = true;
	}
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public boolean getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(boolean sortOrder) {
		this.sortOrder = sortOrder;
	}

    
}
