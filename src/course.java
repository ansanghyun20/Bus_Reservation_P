import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class course extends JFrame {
	
	String[] point = {"서울", "안동"};
	
	public course() {
		setTitle("날짜선택화면"); 
		setSize(500,500);
		getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("출발");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		lblNewLabel.setBounds(233, 48, 61, 28);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("도착");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(233, 260, 61, 28);
		getContentPane().add(lblNewLabel_1);
		
		JLabel location_1 = new JLabel("지역명");
		location_1.setHorizontalAlignment(SwingConstants.CENTER);
		location_1.setFont(new Font("Lucida Grande", Font.PLAIN, 36));
		location_1.setBounds(164, 88, 179, 68);
		getContentPane().add(location_1);
		
		JLabel location_2 = new JLabel("지역명");
		location_2.setHorizontalAlignment(SwingConstants.CENTER);
		location_2.setFont(new Font("Lucida Grande", Font.PLAIN, 36));
		location_2.setBounds(164, 293, 179, 68);
		getContentPane().add(location_2);
		
		
		JComboBox comboBox = new JComboBox(point);
		comboBox.setBounds(164, 6, 191, 49);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				int index = cb.getSelectedIndex();        //콤보박스의 월표시를 가져온 변수 
				if(index==0) {
					location_1.setText(point[0]);
				}
				else if(index==1) {
					location_1.setText(point[1]);
				}

			}
		});
		getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(point);
		comboBox_1.setBounds(164, 221, 191, 27);

		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				int index = cb.getSelectedIndex();        //콤보박스의 월표시를 가져온 변수 
				if(index==0) {
					location_2.setText(point[0]);
				}
				else if(index==1) {
					location_2.setText(point[1]);
				}

			}
		});
		getContentPane().add(comboBox_1);
		
		JButton btnNewButton = new JButton("다음");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				book_confirm con = new book_confirm();
				
				
				JOptionPane A=new JOptionPane();
				A.showMessageDialog(null, "다음 페이지로 이동합니다.");
				dispose();
				con.setVisible();
			}
		});
		btnNewButton.setBounds(198, 405, 117, 29);
		getContentPane().add(btnNewButton);
		
		
	}
	
	public void setVisible() {
		setVisible(true);
	}
}
