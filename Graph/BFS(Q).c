#include <stdio.h>
#define size 7
//인접행렬
int arr[size][size] ={
 0, 1, 0, 0, 0, 0, 1,
 0, 0, 1, 0, 1, 0, 0,
 0, 0, 0, 1, 0, 0, 0,
 0, 0, 0, 0, 0, 0, 0,
 0, 0, 1, 1, 0, 0, 0,
 0, 0, 0, 1, 0, 0, 0,
 0, 0, 0, 0, 0, 1, 0 };
 
int i;
int visited[size]={0,};
//초간단 Q만들기 
int Q[size];
int rear=0, front=0;
void EnQ(int d){
	Q[rear++]=d;
}
int DeQ(){
	return Q[front++];	
}
//bFS탐색 
void BFS(int d){ //DFS는 Vertex를 인자로 넘겼지만, 여기서는 배열로 짰으니 int가 넘어온다.
	EnQ(d);	//시작점 넣으면서 
	printf("%d ",d); //동시에 찍고
	visited[d]=1; //방문
	while(rear!=front){	//Q가 비워질 때 까지!! 중요조건.
		int temp=DeQ(); //한점 빼고 !
		for(i=0; i<size; i++){ //인접한 점들을 넣으면서 
			if(arr[temp][i]==1 && visited[i]==0){ //행은 고정된다[temp]-> DeQ될때 temp가 이동하는 원리!
				EnQ(i);
				printf("%d ",i); //동시에 찍는다. 
				visited[i]=1;
			}
		}
	}
}
int main(){
	BFS(0);
	return 0;
}
