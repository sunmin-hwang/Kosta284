package com.oym.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.oym.exception.NothingException;
import com.oym.service.CustomerServiceImpl;
import com.oym.vo.Customer;
import com.oym.vo.Restaurant;

public class OYMAppTest {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static CustomerServiceImpl mgr = CustomerServiceImpl.getInstance();
	
	public static void charcterInfo(){
		
		String[] O = {
            "  ####  ",
            " #    # ",
            "#      #",
            "#      #",
            "#      #",
            " #    # ",
            "  ####  "
        };

        String[] Y = {
            "#     #",
            " #   # ",
            "  # #  ",
            "   #   ",
            "   #   ",
            "   #   ",
            "   #   "
        };

        String[] M = {
            "#     #",
            "##   ##",
            "# # # #",
            "#  #  #",
            "#     #",
            "#     #",
            "#     #"
        };

        for (int i = 0; i < O.length; i++) {
            System.out.println(O[i] + "  " + Y[i] + "  " + M[i]);
        }
        
		System.out.println("                  ");                     
		System.out.println("           /\\_/\\");                     
	    System.out.println("          ( o.o ) ");
	    System.out.println("           > ^ <  ");
	    
		System.out.println("=============================");
		System.out.println("      Enter를 눌러주세요        ");

		sc.nextLine();
	}
	
	public static void main(String[] args) {

		mainWhile : 
		while(true){
		
			charcterInfo();
			
			System.out.println( "<<OYM : 맛집 검색 서비스>>\n" + 
					"번호를 선택하세요\n" + 
					"1 : 로그인\n" +
					"2 : 회원가입\n" +
					"0 : 종료\n" + 
					"=============================");

			int selectMain = sc.nextInt(); //번호 입력받기

			mainSwitch : 
			switch(selectMain){
				case 0: 
					break mainWhile;
					
				case 1:	
					login(); //로그인
					break;
					
				case 2 : 
					register();//회원가입	
					break;
				default : 	
					System.out.println("유효하지 않은 입력입니다.");
					break;
					
			}//mainSwith			
		}//mainWhile
	}//main

	
	public static void login() {
		
		boolean isLogined = false;
		System.out.println("ID 입력 : ");
		String id = sc.next();
		System.out.println("PW 입력 : ");
		String pw = sc.next();
		sc.nextLine(); // 입력 버퍼 제거
		
		List<Customer> customerList = mgr.getAllCustomer();
		
		for(Customer customer : customerList) {
			if(customer.getId().equals(id) && customer.getPw().equals(pw)) {
				System.out.println("로그인 성공!");
				
				isLogined = true;
				
				menuWhile : while(isLogined)
				{
					System.out.println("\n<<MENU>>\n" + 
										"번호를 선택하세요\n" +
										"1 : 맛집 검색\n" + 
										"2 : 맛집 추천\n" + 
										"3 : 회원 정보 수정\n" + 
										"0 : 로그아웃\n");
					
					int selectMenu = sc.nextInt();
					
					menuSwitch : switch(selectMenu){
					case 0:
						sc.nextLine();
						
						return;
						
					case 1:
						searchRestaurant();
						break;
						
					case 2:
						recommendRestaurant(customer);
						break;
						
					case 3:
						updateCustomer(customer);
						return;
					default : 	
						System.out.println("유효하지 않은 입력입니다.");
						break;	

					}//menuSwitch
				}//menuWhile
			}//if
		}//for
	}
	
	public static void searchRestaurant() {
		
		findWhile : while(true)
		{
			sc.nextLine();
			List<Restaurant> res = new ArrayList<Restaurant>();
			int num = 1;
			String find = "";
			find +=	"<<맛집 검색>>\n";
			find +=	"번호를 선택하세요\n";
			find += "1 : 모든 맛집 보기\n";
			find += "2 : 카테고리로 맛집 검색 (한식|중식|일식|양식)\n";
			find += "3 : 장소로 맛집 검색 (~동)\n";
			find += "4 : 식당 이름으로 맛집 검색\n";
			find += "0 : MENU로 돌아가기\n";

			System.out.println(find);
			
			int selectFind = sc.nextInt();
			
			findSwitch : switch(selectFind){
			case 0:
				return;
			case 1:
				System.out.println("<<모든 맛집 보기>>");
				res = mgr.findAllRestaurant();
				for(Restaurant r : res) {
					System.out.print((num++) + ". " + r);
				}
				System.out.println();
				sc.nextLine();
				break findSwitch;
			case 2:
				System.out.println("<<카테고리로 맛집 검색 (한식|중식|일식|양식)>>");
				System.out.println("검색할 카테고리 입력 : ");
				String category = sc.next();
				if(category.equals("한식") || category.equals("중식") || category.equals("일식") || category.equals("양식")) {
					res = mgr.findRestaurantByCategory(category);
					for(Restaurant r : res) {
						System.out.print((num++) + ". " + r);
					}
					System.out.println();
					sc.nextLine();
				}else {
					System.out.println("한식|중식|일식|양식 중에서 입력해 주세요");
					
				}
				break findSwitch;
			case 3:
				System.out.println("<<장소로 맛집 검색 (~동)>>");
				System.out.println("검색할 장소 입력 : ");
				String location = sc.next();
				try {
					res = mgr.findRestaurantByLocation(location);
					for(Restaurant r : res) {
						System.out.print((num++) + ". " + r);
					}
					System.out.println();
					sc.nextLine();
				} 
				catch (NothingException e) {System.out.println("해당 장소에 있는 식당이 없습니다.");}
				break findSwitch;
			case 4:
				System.out.println("<<식당 이름으로 맛집 검색>>");
				System.out.println("검색할 식당 이름 입력 : ");
				String name = sc.next();
				try {
					res = mgr.findRestaurantByName(name);
					for(Restaurant r : res) {
						System.out.print((num++) + ". " + r);
					}
					System.out.println();
					sc.nextLine();
				} catch(NothingException e) { System.out.println("해당 이름을 가진 식당이 없습니다.");}
				break findSwitch;
			default : 	
				System.out.println("유효하지 않은 입력입니다.");
				break;	
			}//findSwitch
		}//findWhile
	}
	
	public static void recommendRestaurant(Customer customer) {
		
		boolean isrecommend = true;
		recommendWhile : while(isrecommend)
		{
			sc.nextLine();
			List<Restaurant> res = new ArrayList<Restaurant>();
			int num = 1;
			String recommend = "";
			recommend += "=============================\n";
			recommend +=	"<<맛집 추천>>\n";
			recommend +=	"번호를 선택하세요\n";
			recommend += "1 : 가까운 맛집 추천\n";
			recommend += "2 : 가장 좋아하는 카테고리로 맛집 추천 (한식|중식|일식|양식)\n";
			recommend += "3 : 별점 높은 순으로 맛집 추천\n";
			recommend += "4 : 리뷰 많은 순으로 맛집 추천\n";
			recommend += "0 : MENU로 돌아가기\n";
			recommend += "=============================\n";


			System.out.println(recommend);
			
			int selectrecommend = sc.nextInt();
			
			recommendSwitch : switch(selectrecommend){
			case 0:
				return;
			case 1:
				System.out.println("<< ["+ customer.getAddress()+ "]에서 가까운 맛집 추천 리스트 >>");
				try {
					res = mgr.recommendRestaurantByAddress(customer);
					for(Restaurant r : res) {
						System.out.print((num++) + ". " + r);
					}
					System.out.println();
				} catch (NothingException e) {
					e.getMessage();
				}
				sc.nextLine();
				break recommendSwitch;
			case 2:
				System.out.println("<< 내가 가장 좋아하는 ["  + customer.getFavorite()  +"] 맛집 추천 >>");
				try {
					res = mgr.recommendRestaurantByCategory(customer);
					for(Restaurant r : res) {
						System.out.print((num++) + ". " + r);
					}
					System.out.println();
				} catch (NothingException e) {
					e.getMessage();
				}
				sc.nextLine();
				break recommendSwitch;
			case 3:
				System.out.println("<< 리뷰 내 별점 높은 순으로 맛집 추천 >>");
				Map<Restaurant, Double> m = mgr.recommendRestaurantByRating();
				List<Restaurant> keySet = new ArrayList<>(m.keySet());

		        // Value 값으로 오름차순 정렬
		        keySet.sort(new Comparator<Restaurant>() {
		            @Override
		            public int compare(Restaurant r1, Restaurant r2) {
		                return m.get(r2).compareTo(m.get(r1));
		            }
		        });
		        for (Restaurant key : keySet) {
		            System.out.print((num++) + ". " + key);
		            System.out.println("     별점 : " + String.format("%.1f", m.get(key)) );
		        }
		        sc.nextLine();
				break recommendSwitch;
			case 4:
				System.out.println("<<리뷰 많은 순으로 맛집 추천>>");
				res = mgr.recommendRestaurantByReviews();
				for(Restaurant r : res) {
					System.out.print((num++) + ". " + r);
					System.out.println("     리뷰 수 : " + r.getReviews().size() + "개");
				}
				System.out.println();
				sc.nextLine();
				break recommendSwitch;
				
			default : 	
				System.out.println("유효하지 않은 입력입니다.");
				break;
				
			}//recommendSwitch
		}//recommendWhile
	}

	public static void updateCustomer(Customer customer) {
		boolean flag = true;
		String changedFavorite= null;
		userwhile : while(true)
		{
			String user = "";
			user +=	"<<회원정보 수정>>\n";
			user +=	"번호를 선택하세요\n";
			user += "1 : 정보 수정\n";
			user += "2 : 회원 탈퇴\n";
			user += "0 : MENU로 돌아가기\n";

			System.out.println(user);
			
			int selectUser = sc.nextInt();
			
			userSwitch : switch(selectUser){
			case 0:
				break userwhile;
			case 1:
				System.out.println("<<정보 수정>>");
				System.out.println("주소, PW, 선호 카테고리만 수정 가능합니다");
				
				System.out.println("수정할 주소 입력 : ");
				String changedAddress = sc.next();
				
				System.out.println("수정할 PW 입력 : ");
				String changedPw = sc.next();
				
				while(flag) {
				System.out.println("수정할 선호하는 음식의 종류를 적어주세요 ex)한식, 일식, 양식, 중식 : ");
				changedFavorite = sc.next(); 
				if(changedFavorite.equals("한식") || changedFavorite.equals("일식") || 
					changedFavorite.equals("양식") || changedFavorite.equals("중식")){
				flag=false;
				}else {
					System.out.println("수정할 선호하는 음식의 종류를 적어주세요 ex)한식, 일식, 양식, 중식 : ");
					changedFavorite = sc.next(); 
				}
				}//while
				try {
					mgr.updateCustomer(new Customer(customer.getId(),
													changedPw,
													customer.getName(),
													changedAddress,
													changedFavorite,
													customer.getAge(),
													customer.isMan()));
				} catch (NothingException e) {
					e.getMessage();
				}
				
				System.out.println("회원 정보가 수정되었습니다");
				System.out.println("================== 수정 후 회원 정보 ==================");
				System.out.println(customer.toString());
				sc.nextLine();
				return;

			case 2:
				System.out.println("<<회원 탈퇴>>");
				System.out.println("탈퇴하실 회원의 ID 입력 : ");
				String checkOutId = sc.next();
				if(checkOutId.equals(customer.getId())) {
					try {
						mgr.deleteCustomer(checkOutId);
					}catch (NothingException e) {
						e.getMessage();
					}
					System.out.println("[" + checkOutId + "] 님의 회원 탈퇴가 완료되었습니다");
					sc.nextLine();
					
					
					return;
					
				}else {
					System.out.println("ID를 다시 입력해 주세요");
				}
				sc.nextLine();
				break;
				
			default : 	
				System.out.println("유효하지 않은 입력입니다.");
				sc.nextLine();
				break;
				
			}//userSwitch
		}//userwhich
	}

	public static void register() {
		
		registerwhile : while(true) {
			String register = "";
			register +=	"<<회원가입>>\n";
			register += "<<번호를 선택하세요>>\n";
			register += "0 : MENU로 돌아가기\n";
			register += "1 : 회원가입 계속하기\n";
			System.out.println(register);
			
			int selectRegister = sc.nextInt();
			
			registerSwitch : 
			switch(selectRegister){
				case 0:
					break registerwhile;
				case 1:
					registerprocesswhile : 
					while(true) {
						System.out.println("회원가입을 시작합니다.");
						
						System.out.println("ID를 입력해주세요 : ");
						String registerId = sc.next();
						
						System.out.println("비밀번호를 입력해주세요 : ");
						String registerPassword = sc.next();
						
						System.out.println("이름을 입력해주세요 : ");
						String registerName = sc.next();
						
						System.out.println("주소를 입력해주세요 : ");
						String registerAddress = sc.next();
						
						System.out.println("선호하는 음식의 종류를 적어주세요 ex)한식 : ");
						String registerFavorite = sc.next();
						
						System.out.println("나이를 입력해주세요 : ");
						int registerAge = sc.nextInt();
						
						System.out.println("성별을 입력해주세요 : ");
						String registerGender = sc.next();
						
						boolean isMan = false;
						if(registerGender.equals("남자")) {
							isMan = true;
						}
						
						System.out.println("================== 정보 확인 ==================");
						
						System.out.println(registerId + ", " +registerPassword + ", "+ registerName + ", " +  registerAddress + ", " + registerFavorite + ", " + registerAge + ", " +  registerGender);
						
						System.out.println("위의 내용이 맞으십니까?(맞으면 y, 틀리면 n)");
						String check = sc.next();
						
						boolean isRightInfo = false;
						if(check.equals("y")) isRightInfo = true;
						
						if(isRightInfo == true) {
							System.out.println("회원가입이 완료되었습니다.");
							mgr.register(new Customer(registerId, registerPassword, registerName, registerAddress, registerFavorite, registerAge, isMan));
							break registerprocesswhile;
						} 
					}//registerprocesswhile
					sc.nextLine();
					break;
				
				default : 	
					System.out.println("유효하지 않은 입력입니다.");
					break;
					
			}//registerSwitch
		
		}//registerwhile
		
	} //register
	
}