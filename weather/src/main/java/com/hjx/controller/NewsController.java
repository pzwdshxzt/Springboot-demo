package com.hjx.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hjx.model.Info;
import com.hjx.model.News;
import com.hjx.model.NewsResult;
import com.hjx.util.City;
import com.hjx.util.HttpUtils;

@Controller
@RequestMapping("/")
public class NewsController {

	@RequestMapping("/news")
	public String getNews(Map map){
		
		Map<String, String> headers = City.setAppcode();
	    Map<String, String> querys = new HashMap<String, String>();
	    querys.put("type", "type");
	    HttpResponse response;
		try {
			response = HttpUtils.doGet(Info.NEWSHOST, Info.NEWSPATH, Info.METHOD, headers, querys);
			
			JSONObject jsonObject = JSON.parseObject(EntityUtils.toString(response.getEntity()));
			jsonObject = (JSONObject) jsonObject.get("result");
			NewsResult newsResult = jsonObject.toJavaObject(NewsResult.class);
			map.put("news", newsResult.getData());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "news";
	}
}
