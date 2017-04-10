package com.yx.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yx.goddess.GoddessAction;
import com.yx.model.Goddess;

public class TestAction {

	public static void main(String[] args) throws SQLException {

		GoddessAction action = new GoddessAction();
		
		/*总查询
		List<Goddess> result = action.query();
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).getId() + ":" + result.get(i).getUser_name());
		}
		*/
		
		Goddess g = new Goddess();
		g.setUser_name("小青1");
		g.setSex(1);
		g.setAge(23);
		g.setBirthday(new Date());
		g.setEmail("xiaoqing@162.com");
		g.setMobile("19298276357");
		g.setIsdel(0);
		g.setId(4);
		//action.add(g);
		 //更新 action.edit(g);
		//删除  action.del(7);
		
		//条件查询
		List<Map<String,Object>> params = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("name", "user_name");
		map.put("rela", "=");
		map.put("value", "'小夏'");
		
		params.add(map);
		
		List<Goddess> result = action.query(params);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).getId() + ":" + result.get(i).getUser_name());
		
	    }
	}
}
