import javax.swing.JFrame;
import javax.swing.JTextField;

public class book_confirm extends JFrame {
	private JTextField textField;
	public book_confirm() {
		setTitle("예메 정보 확인"); 
		setSize(500,300);
		getContentPane().setLayout(null);
		
		mainPage Date = new mainPage();
		
		
		
		textField = new JTextField();
		textField.setBounds(143, 94, 234, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField.setText(Date.getDate());
		
		
	}
	
	
	public void setVisible() {
		setVisible(true);
	}
}
