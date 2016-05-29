#include<stdio.h>

int main()
{
	int i;
	for(i=1; i<=7; i++)
	{
		if(i==1)
			printf("       *\r*\n");
		else if(i==2)
			printf("      **\r**\n");
		else if(i==3)
			printf("     ***\r***\n");
		else if(i==4)
			printf("    ****\r****\n");
		else if(i==5)
			printf("     ***\r***\n");
		else if(i==6)
			printf("      **\r**\n");
		else if(i==7)
			printf("       *\r*\n");	
	}
	return 0;
}
