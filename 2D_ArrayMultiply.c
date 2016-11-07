#include <stdio.h>

void multiply(double c1[][3], double c2[][2]);
void display(int m, int n);

double result[2][2];

int main(void)
{
   int x = 2;
   int y = 2;
    double a[2][3] = { { 4.2,4.3,3.8 },{ 3.7,1.5,0.7 } };
    double b[3][2] = { { 5.2,2.1 },{ 3.2,1.4 },{ 1.5,3.6 } };

   printf("두 배열을 곱한 값\n");
   multiply(a, b);
   display(x,y);

   return 0;

}
void multiply(double c1[][3], double c2[][2])
{
   int i, j, k;
   double sum;
   for (i = 0; i < 2; i++)
   {
      for (j = 0; j < 2; j++)
      {
         sum = 0;
         for (k = 0; k < 3; k++)
         {
            sum += c1[i][k] * c2[k][j];
         
         }   result[i][j] = sum;
      }
      
   }

}
void display(int m, int n)
{
   int i, j;
   for (i = 0; i < m; i++)
   {
      for (j = 0; j < n; j++)
      {
         printf("%8.2f", result[i][j]);
      }
      printf("\n");
   }
   printf("\n");
}
