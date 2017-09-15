package com.hjx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.hjx.dao.CityInfoDao;
import com.hjx.model.CityA;
import com.hjx.model.CityEntity;
import com.hjx.model.CityInfo;
import com.hjx.model.Info;
import com.hjx.util.City;
import com.hjx.util.HttpUtils;


/** 
*   天气
* Created by hjx on  2017年9月1日 下午3:04:53 
*/
@Controller
@RequestMapping("/")
public class IndexController {

	private Logger log = Logger.getLogger(IndexController.class);
	
	@Autowired
	private CityInfoDao cityDao;
	@RequestMapping("city")
	public String changeCity(Map map){
		List<CityInfo> lists  = cityDao.queryCity0();
		map.put("city0", lists);
		return "select";
	}
	
	@RequestMapping("/city/{parentid}")
	@ResponseBody
	public List<CityInfo> cityId(@PathVariable int parentid){
		List<CityInfo> lists  = cityDao.queryCity1(parentid);
		return lists;
	}
	@RequestMapping("/city/2/{parentid}")
	@ResponseBody
	public List<CityInfo> cityId2(@PathVariable int parentid){
		List<CityInfo> lists  = cityDao.queryCity1(parentid);
		return lists;
	}
	
	/**
	 * 插入城市信息 数据库
	 * @param city
	 * @param map
	 * @param request
	 * @return
	 */
/*	@RequestMapping("getCity")
	@ResponseBody
	public String getCity(){
		Map<String, String> headers = City.setAppcode();
		Map<String, String> querys = new HashMap<>();
	    try {
			HttpResponse response = HttpUtils.doGet(Info.CITYHOST, Info.CITYPATH, Info.METHOD, headers, querys);
			
			JSONObject jsonObject =JSON.parseObject(EntityUtils.toString(response.getEntity()));
			CityA cityA = (CityA) jsonObject.toJavaObject(CityA.class);
			Set<CityInfo> cityInfos = cityA.getResult();
			cityInfos.stream().forEach(o->{ 
				cityDao.insertCity(o);
				System.out.println(o.getCity());});
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}*/
	
	@RequestMapping("/{city}")
	public String City(@PathVariable String city,Map map,HttpServletRequest request){
		try {
	    	Map<String, String> headers = City.setAppcode();
	    	CityEntity cityName = new CityEntity();
		    cityName.setCity(city);
		    Map<String, String> querys = City.setCity(cityName);
	    	HttpResponse response = HttpUtils.doGet(Info.HOST, Info.PATH, Info.METHOD, headers, querys);
	    	//获取response的body
	    	//System.out.println(EntityUtils.toString(response.getEntity()));
	    	JSONObject jsonObject = JSON.parseObject(EntityUtils.toString(response.getEntity()));
	    	jsonObject = (JSONObject) jsonObject.get("result");
	    	CityEntity cityEntity = jsonObject.toJavaObject(CityEntity.class);
	    	map.put("city", cityEntity);
	    	log.info("查询天气:"+cityName + "   状况:"+cityEntity.getWeather());
	    	} catch (Exception e) {
	    	e.printStackTrace();
	    }
		
		return "index";
	}
	
	@RequestMapping("/{id}/city")
	public String idCity(@PathVariable String id,Map map,HttpServletRequest request){
		try {
			System.out.println(id);
	    	Map<String, String> headers = City.setAppcode();
	    	CityEntity cityName = new CityEntity();
		    cityName.setCityId(id);
		    Map<String, String> querys = City.setCity(cityName);
	    	HttpResponse response = HttpUtils.doGet(Info.HOST, Info.PATH, Info.METHOD, headers, querys);
	    	//获取response的body
	    	//System.out.println(EntityUtils.toString(response.getEntity()));
	    	JSONObject jsonObject = JSON.parseObject(EntityUtils.toString(response.getEntity()));
	    	jsonObject = (JSONObject) jsonObject.get("result");
	    	CityEntity cityEntity = jsonObject.toJavaObject(CityEntity.class);
	    	map.put("city", cityEntity);
	    	log.info("查询天气:"+cityName + "   状况:"+cityEntity.getWeather());
	    	} catch (Exception e) {
	    	e.printStackTrace();
	    }
		
		return "index";
	}
	
	@RequestMapping("index")
	public String  index(Map map,HttpServletRequest request) {
//		String ip = City.getIpAddr(request);       		
//		Map<String, String> queryIp = new HashMap<String, String>();
//		System.out.println(ip);
//		if (ip.equals("")) {			
//		}
//	    queryIp.put("ip", ip);
	    try {
	    	Map<String, String> headers = City.setAppcode();
//		    HttpResponse ipResponse = HttpUtils.doGet(Info.IPHOST, Info.IPPATH, Info.METHOD, headers, queryIp);
//		    JSONObject jsonObject= JSON.parseObject(EntityUtils.toString(ipResponse.getEntity()));
	    	CityEntity city = new CityEntity();
	    	String cityName = "北京";
//			Object object =	jsonObject.get("city");
//	    	cityName = object!=null?(String) object:"深圳市";
		    city.setCity( cityName);
		    Map<String, String> querys = City.setCity(city);
	    	HttpResponse response = HttpUtils.doGet(Info.HOST, Info.PATH, Info.METHOD, headers, querys);
	    	//获取response的body
	    	//System.out.println(EntityUtils.toString(response.getEntity()));
	    	JSONObject jsonObject = JSON.parseObject(EntityUtils.toString(response.getEntity()));
	    	jsonObject = (JSONObject) jsonObject.get("result");
	    	CityEntity cityEntity = jsonObject.toJavaObject(CityEntity.class);
	    	map.put("city", cityEntity);
	    	log.info("查询天气:"+cityName + "   状况:"+cityEntity.getWeather());
	    	} catch (Exception e) {
	    	e.printStackTrace();
	    }
		return "index";
	}
}
