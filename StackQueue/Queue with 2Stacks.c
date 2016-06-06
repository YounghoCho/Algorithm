#include <stdio.h>
#include <stdlib.h> //malloc, free
//링크드 구현입니다. 명심하자 영호쓰!! 
typedef struct node{//typedef 빠지면 에러.
    int data;
    struct node *next;
}Node;
typedef struct queue{
    Node *stack1; // 스택은 Node형을 이용하고 
    Node *stack2; //큐를 투스택으로 구현 할 땐 포인터를 이용한다.
}Q;

void push(Node** top, int data);//스택관련 데이터형은 전부 Node 
int pop(Node** top); //pop은 int리턴 

void enQ(Q *q, int x)
{
    push(&q->stack1, x); //q의 주소를 보내는게 아니라, 1번 스택을 보낸다. 
}	//그냥 q->stack1을 보내면, 아래 push구현에서 포인터를 사용할수없어. 
void deQ(Q *q) //void형이 맞다. 리턴은 pop에서만 하면된다. 
{
    int x;
    if (q->stack2 == NULL) { //두개 스택이용 큐제거 
        while (q->stack1 != NULL) {
        x = pop(&q->stack1);
        push(&q->stack2, x);
        }
    }
    x = pop(&q->stack2); 
    printf("%d\n", x);
    //큐 재정렬을 해야 완벽한 Q가 유지된다. 
    while(q->stack2 != NULL){
    	x=pop(&q->stack2);
    	push(&q->stack1, x);
	} 
}
////////////push, pop이 가정되있다고 하면 여기까지랑 메인문만 구현하면됨/////

//push, pop은 연결리스트를 사용하여 구현 
void push(Node** top, int data)
{
    Node* newnode = (Node*) malloc(sizeof(Node));
    newnode->data = data;
    newnode->next = (*top); //노드 연결 
    (*top) = newnode;
}
int pop(Node** top)
{
    int buff;
    Node *t; //꼭 만들어야함. 
        t = *top; //노드복사 
        buff = t->data;
        *top = t->next; //top이 top--와 연결된다는 얘기. next가 그림에선 역방향임. 
        free(t);
        return buff;
}
void display(Node *top1,Node *top2)
{
    while (top1 != NULL) {
        printf("%d ", top1->data);
        top1 = top1->next;
    }
    while (top2 != NULL) {
        printf("%d ", top2->data);
        top2 = top2->next;
    }
   	printf("\n");
}
int main()
{
    Q *q = (Q*)malloc(sizeof(Q));
    int n = 0, data;
    q->stack1 = NULL; //q의 노드들 초기화가 빠지면 display시 무한루프를 돈다.
    q->stack2 = NULL;
    while (1) {
        printf("1:enQ 2:deQ 3:display 4:exit \n");
        scanf("%d", &n);
        switch(n) {
            case 1 : printf("input element\n");
                     scanf("%d", &data);
                     enQ(q, data);
                     break;
            case 2 : deQ(q);
                     break;
            case 3 : display(q->stack1, q->stack2);
                     break;
            case 4 : exit(1);
                     break;
            default : printf("invalid\n");
                      break;
        }
    }
   return 0;
}
