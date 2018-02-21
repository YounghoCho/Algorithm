/* 매일프로그래밍

자연수로 이루어진 배열이 있다. 원소들을 나열해서 가장 큰 값이 되도록 배열을 정렬해라.
예1)1,9,80,4
결1)9,80,4,1 //98041
예2)50,5,530
결2)5,530,50 //553050
 */
import java.util.*;

public class Main {
	public static void main(String[] args) {
		int arr[]= {1,9,80,4};
		int arr2[]= {50,5,530};
		//정렬
		for(int i=0; i<arr.length-1; i++) {
			for(int j=0; j<arr.length-1-i; j++) {
				/*
				 * 이부분이 핵심인데, 바꿔야할 index나 값을 함수로 return해오는 경우
				 * return 값이 1개이므로 스왑이 어렵다.
				 * 그래서 "스왑을 해야되는지 여부"를 return으로 받아오면 되겠다.
				 */
				//가정, 만약에 j+1이 j보다 '먼저와야하는 숫자'라면
				if(func(arr[j+1], arr[j])==true) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
    //출력
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
  
  //'먼저와야하는 숫자' logic
	static boolean func(int a, int b) {
		int len1=0, len2=0;
		int x=a, y=b;
		boolean result=false;
	
    //자리수 구하기
		while(x>0) {len1++; x/=10;}
		while(y>0) {len2++; y/=10;}
		
    //case1: 자리수가 같고, a가 크다(먼저오는수)
		if(len1==len2 && a>=b) result= true;
		
    //case2: 자리수가 다르고, a가 먼저온다
		
    // #case2-1: b의 자리수가 클때
		if(len1<len2) {
			// #자리수를 맞춘다음
			x=a; y=b;
			while(len1<len2) {len2--; y/=10;}
			// #x=53, y=531로 10의자리가 같은경우, a가 짧니(먼저오는숫자)?
			if(x==y) result= true;
			// #x=54, y=530이면 a의 10의자리가 더 크니?
			else if(x>y) result= true;
		}
		
    // #case2-2: a의 자리수가 클때 
		if(len1>len2) {
			// #자리수를 맞춘다음
			x=a; y=b;
			while(len1>len2) {len1--; x/=10;}
			// #10의자리가 같은경우는 먼저오는 숫자가 아니므로 스왑하지않는다.
			// #10의자리가 큰 경우에는 먼저오는 숫자이다.
			if(x>y)
			result= true;
		}
		return result;
	}
}
