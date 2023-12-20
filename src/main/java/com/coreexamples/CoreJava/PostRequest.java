package com.coreexamples.CoreJava;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PostRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data = "{\"encryptionFlag\":\"99\",\"formFactorId\":\"48993942\",\"payload\":\"STX2042[FS]042A[FS]2dc90b902144fc85e66c8034fc5ed0159bb82f33a8b98b53502128547f426ef6e07b88a974bc19ca346658113f4377dc2e430eba2fc20d75521ca0fad66008fe75d1329c471f0adeff1c87b6aa9c19fa3e8c3957d46c2644fb665234fad10ca55ab1f6b5f5e610036e505afd5bfd7daa711106ee7b623038307382b4bd150304cbb518d39d046a34c0f87a242e3ccc6622d6ebd4a81852848b2612991801f08805fa2e6045cb56f8b5522c34b33d1f16c7ccb004fa5773579b19b2b5e8e250523b46e8c6048ec61cf68b71fe43e7642225c066708f6474e2bbe201e1c3116c43ff833d8951a1b05ea443f6dfeabf5174c91909dfabeeaedfe22fceb8cb6b1756e5f255e599c24f069774bbeaf72cb08ef08258ef69570e5feb9078769ebdb0e1baf59cd8da07957f627358900b7b17d598188486ef0b963785d028c181eb808dbe9f95b35261369daee36f567b24f867fbb797510ab3d78188d4d0487e759e9d62c6869d85b750bd9e12acb856fcb1e01eea6eb2edb6e7a9cfb7c38894503302a31c5f3b0fb35dcd5ad096961031c4fb654da456f45b7fb26914779bdfdd0d039cc7a7f90c6a5ce434d734fe2a866ab10514ebc3ff0aad8b367cedb4792f5041d72a8fb13c941252b9c1dc2aa0a7b7738a42248bd9ec9814ca20ca92f2c848f01f98f863589cf24a3280f7155d0060999ddc93cea7b6dc667fcae5755631d5e02bad8dfe2502dadec8e789d14113ad65108382de66eae3a17127589a619498acb55dfd32e7d39b2e03c0f10e4c1c386e9af2fb63e375693a14c796c20ea2ca9a5f00e24b95f87c5f86808fc4c3759710dcbbeefff20010e9aa2d7b36c9611f528bc6caa0dc9955a54768d1d9564782dc668e4f265117704545b60110d7f564fab8388eb122b1f6b736ca3b414a00ff4fe47aba944dec2fd6a4d22beb8191b6017558dae8cf618d8e5c6c291dcc91f74041703869092c287ea297e2490fe2f63d303f49ed3e01bba00bbf01fbffab7435fff9c24178084373dcf7bcc110f70f13d132f39e59cc453203636177cf8b62b58c12596fd18a4a559d874ef123b2819e388449444634c6e0e29d73cd32a4abe2a6b8ec54b2fbefef83a120447e827c63eec1ae85afbf0be3ade85e532fe16f5123d053fe1a446a575d29622e82ae832b384efe67ea24c489e7dcd23444696c992c4e163adeed39150bb72c6deb9e77035695fbb79a0554dde00016ce617d4dc965e5d79b1a46856d31e4e86750f1aa52444298c977277183435696eb2a8eed087ac59f1aefbc14960a891786de7cbab238a5d2e66b005ccf93351bcf82e8eebfc0bab72ce8fbceaf68e790caeb79e85ae4d2e284e0635fdbb1060fc7a668347e8ec5402ca404da1635d3a4bea3b8c6ccdb9133345f33d6ac8045a68ac50174bb40a4412a4be4fe81eb2deebf7cc1834c4fb84647704066a947990d55c29d15bd9aca016201d81bb11baef0ccbd1d5efc2484503fa91db4e1a4ca028e1283e8778f3a890a63aa36382a245a9abac27867ee92c745c90e28c3806f93f32b49f636f6b4ae30b0a4094fc8e8973e7c4aab347a0b975093af1a580acd20ccb70005d234449f7cbd11baffe2ac953acb5673179c268a4fb75879d52aedcaffad1596066dd0b47cd382a8726b4427796547c88cfe21c1975a178b2c6efafb2d9212b90d39d6dd18a281239ded319b23474dbfb68470054d5fd2f0fc09d903f6af736019354d11da71f4b3a8aa6648cd3eb2896614b7dad9fa9f956180765ef882ee56ce39198b99fc0d363063d2e04c956f8de3a151bf1d84be1d8090b59b38108f4a72dba6965b7b578fa9df00b69347a102eb53e00dff7f1d7dff7db0f8e5bb6a254079811a78d8932163c7f868069192efbdad3831da171cdac2391cd0cc61f260434d8f75742720293fd724b268a0516f1dc27da36d08eacf48f18b16bed85e3a7ebdd856ff2a3255e1a3e3a14ad06c5af8bb98a88ae79d57456b771a4dfaee7cba3d8bf956a128d705926e6bf9807370434563b8428f1b530b3a2bce7caf67c4aa9af8a425ac18c2f8cc52f603827fa9a1a3fead993245992c3e2d5b22c3fe00dbbc73664e01d4dc2084be52b100812c6508e52c53b1fdd4504b17d41322d03125e411fed94d98abc28695c2daa121bb201acbb98945302073c64c0bd4950ee525fb612f9bcaf295be77b209fe013b3165116ad4e4cc0b66945edfe4aa5ea8dbdf116ad4e4cc0b66945edfe4aa5ea8dbdf1409c7911598f2c601c69bfcd95098619ec8526f259788bd8f2c087379d94f45c4897eff21202fc00f5e5796db78fd29521ed8f879be4965a4e6b9181654346d31f7a4f61846dc38750f1b45fb955ea0e87be07425f4191218d6e19098759465c737f89321cde82274526693e5431a5fd977c236c05c5d042073b5eb7302335591b41c071dca61159e57abb322a6aed58b1ae8db2fd00cbf5506f665a535da4953b5b6487a2507d7e1bb328486aa9f0af2f0a63fbf6fe5b1a273f4943a1463f12c6989955c4b02b63b124540651ac12d46f4a6413ddd33270283607b5b0fff3c87c71d3b60612a0ae2b0db28b6747e4616070c645e1ebfb43d35242385625c7d1edf8751be27190dacdfd89d6a75bb7800348440f1a58df9335b26f650f8c5ab07d711175a65f58d53d81935d7afed93018b3134cae49ca7f986006aec594ab0072379fd28dd8d8627176c440f273b8572972296e7c698ce49e8777c2e310bbb13a000d8f2a7670897fe636db632f1b0a91e9e99674bff1d347a4564e36dcc455364f622d3586d0486ace8ca90d6db6bee5c9088f11332da49c9224dce9b4678a40d14152224022c807441b3387997769fff0b12e84eb2b7bd822199b8d1f58bETX\",\"txnDateTime\":\"04072022071558\"}";
		String url = "https://ldnd42.auruspay.com/auruspay/api/auruspayServices/transactionService";
		postData(url, data);

	}

	/**
	 * @param url
	 * @param data
	 */
	public static void postData(String url, String data)
	{
		try {
			HttpClient httpclient = HttpClientBuilder.create().build();

			
			HttpPost httpPost =new HttpPost(url);
			StringEntity stringEntity = new StringEntity(data);
			httpPost.setEntity(stringEntity);
			
			httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            
            HttpResponse httpResponse = httpclient.execute(httpPost);
            
            InputStream content = httpResponse.getEntity().getContent();
            
            if(content != null)
            {
            	getData(content);
            }
            else
            {
            	
            }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	public static void getData(InputStream stream)
	{
		String line = "";
		StringBuilder stringBuilder = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(stream));
			while ((line = br.readLine() ) != null) {
				stringBuilder.append(line);
			}
		} catch (Exception e) {
		}
		
		System.err.println(stringBuilder.toString());
	}

}
