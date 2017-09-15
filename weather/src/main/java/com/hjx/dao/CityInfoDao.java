package com.hjx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.hjx.model.CityInfo;

public interface CityInfoDao {

	@Insert("INSERT INTO t_city (cityid,parentid,citycode,city) values(#{cityid},#{parentid},#{citycode},#{city})")
	public void insertCity(CityInfo city);
	
	
	/**
	 * 获取34个省级行政区
	 * @return
	 */
	@Select("select * from t_city where parentid = 0 ")
	@Results({
		 @Result(property = "cityid",  column = "cityid"),
         @Result(property = "parentid",  column = "parentid"),
         @Result(property = "citycode",  column = "citycode"),
         @Result(property = "city",  column = "city")
	})
	public List<CityInfo> queryCity0();
	
	/**
	 * 获取34个省级行政区下属地区
	 * @return
	 */
	@Select("select * from t_city where parentid = #{parentid} ")
	@Results({
		 @Result(property = "cityid",  column = "cityid"),
         @Result(property = "parentid",  column = "parentid"),
         @Result(property = "citycode",  column = "citycode"),
         @Result(property = "city",  column = "city")
	})
	public List<CityInfo> queryCity1(int parentid);
}
