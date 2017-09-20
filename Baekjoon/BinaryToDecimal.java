import java.util.*;

//Kakao
//문제 : 첫비트로 양,음수를 구분하는 이진수를 10진수로 변환하기

class BinaryToDecimal
{
	public static void main (String[] args) throws java.lang.Exception
	{
		String bi="11110111"; //-9
		int arr[]=new int[bi.length()];//문자열 길이는 length();
		//int 1comple[]=new int[8]; //변수는 숫자로 시작하지 않는다. 
		int comple1[]=new int[bi.length()];
		int comple2[]=new int[bi.length()];
		
		//String -> int
		for(int i=0; i<bi.length(); i++){
		//	arr[bi.length()-i-1]=Integer.parseInt(bi.charAt(i)); //parse는 문자가 아닌 문자열에 사용한다.
		arr[i]=bi.charAt(i)-'0'; //charAt(0)은 문자열 맨뒤가 아닌 맨앞이다.
			
		}
		//출력
		System.out.println("문자열");
		print(bi, arr);//배열은 이름만 전달
		
		//+,- 판별
		if(arr[0]==0){
			//양수
			//2진수->10진수
			System.out.println("10진수");
			System.out.println("+"+toDecimal(arr));

		}else{
			//음수
			//1의 보수
			for(int i=0; i<arr.length; i++){
				if(arr[i]==1)comple1[i]=0;
				else comple1[i]=1;
			}
			//출력
			System.out.println("1의보수");
			print(bi, comple1);
			//2의 보수
			int carry=1;//일단 마지막자리에 1을 더한다.
			for(int i=comple1.length-1; i>=0; i--){
				//각 자리마다 올림수를 포함해서 복사해준다.
				comple2[i]=comple1[i]+carry;
				//만약에 올림이 발생하면
				if(comple2[i]==2){ 
					//해당 자리를 0으로 바꾸고 올림수를 1로
					comple2[i]=0;
					carry=1;
				}
				//올림이 발생하지 않으면 올림수를 0으로
				else
					carry=0;
			}
			System.out.println("2의보수");
			print(bi, comple2);

			System.out.println("10진수");
			System.out.println("-"+toDecimal(comple2));
		}
	}
  
	public static void print(String bi, int comple1[]){
		for(int i=0; i<bi.length(); i++)
		System.out.print(comple1[i]+" ");
		System.out.println();
	}
  
	public static int toDecimal(int arr[]){
		int sum=0;
		int two=1;
		for(int i=arr.length-1; i>=0; i--){
			sum+=arr[i]*two;
			two*=2;
		}
		return sum;
	}
}
