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
//방문 배열 생성
int visited[size]={0,};

void DFS(G* g, int data){
  printf("%d ", data);
  visited[data]=1;
  int i;
  //DFS는 반복문이 1개면 된다.
  for(i=0; i<g->n; i++)
    if(!visited[i] && g->mat[data][i]==1)
      DFS(g, i);//재귀호출이므로 BFS처럼 printf를 또 해주지 않아도 된다.
}
//큐생성
int Q[size];
int rear=0, front=0;
void EnQ(int data){
  Q[rear++]=data;
}
int EdQ(){
  return Q[front++]; 
}

void BFS(G* g, int data){
	printf("%d ", data);
	visited[data]=1;
	EnQ(data);
	int i;
	while(!is_empty){
		int temp=DeQ();
		for(i=0; i<g->n; i++){
			if(!visited[i]&&g->mat[temp][i]==1){
				printf("%d ", i);
				visited[i]=1;
				EnQ(i);				
			}
		}
	}
}

#endif
