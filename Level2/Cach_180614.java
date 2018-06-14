/* package whatever; // don't place package name! */

import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
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
		String arr[] = {"Jeju", "Pangyo", "NewYork", "newyork"};
		lower(arr);
		lru(2, arr);
		//String arr[] = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		//lru(0, arr);
	}
	public static void lru(int size, String arr[])
	{
		int hit = 0;
		int max = 0;
		int flag = 0;
		String cach[] = new String[size];
		int rank[] = new int [size];
		int index=0;
		for(int i=0; i<arr.length; i++){
			flag=0;
			//탐색
			System.out.println("찾으려는녀석 : "+arr[i]);
			for(int j=0; j<size; j++){
				System.out.println("비교하는녀석 : "+cach[j]);
				if(cach[j] == arr[i]){
					System.out.println("존재");
					hit++;
					//갱신
					rank[j]=0;
					flag=1;
					break;
				}
			}
			if(flag==1)
				continue;
			//탐색실패
			System.out.println("없음");
			hit += 5;

			//뒤에넣기
			if(index<size){
				System.out.println("뒤에넣기");
				cach[index]=arr[i];
				rank[index]=0;
				//나머지 +1
				for(int u=0; u<size; u++){
					if(u==index) 
						continue;
					rank[u]++;
				}
				index++;
			}
			//오래된 녀석 스왑하기
			else{
				System.out.println("스왑하기");				
				for(int u=0; u<size; u++){
					if(rank[u] >= rank[max])
						max = u;
				}
				//스왑
				cach[max]=arr[i];
				rank[max]=0;
				//나머지+
				for(int u=0; u<size; u++){
					if(u==max) 
						continue;
					rank[u]++;
				}
			}
			for(int p=0; p<size; p++)
				System.out.print(cach[p] + "/");
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
