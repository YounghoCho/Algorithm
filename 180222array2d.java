/*
아래 두 배열을 곱한 결과를 출력하시오
a[2][3] = { { 4.2,4.3,3.8 },{ 3.7,1.5,0.7 } };
b[3][2] = { { 5.2,2.1 },{ 3.2,1.4 },{ 1.5,3.6 } };
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		//배열 선언
		int a[][] = { { 2, 3, 4}, { 2, 3 ,4 } };
		int b[][] = { { 2, 3 }, { 2, 3 }, { 2, 3 } };
		int result[][]= new int[2][2];
		int sum;

//2중 for문인줄 알았다. 역시 화이트보드설계가 중요.
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				sum=0;
				for(int k=0; k<3; k++) {
					sum+=a[i][k]*b[k][j];
				}
				result[i][j]=sum;
			}
		}
		//출력
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++)
				System.out.print(result[i][j]+ " ");
			System.out.println();
		}
	}
}
