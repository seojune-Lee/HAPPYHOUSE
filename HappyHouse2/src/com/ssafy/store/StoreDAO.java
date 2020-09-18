package com.ssafy.store;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StoreDAO {
	private static StoreDAO dao;
	private List<StoreInfo> list;
	
	public static void main(String[] args) throws IOException {
		StoreDAO.getInstance();
	}
	
	public static StoreDAO getInstance() throws IOException {
		if(dao == null) {
			dao = new StoreDAO();
		}
		return dao;
	}
	
	private StoreDAO() throws IOException {
		loadData();
	}

	public void loadData() throws IOException {
		list = new ArrayList<>();
		String csvFileName = "data/" + "상가업소정보.csv";
		try (BufferedReader br = new BufferedReader(new FileReader(csvFileName))) {
		    String line;

		    while ((line = br.readLine()) != null) {
		    	String[] values = line.split("\\|");
		    	
//		        System.out.println(Arrays.toString(values));
//		    	System.out.println(values[1]);		// 업체명
//		    	System.out.println(values[2]);		// 점검일자
//		    	System.out.println(values[8]);		// 점검사항
//		    	System.out.println(values[18]);		// 동
		    	list.add(new StoreInfo(values[1], values[2], values[8], (values[18])));
		    }
		}
	}
	
	public List<StoreInfo> getAll(String dong) {
		List<StoreInfo> result = new ArrayList<StoreInfo>();
		for (StoreInfo si : list) {
			if(si.getDong().equals(dong)) {
				result.add(si);
			}
		}
		return result;
	}
}
