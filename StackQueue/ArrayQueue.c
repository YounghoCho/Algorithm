#include<stdio.h>
#define size 10

int Q[size];
int rear=0, front=0;

void EnQ(int data){
  Q[rear++]=data;
}
int DeQ(){
  return Q[front++];
}
int main(){
  EnQ(1);
  EnQ(2);
  //printf("%d %d",DeQ(), DeQ()); 이렇게하면 스택처럼 뒤에서부터 찍힘!!! 심각한 문제
  printf("%d ", DeQ());
  printf("%d ", DeQ());
  return 0;
}
