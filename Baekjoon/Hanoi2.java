import java.util.*;

class Main
{
	static int count=0;
	
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		int n= scan.nextInt();
		Main m= new Main();
		
		m.hanoi(1,2,3, n);
		System.out.println(count);
	}
	public void hanoi(int first, int mid, int last, int n){
		Stack<Integer> s=new Stack<>();
		
		while(true){
			while(n>1){
				s.push(last);
				s.push(mid);
				s.push(first);
				s.push(n);
				n--;
				//중간과 끝의 교환
				s.push(last);
				last=mid;
				mid=s.pop();
			}

			move(first, last);
		
			if(!s.empty()){
				n=s.pop();
				first=s.pop();
				mid=s.pop();
				last=s.pop();

				move(first,last);

				n--;
				//처음과 중간의 교환
				s.push(first);
				first=mid;
				mid=s.pop();
			}else{
				break;
			}
		}
	}
	static void move(int from, int to){
		count++;
		System.out.println(from+" "+to);
	}
}
