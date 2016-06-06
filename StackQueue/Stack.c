#include<stdio.h>
#include<stdlib.h>
typedef struct node{
	int data;
}Node;
typedef struct stack{
	int capa;
	int top;
	Node*nodes;
}Stack;
void create(Stack** stack, int capa){
	(*stack)= (Stack*)malloc(sizeof(Stack)); //스택의 구조체를 만든다.
	(*stack)->nodes= (Node*)malloc(sizeof(Node)*capa); //여기는 노드들을 만드는거라 (Node)를 써줘야해.
	(*stack)->top=0; //( ) 소괄호를안해주면 ->가 먼저 연산되기때문에 의미가 달라져!
	(*stack)->capa=capa;
}
void destroy(Stack* stack){
	free(stack->nodes);
	free(stack);
}
//2줄 
void push(Stack* stack, int data){
	int pos=stack->top++;
	stack->nodes[pos].data=data;
}
//2줄 
int pop(Stack* stack){
	int pos=--(stack->top);
	return stack->nodes[pos].data;
}
int main(){
	int i;
	Stack* stack=NULL;
	create(&stack,10);
	for(i=0; i<10; i++)
		push(stack,i+1);
	for(i=0; i<10; i++)
		printf("%d ",pop(stack));
	return 0;
}
