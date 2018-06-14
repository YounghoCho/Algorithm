/* 카카오 공채 3번, 캐시+LRU
캐시 크기(cacheSize)와 도시이름 배열(cities)을 입력받는다.
cacheSize는 정수이며, cities는 도시 이름으로 이뤄진 문자열 배열이다.
각 도시 이름은 공백, 숫자, 특수문자 등이 없는 영문자로 구성되며, 대소문자 구분을 하지 않는다. 
입력된 도시이름 배열을 순서대로 처리할 때, “총 실행시간”을 출력한다.

[조건]
캐시 교체 알고리즘은 LRU(Least Recently Used)를 사용한다.
cache hit일 경우 실행시간은 1이다.
cache miss일 경우 실행시간은 5이다.

=================================

//JAVA에서 문자열 비교하기(equals vs ==)//
String a = "a";
String b = "test";
String c = new String("test"); 인 경우

a,b는 call by value로 임의의 주소 500이 주어지며  같은 주소값을 가지고 a와 test가 할당된다.
c는 new연산자에 의해 call by reference로 생성되어 600이라는 다른 주소값을 가지고 test가 할당된다.

equals()같은 경우에는 test라는 값 자체로 비교하기 때문에 b.equals(c)를 하면 true를 반환한다.
반면, ==같은 경우에는 값 자체가 아닌 "주소값을 비교"하기 때문에 b==c를 하면 500==600으로 false를 반환한다. 
*/
import java.util.*;
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//String arr[] = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		//lru(3, arr);
		//String arr[] = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		//lru(3, arr);
		//String arr[] = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		//lru(2, arr);
		//String arr[] = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		//lru(5, arr);
		//String arr[] = {"Jeju", "Pangyo", "NewYork", "newyork"};
		//lower(arr);
		//lru(2, arr);
		String arr[] = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		lru(0, arr);
	}
	public static void lru(int size, String arr[])
	{
		int hit = 0;
		int max = 0;
		int flag = 0;
		String cache[] = new String[size];
		int rank[] = new int [size]; //우선순위
		int index=0; //우선순위 인덱스

		for(int i=0; i<arr.length; i++){
			//예외(캐시사이즈가 0인경우 페이지부재 반복)
			if(size==0){
				hit += 5;
				continue;
			}
			flag=0;
			//S:탐색
			for(int j=0; j<size; j++){
				//toLowerCase후 비교하는것과 eqaulsIgnoreCase()를 쓰는 방법이 있다.
				if(arr[i].equals(cache[j])){
					hit++;
					//갱신
					rank[j]=0;
					flag=1;
					break;
				}
			}
			//동일한 원소가 탐색된 경우 아래 과정은 생략한다.
			if(flag==1) continue;
			//E:탐색(탐색 결과 중복원소 없음)
			hit += 5;
			
			//차곡차곡 캐싱하기
			if(index<size){
				cache[index]=arr[i];
				rank[index]=0;
				//나머지 +1
				for(int u=0; u<size; u++){
					if(u==index) 
						continue;
					rank[u]++;
				}
				index++;
			}
			//LRU : 가장 오래된 원소를 스왑하기
			else{
				for(int u=0; u<size; u++){
					if(rank[u] >= rank[max])
						max = u;
				}
				//스왑
				cache[max]=arr[i];
				rank[max]=0;
				//나머지+
				for(int u=0; u<size; u++){
					if(u==max) 
						continue;
					rank[u]++;
				}
			}
			for(int p=0; p<size; p++)
				System.out.print(cache[p] + "/");
			System.out.println();
		}
		//출력
		System.out.println("실행시간 : " + hit);
	}
	static public void lower(String arr[]){
		for(int i=0; i<arr.length; i++){
			arr[i] = arr[i].toLowerCase();
		}
	} 
}
