package com.keyhuy.paging.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringWriter;

/**
 * 工具类-处理Json数据
 *
 * @author Key
 * @date 2022/01/22/11:53
 **/
public class JsonUtils {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 对象转成Json字符串
     */
    public static String getJsonFromObject(Object object) {

        try {
            // 将对象转成json字符串返回
            return MAPPER.writeValueAsString(object);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * json数据转成对象
     */
    public static <T> T getObjectFormJson(String json, Class<T> clazz) {

        // 初始化对象
        T object = null;

        try {

            // 从json中读取对象
            object = MAPPER.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return object;
    }

    /**
     * 根据请求对象，获取请求体中数据转成json字符
     */
    public static String getJsonFromReqBody(HttpServletRequest request) {
        try {
            // 获取流对象，可以不用释放资源
            BufferedReader br = request.getReader();
            // 拼接请求体中的字符串
            StringBuilder sb = new StringBuilder();

            // 读取数据
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            // 返回json字符串
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 根据请求对象和对象Class，获取请求体中数据转成json字符，再将json转成对象
     */
    public static <T> T getObjectFromReqBody(HttpServletRequest request, Class<T> clazz) {

        // 根据request获取请求体中的json字符串
        String resJson = getJsonFromReqBody(request);

        // 将json转成对象返回
        return getObjectFormJson(resJson, clazz);
    }
}
