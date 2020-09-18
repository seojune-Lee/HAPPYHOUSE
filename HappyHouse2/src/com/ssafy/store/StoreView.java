package com.ssafy.store;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.ssafy.environment.EnvironmentInfo;

public class StoreView {
	private StoreDAO dao;
	private String dong;
	private JFrame frame;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane pan;
	private String[] title = {"업체명", "지점명", "업종분류"};
	
	public StoreView(String dong) {
		this.dong = dong;
		try {
			dao = StoreDAO.getInstance();
		} catch (IOException e) {
			e.printStackTrace();
		}
		frame = new JFrame("주변 상가 정보 분석");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
		setMain();
		
		frame.setSize(500, 300);
		frame.setResizable(true);
		frame.setVisible(true);
	}
	
	public void setMain() {
		model = new DefaultTableModel(title, 20);
		table = new JTable(model);
		pan = new JScrollPane(table);
		frame.add(pan, "Center");
		showStores();
	}
	
	private void showStores() {
		List<StoreInfo> infos = dao.getAll(dong);
		if(infos!=null && infos.size()!=0) {
			int i = 0;
			String[][] data = new String[infos.size()][3];
			for (StoreInfo info : infos) {
				data[i][0] = info.getName();
				data[i][1] = info.getBranch();
				data[i++][2] = info.getKind();
			}
			model.setDataVector(data, title);
		}
	}
}
