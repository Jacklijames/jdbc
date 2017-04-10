package cn.sxt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import cn.sxt.entity.User;

public interface UserDao {
	@Select ("select * from user")
	public List<User> getList();
	@Insert ("insert into user (name,pwd) values (#{name},#{pwd})")
	public int insert(User user);
}
