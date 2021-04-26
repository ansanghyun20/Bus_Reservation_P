/*
 응용프로그램 첫 화면 ( 로그인 화면 )
*/

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class Bus extends JFrame {
	
	
	private JTextField login_text;
	private JTextField pw_text;
	private JButton login_btn;
	private JButton sign_btn;
	
	public static String id;
	public static String pw;
	
	public static boolean isFinded = false;
	public static boolean ispwFinded = false;
	public Bus() {
		getContentPane().setLayout(null);
		
		setTitle("로그인"); 
		setSize(300,400);
	
		
		// 아이디 텍스트 필드 
		login_text = new JTextField();
		login_text.setBounds(67, 98, 145, 33);
		getContentPane().add(login_text);
		login_text.setColumns(10);
		
		
		// 비밀번호 텍스트 필드 
		pw_text = new JTextField();
		pw_text.setBounds(68, 143, 146, 33);
		getContentPane().add(pw_text);
		pw_text.setColumns(10);

		
		
		// 로그인 버튼 
		login_btn = new JButton("Login");
		login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane A=new JOptionPane();
				id = login_text.getText();
				pw = pw_text.getText();
				new DB(3);           //db에서 로그인이 가능한지 여부를 불러오
				
				if(ispwFinded == true) {
					A.showMessageDialog(null, "환영합니다!");
					ispwFinded=false;
					dispose();
					
					mainPage newpage = new mainPage();
					
					newpage.setVisible();
					
				}
				else {
					A.showMessageDialog(null, "아이디 또는 패스워드가 옳지 않습니다.");
					ispwFinded=false;
				}
			}
		});
		login_btn.setBounds(78, 209, 117, 29);
		getContentPane().add(login_btn);
		
		
		// 회원가입 버튼 
		sign_btn = new JButton("Sign Up");
		sign_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signup s = new signup();
				s.setvisible();
			}
		});
		
		
		sign_btn.setBounds(80, 244, 117, 29);
		getContentPane().add(sign_btn);
		
		
	}
	
	public void setvisible() {
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		Bus B = new Bus();
		B.setvisible();
	}
	

	
	
	
	
	
}
