package mypro;

import java.sql.Connection;
import java.util.List;

import org.junit.Test;

import com.xfcc.entity.Employee;
import com.xfcc.entity.Policy;
import com.xfcc.entity.Users;
import com.xfcc.service.EmpService;
import com.xfcc.service.PolicyService;
import com.xfcc.service.UserService;
import com.xfcc.util.JDBCUtil;

public class MyTest {
	@Test
	public void utilTest(){
		
		Connection conn = JDBCUtil.getConnection();
		System.out.println(conn);
		
	}
	
	
		@Test
		public void insertTest(){
			UserService us = new UserService();
			
			System.out.println(us.rigeter("houtianhao", "houtianhao", "侯天浩"));
			
		}
		
		
		@Test
		public void findAll(){
			
			UserService us = new UserService();
			List<Users> list = us.findAllUsers();
			for (Users users : list) {
				System.out.println(users.getRealname());
			}
			
		}
		@Test
		public void findByid(){
			UserService us = new UserService();
			Users  user = us.getUserByid(2);
			System.out.println(user.getRealname());
			
		}
		
		/*
		 * 测试employee相关
		 */
		@Test
		public void gaineEmp(){
			EmpService es = new EmpService();
			Employee   em = es.backLogin("wmz", "123");
			if(em==null){
				
				System.out.println("空！");
			}
			else{
				System.out.println(em.getName());
			}
		}
		//测试获取所有的employee
		
		@Test
		public void findAllEmp(){
			EmpService es = new EmpService();
			List<Employee> empList = es.findAllEmp();
			System.out.println(empList.size());
			if(empList.isEmpty()){
				System.out.println("集合为空！");
			}else{
				
				System.out.println("集合有东西！");
			}
			for(Employee emp :empList){
				
				System.out.println(emp.getName());
				
				
			}
			
			
		}
		//显示所有的政策
		@Test
		public void findAllPol(){
			PolicyService ps = new PolicyService();
			List<Policy> polList = ps.findAllPolicy();
			System.out.println(polList.size());
			if(polList.isEmpty()){
				System.out.println("集合为空！");
			}else{
				
				System.out.println("集合有东西！");
			}
			for (Policy policy : polList) {
				System.out.println(policy.getTitle());
			}
			
			
		}

}