package com.cpj.snippet.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther:: 陈培建
 * @Date: 2023/7/30
 * @Time: 8:07 下午
 * @Description:获取request中的body参数
 */
public class HttpHelper {
    /**
     * 获取body，json字符串的形式
     * @author YunDuan-Clutch
     * @param request
     * @date 2021年11月24日 上午10:46:47
     * @return String
     */
    public static String getBodyString(ServletRequest request) {
        StringBuilder sb = new StringBuilder();
        ServletInputStream inputStream = null;
        BufferedReader reader = null;
        try {
            inputStream = request.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    /**
     * 获取body，map的形式
     * @author YunDuan-Clutch
     * @param request
     * @date 2021年11月24日 上午10:48:29
     * @return Map<String,Object>
     */
    @SuppressWarnings("all")
    public static Map<String, Object> getBodyMap(ServletRequest request) {
        Map<String, Object> params = new HashMap<>();
        String bodyString = getBodyString(request);
        if (StringUtils.isNotEmpty(bodyString)) {
            params = JSON.parseObject(bodyString, Map.class);
        }
        return params;
    }
}