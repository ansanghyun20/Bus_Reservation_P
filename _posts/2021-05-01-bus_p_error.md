---
title: SQL UPDATE 오류
categories: [sql]
comments: true
---

SQL을 사용할 일이 있어서 Select 문에 사용하느 구문을 UPDATE에 적용하였더니 `DB load fail java.sql.SQLException: Can not issue data manipulation statements with executeQuery().`
와 같은 오류를 출력하였다.  

수정 전 UPDATE 코드는 다음과 같다. 
```java
tatement stmt = null;
ResultSet rs = null;

String query = "update RevList Set can='"+can+"' where time='"+time+"' 
and Start='"+locate[0]+"' and Des='"+locate[1]+"' and seat='"+seat+"'";
			
stmt = (Statement) con.createStatement();
rs = stmt.executeQuery(query);
```


수정 후 UPDATE 코드는 다음과 같다. 
```java

String query = "update RevList Set can='"+can+"' where time='"+time+"' 
and Start='"+locate[0]+"' and Des='"+locate[1]+"' and seat='"+seat+"'";
			
		
PreparedStatement pstmt = null;
pstmt = con.prepareStatement(query);



int r = pstmt.executeUpdate();
System.out.println("변경된 row : " + r);
```

UPDATE, DELETE, INSERT는 리턴 값이 없기 때문에 수정 전과 같이 쓰면 오류가 나는 것이었다.

