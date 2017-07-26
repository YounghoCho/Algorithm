#include<stdio.h>
#include<stdlib.h>

//리스트 기본 선언
typedef struct node{
	int data;
	struct node *next;
}N;

//리스트 노드 뒤집기
void reverse(N **head){
	N *cur, *pre, *temp; //연속선언 
	//초기화
	cur=*head;
	pre=NULL;
	
	if(cur){
		while(cur->next){
			//끊기
			temp=cur->next;
			cur->next=pre;
			//다음동작을 위한 세팅
			pre=cur;
			cur=temp;
		}
		//마지막작업
		cur->next=pre;
		*head=cur;
	}
}

int main(){
	N * head=NULL;
	reverse(&head);
}
