package com.self.service;

import com.self.vo.child.Engineer;
import com.self.vo.child.Manager;

public class EmployeeService {
	Manager[ ] ms;
	int midx;
	
	Engineer[ ] egs;
	int egidx;	
	
	private static EmployeeService service = new EmployeeService();

	private EmployeeService(){
		ms = new Manager[5];
		egs = new Engineer[5];
	}
	
	public static EmployeeService getInstance() {
		return service;
	}
	
	public void addManager(Manager m) {	
		ms[midx++] = m;
	}
	
	public void addEngineer(Engineer eg) {	
		egs[egidx++] = eg;
	}
	
	public void deleteManager(String name) {	
		for(int i = 0 ; i < midx ; i++) {
			if(ms[i].getName().equals(name)) {
				for(int j = i; j<midx ; j++) {
					ms[j] = ms[j+1];
				}
				ms[midx] = null;
				midx--;
				
				break;
			}
		}
	}
	
	public void deleteEngineer(String name) {
		int didx = 0;
		for(int i = 0 ; i < egidx ; i++) {
			if(egs[i].getName().equals(name)) didx = i;
		}
		for(int i = didx ; i < egidx-1 ; i++) {
			egs[i] = egs[i+1];
		}
		egs[egidx-1] = null;
		egidx--;
	}
	
	public void updateManager(Manager m) {	
		for(Manager manager : ms) {
			if(manager==null) continue;
			if(manager.getName().equals(m.getName())) {
				manager.upgradeSalary(m.getSalary());
				manager.changeDept(m.getDept());
				manager.changeDeptno(m.getDeptno());
			}
		}
	}
	
	public void updateEngineer(Engineer eg) {	
		for(Engineer engineer : egs) {
			if(engineer==null) continue;
			if(engineer.getName().equals(eg.getName())) {
				engineer.upgradeSalary(eg.getSalary());
				engineer.changeTech(eg.getTech());
				engineer.upgradeBonus(eg.getBonus());
			}
		}
	}	
	
	//Method Overloading
	/*
	 * 하는일은 똑같은데...처리하는 데이타를 달리할때 쓰는 기법
	 * 메소드의 통일감을 강조하면서도 서로다른 데이타를 처리할수 있게끔 해준다.
	 */
	public Manager findManager(String name) {
		Manager m = null;
		for(Manager manager : ms) {
			if(manager==null) continue;
			if(manager.getName().equals(name)) m = manager;
		}
		
		return m;
	}
	
	public Manager[ ] findManager(int deptno) {
		Manager[ ] dmanager = new Manager[midx];
		int temp = 0;
		for(Manager manager : ms) {
			if(manager==null) continue;
			if(manager.getDeptno() == deptno) dmanager[temp++] = manager;
		}
		
		Manager[] realManager = new Manager[temp];
		System.arraycopy(dmanager, 0, realManager, 0, temp);
		
		return realManager;
	}
	
	public Engineer findEngineer(String name) {
		Engineer e = null;
		for(Engineer engineer : egs) {
			if(engineer==null) continue;
			if(engineer.getName().equals(name)) e = engineer;
		}
		
		return e;
	}
	
	public void printManagers() {
		for(int i = 0 ; i < midx ; i++) {
			System.out.println(ms[i]);
		}
	}
	
	public void printEngineers() {
		for(int i = 0 ; i < egidx ; i++) {
			System.out.println(egs[i]);
		}
	}
	
	//부서별 사람수를 출력하는 기능
	public String[][] countDept() {
		String[][] dept = new String[midx][2];
		for(int i = 0; i < midx ; i++) {
			dept[i][1] = "0";
		}
		int didx = 0;
		boolean fin = false;
		for(Manager m : ms) {
			if(m == null) break;
			for(int i = 0; i < didx ; i++) {
				if(m.getDept().equals(dept[i][0])) {
					dept[i][1] = Integer.toString(Integer.parseInt(dept[i][1]) + 1);
					fin = true;
				}
			}
			if(!fin) {
				dept[didx][0] = m.getDept();
				dept[didx++][1] = "1";
			}
		}
		String[][] realDept = new String[didx][2];
		System.arraycopy(dept, 0, realDept, 0, didx);
		return realDept;
	}
	
}

