package com.handpay.obm.pg.simulator.controller;

import com.handpay.obm.pg.simulator.bean.QueryOrderReq;
import com.handpay.obm.pg.simulator.bean.SinopecDeliveryReq;
import com.handpay.obm.pg.simulator.util.HttpClientUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;



/**
 *
 *
 * @author zqjiang
 * @version 1.0  2015年9月10日
 */
@Controller
@RequestMapping("/simulator")
public class Simulator {
//	private static final Logger log=LoggerFactory.getLogger(Simulator.class);

        @RequestMapping("/recharge/")
        public String recharge(HttpServletRequest request) {
                return null;
        }

        HttpClientUtil httpClient = new HttpClientUtil();

        @RequestMapping("/delivery")
        public @ResponseBody String delivery(HttpServletRequest request, SinopecDeliveryReq req) {
                // 创建参数队列
                List<NameValuePair> formparams = new ArrayList<NameValuePair>();
                formparams.add(new BasicNameValuePair("merId", req.getMerId().trim()));
                formparams.add(new BasicNameValuePair("merPwd", StringUtils.isBlank(req.getMerPwd()) ? "" : DigestUtils.md5Hex(req.getMerPwd().trim())));
                formparams.add(new BasicNameValuePair("cardId", req.getCardId().trim()));
                formparams.add(new BasicNameValuePair("num", req.getNum().trim()));
                formparams.add(new BasicNameValuePair("orderId", req.getOrderId().trim()));
                formparams.add(new BasicNameValuePair("orderTime", req.getOrderTime().trim()));
                formparams.add(new BasicNameValuePair("gasCardTel", req.getGasCardTel().trim()));
                formparams.add(new BasicNameValuePair("gasCardName", req.getGasCardName().trim()));
                formparams.add(new BasicNameValuePair("isNotifyResult", req.getIsNotifyResult().trim()));
                formparams.add(new BasicNameValuePair("notify_url", req.getNotify_url().trim()));
                String sign = DigestUtils.sha1Hex(req.getMerId().trim()+req.getCardId().trim()+req.getNum().trim()+req.getOrderId().trim()+req.getOrderTime().trim()+req.getKey().trim());
                formparams.add(new BasicNameValuePair("sign", sign));
                formparams.add(new BasicNameValuePair("version", req.getVersion().trim()));

                return httpClient.post(req.getUrl()+"/api_center/sinopec/delivery", formparams);
        }

        @RequestMapping("/queryOrder")
        public @ResponseBody String queryOrder(HttpServletRequest request, QueryOrderReq req) {
                // 创建参数队列
                List<NameValuePair> formparams = new ArrayList<NameValuePair>();
                formparams.add(new BasicNameValuePair("merId", req.getMerId().trim()));
                formparams.add(new BasicNameValuePair("merPwd", StringUtils.isBlank(req.getMerPwd()) ? "" : DigestUtils.md5Hex(req.getMerPwd().trim())));
                formparams.add(new BasicNameValuePair("orderId", req.getOrderId().trim()));
                formparams.add(new BasicNameValuePair("orderTime", req.getOrderTime().trim()));
                formparams.add(new BasicNameValuePair("ncOrderId", req.getNcOrderId().trim()));
                formparams.add(new BasicNameValuePair("ncOrderTime", req.getNcOrderTime().trim()));
                String sign = "";
                if(StringUtils.isNotBlank(req.getNcOrderId().trim()) && StringUtils.isNotBlank(req.getNcOrderTime().trim())){
                        sign = DigestUtils.sha1Hex(req.getMerId().trim()+req.getNcOrderId().trim()+req.getNcOrderTime().trim()+req.getKey().trim());
                }else if(StringUtils.isNotBlank(req.getOrderId().trim()) && StringUtils.isNotBlank(req.getOrderTime().trim())){
                        sign = DigestUtils.sha1Hex(req.getMerId().trim()+req.getOrderId().trim()+req.getOrderTime().trim()+req.getKey().trim());
                }
                formparams.add(new BasicNameValuePair("sign", sign));
                formparams.add(new BasicNameValuePair("version", req.getVersion().trim()));

                return httpClient.post(req.getUrl()+"/api_center/queryOrder", formparams);
        }

}
