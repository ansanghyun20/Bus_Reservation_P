---
title: 넌블록킹 연결형 방식 통신
categories: [c]
comments: true
---

 비동기 소켓 통신에서 클라이언트가 접속 하였을 때 클라이언트의 IP의 출력을 정확하게 하는 방법을 기술함.
 
　       
* 연결된 클라이언트 각각에 IP주소를 출력하기위해 client_addr를 구조체 배열로 만들었다.            
* 각 배열안에 연결된 클라이언트 부분을 하나씩 증가시키며 집어 넣는다.           
* 클라이언트 연결 해제시 비워진 자리를 맨 마지막 구조체가 채운다.             





　       
　       
### 새로운 클라이언트를 처리하는 부분
##### 주석 확인
```c
//전역변수 m=4;

//새로운 클라이언트를 처리하는 부분
if(FD_ISSET(s, &read_fds)) {
  clilen = sizeof(client_addr[0]);
  client_fd = accept(s, (struct sockaddr *)&client_addr[m], &clilen);
  if(client_fd == -1){
    printf("accept error\n");
    exit(0);
  }
  client_s[num_client] = client_fd;
  printf("클라이언트 연결 접속(소켓번호=%d, ", client_s[num_client]);
  
  //새로연결된 IP의 주소는 가장 최신의 m에 업데이트됨.
  printf("IP 주소 = %S), ", inet_ntoa(client_addr[m].sin_addr));                
  num_client++;
  printf("m의 갯수 : %d ", m);
  printf("총 클라이언트 수 =%d\n", num_client);
  m++;
}
```
　       
　       
### 정보를 대기하는 부분
##### 주석 확인
```c
// 정보를 대기하는 부분
for(i=0; i<num_client; i++){
  if(FD_ISSET(client_s[i], &read_fds)) {
    if((n = recv(client_s[i], rline, MAXLINE, 0)) <= 0){
      removeClient(i);
      continue;
    }

    printf("aaaaaa: %d\n",s);
    rline[n] = '\0';
    send(client_s[i], respond, strlen(respond), 0);
    printf("정보분석 : %s from(소켓번호=%d, ", rline, client_s[i]);
                                
    //IP 주소를 출력할 때 해당하는 소켓번호(client_s[i])에 대한 구조체를 반환
    printf("IP 주소 = %s)\n", inet_ntoa(client_addr[client_s[i]].sin_addr));   
    }
}
```
　       
　       
### 클라이언트 신호를 닫는 부분
##### 주석 확인
```c
void removeClient(int i){
  close(client_s[i]);
  printf("클라이언트 연결 해제(소켓번호=%d, ", client_s[i]);
  printf("IP 주소 = %s), ", inet_ntoa(client_addr[client_s[i]].sin_addr));

  if(i != num_client-1){        
        /*
        ex)
        소켓 번호가 3~ 7에 있을때
        4번을 삭제하면 마지막 번호인 7번이 4번자리에 옴.
        */
    client_s[i] = client_s[num_client-1];  
    // 위와 마찬가지로 구조체의 실 해당하는 IP 주소가 지워지면 마지막 구조체로 매핑해버림
    client_addr[client_s[i]]= client_addr[m-1];  
        }
        num_client--;
        m--;
        printf("총 클라이언트 수 =%d\n", num_client);
}
```
