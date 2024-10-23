package com.self.service;

import com.self.vo.child.Engineer;
import com.self.vo.child.Manager;
import com.self.vo.child.Secretary;
import com.self.vo.parent.Employee;

public class EmployeeService {
	private Employee[] emps;
	private int eidx;
	
	private static EmployeeService service = new EmployeeService();

	private EmployeeService(){
		emps = new Employee[15];
	}
	
	public static EmployeeService getInstance() {
		return service;
	}
	
	public void addEmployee(Employee emp) {	
		if(eidx < emps.length) emps[eidx++] = emp;
	}

	
	public void deleteEmployee(String name) {	
		for(int i = 0 ; i < eidx ; i++) {
			if(emps[i].getName().equals(name)) {
				for(int j = i; j<eidx ; j++) {
					emps[j] = emps[j+1];
				}
				emps[eidx] = null;
				eidx--;
				
				break;
			}
		}
	}
	
	public void updateEmployee(Employee emp) {	
		for(Employee e : emps) {
			if(e==null) continue;
			if(e.getName().equals(emp.getName())) {
			    e.upgradeSalary(emp.getSalary());
			    if(e instanceof Manager) {
			    	((Manager)e).changeDept(((Manager)emp).getDept());
			    	((Manager)e).changeDeptno(((Manager)emp).getDeptno());
			    } else if(e instanceof Engineer) {
			    	((Engineer)e).changeTech(((Engineer)emp).getTech());
			    	((Engineer)e).upgradeBonus(((Engineer)emp).getBonus());
			    } else if(e instanceof Secretary) {
			    	((Secretary)e).changeEmail(((Secretary)emp).getEmail());
			    	((Secretary)e).changePhoneNumber(((Secretary)emp).getPhoneNumber());
			    }
		    }
		}
	}
	
	//Method Overloading
	/*
	 * 하는일은 똑같은데...처리하는 데이타를 달리할때 쓰는 기법
	 * 메소드의 통일감을 강조하면서도 서로다른 데이타를 처리할수 있게끔 해준다.
	 */
	public Employee findEmployee(String name) {
		Employee e = null;
		for(Employee emp : emps) {
			if(emp==null) continue;
			if(emp.getName().equals(name)) e = emp;
		}
		
		return e;
	}
	
	public Manager[ ] findManager(int deptno) {
		Manager[ ] dmanager = new Manager[eidx];
		int temp = 0;
		for(Employee e : emps) {
			if(e==null) continue;
			if(e instanceof Manager) {
				if(((Manager)e).getDeptno() == deptno) dmanager[temp++] = (Manager)e;
			}
			
		}
		
		Manager[] realManager = new Manager[temp];
		System.arraycopy(dmanager, 0, realManager, 0, temp);
		
		return realManager;
	}
	
	//같은 이메일을 사용하는 사람들을 찾아주는 기능
	public Secretary[] findSecretary(String email) {
		Secretary[] eSecretary = new Secretary[eidx];
		int temp = 0;
		for(Employee e : emps) {
			if(e==null) continue;
			if(e instanceof Secretary) {
				if((((Secretary)e).getEmail()).split("@")[1].equals(email)) eSecretary[temp++] = (Secretary)e;
			}
			
		}
		
		Secretary[] realSecrytary = new Secretary[temp];
		System.arraycopy(eSecretary, 0, realSecrytary, 0, temp);
		return realSecrytary;
	}
	
	public void printEmployees() {
		for(int i = 0 ; i < eidx ; i++) {
			System.out.println(emps[i]);
		}
	}
	
	public void printManagers() {
		for(int i = 0 ; i < eidx ; i++) {
			if(emps[i] instanceof Manager) System.out.println(emps[i]);
		}
	}
	
	public void printEngineers() {
		for(int i = 0 ; i < eidx ; i++) {
			if(emps[i] instanceof Engineer) System.out.println(emps[i]);
		}
	}
	
	public void printSecretarys() {
		for(int i = 0 ; i < eidx ; i++) {
			if(emps[i] instanceof Secretary) System.out.println(emps[i]);
		}
	}
	
	//부서별 사람수를 출력하는 기능
	public String[] countDept() {
		String[] dept = new String[eidx*2];
		for(int i = 1; i < eidx*2 ; i+=2) {
			dept[i] = "0";
		}
		int didx = 0;
		boolean fin = false;
		for(Employee e : emps) {
			if(e == null) break;
			if(e instanceof Manager) {
				for(int i = 0; i < didx ; i+=2) {
				    if(((Manager)e).getDept().equals(dept[i])) {
					    dept[i+1] = Integer.toString(Integer.parseInt(dept[i+1]) + 1);
				    	fin = true;
				    }
			    }
			    if(!fin) {
			    	dept[didx] = ((Manager)e).getDept();
			    	dept[didx+1] = "1";
			    	didx += 2;
			    }
			}
			
		}
		String[] realDept = new String[didx];
		System.arraycopy(dept, 0, realDept, 0, didx);
		return realDept;
	}

}

