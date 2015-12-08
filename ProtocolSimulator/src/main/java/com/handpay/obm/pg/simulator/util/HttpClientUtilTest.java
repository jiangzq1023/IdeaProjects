package com.handpay.obm.pg.simulator.util;




import com.google.gson.Gson;
import com.handpay.obm.pg.simulator.bean.CardStatus;
import com.handpay.obm.pg.simulator.bean.NotifyResult;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.bson.types.ObjectId;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;



/**
 * 
 * 
 * @author zqjiang
 * @version 1.0  2015年9月10日
 */
public class HttpClientUtilTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ObjectId _objectId = ObjectId.get();
		System.out.println(_objectId.toString());
//		post();
	}

	/** 
     * 发送 post请求访问本地应用并根据传递参数不同返回不同结果 
     */  
    public static void post() {
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httppost
        HttpPost httppost = new HttpPost("http://jk-bis-stg.wanlitong.com/bis/99WuXianCallback");
//        httppost.setHeader("Accept", "application/json");
        
        try {
            StringEntity se = new StringEntity(createParams(), "UTF-8");
            se.setContentEncoding("UTF-8");
//            se.setContentType("application/x-www-form-urlencoded");
            se.setContentType("application/json");
            httppost.setEntity(se);
            System.out.println("executing request " + httppost.getURI());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                	byte[] br = Base64.decodeBase64(EntityUtils.toString(entity, "UTF-8"));
                    System.out.println("--------------------------------------");
                    System.out.println("Response content: " + new String(br,"utf-8"));
                    System.out.println("--------------------------------------");
                }
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static String createParams(){
    	
    	NotifyResult notify = new NotifyResult();
    	notify.setRetCode("1");
    	notify.setMerId("Z0061");
    	notify.setOrderId("2015091800212503001");
    	notify.setOrderTime("20150918193707");
    	notify.setNcOrderId("102");
    	notify.setNcOrderTime("20150918193706");
    	notify.setCardId("200003");
    	notify.setNum("1");
    	String sign = DigestUtils.sha1Hex(notify.getMerId()+notify.getCardId()+notify.getNum()+notify.getOrderId()+notify.getOrderTime()+"WLT123456789YKKM");
    	notify.setSign(sign);
    	
    	List<CardStatus> cards = new ArrayList<CardStatus>();
    	
    	CardStatus card = new CardStatus();
    	card.setCardNo("MEWnPVQVQ0c=\r\n");
    	card.setStatus("已使用");
    	card.setUseTime("20150801152323");
    	card.setSinopecNo("1000114400014474564");
    	card.setUseProvince("上海市");
    	card.setUseDot("中国石化网上营业厅");
    	
    	cards.add(card);
    	notify.setCards(cards);
    	
    	Gson gson = new Gson();
    	String json = gson.toJson(notify, NotifyResult.class);
    	System.out.println("notify_result:  "+json);
        return json;
    }
    
}