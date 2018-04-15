public class Test {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int N = 2000;
		int arr[] = new int[N];
		for(int i = 2; i<N; i++){
			arr[i] = i;	//0과 1은 0으로 셋팅하고 시작한다. 1은 소수가 아니다.
		}
		//getDecimal(arr, N);
		eratosTenesChe(arr, N);

		long end = System.currentTimeMillis();
		 System.out.println("\n실행시간:" + (end-start));	
	}

  //일반적인 방법(7초 소요)
	static void getDecimal(int arr[], int N){
		for(int i = 2; i < N; i++){
			for(int j = 2; j < Math.sqrt(arr[i]); j++){ //최적화1
				if(arr[i] % j == 0) {
					arr[i] = 0;
					break;	//최적화2					
				}
			}
		}
		print(arr, N);
	}
	
  //에라토스테스체 4초
	static void eratosTenesChe(int arr[], int N){
		for(int i = 2; i < Math.sqrt(N); i++){  // Logic 3 : 2로 나누는 것 보다 루트를 씌우는게 수학적으로 정확함. 일반적 방식과는 다르게, 여기에 sqrt를 적용한다.
			if(arr[i] == 0) { 	// Logic 2 : 이미 색칠된 녀석은 거른다.
				continue;
			}
			for(int j = i + i; j < N; j += i){ // Logic 1 : 첫번째로 오는 인자는 소수이다(i + 1), 인자의 배수들을 소수(0)로 색칠한다(j+=i)
				arr[j] = 0;
			}
		}
		print(arr, N);
	}

	static void print(int arr[], int N) {
		for(int i = 1 ; i < N; i++){
			if(arr[i] != 0) {
				System.out.print(arr[i] + " ");
			}
		}
	}
//End CLass
}
