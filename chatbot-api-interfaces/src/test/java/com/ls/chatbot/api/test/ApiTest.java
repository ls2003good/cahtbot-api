package com.ls.chatbot.api.test;


import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import java.io.IOException;

public class ApiTest {
    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/28888842258421/topics?scope=all&count=20");
        get.addHeader("cookie", "zsxq_access_token=7950C750-7FAB-CCCD-974B-6ED970C570D5_B4A7EA639B2622AE; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22585182455122524%22%2C%22first_id%22%3A%2218e664852fb956-05ea045abdc525-4c657b58-1327104-18e664852fc11ef%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThlNjY0ODUyZmI5NTYtMDVlYTA0NWFiZGM1MjUtNGM2NTdiNTgtMTMyNzEwNC0xOGU2NjQ4NTJmYzExZWYiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI1ODUxODI0NTUxMjI1MjQifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22585182455122524%22%7D%2C%22%24device_id%22%3A%2218e664852fb956-05ea045abdc525-4c657b58-1327104-18e664852fc11ef%22%7D; zsxqsessionid=ed3972f2a6d80f12438b2da2e1be6642; abtest_env=beta");
        get.addHeader("Content-type","application/json; charset=UTF-8");
        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }


    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost("https://api.zsxq.com/v2/topics/4844811411154148/comments");
        httpPost.addHeader("cookie","zsxq_access_token=7950C750-7FAB-CCCD-974B-6ED970C570D5_B4A7EA639B2622AE; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22585182455122524%22%2C%22first_id%22%3A%2218e664852fb956-05ea045abdc525-4c657b58-1327104-18e664852fc11ef%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThlNjY0ODUyZmI5NTYtMDVlYTA0NWFiZGM1MjUtNGM2NTdiNTgtMTMyNzEwNC0xOGU2NjQ4NTJmYzExZWYiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI1ODUxODI0NTUxMjI1MjQifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22585182455122524%22%7D%2C%22%24device_id%22%3A%2218e664852fb956-05ea045abdc525-4c657b58-1327104-18e664852fc11ef%22%7D; zsxqsessionid=ed3972f2a6d80f12438b2da2e1be6642; abtest_env=beta");
        httpPost.addHeader("Content-Type","application/json");

        String paramJson = "{\n"+
               " \"req_data\": {\n"+
                "\"text\": \"我也不会\\n\",\n"+
                " \"image_ids\": [],\n"+
                "\"mentioned_user_ids\": []\n"+
                "}\n" +
         "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        httpPost.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(httpPost);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }


}

















