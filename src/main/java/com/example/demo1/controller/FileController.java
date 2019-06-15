package com.example.demo1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-05-13 17:04
 */
@RestController
public class FileController {
    @RequestMapping("/download")
    public String downLoad(HttpServletResponse response) {
        String filename = "xxxx年计划模板.xls";
        String filePath = "src/main/resources/static";
        File file = new File(filePath + "/" + filename);
        if (file.exists()) { //判断文件父目录是否存在
            response.setContentType("application/force-download");
            try {
                response.setHeader("Content-Disposition", "attachment;fileName=" + new String(filename.getBytes("UTF-8"), "ISO-8859-1"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            byte[] buffer = new byte[1024];
            FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;
            OutputStream os = null; //输出流
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while (i != -excercise1) {
                    os.write(buffer);
                    i = bis.read(buffer);
                }
                return "下载成功";
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (null != bis) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (null != fis) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "下载失败";
    }
}
