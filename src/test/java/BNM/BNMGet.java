package BNM;

import com.thoughtworks.xstream.XStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BNMGet {
    public static <XStream> void main(String[] args) {
        try {
            XStream xstream = new XStream();
            xstream.processAnnotations(Valute.class);
            xstream.processAnnotations(ValCurs.class);
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet getRequest = new HttpGet(
                    "https://bnm.md/en/official_exchange_rates?date=20.02.1999");
            getRequest.addHeader("accept", "application/xml");

            HttpResponse response = httpClient.execute(getRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            String output;
            String xml = "";
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                xml = xml.concat(output.trim());

            }

//            System.out.println(xml);
            ValCurs valCurs;

            if (xml != null) {
                valCurs = (ValCurs) xstream.fromXML(xml);


                for (Object currentVal : valCurs.getValutes()) {
                    System.out.println(currentVal);
                }
            }

            httpClient.getConnectionManager().shutdown();

        } catch (ClientProtocolException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}
