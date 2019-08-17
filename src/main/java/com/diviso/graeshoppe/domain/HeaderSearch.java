package com.diviso.graeshoppe.domain;

public class HeaderSearch {


    private static final long serialVersionUID = 1L;
    
    private String storeNo;

	public String getStoreNo() {
		return storeNo;
	}

	public void setStoreNo(String storeNo) {
		this.storeNo = storeNo;
	}

	@Override
	public String toString() {
		return "HeaderSearch [storeNo=" + storeNo + "]";
	}
	
}