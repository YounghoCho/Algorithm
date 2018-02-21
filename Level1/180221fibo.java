/*
정수 n을 입력받고, 
1)피보나치 수열의 n번째 원소를 출력하시오.
2)n번째까지의 피보나치 합을 구하시오.
3)n번째까지의 피노나치 수열을 재귀함수를 쓰지않고 구현하시오
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int n= scan.nextInt();
		scan.close();
		
		System.out.println("n번째 원소:"+Fibo(n));
		System.out.println("n번째 합:"+Fibo_sum(n));
		Fibo_array(n);	
	}
	static int Fibo(int n) {
		if(n==1) return 1;
		if(n==2) return 1;
		else{
			return Fibo(n-1)+Fibo(n-2);
		}
	}
	static int Fibo_sum(int n) {
		int sum=0;
		for(int i=1; i<=n; i++)
			sum+=Fibo(i);
		return sum;
	}	
	static void Fibo_array(int n) {
		int arr[]=new int[n];
		int pre=1, ppre=1;
		arr[0]=1;
		arr[1]=1;
		for(int i=2; i<n; i++) {
			arr[i]=arr[i-1]+arr[i-2];
		}
		for(int i=0; i<n; i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
}
