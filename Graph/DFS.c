#include "Graph.h"
void DFS(Vertex* V){
	Edge* E= V->Adj; //모서리 선언
	printf("%d ",V->Data); //첫번째 정점 출력, Visited
	V->Visited= Visited; 
	
	while(E != NULL) //모서리가 없을때까지 
	{
		if(E->Target != NULL && E->Target->Visited==NotVisited) // //모서리의 Target이있고 방문하지 않았으면
			DFS(E->Target); //꼭짓점 계속 이동 
		E=E->Next; //다른 모서리로 이동. 
	}
}
