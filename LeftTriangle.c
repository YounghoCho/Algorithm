#include<stdio.h>

int main()
{
 int i,j;
 int n;
 scanf("%d",&n);
 
 for(i=0; i<n;i++)
 {
  for(j=0;j<=i;j++)
  	printf("*");
  printf("\n");
 }
 for(i=0; i<n-1; i++)
 {
 	for(j=n-1; j>i; j--)
 		printf("*");
 	printf("\n");
 }
 return 0;
}
