package dao;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.*;

public class Connector {

    public String doPost(InputStream stream, String uri ){
        try {
            HttpPost post = new HttpPost(uri);
            post.setEntity(new InputStreamEntity(stream));
            post.setHeader("Content-type", "text/xml; charset=ISO-8859-1");

            HttpClient client = HttpClientBuilder.create().build();
            HttpResponse response = client.execute(post);
            HttpEntity httpEntity = response.getEntity();

            return EntityUtils.toString(httpEntity);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String doPost(File file, String uri ) throws FileNotFoundException {
        return doPost(new FileInputStream(file), uri);
    }

    public String doPost(String file, String uri ){
        return doPost(new ByteArrayInputStream(file.getBytes()), uri);
    }
}
