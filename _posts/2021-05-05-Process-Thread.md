---
title: 프로세스와 스레드
categories: [c]
comments: true
---

# 프로세스

* getppid는 자신을 실행시킨 부모의 프로세스 ID를 나타낸다.
* getpid는 자신을 가리키는 프로세스의 일련의 번호를 나타낸다.
* 현재 sum은 전역변수로 선언 되어 있는 상태이다.
* 프로세스 안에서 자식의 프로세스들이 생성 되기 때문에 전역변수의 `데이터 영역`을 공유하지 않는다.
* 따라서 출력결과 또한 sum은 3개의 프로세스 다 1로 출력이된다.
* getppid는 부모의 프로세스를 가리키고 있기 때문에 항상 일정하며 getpid는 번호가 각각 다른것을 확인할 수 있다.

```c
#include <stdio.h>
#include <unistd.h>

int sum=0;

main(argc, argv)
int argc;
char *argv[];
{
int child1, child2, child3, pid, status, fork(), wait();
void exit();
if((child1 = fork()) == 0){
  printf("child: childid1=%d, ppid=%d\n",getpid(), getppid());
  sum++;
  printf("child1: <=============- sum=%d -=============>\n", sum);
  sleep(2);
  execl("/bin/date", "date", (char *)0);
  }

if((child2 = fork()) == 0){
  printf("child2: childid2=%d, ppid=%d\n",getpid(), getppid());
  sum++;
  printf("child2: <=============- sum=%d -=============>\n", sum);
  sleep(2);
  execl("/bin/ls", "ls","-a", (char *)0);
  }

if((child3 = fork()) == 0){
  printf("child3: childid3=%d, ppid=%d\n",getpid(), getppid());
  sum++;
  printf("child3: <=============- sum=%d -=============>\n", sum);
  sleep(2);
  execl("/bin/ls", "ls","-a", (char *)0);
  }

  sleep(2);

  printf("parent: waiting for children \n");
  while((pid = wait(&status)) != -1){
  if(child1 == pid)
    printf("parent: child1 is terminated \n");
  else if(child2 == pid)
    printf("parent: child2 is terminated \n");
  else if(child3 == pid)
    printf("parent: child3 is terminated \n");
  }

  printf("parent: all children terminated \n");
  printf("parent: <===============- sum=%d -================>\n", sum);
  exit(0);
}

```

# 스레드

* 스레드는 하나의 프로세스 단위에서 실행되는 흐름의 단위이다.
* 스레드 사용 갯수에 따라서 단일 스레드 , 멀티 스레드로 나뉘게 된다.
* 아래의 예제는 스레드를 생성하고 닫는 예제이다.
* pthread_create함수는 스레드를 생성하는 함수이다.
* pthread_create 인자
* `첫번째 인자로는 스레드가 생성 됐을 때 그 스레드를 식별하기 위해 사용되는 것이다. ` 
* `두번째 인자는 스레드의 특성을 저장하기 위해 사용하며 기본 특성은 NULL값이 들어간다.`
* `세번째 인자는 분기시켜서 실행할 스레드 함수이다.`
* `네번째 인자는 세번째 인자 함수의 매개변수로 넘겨진다.`
* 성공적으로 생성되면 0을 리턴하는 함수이다.
* pthread_join은 특정 쓰레드를 종료하기를 기다렸다가 스레드가 종료된 다음 진행하는 함수이다.    
* `첫번째 인자는 기다릴 스레드의 식별자를 나타낸다.`
* `두번째 인자는 스레드의 리턴값을 나타낸다.`

### 프로세스와 차이점

* 스레드는 프로세스의 내에서 동작하는 단위이기 때문에 전역변수의 데이터 
* 영역을 공유하고 있어 sum의 값이 계속 증가하는 양상을 볼 수 있다.

```c
#include <sys/types.h>
#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include <pthread.h>
#include <time.h>

void *exThreadFunc(void *no);
int sum=0;

int main(int argc, char *argv[]){
int result, number, i, rst;
pthread_t ex_thread[10];
  if(argc !=2){
  printf("usage: %s number\n", argv[0]);
  exit(0);
  }

number = atoi(argv[1]);
for(i=0; i<number; i++){
  result = pthread_create(&ex_thread[i], NULL, exThreadFunc, (void *)&i);
  printf("%d Thread ID at Main = %ud \n", i, (int)ex_thread[i]);
  if(result < 0){
    perror("thread create error : \n");
    continue;
   }
 sleep(1);
 }

for(i=0; i<number; i++)
  pthread_join(ex_thread[i], (void *)&rst);
}

void *exThreadFunc(void *no){
  int seq;
  pthread_t id;

  seq = *((int *)no);
  id = pthread_self();
  printf("%d Thread Id at exThreadFunc = %ud \n", seq, (int)id);
  srand(time(NULL));
  sleep(rand()%5);

  sum++;
  printf("%d <--------- Thread Ended with sum = %d ----------> \n", seq, sum);
}


```
