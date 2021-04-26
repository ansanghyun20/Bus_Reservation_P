/*
 회원가입 화면
 아이디
 이름 등 입력하는 화면이다. 
*/

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class signup extends JFrame {
	private JTextField id_text;
	private JTextField pw_text;
	private JTextField name_text;
	private JTextField birthday_text;
	private JTextField phone_text;
	private JTextField email_text;
	
	public static String id= "h";
	public static String name= "";
	public static String birthday="";
	public static String phone="";
	public static String email="";
	public static String pw;
	
	public static boolean isCreateID = false;
	public int count=0;
	
	public signup() {
		setTitle("두번째 프레임"); 
		setSize(300,400);
		getContentPane().setLayout(null);
		
		id_text = new JTextField();
		id_text.setBounds(83, 15, 130, 26);
		getContentPane().add(id_text);
		id_text.setColumns(10);
		
		pw_text = new JTextField();
		pw_text.setBounds(85, 60, 130, 26);
		getContentPane().add(pw_text);
		pw_text.setColumns(10);
		
		name_text = new JTextField();
		name_text.setBounds(85, 104, 130, 26);
		getContentPane().add(name_text);
		name_text.setColumns(10);
		
		birthday_text = new JTextField();
		birthday_text.setBounds(85, 157, 130, 26);
		getContentPane().add(birthday_text);
		birthday_text.setColumns(10);
		
		phone_text = new JTextField();
		phone_text.setBounds(85, 215, 130, 26);
		getContentPane().add(phone_text);
		phone_text.setColumns(10);
		
		email_text = new JTextField();
		email_text.setBounds(85, 276, 130, 26);
		getContentPane().add(email_text);
		email_text.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("id");
		lblNewLabel.setBounds(24, 15, 61, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("name");
		lblNewLabel_1.setBounds(26, 104, 61, 16);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("birthday");
		lblNewLabel_2.setBounds(26, 157, 61, 16);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("phone");
		lblNewLabel_3.setBounds(26, 215, 61, 16);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("e-mail");
		lblNewLabel_4.setBounds(26, 276, 61, 16);
		getContentPane().add(lblNewLabel_4);
		
		
		
		
		
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("로그인 화면에서 보냅니다 : " + id);
				
				JOptionPane A=new JOptionPane();
				
				id = id_text.getText();
				pw = pw_text.getText();
				name = name_text.getText();
				birthday = birthday_text.getText();
				phone = phone_text.getText();
				email = email_text.getText();
				
				if(id.length() <5) {
					System.out.println("ID의 길이는 5자 이상입니다.");
					A.showMessageDialog(null,"ID의 길이는 5자 이상입니다.");
				}
				else if(pw.length() <5) {
					System.out.println(" 패스워드의 길이는 5자 이상입니다.");
					A.showMessageDialog(null,"패스워드의 길이는 5자 이상입니다.");
					
				}else if(name.length() <1) {
					System.out.println("이름은 필수 입력 항목 입니다.");
					A.showMessageDialog(null,"이름은 필수 입력 항목 입니다.");
					
				}else if(phone.length() <5) {
					System.out.println("핸드폰 번호는 필수 입력 항목 입니다.");
					A.showMessageDialog(null,"핸드폰 번호는 필수 입력 항목 입니다.");
					
				}else if(count >= 1){
					new DB(1);
					dispose();
					A.showMessageDialog(null,"회원 가입이 완료 되었습니다.");
					A.showMessageDialog(null, name + "님의 가입을 진심으로 환영합니다.");
					setVisible(false);
				}
				else {
					A.showMessageDialog(null,"ID 중복 확인을 진행 해 주세요");
				}
				
			}
		});
		btnNewButton.setBounds(85, 321, 117, 29);
		getContentPane().add(btnNewButton);
		
		
		
		
		
		JLabel lblNewLabel_5 = new JLabel("password");
		lblNewLabel_5.setBounds(22, 58, 61, 16);
		getContentPane().add(lblNewLabel_5);
		
		
		
		
		
		// 아이디 확인 버
		JButton confirm = new JButton("confirm");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				JOptionPane A=new JOptionPane();
				
				id = id_text.getText();
				new DB(2); // 이 클래스에서 ID 중복확인을 한다 
				
				if(isCreateID == false) {
					A.showMessageDialog(null,"중복된 아이디 입니다.");
				}
				else if(id.length()<5) {
					A.showMessageDialog(null,"아이디를 5자 이상으로 해주세요.");
				}
				else{
					A.showMessageDialog(null,"생성 가능한 아이디 입니다.");
					id_text.setText(id);
					id_text.setEnabled(false);
					count ++;
				}
				
				
			}
		});
		confirm.setBounds(212, 15, 82, 29);
		getContentPane().add(confirm);
		
		
		
		
		
		
	}
	
	
	public void setvisible() {
		setVisible(true);
	}

	

	public static void main(String[] args) {
		

	}
}
