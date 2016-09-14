package com.xmc.nju.software.action;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

/**
 * Created by xmc1993 on 16/9/14.
 */
public class BaseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

    private HttpServletRequest request;
    private HttpServletResponse response;



    public void setServletRequest(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        this.request = request;
    }

    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    public HttpServletResponse getResponse(){
        return this.response;
    }


    /**
     * 得到访问的整个url
     * @return
     */
    public String getFullURL() {
        StringBuffer requestURL = request.getRequestURL();
        String queryString = request.getQueryString();

        if (queryString == null) {
            return requestURL.toString();
        } else {
            return requestURL.append('?').append(queryString).toString();
        }
    }

    /**
     * 将请求的字段封装为json数据
     * @return
     */
    public String getFormData() {
        Map parameterMap = request.getParameterMap();
        Gson gson = new Gson();
        return gson.toJson(parameterMap);
    }

    /**
     * 将对象封装为json数据的格式返回给客户端
     * @param obj
     * @throws IOException
     */
    public void sendJsonData(Object obj) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        String jsonString = JSON.toJSONString(obj);
        out.println(jsonString);
        out.flush();
        out.close();
    }

    /**
     * 如果客户端发送的是RawData
     * @return
     * @throws IOException
     */
    public StringBuffer getRawData() throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        StringBuffer result = new StringBuffer("");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s;
        while((s=bufferedReader.readLine())!=null){
            result.append(s);
        }
        return result;
    }
}
