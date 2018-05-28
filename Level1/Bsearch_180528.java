package youngho;

public class Main{
	static int arr[] = new int[100];

	public static void binary(int target) {
		int start = 0;
		int last = arr.length;
		int mid;
		while(start <= last) {
      //mid를 while문 밖에서 할당하면 한번만 동작함.
			mid = (start + last) / 2;
			if(mid == target) {
				print(target);
				break;
			}else {
				 if(target < mid) {
						last = mid - 1;
					}else {
						start = mid + 1;
					}
			}
		}
	}
	public static void init_arr() {
		for(int i = 0; i < arr.length; i++)
			arr[i] = i++;
	}
	public static void print(int n) {
		System.out.println("Found Target : " + n);
	} 
	public static void main(String args[]) {
		init_arr();
		binary(50);
		binary(70);
	}

}
