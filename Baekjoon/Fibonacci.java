//재귀함수가 아닌 피보나치 수열
//피보나치 수열의 n자리 값을 구한다.
import java.util.*;

class Main 
{
	public static void fibo(int n){
		int f1=0;
		int f2=1;
		int sum=0;
		
		if(n==0) System.out.println("0");
		else if(n==1) System.out.println("1"); 
		else{
      //main idea
			for(int i=2; i<=n; i++){
			sum= f1+f2;
			f1=f2;
			f2=sum;
		}
		System.out.println(sum); 
		}
	}
	public static void main(String[] args) 
	{
		Scanner scan= new Scanner(System.in);
		int n= scan.nextInt();
		
		fibo(n);

	}
}
