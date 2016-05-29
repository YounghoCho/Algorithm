#ifndef GRAPH_H //여기서만 _h를 쓰고 .c에서는 .h로 사용한다. 
#define GRAPH_H
#include<stdio.h>
#include<stdlib.h>

enum VisitMode { Visited, NotVisited };
typedef int ElementType;

//꼭지점 구조체
typedef struct tagVertex{ //typedef가 빠지면 안되지
	ElementType Data;
	int Visited;
	int Index;
	struct tagVertex* Next; //구조체 안에는 struct타입을 써줘야해.
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

//어떤 인자들을 넘기는지 잘봐
Graph* CreateGraph();
void DestroyGraph( Graph*G);

Vertex* CreateVertex(ElementType Data);
void DestroyVertex( Vertex* V);

Edge* CreateEdge( Vertex* From, Vertex* Target, int Weight); //중요
void DestroyEdge(Edge*E);

void AddVertex( Graph*G, Vertex* V);//그래프에 점을 잇는다.
void AddEdge( Vertex*V, Edge*E);//점에 모서리를 잇는다.
void PrintGraph (Graph* G);

#endif //매크로함수종료 
