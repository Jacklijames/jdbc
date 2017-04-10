package com.yx.goddess;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.yx.dao.GoddessDao;
import com.yx.model.Goddess;

//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import com.yx.dao.GoddessDao;
//import com.yx.model.Goddess;

public class GoddessAction {
	
	public void add(Goddess goddess) throws SQLException{
		
		GoddessDao dao = new GoddessDao();
		dao.addGoddess(goddess);
		
	}
	
	public void edit(Goddess goddess) throws SQLException{
		GoddessDao dao = new GoddessDao();
		dao.updateGoddess(goddess);
	}
	
	public void del(Integer id) throws SQLException{
		GoddessDao dao = new GoddessDao();
		dao.delGoddess(id);
	}
	
	public Goddess get(Integer id) throws SQLException{
		GoddessDao dao = new GoddessDao();
		return dao.get(id);
	}
	
	
	public List<Goddess> query() throws SQLException{
		GoddessDao dao = new GoddessDao();
		return dao.query();
	}
	
	public List<Goddess> query(List<Map<String,Object>> params) throws SQLException{
		GoddessDao dao = new GoddessDao();
		return dao.query(params);
	}
	
	
	
//	public static void main(String[] args) throws SQLException {
//		
//		GoddessDao g = new GoddessDao();
//		/*List<Goddess> gs = g.query();
//		for (Goddess goddess : gs) {
//			System.out.println(goddess.getUser_name() + goddess.getAge());
//		}
//		*/
//		
//		//List<Goddess> result = g.query("灏忓","19856233265","xiaoxia@162.com");
//		
//		List<Map<String,Object>> params = new ArrayList<Map<String,Object>>();
//		
//		Map<String,Object> param = new HashMap<String, Object>();
//		param.put("name", "user_name");
//		param.put("rela", "like");
//		param.put("value", "'%灏忓%'");
//		params.add(param);
//		
//		param = new HashMap<String, Object>();
//		param.put("name", "mobile");
//		param.put("rela", "=");
//		param.put("value", "'19856233265'");
//		params.add(param);
//		
//		List<Goddess> result = g.query(params);
//		
//		for (int i = 0; i < result.size(); i++) {
//			System.out.println(result.get(i).toString());
//		}
//		
//		
//		
//		Goddess g1 = new Goddess();
//		
//		g1.setUser_name("灏忓");
//		g1.setAge(21);
//		g1.setSex(1);
//		g1.setBirthday(new Date());
//		g1.setEmail("xiaoxia@162.com");
//		g1.setMobile("19856233265");
//		//g1.setCreate_user("admin");
//		//g1.setCreate_data(new Date());
//		g1.setUpdate_user("admin");
//		g1.setUpdate_data(new Date());
//		g1.setIsdel(1);
//		g1.setId(3);
//		
//		
//		
//		//Goddess g2 = g.get(3);
//		//System.out.println(g2.toString());
//		
//		//g.delGoddess(2);
//		//g.updateGoddess(g1);
//		//g.addGoddess(g1);
//		
//	}
}

