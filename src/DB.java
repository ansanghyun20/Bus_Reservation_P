import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	
	private int count= 0;
	
	public DB(int i) {
		
		
		/*
			i = 1 -------> 회원 가입 정보 보내기
			i = 2 -------> 아이디 중복확인 
			i = 3 -------> 아이디 로그인 검증 
		*/
		Connection con =null;
		
		
		String url = "jdbc:mysql://localhost:3306/Information";
		String user = "sang";
		String pw = "1234";
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("after forName");
			con = DriverManager.getConnection(url, user, pw);
			System.out.println("DBms connection success");
			System.out.println("DB load success");
			
			
			// ---------------------------------------------
			
			if(i == 1) {        // 회원가입 정보 보내기 
				send(con);
			}
			else if(i == 2) {
				avoidDuplication(con);
			}
			else if(i == 3) {
				login(con);
			}
			
			// ---------------------------------------------
			
			
		} catch (Exception e) {
			System.out.println("DB load fail " + e.toString());
		}
	}
	
	
	
	// 회원가입 정보를 db로 전송하는 함수 
	
	public void send(Connection con) throws SQLException {
		String SQL = "insert into member(id, pw, name, birthday, phone, email) values(?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null; 
		pstmt = con.prepareStatement(SQL);
		
		
		signup s_infor = new signup();
		if(s_infor.id != null) {
		
			pstmt.setString(1, s_infor.id);
			pstmt.setString(2, s_infor.pw);
			pstmt.setString(3, s_infor.name);
			pstmt.setString(4, s_infor.birthday);
			pstmt.setString(5, s_infor.phone);
			pstmt.setString(6, s_infor.email);
			int r = pstmt.executeUpdate(); 
			System.out.println("변경된 row : " + r); 
		}
		
		else {
			System.out.println("전송할 수 없습니다.");
		}
		
		
	}
	
	
	
	// 회원가입시 아이디 중복을 피하게 해주는 함수 
	public void avoidDuplication(Connection con) throws SQLException {
		Statement stmt = null;
        ResultSet rs = null;
		
		signup s = new signup();
		String query = "select * from member where id = '"+ s.id + "'";
		
		
		stmt = (Statement)con.createStatement();
        rs = stmt.executeQuery(query);
        
		
		String compare2 = s.id;
		while(rs.next()) {
			String compare1 = rs.getString("id");
        	if(compare1.equals(compare2)) {  // signup 탭의 아이디와 db의 아이디 중복 확
        		
        		System.out.println("중복된 아이디가 존재합니다.");
        		s.isCreateID = false;
        		count ++;					//count를 올려서 아이디 생성할 수 있는 것을 방지 
        	}
        }
        
		if(count <1) { 						//count가 조건에 만족할 때 아이디를 생성할 수 있다.
			System.out.println("아이디를 생성할 수 있습니다.");
			s.isCreateID = true;
		}
		
	}
	
	
	
	
	// 로그인시 아이디와 비밀번호를 확인해 주는 함수 
	public void login(Connection con) throws SQLException {
		Statement stmt = null;
        ResultSet rs = null;
        
        Bus B = new Bus();
        String query = "select * from member where id = '"+ B.id + "'";
        
        stmt = (Statement)con.createStatement();
        rs = stmt.executeQuery(query);
        
        String s_pw = B.pw;
    
        while(rs.next()) {         
        	if(rs.getString(1)==null) {             // DB에 ID 가 존재하는지 검사한다 아이디가 없을시 처리  
        		B.isFinded = false;
        	}else {									// DB에 ID 가 존재한다. 
        		B.isFinded = true;		
        		System.out.println("------id------");
        		System.out.println(rs.getString(1));
        	
        		
        		String rs_pw = rs.getString(2);
        		if(rs_pw.equals(s_pw)) {			//DB 속에 존재하는 id에서  작성된 pW와 일치하는지 검사한다.
        			B.ispwFinded = true;
        			System.out.println("------pw------");
            		System.out.println(rs.getString(2));
        		}else {
        			B.ispwFinded = false;
            		
        		}
        		
        	
         }
        }
        
        
        
        
	}
	
	
	
	
}
