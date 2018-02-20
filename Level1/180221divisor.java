/*
입력받은 수의 약수, 개수 구하기
*/
import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int n= scan.nextInt();
		
		divid(n);
    scan.close();
	}
  
	static void divid(int n){
		//계산해봤는데, 50000까지 중 약수의 최대개수는 97개이다.
		int stack[]= new int[200];
		int top=0;
		int count=0;

    //logic
		for(int i=1; i<n; i++){
			if(n%i==0){
				count++;
				stack[top++]=i;
			}
		}
    
		//print
		System.out.print("약수 개수 : "+count+"\n약수 : ");
		for(int i=0; i<top; i++)
			System.out.print(stack[i]+" ");
		System.out.println();
	 }
}
