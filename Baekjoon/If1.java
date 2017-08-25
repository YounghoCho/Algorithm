//문제
//세 정수 A, B, C가 주어진다. 이 때, 두 번째로 큰 정수를 출력하는 프로그램을 작성하시오. 

//입력
//첫째 줄에 세 정수 A, B, C가 공백으로 구분되어 주어진다. (1 ≤ A, B, C ≤ 100)

//출력
//두 번째로 큰 정수를 출력한다.
	
import java.util.*;

class Main
{
	public static void main(String args[]){
		Scanner scan= new Scanner(System.in);
		int a=scan.nextInt();
		int b=scan.nextInt();
		int c=scan.nextInt();
		
		int mid;
    
    //idea is here
		if(a>b){
			if(a>c){
				if(c>b)
					mid=c;
				else
					mid=b;
			}
			else
				mid=a;
		}
		else{
			if(b>c){
				if(a>c)
					mid=a;
				else
					mid=c;
			}
			else
				mid=b;
		}
		System.out.print(mid);
			
	}
}
