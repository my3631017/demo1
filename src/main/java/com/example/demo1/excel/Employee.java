package com.example.demo1.excel;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import lombok.Data;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-04-12 16:44
 */
@Data
public class Employee implements Serializable {
    public static void main(String[] args) throws Exception {
        String year = "2019";
        String title = year + "年各月计划与实际完成量统计";
        String sheetName = year + "年计划与完成";

        String[] sheetNames = {"元月", "二月份", "2018年计划与完成"};
        TemplateExportParams params = new TemplateExportParams(
                "productContractTemplate.xlsx", true, sheetNames);
        Map<String, Object> map = new HashMap<String, Object>();
        Plan plan = new Plan();
//        plan.setDate("2019-04");
        plan.setBasic("555");
//        plan.setPlan("666");
//        plan.setStruggle("777");
//        plan.setActual("888");
        List<Plan> planList = new ArrayList<>();
        planList.add(plan);
        planList.add(plan);
        planList.add(plan);
        planList.add(plan);
        planList.add(plan);
        planList.add(plan);
        planList.add(plan);
        planList.add(plan);
        planList.add(plan);
        map.put("list", planList);
        Workbook workbook = ExcelExportUtil.exportExcel(params, map);
        File savefile = new File("E:\\ExcelExport");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream("E:\\ExcelExport\\" + year + "专项支出用款申请书_map.xls");
        workbook.write(fos);
        fos.close();
    }
}
