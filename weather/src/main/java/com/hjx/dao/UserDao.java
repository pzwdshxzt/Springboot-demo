package com.hjx.dao;

import com.hjx.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {


    /**
     * 获取所有user
     * @return List<User>
     */
    @Select("SELECT * FROM t_user")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "name",  column = "name"),
            @Result(property = "content",  column = "content"),
            @Result(property = "birthday",  column = "birthday"),
            @Result(property = "remark",  column = "remark"),
            @Result(property = "age",  column = "age"),
    })
    public List<User> getAll();

    @Insert("INSERT INTO t_user (name,age,content,birthday,remark) VALUES(#{user.name},#{user.age},#{user.content},#{user.birthday},#{user.remark})")
    public void addUser(User user);
}
