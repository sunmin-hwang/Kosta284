/*
 step1
 void addEngineer(Engineer e){ }
 void insertSalesMan(SalesMan s){ }
 void registerAnalysist(Analysist a){ }
 
 step2
 void addEngineer(Engineer e){ }
 void addSalesMan(SalesMan s){ }
 void addAnalysist(Analysist a){ }
 
 step3
 void addEmployee(Engineer e){ }
 void addEmployee(SalesMan s){ }
 void addEmployee(Analysist a){ }
 
 step4
 void addEmployee(Employee e){ }
*/
package com.edu.service;

import com.edu.vo.Engineer;
import com.edu.vo.SalesMan;

/*
 * Enginner, SalesMan 각각의 직원들을 핸들링라는 기능만으로 구성된 서비스 클래스..
 * */
public class HRService {
	
	Engineer[] engineers;
	int eidx;
	
	SalesMan[] salesMans;
	int sidx;
	
	public HRService() { }
	public HRService(int size){
		engineers = new Engineer[size];
		salesMans = new SalesMan[size];
	}
	
	//서비스 기능들을 정의....1) 선언부 먼저 작성 + 2) 나중에 구현부 작성 + Test에서 하나씩 호출
	
	//엔지니어를 추가하는 기능
	public void addEmployee(Engineer engineer) {
		if(eidx == engineers.length) System.out.println("더이상 추가 불가");
		else {
			engineers[eidx++] = engineer;
			System.out.println(engineer.getName() + " 엔지니어 등록 성공");
		}
	}
	
	//영업사원을 추가하는 기능
    public void addEmployee(SalesMan salesMan) {
    	if(sidx == salesMans.length) System.out.println("더이상 추가 불가");
		else {
			salesMans[sidx++] = salesMan;
			System.out.println(salesMan.getName() + " 영업사원 등록 성공");
		}
	}

	//엔지니어의 정보를 수정하는 기능
    public void updateEmployee(Engineer engineer) {
		for(Engineer e : engineers) {
			if(e == null) continue;
			if(e.getName().equals(engineer.getName())) {
				e.changeSalary(engineer.getSalary());
				e.developMainSkill(engineer.getMainSkill());
			}
		}
	}
    
	//영업사원의 정보를 수정하는 기능
    public void updateEmployee(SalesMan salesMan) {
    	for(SalesMan s : salesMans) {
			if(s == null) continue;
			if(s.getName().equals(salesMan.getName())) {
				s.changeSalary(salesMan.getSalary());
				s.setCommition(salesMan.getCommition());
			}
		}
	}
    
	//특정한 엔지니어를 검색하는 기능...이름으로
    public Engineer searchEmployee(String name) {
    	Engineer engineer = null;
    	for(int i = 0; i < eidx ; i++) {
			if(engineers[i].getName().equals(name)) {
				engineer = engineers[i];
			}
		}
		return engineer;
	}
    
    public void printEmployee() {
    	for(int i = 0; i < eidx ; i++) System.out.println(engineers[i].getDetails());
    	for(int i = 0; i < sidx ; i++) System.out.println(salesMans[i].getDetails());
    	System.out.println("============================");
    }
    
}
