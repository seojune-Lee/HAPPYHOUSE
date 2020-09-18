package com.ssafy.environment;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EnvironmentView {
	private EnvironmentDAO dao;
	private String dong;
	private JFrame frame;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane pan;
	private String[] title = {"업체명", "지도점검일자", "점검사항"};
	
	public EnvironmentView(String dong) {
		this.dong = dong;
		try {
			dao = EnvironmentDAO.getInstance();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		frame = new JFrame("주변 환경 오염 정보 분석");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
		setMain();
		
		frame.setSize(1000, 500);
		frame.setResizable(true);
		frame.setVisible(true);
	}
	
	public void setMain() {
		model = new DefaultTableModel(title, 20);
		table = new JTable(model);
		pan = new JScrollPane(table);
		frame.add(pan, "Center");
		showEnvironments();
	}
	
	private void showEnvironments() {
		List<EnvironmentInfo> infos = dao.getAll(dong);
		if(infos!=null && infos.size()!=0) {
			int i = 0;
			String[][] data = new String[infos.size()][3];
			for (EnvironmentInfo info : infos) {
				data[i][0] = info.getName();
				data[i][1] = info.getDate();
				data[i++][2] = info.getContent();
			}
			model.setDataVector(data, title);
		}
	}
}
