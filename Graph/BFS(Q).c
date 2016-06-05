#include <stdio.h>
#define size 7
//인접행렬
int arr[size][size] ={
 0, 1, 1, 0, 0, 0, 0,
 0, 0, 0, 1, 1, 0, 0,
 0, 0, 0, 1, 0, 1, 0,
 0, 0, 0, 0, 1, 0, 1,
 0, 0, 0, 0, 0, 0, 1,
 0, 0, 0, 0, 0, 0, 1,
 0, 0, 0, 0, 0, 0, 0 };

//초기화
int i;
int visited[size] = { 0, };
int Q[size];
int front=-1, rear=-1;
 
void EnQ(int data)
{
 rear++;
 Q[rear] = data;
}

int isEmpty()
{
 if (rear == front)
  return 1;
 return 0;
}

int DeQ()
{
 if (isEmpty())
  return -1;
 else
 {
  front++;
  return Q[front];
 }
}

void bfs(int d)
{
 EnQ(d);
//방문하지 않은 정점이라면 출력하고, Visited을 1로 표시
 if (visited[d] == 0)
 {
  printf("%d ", d);
  visited[d] = 1;
 }
 while(!isEmpty())
 {
//Queue에 있는 한 정점을 Pop
  int t = DeQ();
  for (int i = 0; i < size; i++)
  {
//정점이고, 방문하지 않았을 경우 Queue에 Push하고, Visited을 1로 표시
   if (arr[t][i] == 1 && visited[i] == 0)
   {
    EnQ(i);
    printf("%d ",i);
	visited[i] = 1;
   }
  }
 }
}

int main()
{
 bfs(0);
 return 0;
}
