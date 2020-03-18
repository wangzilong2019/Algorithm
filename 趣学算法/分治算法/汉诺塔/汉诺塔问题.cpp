//汉诺塔问题，打印的是整个的移动过程
#include <stdio.h>
void hanoi(int n , char A , char C , char B)//n个圈圈在柱子A上，借助柱子B，移动到柱子C上
{
  if(n == 1)//如果A柱子上只有一个圈圈，直接移动到C上
    printf("Move dish %d from %c to %c\n",n,A,C);
  else
  {
    hanoi(n-1,A,C,B);//将A柱子上的n-1个圈圈，借助柱子C，移动到柱子B上
    printf("Move dish %d from %c to %c\n",n,A,C);//将A柱子上的最后一个圈圈移动到柱子C上
    hanoi(n-1,B,A,C);//将B柱子上的n-1个圈圈，借助柱子A，移动到柱子C上
  }
}
 
int main()
{
  
  hanoi(8,'A','C','B');
  return 0;
}
