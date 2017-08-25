//최단거리검색
import java.util.*;

class Dijkstra
{
   static int inf=999;
   static int size=6;
   static int[] distance = new int[size];//기준점으로부터의 거리 저장
   static boolean[] visited = new boolean[size];//각 정점의 방문여부 기록
   static int[] preD = new int[size]; //이동경로 저장
   static int nextNode = 0;//가장 가까운 정점의 인덱스
   static int min=inf;
   public static void dijkstra(int matrix[][], int start, int end){
      //핵심! 거리값 초기화
      distance = matrix[0];
      //시작점의 거리는0
      distance[start]=0;
      //시작점의 방문 기록
      visited[start] =true;
      
      //algorithm1 (가까운점 찾기)
      for(int i=0; i<size; i++){
		  min=inf;//이 설정이 없으면 정점이 이동하지않는다★★★ //첫회전만 돌기때문에 다른접점은 비교할 수 없다.
		  for(int j=0; j<size; j++){
			 //조건1: 무한대인경우(두 정점간에 교류가 없는경우 패스)
			 //조건2: 방문하지 않은 정점인경우
			  if(min > distance[j] && visited[j]==false){
				  //포인트! 인접한 정점의 거리들을 min에 저장하면서 가장 가까운 정점을 찾는다
				  min = distance[j];
				  nextNode = j;//★이게 인덱스로 사용되
			  }
		  }
		  //가장 가까운 정점 방문 기록
		  visited[nextNode] = true;
		  
		  //algorithm2(시작점에서 기준점을 가까운점으로 이동하고 거리를 갱신한다)
		  for(int c= 0; c<size; ++c){
				  //위에서 min=distance[j];로 가장가까운 거리를 담았다
				  //조건3:시작점~새인접점의 거리>최소점의 거리+최소점~새인접점의 거리
				  //★여기서, 0과 이어지지 않은 E까지 연결되는거야. 
				  if(distance[c] > min+matrix[nextNode][c]){
					 //시작점~새인접점의 거리를 그대로 갱신해준다.
					  distance[c] = min + matrix[nextNode][c]; //★min을 사용
					  //갱신후 이동경로 저장
					  preD[c] = nextNode;
				  }
		  }
		  System.out.print(min+" ");
   }
      
      //최종 거리 출력
      for(int i=0; i<size; ++i)
         System.out.print("|" + distance[i]);
      System.out.println("|");
      
      //printing the paths!
      for(int i=0; i<size; ++i){
         int j;
         System.out.print("Path = " + i);
         j=i;
         do{
             j=preD[j];
             System.out.print("<-" + j);
         }while(j!=0);
         
         System.out.println();
      }
      //start에서 end까지의 거리
      System.out.print("시작점부터 끝점까지의 최단거리는 :");
      System.out.println(distance[end]);
   }
   
   public static void main(String[] args) {
      
      //visited, preD 초기화.
      for(int i=0; i<size; ++i){
      visited[i] = false;
      preD[i] = 0;
      }
      //각 정점간에 거리
      int matrix[][]={
          {  0,   4,   1,   2,   3, inf},
          {  4,   0, inf, inf, inf,   4},
          {  1, inf,   0,   2, inf, inf},
          {  2, inf,   2,   0, inf,   4},
          {  3, inf, inf, inf,   0,   4},
		  {inf,   4, inf,   4,   4,   0}
      };
      dijkstra(matrix,0,5);
   }
}

//매트릭스 그림 참고 : http://mrl.kr/dijkstra-algorithm/
