package com.example.demo1.excel;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * 
 * @comment Excel导入和导出数据工具类
 * 
 * @author guoyk@cdtiansheng.com
 * @date   2018年1月31日
 */
public class ExcelUtils {
	
	/**
	 * 
	 * @comment Excel枚举样式效果
	 * 
	 * @author guoyk@cdtiansheng.com
	 * @date   2018年1月31日
	 */
	public enum ExcelStyle
	{
		//[VERSION:TITLE:标题、TABLEHEAD:表头]
		TITLE, TABLEHEAD
	}
	
	/**
	 * @comment excel 样式选择
	 * @param workbook
	 * @param style
	 * @return
	 *
	 * @author 	zhouxin@cdtiansheng.com
	 * @date    2018年4月20日
	 */
	public static CellStyle getHeaderCellStyle(Workbook workbook, ExcelStyle style)
	{
		Font font = workbook.createFont();// 字体
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setLocked(true);
		headerCellStyle.setWrapText(true);
		headerCellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);// 上下居中
		switch (style) 
		{
			case TITLE:
				font.setFontName("微软雅黑"); 
				font.setColor((short)0x8);//字体颜色
				font.setFontHeightInPoints((short) 14);  //字体大小
				font.setBoldweight(Font.BOLDWEIGHT_BOLD);  //字体粗细
		        headerCellStyle.setFont(font);  
		        
		        headerCellStyle.setAlignment(CellStyle.ALIGN_CENTER);// 左右居中
		        headerCellStyle.setLeftBorderColor((short)0x37);// 左边框的颜色  
		        headerCellStyle.setBorderLeft((short) 1);// 边框的大小  
		        headerCellStyle.setRightBorderColor((short)0x37);// 右边框的颜色  
		        headerCellStyle.setBorderRight((short) 1);// 右边框的大小 
				break;
			case TABLEHEAD:
				font.setFontName("宋体");
				font.setFontHeightInPoints((short) 10);
				font.setBoldweight(Font.BOLDWEIGHT_BOLD);
				headerCellStyle.setFont(font);
				
				headerCellStyle.setAlignment(CellStyle.ALIGN_CENTER);// 左右居中
				headerCellStyle.setBorderTop((short) 1);// 上边框的大小
				headerCellStyle.setBorderBottom((short) 1);// 下边框的大小
				headerCellStyle.setBorderLeft((short) 1);// 左边框的大小
				headerCellStyle.setBorderRight((short) 1);// 右边框的大小
				headerCellStyle.setFillForegroundColor(HSSFColor.GREEN.index);// 设置前景色
				headerCellStyle.setFillPattern((short) 1);// 使用前景填充单元格
				break;
		}
		
		return headerCellStyle;
	}
}

