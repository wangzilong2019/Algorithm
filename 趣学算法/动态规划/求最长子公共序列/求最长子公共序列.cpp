#include<stdio.h>
#define MAX 100
#include<string.h>
int len1,len2;
int c[MAX][MAX],b[MAX][MAX];
char s1[MAX],s2[MAX];
//����������������⺯��
void LCSL(){
	int i,j;
	for(i=1;i<=len1;i++){
		for(j=1;j<=len2;j++){
			//�жϵ�ǰ�ַ�����Ƚ��ַ��Ƿ���� 
			if(s1[i-1]==s2[j-1]){
				//��ȣ���ȡ��c[i][j]���Ͻ�ֵ��1 
				c[i][j]=c[i-1][j-1]+1;
				b[i][j]=1;
			}
			else{
				//����ȣ���Ƚ�c[i][j]���������Ĵ�С��ѡȡ��ֵ 
				if(c[i][j-1]>=c[i-1][j]){
					c[i][j]=c[i][j-1];
					b[i][j]=2;
				}
				else{
					c[i][j]=c[i-1][j];
					b[i][j]=3;
				}
			}
		}
	}
}
//���ݵ�ǰ������Ϣb[][]��ֵ������ 
void print(int i,int j){
	if(i==0 || j==0){
		return ;
	} 
	if(b[i][j]==1){
		print(i-1,j-1);
		printf("%c",s1[i-1]);
	}
	else{
		if(b[i][j]==2){
			print(i,j-1);
		}
		else{
			if(b[i][j]==3){
				print(i-1,j);
			}
		}
	}
} 
int main(){
	int i;
	printf("�����������ַ�����\n");
	gets(s1);
	gets(s2);
	len1=strlen(s1);
	len2=strlen(s2);
	for(i=0;i<=len1;i++){
		c[i][0]=0;
	}
	for(i=0;i<=len2;i++){
		c[0][i]=0;
	}
	LCSL();
	printf("�ַ��������г����ǣ�");
	printf("%d\n",c[len1][len2]);
	printf("��ӹ��������ǣ�\n");
	print(len1,len2);
	return 0;
}
