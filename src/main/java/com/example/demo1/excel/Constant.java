package com.example.demo1.excel;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @comment gzcx常量定义类
 * 
 * @author guoyk@cdtiansheng.com
 * @date   2018年1月31日
 */
public class Constant {
	
	/**
	 * excel导出数据类型
	 */
	public static final String EXPORT_EXCEL_TYPE = "exportExcelType";
	
	/**
	 * excel最大数据导出数据
	 */
	public static final Integer EXCEL_MAX_LENGTH = 65536;
	
	/**
	 * 
	 * @comment Excel导出数据枚举类型定义
	 * 
	 * @author guoyk@cdtiansheng.com
	 * @date   2018年4月24日
	 */
	public enum ExcelObjectType
	{
		SEX("iWSSexService","getPageInfo","性别工龄统计数据表"),
		ADMINISTRATIVELEVEL("iWSAdministrativeLevelService","getPageInfo","行政级别统计数据表"),
		EDUCATION("iWSEducationService","getPageInfo","学历人员身份统计数据表格"),
		LEVEL("iWSLevelService","getPageInfo","薪资级别人员身份统计数据表"),
		NATION("iWSNationService","getPageInfo","民族人员身份统计数据表"),
		ORGANIZATION("iWSOrganizationService","getPageInfo","人员身份工龄段统计数据表"),
		POST("iWSPostService","getPageInfo","职位工龄段统计数据表"),
		WORKSTATUS("iWSWorkStatusService","getPageInfo","在职状态工龄段统计数据表"),
		WORKYEAR("iWSWorkYearService","getPageInfo","工龄段学历统计数据表"),
		JOBLEVEL("iWSJobLevelService","getPageInfo","档次工龄段统计数据表"),
		POSTLEVEL("iWSPostLevelService","getPageInfo","职位级别工龄段统计表"),
		WAGECONSTITUTE("iWageConstituteService","getPageInfo","工资组成统计数据");
		
		/**
		 * beanId
		 */
		private String beanId;
		
		/**
		 * 方法名
		 */
		private String methodName;
		
		/**
		 * 文件名称
		 */
		private String fileName;
		
		/**
		 * 列标题
		 */
		public static List<Excelingation> EXCELINGATION_LIST = new ArrayList<Excelingation>();
		
		static{
			String[]  sexColumnTitle = {"所属年月","性别","区域|单位","工龄段","用户数量","月均工资(元)","总工资(万元)"};//性别
			Integer[] sexColumnWidth = {20,20,50,20,20,20,20};
			String[]  sexFieldNames = {"belong_year_month_","name_","group_name_","workyear_name_","user_count_","average_wage_","amount_wage_"};
			Excelingation sexExcelingation = new Excelingation(sexColumnTitle,sexColumnWidth,sexFieldNames);
			EXCELINGATION_LIST.add(sexExcelingation);
			
			String[] administrativeLevelColumnTitle = {"年月","行政职务","区域|单位","工龄","用户数量","月均工资(元)","总工资(万元)"};//行政级别
			Integer[] administrativeLevelWidth = {20,30,50,20,20,20,20};
			String[]  administrativeLevelNames = {"belong_year_month_","name_","group_name_","workyear_name_","user_count_","average_wage_","amount_wage_"};
			Excelingation administrativeLevelExcelingation = new Excelingation(administrativeLevelColumnTitle,administrativeLevelWidth,administrativeLevelNames);
			EXCELINGATION_LIST.add(administrativeLevelExcelingation);
			
			String[] educationColumnTitle = {"年月","学历","区域|单位","人员身份","用户数量","月均工资(元)","总工资(万元)"};//学历
			Integer[] educationWidth = {20,20,50,20,20,20,20};
			String[]  educationNames = {"belong_year_month_","name_","group_name_","organization_name_","user_count_","average_wage_","amount_wage_"};
			Excelingation educationExcelingation = new Excelingation(educationColumnTitle,educationWidth,educationNames);
			EXCELINGATION_LIST.add(educationExcelingation);
			
			String[] levelColumnTitle = {"年月","薪资级别","区域|单位","人员身份","用户数量","月均工资(元)","总工资(万元)"};//工资级别
			Integer[] levelWidth = {20,20,50,20,20,20,20};
			String[]  levelNames = {"belong_year_month_","name_","group_name_","organization_name_","user_count_","average_wage_","amount_wage_"};
			Excelingation levelExcelingation = new Excelingation(levelColumnTitle,levelWidth,levelNames);
			EXCELINGATION_LIST.add(levelExcelingation);
			
			String[] nationColumnTitle = {"年月","民族","区域|单位","人员身份","用户数量","月均工资(元)","总工资(万元)"};//民族
			Integer[] nationWidth = {20,30,50,20,20,20,20};
			String[]  nationNames = {"belong_year_month_","name_","group_name_","organization_name_","user_count_","average_wage_","amount_wage_"};
			Excelingation nationExcelingation = new Excelingation(nationColumnTitle,nationWidth,nationNames);
			EXCELINGATION_LIST.add(nationExcelingation);
			
			String[] organizationColumnTitle = {"年月","人员身份","区域|单位","工龄段","用户数量","月均工资(元)","总工资(万元)"};//编制
			Integer[] organizationWidth = {20,20,50,20,20,20,20};
			String[]  organizationNames = {"belong_year_month_","name_","group_name_","workyear_name_","user_count_","average_wage_","amount_wage_"};
			Excelingation organizationExcelingation = new Excelingation(organizationColumnTitle,organizationWidth,organizationNames);
			EXCELINGATION_LIST.add(organizationExcelingation);
			
			String[] postColumnTitle = {"年月","职位名称","区域|单位","工龄","用户数量","月均工资(元)","总工资(万元)"};//职位
			Integer[] postWidth = {20,30,50,20,20,20,20};
			String[]  postNames = {"belong_year_month_","name_","group_name_","workyear_name_","user_count_","average_wage_","amount_wage_"};
			Excelingation postExcelingation = new Excelingation(postColumnTitle,postWidth,postNames);
			EXCELINGATION_LIST.add(postExcelingation);
			
			String[] workStatusTitle = {"年月","在职状态","区域|单位","工龄","用户数量","月均工资(元)","总工资(万元)"};//在职状态
			Integer[] workStatusWidth = {20,20,50,20,20,20,20};
			String[]  workStatusNames = {"month_","name_","group_name_","workyear_name_","user_count_","average_wage_","amount_wage_"};
			Excelingation workStatusExcelingation = new Excelingation(workStatusTitle,workStatusWidth,workStatusNames);
			EXCELINGATION_LIST.add(workStatusExcelingation);
			
			String[] workYearTitle = {"年月","工龄段","区域|单位","学历","用户数量","月均工资(元)","总工资(万元)"};//工龄
			Integer[] workYearWidth = {20,30,50,20,20,20,20};
			String[]  workYearNames = {"month_","name_","group_name_","education_name_","user_count_","average_wage_","amount_wage_"};
			Excelingation workYearExcelingation = new Excelingation(workYearTitle,workYearWidth,workYearNames);
			EXCELINGATION_LIST.add(workYearExcelingation);
			
			String[] jobLevelTitle = {"年月","档次","区域|单位","工龄","用户数量","月均工资(元)","总工资(万元)"};//工龄
			Integer[] jobLevelWidth = {20,30,50,20,20,20,20};
			String[]  jobLevelNames = {"belong_year_month_","name_","group_name_","workyear_name_","user_count_","average_wage_","amount_wage_"};
			Excelingation jobLevelExcelingation = new Excelingation(jobLevelTitle,jobLevelWidth,jobLevelNames);
			EXCELINGATION_LIST.add(jobLevelExcelingation);
			
			String[] postLevelTitle = {"年月","职位级别","区域|单位","工龄","用户数量","月均工资(元)","总工资(万元)"};//工龄
			Integer[] postLevelWidth = {20,30,50,20,20,20,20};
			String[]  postLevelNames = {"belong_year_month_","name_","group_name_","workyear_name_","user_count_","average_wage_","amount_wage_"};
			Excelingation postLevelExcelingation = new Excelingation(postLevelTitle,postLevelWidth,postLevelNames);
			EXCELINGATION_LIST.add(postLevelExcelingation);
			
			String[] wageConstituteTitle = {"年月","区域|单位","津贴总额(元)","补贴总额(元)","职务工资总额(元)","级别工资总额(元)","薪级工资总额(元)","绩效工资总额(元)","岗位工资总额(元)","其他工资总额(元)","应发工资总额(元)","实发工资总额(元)","用户数量"};//工龄
			Integer[] wageConstituteWidth = {20,50,20,20,20,20,20,20,20,20,20,20,20};
			String[]  wageConstituteNames = {"belong_year_month_","group_name_","amount_allowance_","amount_subsidy_",
					"amount_duties_","amount_level_","amount_salary_scale_","amount_performance_","amount_post_","amount_other_","amount_wage_","amount_personal_payroll_","user_count_"};
			Excelingation wageConstituteExcelingation = new Excelingation(wageConstituteTitle,wageConstituteWidth,wageConstituteNames);
			EXCELINGATION_LIST.add(wageConstituteExcelingation);
		}
		
		
		private ExcelObjectType()
		{
			
		}
		
		private ExcelObjectType(String beanId, String methodName, String fileName) {
			this.beanId = beanId;
			this.methodName = methodName;
			this.fileName = fileName;
		}


		public String getBeanId() {
			return beanId;
		}

		public void setBeanId(String beanId) {
			this.beanId = beanId;
		}

		public String getMethodName() {
			return methodName;
		}
		
		public void setMethodName(String methodName) {
			this.methodName = methodName;
		}
		public String getFileName() {
			return fileName;
		}
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
	}
	

}
