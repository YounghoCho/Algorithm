void topologicalSort(G* g){
  int i;
  GN* gn;
  Stack* s; //Not made yet

  int* in_degree= (int*)malloc(sizeof(int)* g->n);//노드 수 만큼 포인터배열을 만들어준다.
  
  //포인터 초기화
  for(i=0; i<g->n; i++)
    in_degree[i]=0;
  //각 정점의 진입차수 구하기
  for(i=0l i<g->n; i++){
    gn= g->Adj[i];
    while(gn != NULL){
      in_degree[gn->data]++;
      gn=gn->next;
    }
  }

init(&s); //스택초기화 함수 //Not made yet
  
//진입차수가 없는 정점을 기준으로 삼는다.
for(i=0; i<g->n; i++)
  if(in_degree==0)
    push(&s, i);//Not made yet

//스택이 빌때까지 제거작업
while(!is_empty(&s)){ //Not made yet
  int temp= pop(&s);
  printf("%d ", temp);
  gn= g->Adj[temp];//정점배열 Adj중 pop된 정점 temp를 gn이 가리키게 한다.
  while(gn!=NULL){
    in_degree[gn->data]--; //진입차수를 낮추는 것을 제거하는것으로 표시
    if(in_degree[g->data]==0)
      push(&s, g->data);
    gn=gn->next;
  }
 }
free(in_degree);
}
}
}
