package com.weyoung.wxapp.common.util;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpUtil  {
    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    final static int BUFFER_SIZE = 4096;
    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return String 所代表远程资源的响应结果
     */
    public static String get(String url,String param){
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            //System.out.println(urlNameString);
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            /*for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }*/
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
    private static String charset = "utf-8";

    public static byte[] post(String url, JSONObject json) throws ClientProtocolException, IOException{
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient client = HttpClients.createDefault();
        //解决中文乱码问题
        StringEntity entity = new StringEntity(json.toString(), charset);
        entity.setContentEncoding(charset);
        entity.setContentType("application/json");
        httpPost.setEntity(entity);
        HttpResponse response = client.execute(httpPost);

        if(response.getStatusLine().getStatusCode() == 200){
//            HttpEntity httpEntity = response.getEntity();
//            return EntityUtils.toString(httpEntity, charset);
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] data = new byte[BUFFER_SIZE];
            int count = -1;
            while ((count = response.getEntity().getContent().read(data,0,BUFFER_SIZE)) != -1)
                outStream.write(data, 0, count);

            data = null;
            return outStream.toByteArray();
        }
        return null;
    }
}
