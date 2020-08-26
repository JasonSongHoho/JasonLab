package lab.test;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;


/**
 * Apache HttpClient 最佳实践
 *
 * @author jasonsong
 * 2020/8/25
 */


public class HttpClientLab {

    public static void main(String[] args) {

        CloseableHttpResponse response = null;
        HttpPost httpPost = new HttpPost();
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            httpPost.setEntity(new StringEntity(""));
            httpPost.setHeader("head", "hv");
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            System.out.println(EntityUtils.toString(entity));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                httpPost.abort();
            }
        }
    }

}
