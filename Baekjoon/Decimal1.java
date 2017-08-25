//문제
//M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

//입력
//첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1≤M≤N≤1,000,000)

//일반 소수를 구하는 방식과는 다르다
//eratosthenes(에라토스네스)의 소수 공식을 알아야한다.
//왜냐하면 중첩for문을 아무리 간소화시켜도 구하는 수가 너무 크면 오래걸리기 때문
//에라토스네스 소수 공식은 : 2부터 시작해서 범위내의 모든 배수를 지우고 최종 남는 것들이 소수가 된다는 원리
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int m=scan.nextInt();
    
		int arr[]=new int[m+1];//m+1
		for (int i=0; i<m; i++)
			arr[i]=0;
    //except for 0 & 1
    arr[0]=1;
		arr[1]=1;
    //eratosthenes
		for (int i=2; i<=m/2+1; i++) //saving idea : m/2+1
			for (int j=2; i*j<=m; j++) //main idea : i*j<=m
					arr[i*j]=1;
		
		for (int i=n; i<=m; i++) //not from 0 to m
			if(arr[i]==0)
				System.out.println(i);
		scan.close(); //close Scanner stream input
	}
}
