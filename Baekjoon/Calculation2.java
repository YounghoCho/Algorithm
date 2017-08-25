//O는 문제를 맞은 것이고, X는 문제를 틀린 것이다. 
//문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다. 
//"OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
//OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.

//입력
//첫째 줄에 테스트 케이스의 개수가 주어진다. 
//각 테스트 케이스는 한 줄로 이루어져 있고, 길이가 0보다 크고 80보다 작은 문자열이 주어진다. 문자열은 O와 X만으로 이루어져 있다.

//예제 입력
//5
//OOXXOXXOOO
//OOXXOOXXOO
//OXOXOXOXOXOXOX
//OOOOOOOOOO
//OOOOXOOOOXOOOOX

//예제 출력
//10
//9
//7
//55
//30

import java.util.*;

public class Calculation2 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=Integer.parseInt(scan.nextLine());
		int sum=0;
		String s="";
		//This is the idea
		int bonus=0;

		for (int i=0; i<n ; i++){
			s=scan.nextLine();	
			for (int j=0; j<s.length(); j++){
				if(s.charAt(j)=='O'){
					sum+=(1+bonus);
					bonus++;
				}
				else{
					bonus=0;
				}
			}
			System.out.println(sum);
			sum=0;
			bonus=0;
		}

	}
}
