package com.taoism.Util.okhttp;

import okhttp3.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

/**
 * 请求工具类
 *
 * @author 李嘉
 * @version 1.0
 * @Description 请求工具类
 * @date 2019/4/9 9:53
 */
public class HttpUtil {

    /**
     * 根据map获取get请求参数
     * @param queries
     * @return
     */
    public static StringBuffer getQueryString(String url, Map<String,String> queries){
        StringBuffer sb = new StringBuffer(url);
        if (queries != null && queries.keySet().size() > 0) {
            boolean firstFlag = true;
            Iterator iterator = queries.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry<String, String>) iterator.next();
                if (firstFlag) {
                    sb.append("?" + entry.getKey() + "=" + entry.getValue());
                    firstFlag = false;
                } else {
                    sb.append("&" + entry.getKey() + "=" + entry.getValue());
                }
            }
        }
        return sb;
    }

    /**
     * 调用okhttp的newCall方法
     * @param request
     * @return
     */
    private static String execNewCall(Request request){
        Response response = null;
        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            response = okHttpClient.newCall(request).execute();
            int status = response.code();
            if (response.isSuccessful()) {
                return response.body().string();
            }
        } catch (Exception e) {
            //logger.error("okhttp3 put error >> ex = {}", ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return "";
    }

    /**
     * get
     * @param url     请求的url
     * @param queries 请求的参数，在浏览器？后面的数据，没有可以传null
     * @return
     */
    public static String get(String url, Map<String, String> queries) {
        StringBuffer sb = getQueryString(url,queries);
        Request request = new Request.Builder()
                .url(sb.toString())
                .build();
        return execNewCall(request);
    }

    /**
     * get
     * @param url       请求的url
     * @return
     */
    public static String get(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        return execNewCall(request);
    }

    /**
     * post
     *
     * @param url    请求的url
     * @param params post form 提交的参数
     * @return
     */
    public static String postFormParams(String url, Map<String, String> params) {
        FormBody.Builder builder = new FormBody.Builder();
        //添加参数
        if (params != null && params.keySet().size() > 0) {
            for (String key : params.keySet()) {
                builder.add(key, params.get(key));
            }
        }
        Request request = new Request.Builder()
                .url(url)
                .post(builder.build())
                .build();
        return execNewCall(request);
    }


    /**
     * Post请求发送JSON数据....{"name":"zhangsan","pwd":"123456"}
     * 参数一：请求Url
     * 参数二：请求的JSON
     * 参数三：请求回调
     */
    public static String postJsonParams(String url, String jsonParams) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonParams);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        return execNewCall(request);
    }

    /**
     * Post请求发送xml数据....
     * 参数一：请求Url
     * 参数二：请求的xmlString
     * 参数三：请求回调
     */
    public static String postXmlParams(String url, String xml) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/xml; charset=utf-8"), xml);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        return execNewCall(request);
    }

    /**
     * POST请求文件
     * @param url
     * @param fileInfo
     * @return
     */
    public static String postFileParams(String url, File fileInfo) {
        String msg = "";
        try {
            URL urlObj = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) urlObj.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setUseCaches(false);
            urlConnection.setRequestProperty("Connection", "Keep-Alive");
            urlConnection.setRequestProperty("Charset", "UTF-8");

            String BOUNDARY = "----------" + System.currentTimeMillis();
            urlConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

            StringBuilder sb = new StringBuilder();
            sb.append("--"); // 必须多两道线
            sb.append(BOUNDARY);
            sb.append("\r\n");
            sb.append("Content-Disposition: form-data;name=\"media\";filename=\"" + fileInfo.getName() + "\"\r\n");
            sb.append("Content-Type:application/octet-stream\r\n\r\n");
            byte[] headBytes = sb.toString().getBytes("utf-8");
            OutputStream out = new DataOutputStream(urlConnection.getOutputStream());
            out.write(headBytes);
            InputStream in = new FileInputStream(fileInfo);
            int bytes = 0;
            byte[] bufferOut = new byte[1024];
            while ((bytes = in.read(bufferOut)) != -1) {
                out.write(bufferOut, 0, bytes);
            }
            in.close();
            // 结尾部分
            byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线
            out.write(foot);
            out.flush();
            out.close();
            StringBuffer buffer = new StringBuffer();
            BufferedReader reader = null;
            try {
                // 定义BufferedReader输入流来读取URL的响应
                reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    //System.out.println(line);
                    buffer.append(line);
                }
                msg = buffer.toString();
                System.out.println(msg);
            } catch (IOException e) {
                System.out.println("发送POST请求出现异常！" + e);
                e.printStackTrace();
                throw new IOException("数据读取异常");
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return msg;
    }
}
