package com.handpay.obm.pg.simulator.util;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;



/**
 *
 *
 * @author zqjiang
 * @version 1.0  2015年9月10日
 */
public class HttpClientUtil {
	private static final Logger log = LoggerFactory.getLogger(HttpClientUtil.class);
	/**
	 * 发送 post请求
	 */
	public String post(String url, List<NameValuePair> formparams) {
		long startTime = System.currentTimeMillis();
		// 创建默认的httpClient实例.
		RequestConfig config = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD_STRICT).build();
		CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(config).build();
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        CloseableHttpClient httpclient = HttpClientUtil.createSSLClientDefault();
		// 创建httppost
		HttpPost httppost = new HttpPost(url);

		try {
			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
			uefEntity.setContentType("application/x-www-form-urlencoded");
			httppost.setEntity(uefEntity);
			log.info("请求链接：" + httppost.getURI());
			CloseableHttpResponse response = httpClient.execute(httppost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					String res = EntityUtils.toString(entity, "UTF-8");
					long endTime = System.currentTimeMillis() - startTime;
					return res + "---耗时[" + endTime + "]毫秒";
				}
			} finally {
				response.close();
			}
		} catch (ParseException | IOException e1) {
			e1.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

//	private static CloseableHttpClient createSSLClientDefault(){
//    	SSLContext sslContext;
//		try {
//			sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
//				//信任所有
//				public boolean isTrusted(X509Certificate[] chain,
//						String authType) throws CertificateException {
//					return true;
//				}
//			}).build();
//			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
//			return HttpClients.custom().setSSLSocketFactory(sslsf).build();
//		} catch (KeyManagementException | NoSuchAlgorithmException
//				| KeyStoreException e) {
//			e.printStackTrace();
//		}
//        return  HttpClients.createDefault();
//    }


}