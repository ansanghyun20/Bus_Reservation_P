import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.SwingConstants;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import java.awt.GridLayout;
import javax.swing.JScrollPane;
import java.awt.Color;


public class mainPage extends JFrame {

	String monthArray[] = {"1","2","3","4","5","6","7","8","9","10","11","12"};	
	String yearArray[] = {"2021","2022","2023","2024","2025","2026","2027"};	

	int year=0, date =0;
	JButton date_1, date_2, date_3, date_4, date_5, date_6, date_7, date_8, date_9, date_10,
			date_11, date_12, date_13, date_14, date_15, date_16, date_17, date_18, date_19, date_20,
			date_21, date_22, date_23, date_24, date_25, date_26, date_27, date_28, date_29, date_30;
	private JButton date_31;
	private JLabel lblNewLabel_2;
	private JLabel selected_date;
	private JLabel lblNewLabel_3;
	private JButton next_btn;
	
	public static String transfer_date;
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Calendar cal = Calendar.getInstance( );
	
	
	public mainPage() {
		
		
		
		int month = cal.get(Calendar.MONTH) +1 ;
		
		int current_month = month;
		
		getContentPane().setLayout(null);
		
		setTitle("날짜선택화면"); 
		setSize(500,500);
		
		JLabel lblNewLabel_1 = new JLabel("날짜를 선택해 주세요.");
		lblNewLabel_1.setBounds(197, 6, 129, 16);
		getContentPane().add(lblNewLabel_1);
		
		JLabel date_check = new JLabel(current_month+"");
		date_check.setBounds(477, 6, 17, 16);
		getContentPane().add(date_check);
		
		lblNewLabel_2 = new JLabel("월 : ");
		lblNewLabel_2.setBounds(278, 67, 28, 16);
		getContentPane().add(lblNewLabel_2);
		
		
		lblNewLabel_3 = new JLabel("년 : ");
		lblNewLabel_3.setBounds(121, 67, 61, 16);
		getContentPane().add(lblNewLabel_3);
		
		
		
		selected_date = new JLabel("New label");
		selected_date.setBounds(186, 335, 140, 16);
		getContentPane().add(selected_date);
		
		
		
		JComboBox comboBox_1 = new JComboBox(yearArray);
		comboBox_1.setBounds(148, 63, 96, 27);
		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				int index = cb.getSelectedIndex();        //콤보박스의 월표시를 가져온 변수 
				year= index;
				cal.set(year+2021, date, 1);
				date_check.setText(cal.getActualMaximum(Calendar.DAY_OF_MONTH)+""); // 라벨에 월의 마지막 일자 표시 
				Button_control(cal.getActualMaximum(Calendar.DAY_OF_MONTH));

			}
		});
		getContentPane().add(comboBox_1);
		
		
		JComboBox comboBox = new JComboBox(monthArray);
		comboBox.setBounds(302, 60, 61, 33);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				int index = cb.getSelectedIndex();        //콤보박스의 월표시를 가져온 변수 
				date = index;
				cal.set(year+2021, index, 1);
				date_check.setText(cal.getActualMaximum(Calendar.DAY_OF_MONTH)+""); // 라벨에 월의 마지막 일자 표시 
				Button_control(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
			}
		});
		getContentPane().add(comboBox);
		
		
		
		//-------------------------------------------------------
		JPanel panel = new JPanel();
		panel.setBounds(32, 98, 437, 225);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 7, 0, 0));
		
		
		
		
		
		
		date_1 = new JButton("1");
		date_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cal.set(Calendar.DATE, 1);
				selected_date.setText(format.format(cal.getTime()));
				transfer_date = selected_date.getText();
			}
		});
		panel.add(date_1);
		
		date_2 = new JButton("2");
		date_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.set(Calendar.DATE, 2);
				selected_date.setText(format.format(cal.getTime()));
				transfer_date = selected_date.getText();
			}
		});
		panel.add(date_2);
		
		date_3 = new JButton("3");
		date_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.set(Calendar.DATE, 3);
				selected_date.setText(format.format(cal.getTime()));
				transfer_date = selected_date.getText();
			}
		});
		panel.add(date_3);
		
		date_4 = new JButton("4");
		date_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.set(Calendar.DATE, 4);
				selected_date.setText(format.format(cal.getTime()));
				transfer_date = selected_date.getText();
			}
		});
		panel.add(date_4);
		
		date_5 = new JButton("5");
		date_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.set(Calendar.DATE, 5);
				selected_date.setText(format.format(cal.getTime()));
				transfer_date = selected_date.getText();
			}
		});
		panel.add(date_5);
		
		date_6 = new JButton("6");
		date_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.set(Calendar.DATE, 6);
				selected_date.setText(format.format(cal.getTime()));
				transfer_date = selected_date.getText();
			}
		});
		panel.add(date_6);
		
		date_7 = new JButton("7");
		date_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.set(Calendar.DATE, 7);
				selected_date.setText(format.format(cal.getTime()));
				transfer_date = selected_date.getText();
			}
		});
		panel.add(date_7);
		
		date_8 = new JButton("8");
		date_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.set(Calendar.DATE, 8);
				selected_date.setText(format.format(cal.getTime()));
				transfer_date = selected_date.getText();
			}
		});
		panel.add(date_8);
		
		date_9 = new JButton("9");
		date_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.set(Calendar.DATE, 9);
				selected_date.setText(format.format(cal.getTime()));
				transfer_date = selected_date.getText();
			}
		});
		panel.add(date_9);
		
		date_10 = new JButton("10");
		date_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.set(Calendar.DATE, 10);
				selected_date.setText(format.format(cal.getTime()));
				transfer_date = selected_date.getText();
			}
		});
		panel.add(date_10);
		
		date_11 = new JButton("11");
		date_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.set(Calendar.DATE, 11);
				selected_date.setText(format.format(cal.getTime()));
				transfer_date = selected_date.getText();
			}
		});
		panel.add(date_11);
		
		date_12 = new JButton("12");
		date_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.set(Calendar.DATE, 12);
				selected_date.setText(format.format(cal.getTime()));
				transfer_date = selected_date.getText();
			}
		});
		panel.add(date_12);
		
		date_13 = new JButton("13");
		date_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.set(Calendar.DATE, 13);
				selected_date.setText(format.format(cal.getTime()));
				transfer_date = selected_date.getText();
			}
		});
		panel.add(date_13);
		
		date_14 = new JButton("14");
		date_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.set(Calendar.DATE, 14);
				selected_date.setText(format.format(cal.getTime()));
				transfer_date = selected_date.getText();
			}
		});
		panel.add(date_14);
		
		date_15 = new JButton("15");
		date_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.set(Calendar.DATE, 15);
				selected_date.setText(format.format(cal.getTime()));
				transfer_date = selected_date.getText();
			}
		});
		panel.add(date_15);
		
		date_16 = new JButton("16");
		date_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.set(Calendar.DATE, 16);
				selected_date.setText(format.format(cal.getTime()));
				transfer_date = selected_date.getText();
			}
		});
		panel.add(date_16);
		
		date_17 = new JButton("17");
		date_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.set(Calendar.DATE, 17);
				selected_date.setText(format.format(cal.getTime()));
				transfer_date = selected_date.getText();
			}
		});
		panel.add(date_17);
		
		date_18 = new JButton("18");
		date_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.set(Calendar.DATE, 18);
				selected_date.setText(format.format(cal.getTime()));
				transfer_date = selected_date.getText();
			}
		});
		panel.add(date_18);
		
		date_19 = new JButton("19");
		date_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.set(Calendar.DATE, 19);
				selected_date.setText(format.format(cal.getTime()));
				transfer_date = selected_date.getText();
			}
		});
		panel.add(date_19);
		
		date_20 = new JButton("20");
		date_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.set(Calendar.DATE, 20);
				selected_date.setText(format.format(cal.getTime()));
				transfer_date = selected_date.getText();
			}
		});
		panel.add(date_20);
		
		date_21 = new JButton("21");
		date_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.set(Calendar.DATE, 21);
				selected_date.setText(format.format(cal.getTime()));
				transfer_date = selected_date.getText();
			}
		});
		panel.add(date_21);
		
		date_22 = new JButton("22");
		date_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.set(Calendar.DATE, 22);
				selected_date.setText(format.format(cal.getTime()));
				transfer_date = selected_date.getText();
			}
		});
		panel.add(date_22);
		
		date_23 = new JButton("23");
		date_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.set(Calendar.DATE, 23);
				selected_date.setText(format.format(cal.getTime()));
				transfer_date = selected_date.getText();
			}
		});
		panel.add(date_23);
		
		date_24 = new JButton("24");
		date_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.set(Calendar.DATE, 24);
				selected_date.setText(format.format(cal.getTime()));
				transfer_date = selected_date.getText();
				
			}
		});
		panel.add(date_24);
		
		date_25 = new JButton("25");
		date_25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.set(Calendar.DATE, 25);
				selected_date.setText(format.format(cal.getTime()));
				transfer_date = selected_date.getText();
			}
		});
		panel.add(date_25);
		
		date_26 = new JButton("26");
		date_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.set(Calendar.DATE, 26);
				selected_date.setText(format.format(cal.getTime()));
				transfer_date = selected_date.getText();
			}
		});
		panel.add(date_26);
		
		date_27 = new JButton("27");
		date_27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.set(Calendar.DATE, 27);
				selected_date.setText(format.format(cal.getTime()));
				transfer_date = selected_date.getText();
			}
		});
		panel.add(date_27);
		
		date_28 = new JButton("28");
		date_28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.set(Calendar.DATE, 28);
				selected_date.setText(format.format(cal.getTime()));
				transfer_date = selected_date.getText();
			}
		});
		panel.add(date_28);
		
		date_29 = new JButton("29");
		date_29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.set(Calendar.DATE, 29);
				selected_date.setText(format.format(cal.getTime()));
				transfer_date = selected_date.getText();
			}
		});
		panel.add(date_29);
		
		date_30 = new JButton("30");
		date_30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.set(Calendar.DATE, 30);
				selected_date.setText(format.format(cal.getTime()));
				transfer_date = selected_date.getText();
			}
		});
		panel.add(date_30);
		
		date_31 = new JButton("31");
		date_31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.set(Calendar.DATE, 31);
				selected_date.setText(format.format(cal.getTime()));
				transfer_date = selected_date.getText();
			}
		});
		panel.add(date_31);
		
		
		
	
	
		//-------------------------------------------------------
		
		
		
		
	
		
		next_btn = new JButton("다음");
		next_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane A=new JOptionPane();
				A.showMessageDialog(null, selected_date.getText()+"으로 선택 되었습니다.");
				A.showMessageDialog(null, "다음 화면으로 이동합니다.");
				
				course co = new course();
				co.setVisible();
				dispose();
				
			}
		});
		next_btn.setBackground(Color.BLUE);
		next_btn.setBounds(197, 396, 117, 29);
		getContentPane().add(next_btn);
		
	
		
		
		

		
	}
	
	
	public void setVisible() {
		setVisible(true);
	}
	
	public void Button_control(int i) {
		if(i==28) {
			date_29.setVisible(false);
			date_30.setVisible(false);
			date_31.setVisible(false);
		}
		else if(i==29) {
			date_29.setVisible(true);
			date_30.setVisible(false);
			date_31.setVisible(false);
			
		}
		else if(i==30) {
			date_29.setVisible(true);
			date_30.setVisible(true);
			date_31.setVisible(false);
			
		}
		else if(i==31) {
			date_29.setVisible(true);
			date_30.setVisible(true);
			date_31.setVisible(true);
			
		}
	}
	
	
	
	public String getDate() {
		
		
		return transfer_date;
	}
}
