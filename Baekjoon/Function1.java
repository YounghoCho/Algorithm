//문제
//양의 정수 n에 대해서 d(n)을 n과 n의 각 자리수를 더하는 함수라고 정의하자. 예를 들어, d(75) = 75+7+5 = 87이다.
//예를 들어, 33으로 시작한다면 다음 수는 33 + 3 + 3 = 39이고, 그 다음 수는 39 + 3 + 9 = 51, 다음 수는 51 + 5 + 1 = 57이다. 
//n을 d(n)의 생성자라고 한다. 위의 33은 39의 생성자이고, 39는 51의 생성자, 51은 57의 생성자이다. 
//생성자가 없는 숫자를 셀프 넘버라고 한다. 
//100보다 작은 셀프 넘버는 총 13개가 있다. 1, 3, 5, 7, 9, 20, 31, 42, 53, 64, 75, 86, 97

//10000보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 출력하는 프로그램을 작성하시오.

//fail...
import java.util.*;

class Main
{
	public static void main(String args[]){
		Scanner scan= new Scanner(System.in);
		int arr[]=new int[10037];

		for (int j=1; j<=10000; j++){
      //호출위치가 기가막히네
			arr[func(j)]=1;
			if(arr[j]!=1)
				System.out.println(j);
		}
	}
  //설계미쳤다
	static int func(int i){
		int res=i;
		if(i>=10000) {
			res+=i/10000;
			i%=10000;
		}
		if(i>=1000){
			res+=i/1000;
			i%=1000;
		}
		if(i>=100){
			res+=i/100;
			i%=100;
		}
		if(i>=10){
			res+=i/10;
			i%=10;
		}
		return res+=i;
	}
}
