#include<stdio.h>

int main(){
 int n,j;
 printf("input : ");
 scanf("%d",&n);
 for(j=2; j<= n/2; j++) //good idea
	 if(n%j==0)
	 {
	  	printf("not prime");
		return 0; 
	 }
 printf("Prim number : %d", n);
 	 
 return 0;
}
