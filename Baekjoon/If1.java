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
