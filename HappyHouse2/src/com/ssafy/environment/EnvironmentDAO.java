package com.ssafy.environment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EnvironmentDAO {
	private static EnvironmentDAO dao;
	
	public static EnvironmentDAO getInstance() throws IOException {
		if(dao == null) {
			dao = new EnvironmentDAO();
		}
		return dao;
	}
	
	private List<EnvironmentInfo> list;
	
	private EnvironmentDAO() throws IOException {
		loadData();
	}

	public void loadData() throws IOException {
		list = new ArrayList<>();
//		String csvFileName = "c:" + File.separator + "SSAFY" + File.separator + "서울시 종로구 환경 지도점검 내역 현황.csv";
		String csvFileName = "data/" + "서울시 종로구 환경 지도점검 내역 현황.csv";
		try (BufferedReader br = new BufferedReader(new FileReader(csvFileName))) {
		    String line;

		    while ((line = br.readLine()) != null) {
		    	String[] values = line.split(",");
		    	
//		        System.out.println(Arrays.toString(values));
//		    	System.out.println(values[0]);		// 업체명
//		    	System.out.println(values[4]);		// 점검일자
//		    	System.out.println(values[9]);		// 점검사항
//		    	System.out.println(values[12]);		// 주소
//		    	System.out.println(values[12].split(" ")[2]);	// 동
		    	list.add(new EnvironmentInfo(values[0], values[4], values[9], values[12].split(" ")[2]));
		    }
		}
	}
	
	public List<EnvironmentInfo> getAll(String dong) {
		List<EnvironmentInfo> result = new ArrayList<EnvironmentInfo>();
		for (EnvironmentInfo ei : list) {
			if(ei.getDong().equals(dong)) {
				result.add(ei);
			}
		}
		return result;
	}
}
