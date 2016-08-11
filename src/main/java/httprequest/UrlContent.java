package httprequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

public class UrlContent {
	
//	https://www.mkyong.com/java/apache-httpclient-examples/
	public static void main(String[] args) throws IOException {
		post();
		
		apachePost();
//		
//		get();
	}

	private static void apachePost() throws UnsupportedEncodingException, IOException, ClientProtocolException {
		{
			
//		    final HttpParams httpParams = new BasicHttpParams();
//		    Configurable
//		    HttpConnectionParams.setConnectionTimeout(httpParams, 30000);
//		    client = new DefaultHttpClient(httpParams);
			
		    
			HttpPost httppost = new HttpPost("http://www.example.com/page.php");

			// Request parameters and other properties.
			List<NameValuePair> params = new ArrayList<NameValuePair>(2);
			params.add(new BasicNameValuePair("param-1", "12345"));
			params.add(new BasicNameValuePair("param-2", "Hello!"));
			httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

			//Execute and get the response.
			HttpClient httpclient = HttpClientBuilder.create()
					.setConnectionTimeToLive(10, TimeUnit.SECONDS)
					.build();
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			response.getStatusLine();
			if (entity != null) {
			    InputStream instream = entity.getContent();
			    try {
			        // do something useful
			    } finally {
			        instream.close();
			    }
			}
		}
	}

	private static void post() throws MalformedURLException, IOException, ProtocolException {
		String rawData = "id=10";
		String type = "application/x-www-form-urlencoded";
		String encodedData = URLEncoder.encode( rawData ); 
		URL u = new URL("http://www.example.com/page.php");
		HttpURLConnection conn = (HttpURLConnection) u.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty( "Content-Type", type );
		conn.setRequestProperty( "Content-Length", String.valueOf(encodedData.length()));
		OutputStream os = conn.getOutputStream();
		conn.connect();
		conn.getResponseCode();
		os.write(encodedData.getBytes());
	}

	private static void get() throws MalformedURLException, IOException {
		String link = "http://google.com";

		URL url = new URL(link);
		URLConnection conn = url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		// open the stream and put it into BufferedReader
		String inputLine;
		while ((inputLine = br.readLine()) != null) {
			System.out.println(inputLine);
		}
		br.close();
		System.out.println("Done");
	}
}