#include<stdio.h>
#include<string.h>
#define MAX 100
//����ȫ�ֱ��� 
int n;
int p[MAX];
int m[MAX][MAX],s[MAX][MAX];
void matrixchain(){
	int i,j,k,d,min;
	//��ʼ������ 
	memset(m,0,sizeof(m));
	memset(s,0,sizeof(s));
	for(k=2;k<=n;k++){
		for(i=1;i<=n-k+1;i++){
			j=i+k-1;
			//����Ϊk=i�ĳ˷����� 
			m[i][j]=m[i+1][j]+p[i-1]*p[i]*p[j];
			s[i][j]=i;
			//�ҵ��������ٵ� 
			for(d=i+1;d<j;d++){
				if(m[i][j]>m[i][d]+m[d+1][j]+p[i-1]*p[k]*p[j]){
					m[i][j]=m[i][d]+m[d+1][j]+p[i-1]*p[k]*p[j];
					s[i][j]=d;
				}
			}
		}
	}
}
void print(int i,int j){
	if(i==j){
		printf("A[%d",i);
		printf("]");
		return ;
	}
	printf("(");
	print(i,s[i][j]);
	print(s[i][j]+1,j);
	printf(")");
}
int main(){
	int i,j;
	printf("���������ĸ���n��\n");
	scanf("%d",&n);
	printf("������ÿ����������������һ�������������\n");
	for(i=0;i<=n;i++){
		scanf("%d",&p[i]);
	}
	matrixchain();
	print(1,n);
	printf("��С��������ֵΪ��%d",m[1,n]);
	return 0;
}
