
package com.other.algorithms;

public class JerseyClientUtil {
	
	/*public static void main(String[] args)
	{
		//String s = "{\"StatusInfos\": {\"StatusInfo\": {\"POSID\": \"09123004\",\"LANENO\": \"1\",\"ResponseCode\": \"00000\",\"ResponseText\": \"SUCCESS\"}}}";
		String s ="{\"InitAESDKResponseEx\":{\"StatusInfos\":{\"StatusInfo\":{\"ResponseCode\":\"00000\",\"POSID\":\"09123004\",\"LANENO\":1,\"ResponseText\":\"SUCCESS\"}}}}";
		
		String k = "{\"TransResponseEx\":{\"CCTID\":1,\"POSID\":\"09123004\",\"APPID\":4,\"BatchNumber\":310001,\"TransDetailDatas\":{\"TransDetailData\":{\"AddressVerification\":3,\"ResponseCode\":\"00000\",\"EMVReceiptData\":{\"SequenceNo\":\"0010020011\",\"LpsCode\":\"D@1\",\"ResponseCode\":\"000\",\"ProcessorResponseDate\":181106,\"ISO\":\"00\",\"MerchantMessage\":\"APPROVED\",\"CustomerMessage\":\"APPROVED - THANK YOU\",\"ProcessorResponseTime\":\"022009\"},\"BalanceAmount\":0,\"MaskedCardNumber\":\"453094XXXXXX9010\",\"SignatureReceiptFlag\":\"\",\"ApprovalCode\":\"022009\",\"CardToken\":\"\",\"TransactionAmount\":10,\"TransactionSequenceNumber\":\"000003\",\"CardType\":\"PLC\",\"TransactionIdentifier\":193183100839473796,\"CardExpiryDate\":\"\",\"EMVData\":\"SequenceNo%7E30303130303230303131%1EResponseCode%7E303030%1ERespDate%7E313831313036%1ELPSCode%7E444031%1EMerchantMessage%7E415050524f564544%1EISO%7E3030%1EOriginalTransCode%7E323031%1ERespTime%7E303232303039%1ETransmissionNumber%7E3033%1ERecordMessage%7E415050524f564544202d205448414e4b20594f55%1ELangInd%7E30\",\"VoidData\":\"\",\"ResponseText\":\"APPROVED THANKS\",\"CustomerName\":\"\"}},\"AurusPayTicketNumber\":318310083947371228}}";
		JSONObject jo = new JSONObject(k);
		
		//System.err.println(jo.getJSONObject("InitAESDKResponseEx").getJSONObject("StatusInfos").getJSONObject("StatusInfo").getString("ResponseText"));
		
		System.err.println(jo.getJSONObject("TransResponseEx").getJSONObject("TransDetailDatas").getJSONObject("TransDetailData").getString("ResponseText"));
		
		
		//postTestData();
	}
	
	
	private static void postTestData()
	{
		try{
			
			final String uri = "http://localhost:8090/aurusautomation/dummylink.do";
			 
			Test t = new Test();
			//t.setName("235234524");
			//t.setPassword("APPROVED");
		 
			RestTemplate restTemplate = new RestTemplate();
		    //restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		    //restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

		  restTemplate.postForObject(uri, t, Test.class);
		    
		}catch (HttpClientErrorException e) {
		      System.out.println(e.getStatusCode());
		      System.out.println(e.getResponseBodyAsString());
		 }
	}*/



}