#include <stdio.h>
#include <stdlib.h> //malloc, free
struct node
{
    int data;
    struct node *next;
};
void push(struct node** top, int data);//스택관련 데이터형은 전부 struct node 
int pop(struct node** top); //pop은 int형 
struct queue
{
    struct node *stack1; // 큐 생서은, struct Node형을 이용하고 
    struct node *stack2; //포인터를 이용한다.
};
void enqueue(struct queue *q, int x) //struct Q를 참조하는 포인터가 필요
{
    push(&q->stack1, x); //q의 주소를 보내는게 아니라, 1번 스택을 보낸다. 
}
void dequeue(struct queue *q) //void형이 맞다. 실제적 pop은 스택에서 기능하기때문에 
{
    int x;
    if (q->stack2 == NULL) { //스택이용,ㅡ 큐 제거  
        while (q->stack1 != NULL) {
        x = pop(&q->stack1);
        push(&q->stack2, x);
        }
    }
    x = pop(&q->stack2); 
    printf("%d\n", x);
    //큐 재정렬 
    while(q->stack2 != NULL){
    	x=pop(&q->stack2);
    	push(&q->stack1, x);
	} 
}
////////////push, pop이 가정되있다고 하면 여기까지랑 메인문만 구현하면됨/////
void push(struct node** top, int data)
{
    struct node* newnode = (struct node*) malloc(sizeof(struct node));//newnode에 *붙이는거 까먹지마 
    newnode->data = data;
    newnode->next = (*top);
    (*top) = newnode;
}
int pop(struct node** top)
{
    int buff;
    struct node *t;
        t = *top;
        buff = t->data;
        *top = t->next;
        free(t);
        return buff;
}
void display(struct node *top1,struct node *top2)
{
	printf("---------------------\n"); 
    while (top1 != NULL) {
        printf("%d\n", top1->data);
        top1 = top1->next;
    }
    while (top2 != NULL) {
        printf("%d\n", top2->data);
        top2 = top2->next;
    }
   	printf("---------------------\n");
}
int main()
{
    struct queue *q = (struct queue*)malloc(sizeof(struct queue));
    int f = 0, a;
    char ch = 'y';
    q->stack1 = NULL;
    q->stack2 = NULL;
    while (ch == 'y'||ch == 'Y') {
        printf("enter ur choice\n1.add to queue\n2.remove from queue\n3.display\n4.exit\n");
        scanf("%d", &f);
        switch(f) {
            case 1 : printf("enter the element to be added to queue\n");
                     scanf("%d", &a);
                     enqueue(q, a);
                     break;
            case 2 : dequeue(q);
                     break;
            case 3 : display(q->stack1, q->stack2);
                     break;
            case 4 : exit(1);
                     break;
            default : printf("invalid\n");
                      break;
        }
    }
}
