//문제
//N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.

//입력
//첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.

//출력
//입력으로 주어진 숫자 N개의 합을 출력한다.


//*여기서 매우 중요한것은, 바로 %10 /10 계산을 쓰면 안된다는것.
//*왜냐하면 N이 100인경우는 100자리 숫자라는 뜻인데, 정수형으로는 표현할 수가 없다.

import java.util.*;

class Loop1
{
		public static void main(String[] args) 
	{
		//중요! Scanner의 다른타입을 동시에 쓸때는 참조변수를 두개만들어줘야해
    //그러나 백준에서 런타임 에러가 발생하더라
			//Scanner scan1=new Scanner(System.in);
			//Scanner scan2=new Scanner(System.in);

		Scanner scan=new Scanner(System.in);
    
		//So, 형변환을 해주면 된다.
		int n = Integer.parseInt(scan.nextLine());
		String num = scan.nextLine();
		int sum=0;
		
		for(int i=0; i<n; i++){
			sum += num.charAt(i)-'0'; //(int)변환 없이도 문자를 숫자로변환 !
		}
		System.out.print(sum);

	}
}
