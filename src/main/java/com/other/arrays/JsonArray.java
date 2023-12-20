package com.other.arrays;

import org.json.JSONArray;
import org.json.JSONObject;


public class JsonArray
{

	public static void main(String[] args)
	{
		//getJsonArray();
		
/*		String str = "{\"ProcessTransactionResponse\":{\"transaction_time\":\"004318\",\"processor_filed_encryption_key\":\"\",\"transaction_date\":\"07262018\","
						+ "\"store_id\":\"\",\"source_transaction_id\":\"\",\"processor_mac_key\":\"\",\"batch_number\":\"206001\",\"partial_card\":\"5930\","
						+ "\"ki_number\":\"\",\"response_code\":\"20006\",\"card_type\":\"GCC\",\"card_identifier\":\"\"}}";*/
		
		
		String str = "{\"ProcessTransactionResponse\":{\"transaction_time\":\"null\", "
						+ "\"ki_number\":\"\",\"response_code\":\"20006\",\"card_type\":\"GCC\",\"card_identifier\":\"\"}}";
		
		JSONObject respObj = new JSONObject(str);
		
		JSONObject object = (JSONObject) respObj.getJSONObject("ProcessTransactionResponse");
		if(object.has("transaction_time"))
		{
			System.out.println(object.get("transaction_time"));
		}
		else
		{
			System.out.println("i am not here ....");
		}
	
		System.out.println(object);
		
		respObj = new JSONObject();
		String val = "";
		respObj.put("name", val);
		respObj.put("address", val);
		
		System.out.println(respObj.toString());
		
		if(respObj.has("name"))
		{
			System.out.println("*************************");
		}else
		{
			System.out.println("]]]]]]]]]]]]]]]]]]]]]]]]]]]]");
		}
						
		}

	private static void getJsonArray()
	{
		String str = "{\"employees\":[ "
						+ "{\"name\":\"Ram\", \"email\":\"ram@gmail.com\", \"age\":23}, "
						+ "{\"name\":\"Shyam\", \"email\":\"shyam23@gmail.com\", \"age\":28},"
						+ "{\"name\":\"John\", \"email\":\"john@gmail.com\", \"age\":33} ]} ";
		
		
		JSONObject jsonObject =new JSONObject(str);
		
		JSONArray jsonArray = jsonObject.getJSONArray("employees");
		
		for (Object object : jsonArray)
		{
			JSONObject jo = (JSONObject) object;
			System.out.println(jo.get("name"));
		}
	}
}
