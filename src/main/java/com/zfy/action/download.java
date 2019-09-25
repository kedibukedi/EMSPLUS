package com.zfy.action;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
@RequestMapping("/down")
public class download {
    @RequestMapping("/load")                //接受要下载的文件名
    public ResponseEntity<byte[]> download(String filename, HttpSession session) throws Exception{
       //获取目标文件的具体路径
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("/shangchuan");
        //获取目标文件
        File file=new File(realPath+"/"+filename);
        //把目标文件转换为字节数组
        byte[] bytes= FileUtils.readFileToByteArray(file);
        //设置HTTP协议请求
        HttpHeaders httpHeaders=new HttpHeaders();
        //解决文件下载文件名乱码问题
        String downname=new String(filename.getBytes("UTF-8"),"ISO-8859-1");
        //下载过后以附件形式下载 设置文件下载后打开
        httpHeaders.setContentDispositionFormData("attachment",downname);
        //下载格式以二进制流的形式
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //目标文件转换成字节数组告知springMVC文件下载已经创建可下载
        return new ResponseEntity<byte[]>(bytes,httpHeaders, HttpStatus.CREATED);
    }
}
