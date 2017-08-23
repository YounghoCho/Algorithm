import java.util.*;//added to use Arrays.sort();
				   //added to use Scanner();

class Searching
{	
	public void sequential(int arr[], int search){
		int value=0;
		int index=0;

		for(int i=0; i<arr.length; i++){
			if(arr[i]==search){
				value=arr[i];
				index=i;
				break;
			}
		}
		System.out.println("found out "+value+", at "+index);
	}
	//use this when you don't need to be change array set
	public void binary(int arr[], int search){
		boolean flag=false;
		int index=0;
		int left=0;
		int right=arr.length-1;
		int mid=0;
		int midValue=0;
		
		while(left<=right){ // '=' must exist. //If search is the final index, then result of recursion is left=left!  
			mid=(left+right)/2;
			midValue=arr[mid];

			//find out
			if(midValue==search){
				flag=true;
				index=mid;
				break;
			}
			//recursion
			if(search<midValue) right = mid-1;
			else left = mid+1;
		}
		//print
			if(flag==true)
					System.out.println("search is : "+midValue+"\nindex is :"+index);
			else
				System.out.println("can't find");
		}

		//use Binary search "Tree" when you need to change array set frequently
		//remember Left<Root<Right !

}
class Search 
{
	public static void main(String[] args) 
	{	
		////////input format//////////// 
		//don forget "import java.util.*"
		/*
		Scanner scan=new Scanner(System.in);
		
		String a= scan.nextLine();
		int b= scan.nextInt();
		double c= scan.nextDouble();
		System.out.println("문자열 : "+a+"\n숫자 : "+b+"\n실수 : "+c);
		*/
		/////////////////////////////////
		
		int arr[]={10,3,17,99,75,34,21,87};
		Arrays.sort(arr); //ascending sort

		Searching s= new Searching();
	//	s.sequential(arr,99);
	//	s.binary(arr, 99);

	}
}
