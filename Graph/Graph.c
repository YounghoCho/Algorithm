#include "Graph.h"
//그래프 생성
Graph* CreateGraph(){ 
	Graph* graph=(Graph*)malloc(sizeof(Graph));
	graph->Vertices= NULL;
	graph->VertexCount= 0;
	return graph; }
//꼭지점 생성
Vertex* CreateVertex(ElementType Data){
	Vertex* V= (Vertex*)malloc(sizeof(Vertex));
	V->Data= Data;
	V->Visited= NotVisited;
	V->Index= -1;
	V->Next= NULL;
	V->AdjacencyList= NULL;
	return V; }
//모서리 생성
Edge* CreateEdge( Vertex*From, Vertex*Target, int Weight){
	Edge* E = (Edge*)malloc(sizeof(Edge));
	E->Weight= Weight;
	E->Next= NULL;
	E->From= From;
	E->Target= Target;
	return E; }
//////////////////////////////////////////////////////////
//꼭지점 추가 -> 꼭지점들을 linked list로 이어 배열을 만든다.
void AddVertex( Graph* G, Vertex* V){
	Vertex* VertexList= G->Vertices;
	if(VertexList==NULL)
		G->Vertices= V; //VertexList에 붙이면 안되지 !
	else{
		while( VertexList->Next != NULL)
			VertexList= VertexList->Next;
		VertexList->Next=V;
	}
	V->Index= G->VertexCount++; } 
//모서리 추가 -> 각 꼭지점마다 Adj포인터를 사용해 모서리 배열을 만든다. E1, E2, E3..
void AddEdge( Vertex* V, Edge* E){
	if( V->AdjacencyList==NULL)
		V->AdjacencyList=E;
	else{
		Edge* AdjacencyList= V->AdjacencyList;
		while(AdjacencyList->Next != NULL)
			AdjacencyList= AdjacencyList->Next;
		AdjacencyList->Next=E;
	} } 
//////////////////////////////////////////////////////////
//그래프 소멸 : call그래프소멸-> call 꼭짓점소멸-> call모서리 소멸.. 그래프 삭제만 콜해주면, 알아서 모서리 꼭짓점, 그래프 순으로 제거.
 void DestroyGraph(Graph*G){
	while(G->Vertices != NULL)
	{
		Vertex* Vertices = G->Vertices->Next;
		DestroyVertex(G->Vertices);
		G->Vertices = Vertices;
	} 
	free(G); }
//꼭지점 소멸
void DestroyVertex(Vertex* V){
	while(V->AdjacencyList != NULL)
	{
		Edge* Edge= V->AdjacencyList->Next;
		DestroyEdge( V->AdjacencyList);
		V->AdjacencyList= Edge;
	}
	free(V); }
//모서리 소멸
void DestroyEdge(Edge* E){
	free(E); } 
//그래프 출력 
void PrintGraph(Graph* G){
	Vertex* V=NULL;
	Edge* E=NULL;
	if((V=G->Vertices)==NULL)
		return;
	while( V!=NULL){
		printf("%c : ", V->Data); //main문에서 '1'이런식으로 문자를 넣었기 떄문에 %c를 사용.
		if((E=V->AdjacencyList)==NULL){
			V=V->Next;
			printf("\n");
			continue;	//없으면 아래 while문 그냥 읽혀버린다.
		}
		while( E!=NULL){
			printf("%c[%d] ", E->Target->Data, E->Weight); //Target에서 끝나면 안되고, Data도 찍어야함.
			E= E->Next; //이동!
		}
		printf("\n");
		V=V->Next;	//이동!}	
	printf("\n"); }
}
