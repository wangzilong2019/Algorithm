//��ŵ�����⣬��ӡ�����������ƶ�����
#include <stdio.h>
void hanoi(int n , char A , char C , char B)//n��ȦȦ������A�ϣ���������B���ƶ�������C��
{
  if(n == 1)//���A������ֻ��һ��ȦȦ��ֱ���ƶ���C��
    printf("Move dish %d from %c to %c\n",n,A,C);
  else
  {
    hanoi(n-1,A,C,B);//��A�����ϵ�n-1��ȦȦ����������C���ƶ�������B��
    printf("Move dish %d from %c to %c\n",n,A,C);//��A�����ϵ����һ��ȦȦ�ƶ�������C��
    hanoi(n-1,B,A,C);//��B�����ϵ�n-1��ȦȦ����������A���ƶ�������C��
  }
}
 
int main()
{
  
  hanoi(8,'A','C','B');
  return 0;
}
