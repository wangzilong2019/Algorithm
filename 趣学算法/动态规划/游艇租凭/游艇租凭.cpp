#include<stdio.h>
#define MAX 100
int r[MAX][MAX],m[MAX][MAX],s[MAX][MAX];
int b,n;
//最小租金求解函数 
void rent(){
	int k,d,i,j,temp;
	//从3个点到n个点，依次计算出最小费用 
	for(k=3;k<=n;k++){
		for(i=b;i<=n-k+1;i++){
		//for(i=1;i<=n-k+1;i++){
			j=i+k-1;
			for(d=i+1;d<j;d++){
				//计算出最小费用为m[][] 
				if(m[i][d]+m[d][j]<m[i][j]){
					m[i][j]=m[i][d]+m[d][j];
					//记录经过站台 
					s[i][j]=d;
				}
			} 
		} 
	} 
} 
void print(int i,int j){
	if(s[i][j]==0){
		printf("%d->",j);
		return ;
	}
	print(i,s[i][j]);
	print(s[i][j],j);
}
int main(){
	int i,j;
	printf("请输入游艇出租站的个数：\n");
	scanf("%d",&n);
	//初始化s[][] 
	for(i=1; i<=n; i++){
		for(j=i+1; j<=n; j++){
			s[i][j]=0;
		}
	}
	for(i=1;i<=n;i++){
		for(j=i+1;j<=n;j++){
			printf("请输入第%d站台到第%d站台的租金：\n",i,j);
			scanf("%d",&r[i][j]);
			//初始化m[][]为r[][] 
			m[i][j]=r[i][j];
		}
	} 
	rent();
	printf("请输入从第i站台到第j站台：\n");
	scanf("%d %d",&i,&j);
	printf("从站台i到站台j的最小花费代价为%d\n",m[i][j]);
	//printf("从站台1到站台n的最小花费代价为%d\n",m[1][n]);
	printf("所经过的站台为：\n");
	//printf("1->");
	printf("%d->",i);
	print(i,j);
	//print(1,n);
	return 0;
}
