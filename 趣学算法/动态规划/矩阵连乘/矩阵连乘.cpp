#include<stdio.h>
#include<string.h>
#define MAX 100
//声明全局变量 
int n;
int p[MAX];
int m[MAX][MAX],s[MAX][MAX];
void matrixchain(){
	int i,j,k,d,min;
	//初始化矩阵 
	memset(m,0,sizeof(m));
	memset(s,0,sizeof(s));
	for(k=2;k<=n;k++){
		for(i=1;i<=n-k+1;i++){
			j=i+k-1;
			//决策为k=i的乘法策略 
			m[i][j]=m[i+1][j]+p[i-1]*p[i]*p[j];
			s[i][j]=i;
			//找到次数最少的 
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
	printf("请输入矩阵的个数n：\n");
	scanf("%d",&n);
	printf("请输入每个矩阵的行数和最后一个矩阵的列数：\n");
	for(i=0;i<=n;i++){
		scanf("%d",&p[i]);
	}
	matrixchain();
	print(1,n);
	printf("最小计算量的值为：%d",m[1,n]);
	return 0;
}
