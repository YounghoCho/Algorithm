#include<stdio.h>

int main()
{
	int n, i,j,k;
	scanf("%d",&n);
 
	for(i=0;i<n;i++)
	{		
		for(j=0;j<=i;j++)
		{
			printf("# ");
		}
		printf("\n");	
	}
	for(i=0; i<n-1; i++)
	{
		//for(k=0;k<=i-n;k++)
		//	printf("  ");
		for(j=n-1; j>i; j--)
			printf("# ");	
		printf("\n");
    }
	return 0;
}
//This is not very long codes, but i spent a little bit more time than i expected.
//The most important point is seperating.
// in first ourter for, print from start to half
// in second for, printf rest
