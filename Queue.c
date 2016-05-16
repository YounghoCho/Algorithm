#include<stdio.h>
#include<stdlib.h>

typedef struct node{
	int data;
}Node;
typedef struct Queue{
	int front;
	int rear;
	int capa;
	Node* nodes;
}Q;
void createQ(Q**q, int capa){
	(*q)= (Q*)malloc(sizeof(Q));
	(*q)->nodes= (Node*)malloc(sizeof(Node)*capa+1);
	(*q)->front=0;
	(*q)->rear=0;
	(*q)->capa=capa;
}
void destroy(Q* q){
	free(q->nodes);
	free(q);
}
//stack은 if문이 없고, front&rear대신 top하나로 연산한다. 
void enQ(Q* q, int data){
	int pos=q->rear;
	if(q->rear==q->capa)
		q->rear=0;
	else
		q->rear++;
	q->nodes[pos].data=data;
}
//return인것 빼면 enQ랑 같음. 
int deQ(Q* q){
	int pos=q->front;
	if(q->front==q->capa)
		q->front=0;
	else
		q->front++;
	return q->nodes[pos].data;
}
int main(){
	int i;
	Q* q=NULL;
	createQ(&q, 5);
	for(i=0; i<5; i++)
		enQ(q, i);
	for(i=0; i<5; i++)
		printf("%d ",deQ(q));
	return 0;
}

