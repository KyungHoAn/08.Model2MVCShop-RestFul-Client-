package client.app;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.User;

public class RestHttpClientAppPro {

		//main method
	public static void main(String[] args) throws Exception{
		
//		System.out.println("\n=======================");
//		RestHttpClientAppPro.getProductTest_JsonSimple();
		
//		System.out.println("\n=======================");
//		RestHttpClientAppPro.getProductTest_CodeHaus();
		
//		System.out.println("\n=======================");
//		RestHttpClientAppPro.addProductTest_JsonSimple();
		
//		System.out.println("\n=======================");
//		RestHttpClientAppPro.addProductTest_Codehaus();
		
//		System.out.println("\n=======================");
//		RestHttpClientAppPro.listProductTest_JsonSimple();
		
//		System.out.println("\n=======================");
//		RestHttpClientAppPro.listProductTest_Codehaus();
		
		System.out.println("\n=======================");
		RestHttpClientAppPro.upateProductTest_JsonSimple();
	}
	public static void getProductTest_JsonSimple() throws Exception{
		HttpClient httpClient = new DefaultHttpClient();
		
		String url ="http://127.0.0.1:8080/product/json/getProduct/10016";
		
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept","application/json");
		httpGet.setHeader("Content-Type","application/json");
		
		HttpResponse httpResponse = httpClient.execute(httpGet);
		
		System.out.println(httpResponse);
		System.out.println();
		
		HttpEntity httpEntity = httpResponse.getEntity();
		
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		System.out.println("[Server 에서 받은 Data 확인");
		String serverData = br.readLine();
		System.out.println(serverData);
		
		JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
		System.out.println(jsonobj);
	}
	public static void getProductTest_CodeHaus() throws Exception{
		HttpClient httpClient = new DefaultHttpClient();
		
		String url = "http://127.0.0.1:8080/product/json/getProduct/10016";
		
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept","application/json");
		httpGet.setHeader("Content-Type","application/json");
		
		HttpResponse httpResponse = httpClient.execute(httpGet);
		
		System.out.println(httpResponse);
		System.out.println();
		
		HttpEntity httpEntity = httpResponse.getEntity();
		
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println(jsonobj);
		
		ObjectMapper objectMapper = new ObjectMapper();
		System.out.println(jsonobj);
		Product product = objectMapper.readValue(jsonobj.toString(), Product.class);
		System.out.println(product);
	}
	
	public static void addProductTest_JsonSimple() throws Exception{
		HttpClient httpClient = new DefaultHttpClient();
		
		String url = "http://127.0.0.1:8080/product/json/addProduct";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept","application/json");
		httpPost.setHeader("Content-Type","application/json");
		
		JSONObject json = new JSONObject();
		json.put("prodName","비타민");
		json.put("prodDetail","비타5000");
		HttpEntity httpEntity = new StringEntity(json.toString(),"utf-8");
		
		httpPost.setEntity(httpEntity);
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		System.out.println(httpResponse);
		System.out.println();
		
		HttpEntity httpEntity01 = httpResponse.getEntity();
		
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
		
		System.out.println("[Server 에서 받은 Data확인]");
		String serverData = br.readLine();
		System.out.println(serverData);
		
		JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
		System.out.println(jsonobj);
		
	}
	
	public static void addProductTest_Codehaus() throws Exception{
		HttpClient httpClient = new DefaultHttpClient();
		
		String url = "http://127.0.0.1:8080/product/json/addProduct";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept","application/json");
		httpPost.setHeader("Content-Type","application/json");
		
		Product product = new Product();
		product.setProdName("초밥");
		product.setProdDetail("제일 좋아하는 음식");
		ObjectMapper objectMapper01 = new ObjectMapper();
		
		String jsonValue = objectMapper01.writeValueAsString(product);
		
		System.out.println(jsonValue);
		
		HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");
		
		httpPost.setEntity(httpEntity01);
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		System.out.println(httpResponse);
		System.out.println();
		
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println(jsonobj);
	
		ObjectMapper objectMapper = new ObjectMapper();
		Product pro = objectMapper.readValue(jsonobj.toString(), Product.class);
		System.out.println(pro);
	}
	
	public static void listProductTest_JsonSimple() throws Exception{
		HttpClient httpClient = new DefaultHttpClient();
		
		String url = "http://127.0.0.1:8080/product/json/listProduct";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept","application/json");
		httpPost.setHeader("Content-Type","application/json");
		
		Product product = new Product();
		ObjectMapper objectMapper01 = new ObjectMapper();
		
		String jsonValue = objectMapper01.writeValueAsString(product);
		
		System.out.println(jsonValue);
		
		HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");
		
		httpPost.setEntity(httpEntity01);
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		System.out.println(httpResponse);
		System.out.println();
		
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println(jsonobj);
	}
	
	public static void listProductTest_Codehaus() throws Exception{
		HttpClient httpClient = new DefaultHttpClient();
		
		String url = "http://127.0.0.1:8080/product/json/listProduct";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept","application/json");
		httpPost.setHeader("Content-Type","application/json");
		
		Product product = new Product();
		ObjectMapper objectMapper01 = new ObjectMapper();
		
		String jsonValue = objectMapper01.writeValueAsString(product);
		
		System.out.println(jsonValue);
		
		HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");
		
		httpPost.setEntity(httpEntity01);
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		System.out.println(httpResponse);
		System.out.println();
		
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println(jsonobj);
	
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> pro = objectMapper.readValue(jsonobj.toString(), Map.class);
		System.out.println(pro);
		
	}
	
	public static void upateProductTest_JsonSimple() throws Exception{
		HttpClient httpClient = new DefaultHttpClient();
		
		String url ="http://127.0.0.1:8080/product/json/updateProduct/10100";
		
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept","application/json");
		httpGet.setHeader("Content-Type","application/json");
		
		HttpResponse httpResponse = httpClient.execute(httpGet);
		
		System.out.println(httpResponse);
		System.out.println();
		
		HttpEntity httpEntity = httpResponse.getEntity();
		
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		System.out.println("[Server 에서 받은 Data 확인");
		String serverData = br.readLine();
		System.out.println(serverData);
		
		JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
		System.out.println(jsonobj);
	}
}
