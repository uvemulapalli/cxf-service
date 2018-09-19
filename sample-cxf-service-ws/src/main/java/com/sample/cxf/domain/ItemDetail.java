package com.sample.cxf.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ItemDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	private String itemName;

	private Integer itemId;

	private String exceptionInformation;

	public ItemDetail() {
	}

	public ItemDetail(String exceptionInformation) {
		this.exceptionInformation = exceptionInformation;
	}

	public ItemDetail(String itemName, Integer itemId) {
		this.itemName = itemName;
		this.itemId = itemId;
	}

	public String getExceptionInformation() {
		return exceptionInformation;
	}

	public Integer getItemId() {
		return itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setExceptionInformation(String exceptionInformation) {
		this.exceptionInformation = exceptionInformation;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
}