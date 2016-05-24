#include "Graph.h"
///////////////과제_조영호////////////////// 
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
//꼭지점 추가
void AddVertex( Graph* G, Vertex* V){
	Vertex* VertexList= G->Vertices;
	if(VertexList==NULL)
		G->Vertices= V;
	else{
		while( VertexList->Next != NULL)
			VertexList= VertexList->Next;
		VertexList->Next=V;
	}
	V->Index= G->VertexCount++; } 
//모서리 추가
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
//그래프 소멸
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
		printf("%c : ", V->Data);
		if((E=V->AdjacencyList)==NULL){
			V=V->Next;
			printf("\n");
			continue;
		}
		while( E!=NULL){
			printf("%c[%d] ", E->Target->Data, E->Weight);
			E= E->Next;
		}
		printf("\n");
		V=V->Next;	}	
	printf("\n"); }
