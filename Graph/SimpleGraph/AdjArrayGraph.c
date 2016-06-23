#define size 10
typedef struct graph{
  int n;//정점 개수
  int mat[size][size];//인접행렬
}G;
void initG(G* g){
  g->n=0;
  int i,j;
  for(i=0; i<g->n; i++)
    for(j=0; j<g->n; j++)
      g->mat[i][j]=0;
}
void insert_Vertex(G* g){
  if((g->n)>size){
    printf("정점 개수 초과");
    return;
  }
  g->n++;//정점개수 증가가 삽입임.
}
void insert_Edge(G* g, int From, int Target){
  if(g->n>=From||g->n?=Target){
    printf("범위 초과");
    return;
  }
  g->mat[From][Target]=1;
  g->mat[Target][From]=1;
}
