class Arr
{
	int arr[]={100,3,17,1,46,88,12,99};

	public void fprint(int arr[]){
		int i;
		for (i=0; i<arr.length; i++ )
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	public void bubble(int arr[]){
		int temp;
		for (int i=0; i<arr.length-1; i++ )
		{
			for(int j=0; j<arr.length-i-1; j++){ //Point is '-i-1'
				if(arr[j]>arr[j+1]){
					temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
				}
			}
		}
		fprint(arr);
	}

	public void select(int arr[]){
		int min,temp;
		for (int i=0; i<arr.length-1; i++){ //No change
			min=i; //min=arr[i] is NOT //must know index
			for (int j=i+1; j<arr.length; j++){ //'+i+1' is added to 'j' //so '+i+i' is subtrated from 'arr.length-i-1' 
				if(arr[min]>arr[j]){ //The key of selection is Index
					min=j;
				}
			}
			temp=arr[min];
			arr[min]=arr[i];
			arr[i]=temp;
		}
		fprint(arr);
	}

	public void insert(int arr[]){
		int i,j,temp=0;
		for(i=1; i<arr.length; i++){ //set standard 'i=1' and go repeat process of 'j--' 
			temp=arr[i];
			for(j=i-1; j>=0 && arr[j]>temp; j--){	//can't depart '&&' as 'if(arr[j]>temp)' //they are different //cause j keep being decrised
					arr[j+1]=arr[j];
			}			
			arr[j+1]=temp;//watch out 'j+1' as 'j--' caused from 'for()' 
		}
		fprint(arr);
	}

}
class Sort
{
	public static void main(String[] args) 
	{
		Arr t1=new Arr();
		Arr t2=new Arr();
		Arr t3=new Arr();
		Arr t4=new Arr();

		System.out.println("---Original array---");
		t1.fprint(t1.arr);
		System.out.println("---Bubble sort---");
		t1.bubble(t1.arr);
		System.out.println("---Selection sort---");
		t2.select(t2.arr);
		System.out.println("---Insertion sort---");
		t3.insert(t3.arr);

	}
}
