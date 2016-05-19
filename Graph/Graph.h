#ifndef GRAPH_H
#define GRAPH_H
#include<stdio.h>
#include<stdlib.h>

enum VisitMode { Visited, NotVisited };
typedef int ElementType;

//꼭지점 구조체
typedef struct tagVertex{ 
	ElementType Data;
	int Visited;
	int Index;
	struct tagVertex* Next;
	struct tagEdge* AdjacencyList;
} Vertex;
//모서리 구조체
typedef struct tagEdge{  
	int Weight;
	struct tagEdge* Next;
	Vertex*From;
	Vertex*Target;
}Edge; 
//그래프 구조체
typedef struct tagGraph{  
	int VertexCount;
	Vertex* Vertices;
}Graph;  
//Vertex, Edge, Graph 구조체를 만듬 

Graph* CreateGraph();
void DestroyGraph( Graph*G);

Vertex* CreateVertex(ElementType Data);
void DestroyVertex( Vertex* V);

Edge* CreateEdge( Vertex* From, Vertex* Target, int Weight);
void DestroyEdge(Edge*E);

void AddVertex( Graph*G, Vertex* V);
void AddEdge( Vertex*V, Edge*E);
void PrintGraph (Graph* G);

#endif //매크로함수종료 
