import java.util.*;

class BubbleSort{
	public static void main(String[] args){
		Scanner scan= new Scanner(System.in);
		int N;
		N= scan.nextInt();

		//array
		int arr[]=new int[N];
		
		//input
		for(int i=0; i<N; i++){
			arr[i]=scan.nextInt();
		}

		//bubble sort
		for(int i=0; i<N-1; i++){
			//int j=i, j<N-1
			for(int j=i; j<N-1;j++){
/*				for(int k=0; k<N; k++)
					System.out.print(arr[k]+" ");
				System.out.println();
*/	
				if(arr[i]>arr[j+1]){
					int temp=arr[j+1];
					arr[j+1]=arr[i];
					arr[i]=temp;
					}
			}
		}
		
		//print
		for(int i=0; i<N; i++){
//			System.out.println("----");
			System.out.println(arr[i]);
		}
	}
}