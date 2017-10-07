import java.util.*;

class BinarySort
{
	static void binary(int target, int arr[], int l, int r){
			int mid;
		
      while(l<=r){ //mid>=0 is not
				mid=(l+r)/2; //mid position is here.
			
        if(target==arr[mid]){
					System.out.println(target+"은 "+mid+"번째에");
					break;
				}
				else{
					if(target<arr[mid])
						r=mid-1; //wow1
					else
						l=mid+1; //wow2
				}
			}
		}
	public static void main(String []args){
    //Before binarySearching, array must be ranged
		int arr[]={1,3,7,10,46,88,122,990,1111};
		binary(1111,arr,0,arr.length);
	}
}
