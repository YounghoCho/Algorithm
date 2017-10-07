/*
1.main
-이차행렬
-방문배열초기화
-다익스트라호출
2.Dijkstra
-거리배열초기화
-시작점설정
-인접점찾기
 1)for 
	-최소거리 inf초기화
	 2)for
		-방문하지않고, 최소거리min보다 현재거리가작으면
			-최소거리min과 최소거리인덱스next를 반복 갱신 => 최단 인접점찾기
		-최단 인접점을 방문표시
	 3)for
		-기존 점에서 목적지로 직접 가는것과, 최단거리+최단거리 정점에서 목적지를 비교
*/

import java.util.*;

class Main
{
	static int inf=999;
	static int size=6;
	static int distance[]=new int[size]; //출발점에서 각 정점까지의 최단거리를 나타냄
	static boolean visited[]=new boolean[size];
	static int min; //인접점의 거리값
	static int next; //인접점의 인덱스

	static void D(int matrix[][], int start, int end){
		distance=matrix[0];
		visited[start]=true;
		//경로1. 시작점
		//System.out.print(start+"->");
	
		for (int i=0; i<size; i++){
			min=inf; //왜?
			for (int j=0; j<size; j++){
				if(visited[j]==false&&min>distance[j]){
					min=distance[j];
					next=j;
				}
			}
			visited[next]=true;

			for (int c=0; c<size; c++){
				if(distance[c]>min+matrix[next][c]){
					distance[c]=min+matrix[next][c];
					//경로2, 끝점까지의 경로
					//System.out.print(next+"->");
				}
			}
		}
		//출발점에서 각 점까지의 최종 거리==distance[i]
		System.out.print("최단거리: " + distance[end]);
	}

	public static void main(String []args){
		int matrix[][]={
		  {  0,   4,   1,   2,   3, inf},
		  {  4,   0, inf, inf, inf,   4},
		  {  1, inf,   0,   2, inf, inf},
		  {  2, inf,   2,   0, inf,   4},
		  {  3, inf, inf, inf,   0,   4},
		  {inf,   4, inf,   4,   4,   0}
		};
		for(int i=0; i<size; i++){
			visited[i]=false;
		}
		D(matrix, 0 ,5);
	}
}
