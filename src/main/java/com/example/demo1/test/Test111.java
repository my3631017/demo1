package com.example.demo1.test;

import com.alibaba.fastjson.JSON;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-05-25 15:21
 */
public class Test111 {



    public static void main(String[] args) {

        List<ShareRule> shareRuleList=new ArrayList<>();
        ShareRule shareRule= ShareRule.builder()
                .line_id("111111")
                .line_code("SCCX_01")
                .line_name("粗粒钛精矿产线")
                .weight(3)
                .build();

        shareRuleList.add(shareRule);
        shareRuleList.add(shareRule);
        shareRuleList.add(shareRule);
        shareRuleList.add(shareRule);


        String string = JSON.toJSONString(shareRuleList);
        System.out.println(string);




    }

}
@Builder
@Data
class ShareRule{
    private String line_id;
    private String line_code;
    private String line_name;
    private Integer weight;
}
