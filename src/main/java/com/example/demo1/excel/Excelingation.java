package com.example.demo1.excel;

/**
 * 
 * @comment Excel对象绑定实体类
 * 
 * @author guoyk@cdtiansheng.com
 * @date   2018年1月31日
 */
public class Excelingation{

	/**
	 * excel列标题
	 */
	private String[] columnTitle;
	
	/**
	 * excel列宽度
	 */
	private Integer [] columnWidth;
	
	/**
	 * 实体类反射属性方法
	 */
	private String[] fieldNames;

	public Excelingation(String[] columnTitle, Integer[] columnWidth, String[] fieldNames) {
		this.columnTitle = columnTitle;
		this.columnWidth = columnWidth;
		this.fieldNames = fieldNames;
	}

	public String[] getColumnTitle() {
		return columnTitle;
	}

	public void setColumnTitle(String[] columnTitle) {
		this.columnTitle = columnTitle;
	}

	public Integer[] getColumnWidth() {
		return columnWidth;
	}

	public void setColumnWidth(Integer[] columnWidth) {
		this.columnWidth = columnWidth;
	}

	public String[] getFieldNames() {
		return fieldNames;
	}

	public void setFieldNames(String[] fieldNames) {
		this.fieldNames = fieldNames;
	}

}
