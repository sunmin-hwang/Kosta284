package com.oym.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.oym.exception.NothingException;
import com.oym.vo.ChiRestaurant;
import com.oym.vo.Customer;
import com.oym.vo.JapRestaurant;
import com.oym.vo.KorRestaurant;
import com.oym.vo.Menu;
import com.oym.vo.Restaurant;
import com.oym.vo.Review;
import com.oym.vo.WesRestaurant;
/**
 * CustomerService를 implements 받은 서비스 클래스
 */
public class CustomerServiceImpl implements CustomerService{
	
	private ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>(){{
		add(new ChiRestaurant("만리성", "02-111-2222", "관철동", 1000, 2100, new ArrayList<Review>(){{
			add(new Review("아주 좋아요", 5, "만리성"));
			add(new Review("맛있어요", 3, "만리성"));
			add(new Review("재미있어요", 2, "만리성"));
			add(new Review("별로에요", 1, "만리성"));
			add(new Review("재방문 의사 있음", 5, "만리성"));//3.2
		}}, new ArrayList<Menu>() {{
			add(new Menu("짜장면", 10000, "메인 메뉴", "수타면"));
			add(new Menu("짬뽕", 11000, "메인 메뉴", "얼큰한 맛"));
		}}));
		add(new ChiRestaurant("광한루", "02-222-4444", "월곡동", 900, 2200, new ArrayList<Review>(){{
			add(new Review("아주 좋아요", 5, "광한루"));
			add(new Review("맛있어요", 3, "광한루"));
			add(new Review("재미있어요", 2, "광한루"));
			add(new Review("별로에요", 5, "광한루"));
			add(new Review("재방문 의사 있음", 5, "광한루"));
			add(new Review("추천", 4, "광한루"));
		}}, new ArrayList<Menu>() {{
			add(new Menu("꿔바로우", 15000, "메인 메뉴", "쫄깃한 튀김"));
			add(new Menu("마라탕", 30000, "메인 메뉴", "맵기 선택 가능"));
		}}));
		add(new JapRestaurant("갓덴스시", "02-444-5555", "삼성동", 1100, 2100, new ArrayList<Review>(){{
			add(new Review("아주 좋아요", 1, "갓덴스시"));
			add(new Review("맛있어요", 3, "갓덴스시"));
			add(new Review("재미있어요", 2, "갓덴스시"));
			add(new Review("별로에요", 5, "갓덴스시"));//2.75
		}}, new ArrayList<Menu>() {{
			add(new Menu("참치초밥", 20000, "main", "신선한 참치를 바로 잘라서 만든 초밥. 먹으면 갓덴이라고 외치게 됩니다."));
			add(new Menu("광어초밥", 12000, "main", "신선한 광어를 바로 잘라서 만든 초밥. 먹으면 갓덴이라고 외치게 됩니다."));
		}}));
		add(new JapRestaurant("코다차야", "02-888-7777", "쌍문동", 1700, 300, new ArrayList<Review>(){{
			add(new Review("아주 좋아요", 1, "코다차야"));
			add(new Review("맛있어요", 3, "코다차야"));
			add(new Review("재미있어요", 2, "코다차야"));//2
		}}, new ArrayList<Menu>() {{
			add(new Menu("한식뷔페", 9000, "main", "다양한 한식을 배부르게 드세요."));
			add(new Menu("사케", 100000, "drink", "맛 좋은 술을 드셔보세요."));
		}}));

		add(new KorRestaurant("이리오너라", "02-999-2699", "관철동", 700, 100, new ArrayList<Review>(){{
			add(new Review("너무 짜요", 1, "이리오너라"));
			add(new Review("양이 많아요", 3, "이리오너라"));
			add(new Review("재미있어요", 2, "이리오너라"));
			add(new Review("식권도 샀어요", 5, "이리오너라"));
			add(new Review("한식뷔페 짱", 4, "이리오너라"));
			add(new Review("맛있음", 3, "이리오너라"));//3
		}}, new ArrayList<Menu>() {{
			add(new Menu("삼겹김치찌개", 9500, "main", "이거 아주 죽여줍니다. 엄청 맛있어요."));
			add(new Menu("꿀막걸리", 3500, "drink", "둘이 먹다가 하나가 죽어요."));
		}}));
		add(new KorRestaurant("1992 덮밥&짜글이 강남본점", "02-465-6564", "관철동", 1000, 1100, new ArrayList<Review>(){{
			add(new Review("흠.....", 1, "1992 덮밥&짜글이 강남본점"));
			add(new Review("짜글이 지존", 3, "1992 덮밥&짜글이 강남본점"));
			add(new Review("짜요", 2, "1992 덮밥&짜글이 강남본점"));
			add(new Review("싱거워요", 2, "1992 덮밥&짜글이 강남본점"));
			add(new Review("짜글이가 맛있음", 3, "1992 덮밥&짜글이 강남본점"));//2.2
		}}, new ArrayList<Menu>() {{
			add(new Menu("전주비빔밥", 12500, "main", "전주에서만 맛볼수있던 전주비빕밥"));
			add(new Menu("전라도식 고추장볶음", 7900, "side", "고소한 맛의 고기에 ㅁ약고추장 소스를 넣은 존맛탱"));
		}}));
		add(new WesRestaurant("롤링파스타", "02-886-4569", "쌍문동", 0, 2400, new ArrayList<Review>(){{
			add(new Review("아주 좋아요", 1, "롤링파스타"));
			add(new Review("맛있어요", 3, "롤링파스타"));
			add(new Review("파스타가 정말 맛있어요", 2, "롤링파스타"));
			add(new Review("가격이 너무 비싸요", 2, "롤링파스타"));
			add(new Review("가성비가 좋아요", 3, "롤링파스타"));
			add(new Review("파스타가 매워요", 4, "롤링파스타"));
			add(new Review("피자가 정말 맛있어요", 5, "롤링파스타"));
			add(new Review("맛없어요", 1, "롤링파스타"));
			add(new Review("배물러요", 1, "롤링파스타"));//2.44
		}}, new ArrayList<Menu>() {{
			add(new Menu("스테이크", 70000, "side", "부채살 스테이크"));
			add(new Menu("알리오올리오", 15000, "drink", "매운맛"));		
			
		}}));
		add(new WesRestaurant("아웃백", "02-444-7768", "화양동", 500, 1500, new ArrayList<Review>(){{
			add(new Review("아주 좋아요", 4, "아웃백"));
			add(new Review("매우 만족합니", 3, "아웃백"));
			add(new Review("그냥 그래요", 2, "아웃백"));
			add(new Review("스테이크가 참 맛있어요", 2, "아웃백"));
			add(new Review("맛있어요", 2, "아웃백"));
			add(new Review("맛없어요", 3, "아웃백"));
			add(new Review("그냥 맛있어요", 5, "아웃백"));//3
		}}, new ArrayList<Menu>() {{
			add(new Menu("샐러드", 10000, "side", "연어샐러드입니다."));
			add(new Menu("로제파스타", 15000, "drink", "깊은 풍미"));		
			
		}}));
		
	}};
	private static CustomerServiceImpl service = new CustomerServiceImpl();
	private CustomerServiceImpl(){ // 싱글톤 작성
		
	}
	
	public static CustomerServiceImpl getInstance() {
		return service;
	}

	private List<Customer> customers = new ArrayList<>() {
		{
			add(new Customer("111", "abc","김지남","쌍문동","한식", 30, true));
			add(new Customer("222", "erf","박시우","삼성동","양식", 20, false));
			add(new Customer("333", "adfd","신승현","관철동","중식", 50, true));
			add(new Customer("444", "sdfd111","이찬영","월곡동","일식", 40, false));
			add(new Customer("555", "df22","황선민","월곡동","한식", 20, true));
		}
	};
	
	public List<Customer> getAllCustomer(){
		return customers;
	}

	@Override
	public void register(Customer customer) {
		customers.add(customer);
		
	}

	@Override
	public Customer findCustomer(String id)throws NothingException {
		
		Customer c = null;
		for(Customer tmp : customers) {
			if( tmp.getId().equals(id)) {
				c = tmp;
				break;
			}
		}
		if(c == null ) throw new NothingException("아이디가 [" + id + "]인 사용자는 없습니다.");
		
		return c;
	}

	@Override
	public void updateCustomer(Customer user)throws NothingException{
		
		Customer c = findCustomer(user.getId());
		
		int idx = customers.indexOf(c);
		
		customers.get(idx).changeAddress(user.getAddress());
		customers.get(idx).changePw(user.getPw());
		customers.get(idx).changeFavorite(user.getFavorite());
		
	}

	@Override
	public void deleteCustomer(String id) throws NothingException{
		
		Customer c = findCustomer(id);

		customers.remove(c);
	}

	@Override
	public ArrayList<Restaurant> findAllRestaurant() {
		
		return restaurants;
	}

	@Override
	// 한식,양식,중식 입력받아서 해당하는 레스토랑 리스트 리턴
	public ArrayList<Restaurant> findRestaurantByCategory(String category) {
		ArrayList<Restaurant> t= new ArrayList<Restaurant>();
		switch(category) {
		case "한식": 
			for(Restaurant r : restaurants) { if(r instanceof KorRestaurant) t.add(r);}
			break;
		case "일식": 
			for(Restaurant r : restaurants) { if(r instanceof JapRestaurant) t.add(r);}
			break;
		case "양식": 
			for(Restaurant r : restaurants) { if(r instanceof WesRestaurant) t.add(r);}
			break;
		case "중식": 
			for(Restaurant r : restaurants) { if(r instanceof ChiRestaurant) t.add(r);}
			break;
		}
		return t;
	}

	@Override
	public ArrayList<Restaurant> findRestaurantByLocation (String location) throws NothingException{
		ArrayList<Restaurant> t= new ArrayList<Restaurant>();
		for(Restaurant r : restaurants) {
			if(r.getLocation().equals(location)) t.add(r);
		}
		if(t.isEmpty()) throw new NothingException();
		return t;
	}

	@Override
	public ArrayList<Restaurant> findRestaurantByName(String name) throws NothingException{
		ArrayList<Restaurant> t= new ArrayList<Restaurant>();
		for(Restaurant r : restaurants) {
			if(r.getName().contains(name)) t.add(r);
		}if(t.isEmpty()) throw new NothingException();
		return t;
	}

	@Override
	public List<Restaurant> recommendRestaurantByAddress(Customer customer) throws NothingException {
		List<Restaurant> aRestaurants = new ArrayList();
		for(Restaurant restaurant : restaurants) {
			if(restaurant.getLocation().equals(customer.getAddress())) aRestaurants.add(restaurant);
		}
		if(aRestaurants.isEmpty()) throw new NothingException(customer.getAddress() + "에는 맛집이 없습니다.");
		
		Collections.sort(aRestaurants, new Comparator<Restaurant>() {

			@Override
			public int compare(Restaurant r1, Restaurant r2) {
				return r2.getName().compareTo(r1.getName());
			}
			
		});
		return aRestaurants;
	}

	@Override
	public List<Restaurant> recommendRestaurantByCategory(Customer customer) throws NothingException {
		List<Restaurant> cRestaurants = new ArrayList();
		for(Restaurant restaurant : restaurants) {
			switch (customer.getFavorite()) {
			case "한식": {
				if(restaurant instanceof KorRestaurant) cRestaurants.add(restaurant);
				break;
			}case "중식": {
				if(restaurant instanceof ChiRestaurant) cRestaurants.add(restaurant);
				break;
			}case "일식": {
				if(restaurant instanceof JapRestaurant) cRestaurants.add(restaurant);
				break;
			}case "양식": {
				if(restaurant instanceof WesRestaurant) cRestaurants.add(restaurant);
				break;
			}}
		}
		if(cRestaurants.isEmpty()) throw new NothingException(customer.getFavorite() + "집이 존재하지 않습니다.");
		
		Collections.sort(cRestaurants, new Comparator<Restaurant>() {

			@Override
			public int compare(Restaurant r1, Restaurant r2) {
				return r2.getName().compareTo(r1.getName());
			}
			
		});
		return cRestaurants;
	}

	@Override
	public Map<Restaurant, Double> recommendRestaurantByRating() {
		List<Restaurant> raRestaurants = new ArrayList();
		Map<Restaurant, Double> raRestaurant = new HashMap<Restaurant, Double>();
		for(Restaurant r : restaurants) {
			raRestaurant.put(r, 0.0);
		}
		for(int i = 0 ; i < restaurants.size() ; i++) {
			int sum = 0;
			for(Review r : restaurants.get(i).getReviews()) {
				raRestaurant.put(restaurants.get(i), raRestaurant.get(restaurants.get(i))+r.getRating());
				sum++;
			}
			raRestaurant.put(restaurants.get(i), raRestaurant.get(restaurants.get(i))/sum);
		}
		return raRestaurant;
	}

	@Override
	public List<Restaurant> recommendRestaurantByReviews() {
		List<Restaurant> reRestaurants = restaurants;
		Collections.sort(reRestaurants, new Comparator<Restaurant>() {

			@Override
			public int compare(Restaurant r1, Restaurant r2) {
				return r2.getReviews().size() - r1.getReviews().size();
			}
			
		});
		return reRestaurants;
	}

}
