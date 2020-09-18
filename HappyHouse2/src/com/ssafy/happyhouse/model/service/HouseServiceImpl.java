package com.ssafy.happyhouse.model.service;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.ssafy.happyhouse.HappyHouseException;
import com.ssafy.happyhouse.model.dao.HouseDao;
import com.ssafy.happyhouse.model.dao.HouseDaoImpl;
import com.ssafy.happyhouse.model.dto.HouseDeal;
import com.ssafy.happyhouse.model.dto.HousePageBean;

public class HouseServiceImpl implements HouseService{
	private HouseDao dao;
	private List<HouseDeal> deals;
	
	public HouseServiceImpl() {
		 dao = new HouseDaoImpl();
	}
	/**
	 * 검색 조건(key) 검색 단어(word)에 해당하는 아파트 거래 정보(HouseInfo)를  검색해서 반환.  
	 * @param bean  검색 조건과 검색 단어가 있는 객체
	 * @return 조회한 주택 목록
	 */
	@Override
	public List<HouseDeal> searchAll(HousePageBean  bean){
		deals = dao.searchAll(bean);
		return deals;
	}
	
	/**
	 * 아파트 식별 번호에 해당하는 아파트 거래 정보를 검색해서 반환. 
	 * @param no	검색할 아파트 식별 번호
	 * @return		아파트 식별 번호에 해당하는 아파트 거래 정보를 찾아서 리턴한다, 없으면 null이 리턴됨
	 * @throws HappyHouseException 
	 */
	@Override
	public HouseDeal search(int no) throws HappyHouseException {
		
		// complete code #03
		// null 을 return 하면 안됩니다. Dao Layer 의 적절한 method를 호출하여 Business Logic 을 완성하세요.
		HouseDeal result = dao.search(no);
		if(result == null) {
			throw new HappyHouseException();
		}
		return result;
	}
	
	public List<HouseDeal> sortDong(int type) {
		// 오름차순
		if(type == 0) {
			Collections.sort(deals, new Comparator<HouseDeal>() {
				@Override
				public int compare(HouseDeal o1, HouseDeal o2) {
					return o1.getDong().compareTo(o2.getDong());
				}
			});
			return deals;
		}
		//내림차순
		else {
			Collections.sort(deals, new Comparator<HouseDeal>() {
				@Override
				public int compare(HouseDeal o1, HouseDeal o2) {
					return o2.getDong().compareTo(o1.getDong());
				}
				
			});
			return deals;
		}
	}
	
	public List<HouseDeal> sortAmount(int type) {
		// 오름차순
		if(type == 0) {
			Collections.sort(deals, new Comparator<HouseDeal>() {
				@Override
				public int compare(HouseDeal o1, HouseDeal o2) {
					try {
						if(o1.getDealAmount() == null) {
							return 1;
						} else if(o2.getDealAmount() == null) {
							return -1;
						}
						return NumberFormat.getNumberInstance(java.util.Locale.US).parse(o1.getDealAmount().trim()).intValue() - NumberFormat.getNumberInstance(java.util.Locale.US).parse(o2.getDealAmount().trim()).intValue();
					} catch (ParseException e) {
						e.printStackTrace();
						return 0;
					}
				}
			});
			return deals;
		}
		// 내림차순
		else {
			Collections.sort(deals, new Comparator<HouseDeal>() {
				@Override
				public int compare(HouseDeal o1, HouseDeal o2) {
					try {
						if(o1.getDealAmount() == null) {
							return 1;
						} else if(o2.getDealAmount() == null) {
							return -1;
						}
						return NumberFormat.getNumberInstance(java.util.Locale.US).parse(o2.getDealAmount().trim()).intValue() - NumberFormat.getNumberInstance(java.util.Locale.US).parse(o1.getDealAmount().trim()).intValue();
					} catch (ParseException e) {
						e.printStackTrace();
						return 0;
					}
//					return Integer.parseInt(o2.getDealAmount()) - Integer.parseInt(o1.getDealAmount());
				}
			});
			return deals;
		}
	}
}
