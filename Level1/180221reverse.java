/*
입력받은 정수의 순서를 반대로 바꾼 수를 구하시오
ex1) 1024-> 4201
ex2) 420 -> 24

입력받은 문자열을 반대로 출력하시오.
ex) youngho -> ohgnuoy
*/

import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		//int n= scan.nextInt();
		/*
		nextInt()는 마지막 개행문자 전까지를 숫자로 인식합니다.
		그래서 nextInt()후 그냥 str= scan.nextLine을 하게되면 입력받을 수 없습니다.
		대안1, scan.nextLine();을 중간에 한번 더 선언해줍니다.
		이보다 더 좋은 방법은 Integer.parseInt 입니다.
		*/
		int n= Integer.parseInt(scan.nextLine());
		String str= scan.nextLine();
		scan.close();
		
		reverse_num(n);
		reverse_str(str);
	}
  
	static void reverse_num(int n){
		int result=0;
		while(n>0){			
			result+=n%10;
			n/=10;
			//마지막 반복에서 n==0일때도 result*=10을 하게되면 4201이 아닌 42010이된다. 
			if(n>0)
				result*=10; //n==420이면 첫 반복에서 0*10이 되므로, 따로 신경쓸필요없다. 		
		}
		System.out.println("result_num:"+result);
	}
  
	static void reverse_str(String str){
		int len= str.length();
		String result="";
		for(int i=0; i<len; i++){
			result+= str.charAt(len-1-i);			
		}
		System.out.println("result_str:"+result);
	}
}
