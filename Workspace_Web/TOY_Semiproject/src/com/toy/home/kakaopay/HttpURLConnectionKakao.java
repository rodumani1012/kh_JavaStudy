package com.toy.home.kakaopay;

import java.io.BufferedReader;

import java.io.DataOutputStream;
import java.io.InputStreamReader;

import java.net.URL;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class HttpURLConnectionKakao {

	private final String URL = "https://kapi.kakao.com";
	private final String READY_URI = "/v1/payment/ready";
	
	public HashMap<String, String> readyToPay() throws Exception {

		URL url = new URL(URL + READY_URI);
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

		/* add reuqest header */
		con.setRequestMethod("POST");
		con.setRequestProperty("Authorization", "KakaoAK 7f93f4e99b437cdfbe264d87fa8addcd");
		con.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		String urlParameters = 
				"cid=TC0ONETIME" + "&" +
				"partner_order_id=partner_order_id" + "&" +
				"partner_user_id=partner_user_id"	+ "&" +
				"item_name=프리미엄"					+ "&" +
				"quantity=1"						+ "&" +
				"total_amount=2200"					+ "&" +
				"vat_amount=200"					+ "&" +
				"tax_free_amount=0"					+ "&" +
				"approval_url=ec2-54-180-29-116.ap-northeast-2.compute.amazonaws.com/success"+ "&" +
				"fail_url=ec2-54-180-29-116.ap-northeast-2.compute.amazonaws.com/fail"	+ "&" +
				"cancel_url=ec2-54-180-29-116.ap-northeast-2.compute.amazonaws.com/cancel"
				;
		
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		//int responseCode = con.getResponseCode();

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		String responseStr = response.toString();
		HashMap<String, String> responseBody = converJsonToMap(responseStr);
		return responseBody;

	}
	
	private HashMap<String, String> converJsonToMap(String jsonString) {
		HashMap<String,String> map = new Gson().fromJson(jsonString, new TypeToken<HashMap<String, String>>(){}.getType());
		return map;
	}
	
	
}
