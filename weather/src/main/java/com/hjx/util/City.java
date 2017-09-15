package com.hjx.util;
/** 
*   类说明 
* Created by hjx on  2017年9月1日 上午10:38:45 
*/

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.hjx.model.CityEntity;
import com.hjx.model.Info;

public class City {

	public static Map<String, String> setCity(CityEntity city){
		
		Map<String, String> querys = new HashMap<String, String>();
	    if (city.getCity()==null && city.getCityCode()==null&&city.getCityId()==null) {
			return null;
		}
	    querys.put("city", city.getCity());
	    querys.put("citycode", city.getCityCode());
	    querys.put("cityid", city.getCityId());
	    querys.put("ip", "");
	    querys.put("location", "");
		return querys;
	}
	public static Map<String, String> setAppcode(){
	    Map<String, String> headers = new HashMap<String, String>();
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + Info.APPCODE);
	    return headers;
	}
	 public static String getIpAddr(HttpServletRequest request){  
	        String ipAddress = request.getHeader("x-forwarded-for");  
	            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
	                ipAddress = request.getHeader("Proxy-Client-IP");  
	            }  
	            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
	                ipAddress = request.getHeader("WL-Proxy-Client-IP");  
	            }  
	            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
	                ipAddress = request.getRemoteAddr();  
	                if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){  
	                    //根据网卡取本机配置的IP  
	                    InetAddress inet=null;  
	                    try {  
	                        inet = InetAddress.getLocalHost();  
	                    } catch (UnknownHostException e) {  
	                        e.printStackTrace();  
	                    }  
	                    ipAddress= inet.getHostAddress();  
	                }  
	            }  
	            //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割  
	            if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15  
	                if(ipAddress.indexOf(",")>0){  
	                    ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));  
	                }  
	            }  
	            return ipAddress;   
	    }
	

}
