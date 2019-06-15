package com.example.demo1.test;

import lombok.Data;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-01-04 17:28
 */
@Data
public class TestDemo {

    public static String exchange(String s) {
        if (s == null) {
            System.out.println("数据为空");
            return "";
        }
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            String s1 = Integer.toHexString(aChar);
            String s2 = Long.toHexString(aChar);
            //加toUpperCase把小写字母变大写
            sb.append(Long.toHexString(aChar).toUpperCase());
        }
        return sb.toString();
    }

    public static List<String> getNumber(String num) {
        StringBuilder sb = new StringBuilder();
        char[] chars = num.toCharArray();
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    //前3位
                    sb.append(num);
                    //第4位
                    sb.append(i);
                    //第5位
                    sb.append(k);
                    //第6位
                    sb.append(j);
                    //第7位
                    sb.append(k);
                    //第8位
                    sb.append(i);
                    //第9位
                    sb.append(chars[2]);
                    //第10位
                    sb.append(chars[1]);
                    //第11位
                    sb.append(chars[0]);
                    //添加到集合
                    numbers.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
        }
        return numbers;
    }

    /**
     * 分析指定html页面返回的数据
     *
     * @param number 组成url的手机号
     * @return s
     * @throws IOException e
     */
    public static String html(String number) throws IOException {
        String uri = "http://api.qingyunke.com/api.php?key=free&appid=0&msg=";
        /*
          首先要和URL下的URLConnection对话。 URLConnection可以很容易的从URL得到。比如： // Using
           java.net.URL and //java.net.URLConnection
         */
        URL url = new URL(uri + number);
        URLConnection connection = url.openConnection();
        /*
         * 然后把连接设为输出模式。URLConnection通常作为输入来使用，比如下载一个Web页。
         * 通过把URLConnection设为输出，你可以把数据向你个Web页传送。下面是如何做：
         */
        connection.setDoOutput(true);
        /*
         * 最后，为了得到OutputStream，简单起见，把它约束在Writer并且放入POST信息中，例如： ...
         */
        OutputStreamWriter out = new OutputStreamWriter(connection
                .getOutputStream(), "8859_1");
        out.write("username=kevin&password=*********"); //post的关键所在！
        // remember to clean up
        out.flush();
        out.close();
        /*
         * 这样就可以发送一个看起来象这样的POST：
         * POST /jobsearch/jobsearch.cgi HTTP excercise1.0 ACCEPT:
         * text/plain Content-type: application/x-www-form-urlencoded
         * Content-length: 99 username=bob password=someword
         */
        // 一旦发送成功，用以下方法就可以得到服务器的回应：
        String sCurrentLine;
        StringBuilder sTotalString;
        sTotalString = new StringBuilder();
        InputStream l_urlStream;
        l_urlStream = connection.getInputStream();
        // 传说中的三层包装阿！
        BufferedReader l_reader = new BufferedReader(new InputStreamReader(l_urlStream));
        while ((sCurrentLine = l_reader.readLine()) != null) {
            sTotalString.append(sCurrentLine).append("/r/n");

        }
//        System.out.println(sTotalString);
        return sTotalString.toString();
    }

    public static String test(String phone) throws IOException {
        //发送请求到页面，返回数据
        String s = html(phone);
        //分析返回数据
        if (s.contains("号码已售")) {
            return "号码已售";
        } else {
            int x = s.indexOf("￥");
            int y = s.indexOf("元");
            return phone + "  " + s.substring(x, y + 1);
        }
    }

    public static void main(String[] args) throws Exception {
//        List<Integer> listA = new ArrayList<>();
//        List<Integer> listB = new ArrayList<>();
//        List<User> users=new ArrayList<>();
//        User user=new User();user.setAge(28);
//        users.add(user);
//        listA.add(excercise1);
//        listA.add(excercise2);
//        listB.add(excercise2);
//        listB.add(excercise3);
//        listA.removeAll(listB);
//        listA.addAll(listB);
//        users.get(0).setAge(25);
//        System.out.println(users);
        // 上班时间段
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String timeSlot = "08:00~20:00";
        // TODO 进行时间段和检修时间匹配
        String[] split = timeSlot.split("~");
        String today = dateFormat.format(new Date());
        System.out.println(sdf.format(new Date()));
        String begin = today + " " + split[0] + ":00";
//        String begin ="2017-05-02 21:00:00";
        String end = today + " " + split[1] + ":00";
        Date workStartTime = sdf.parse(begin);
        System.out.println(workStartTime);
        Date workEndTime = sdf.parse(end);
        System.out.println(workEndTime);
    }

    /*for (MonthPlan monthPlan : monthPlanList) {

            Double dayBasicTargetYield = monthPlan.getBasicTargetYield() / monthPlan.getActualWorkingDays();
            Double dayStruggleTargetYield = monthPlan.getStruggleTargetYield() / monthPlan.getActualWorkingDays();

            Date beginning = beginDate;
            Date ending = endDate;
            // 开始日期在本月
            if (DateUtil.isSameMonth(beginDate, monthPlan.getYearMonth())) {
                beginning = beginDate;
            }
            // 结束日期在本月
            if (DateUtil.isSameMonth(endDate, monthPlan.getYearMonth())) {
                ending = endDate;
            }
            String plannedMaintenanceTime = monthPlan.getPlannedMaintenanceTime();
            List<MaintenanceTime> maintenanceTimes = JSON.parseArray(plannedMaintenanceTime, MaintenanceTime.class);
            // 计数
            Integer count = 0;
            while (beginning.before(ending)) {
                // 取出一天的排班计划
                WorkScheduling workScheduling = workSchedulingList.get(count++);
                // 遍历到周期结束，清零继续从第一天开始取
                if (count == workSchedulingList.size()) {
                    count = 0;
                }
                // 遍历一天的排班计划
                List<DaySchedule> dayScheduleList = workScheduling.getDayScheduleList();
                for (DaySchedule daySchedule : dayScheduleList) {
                    // 一个班次
                    // 上班时间段
                    String timeSlot = daySchedule.getTimeSlot().trim();
                    // 进行时间段和检修时间匹配
                    String[] split = timeSlot.split("~");
                    String today = dateFormat.format(beginDate);
                    String begin = today + " " + split[PlanConstant.ZERO] + ":00";
                    String end = today + " " + split[PlanConstant.ONE] + ":00";
                    // 班次开始时间
                    Date workStartTime = null;
                    // 班次结束时间
                    Date workEndTime = null;
                    try {
                        workStartTime = sdf.parse(begin);
                        workEndTime = sdf.parse(end);

                    } catch (ParseException e) {
                        log.info("班次时间段有误");
                    }
                    // 检修时间
                    String str = "";
                    // 检修时长
                    Double overhaulTime = PlanConstant.DOUBLE_ZERO;
                    // 遍历月检修时间，取交集计算班次内的检修时间
                    for (MaintenanceTime maintenanceTime : maintenanceTimes) {
                        // 检修开始时间
                        Date startTime = maintenanceTime.getStartTime();
                        // 检修结束时间
                        Date endTime = maintenanceTime.getEndTime();
                        // 计算检修时间和上班时间的交集
                        Map<String, Object> intersection = DateUtil.getIntersection(workStartTime, workEndTime, startTime, endTime);
                        String begin1 = (String) intersection.get("begin");
                        String end1 = (String) intersection.get("end");
                        // 有交集
                        if (null != begin1 && !begin1.equals("")) {
                            StringBuffer stringBuffer = new StringBuffer(str);
                            str = stringBuffer.append(begin1).append("~").append(end1).append(" ").toString();
                            Double maintenance = (Double) intersection.get("diff") / (60 * 24);
                            overhaulTime += maintenance;
                        }
                    }
                    // 实际工作时长
                    Double actualWorkingTime = DateUtil.getIntervalHours(workStartTime, workEndTime) / 24 - overhaulTime;

                    dayPlan.setDay(beginning);
                    dayPlan.setBasicTargetYield(dayBasicTargetYield);
                    dayPlan.setStruggleTargetYield(dayStruggleTargetYield);
                    dayPlan.setPlannedMaintenanceMime(str);
                    dayPlan.setPlannedOverhaulTime(overhaulTime);
                    dayPlan.setActualWorkingTime(actualWorkingTime);
                    dayPlan.setPlanMonthId(monthPlan.getId());
                    dayPlan.setWorkTeamName(daySchedule.getWorkTeamName());
                    dayPlan.setWorkTeamTypeName(daySchedule.getWorkTeamTypeName());

                    dayPlanList.add(dayPlan);
                }
                beginning = DateUtil.getNextDay(beginning);
            }
        }*/
}
