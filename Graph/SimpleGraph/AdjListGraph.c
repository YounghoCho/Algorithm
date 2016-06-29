#ifndef GRAPH_H
#define GRAPH_H

#define size 10
typedef struct node{
  int data;
  struct node* next;
}GN;
typedef struct graph{
  int n;
  GN* adj[size]; //노드형이 오고, 포인터배열을 생성한다.
}G;
void initG(G* g){
  g->n=0;
  int i;
  for(i=0; i<g->n; i++)
    g->adj[i]=NULL;//포인터 배열 초기화.
}
void insert_Vertex(G* g){ g->n++; }
void insert_Edge(G* g, int From, int Target){
  GN* gn;
  gn= (GN*)malloc(sizeof(GN));
  gn->data=Target; //Target을 data로 넣어준다.
  gn->next=g->adj[From]; //노드가 포인터배열을(정점배열) 가리키게하고
  g->adj[From]=gn;//정점 인덱스가 새로운 노드를 가리키게 한다. 여기에 노드들이 계속 이어지게하는 비밀이 있다.
}
int visited[size]={0,};

void DFS(G* g, int d){
  GN* gn= g->Adj[d]; //포인터행렬
  printf("%d ", d)//gn->data가 아님
  visited[d]=1;
  
  for(gn; gn; gn=gn->next)
    if(!visited[gn->data])
      DFS(g, gn->data);//재귀호출 이기때문에 printf를 또 해주지 않아도 됨.
}

#endif
