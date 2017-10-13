//분할과 합병 두가지로 나뉜다.

import java.util.*;

class Main{

	public static void main(String args[]){
		int arr[]={10,2,4,12, 7,6,5,11};

		System.out.println("original");
		print(arr);

		merge_sort(arr);
	}

	static void merge_sort(int arr[]){
		int n= arr.length;
//		int temp1[]=new int[n];
//		int temp2[]=new int[n];
		int temp1[]=new int[n/2];
		int temp2[]=new int[n-n/2];
		
		if(n==1) return;

		for(int i=0; i<n/2; i++)
			temp1[i]=arr[i];
//		for(int i=n/2; i<n; i++)
		for(int i=0; i<n-n/2; i++)
			temp2[i]=arr[n/2+i];

		merge_sort(temp1);
		merge_sort(temp2);

		merge(temp1, temp2, arr);		
	}

	static void merge(int temp1[], int temp2[], int arr[]){

		int a=0,b=0,c=0;
		while(a<temp1.length){
			if(b<temp2.length){
				if(temp1[a]<temp2[b]){
					arr[c]=temp1[a];
					a++;
				}else{
					arr[c]=temp2[b];
					b++;
				}
				c++;
			}else{
				arr[c]=temp1[a];
				a++;
				c++;
			}
		}
		while(b<temp2.length){
			arr[c]=temp2[b];
			b++;
			c++;
		}
		System.out.println("merge");
		print(arr);
	}
	
	static void print(int arr[]){
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
}
