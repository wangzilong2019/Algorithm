#include<stdio.h>
#define MAX 100 //定义最大物品件数 
#define MAXV 100 //定义购物车最大载重
int c[MAX][MAXV],w[MAX],v[MAX],x[MAX];
int n,W;
int main(){
	int i,j;
	printf("请输入物品的个数n：\n");
	scanf("%d",&n);
	printf("请输入购物车的最大载重W：\n"); 
	scanf("%d",&W);
	printf("请输入每件商品重量w和价值v：\n");
	for(i=1;i<=n;i++){
		scanf("%d %d",&w[i],&v[i]);
	}
	//初始化二维数组c[i][j]
	for(i=0;i<=n;i++){
		c[i][0]=0;
	} 
	for(j=0;j<=W;j++){
		c[0][j]=0;
	}
	for(i=1;i<=n;i++){
		for(j=1;j<=W;j++){
			//判断当前物品重量与购物车载重大小 
			if(w[i]>j){
				c[i][j]=c[i-1][j];
			}
			else{
				if(c[i-1][j]>(c[i-1][j-w[i]]+v[i])){
					c[i][j]=c[i-1][j];
				}
				else{
					c[i][j]=c[i-1][j-w[i]]+v[i];
				}
			}
		}
	}
	printf("装入购物车的最大价值：\n");
	printf("%d\n",c[n][W]);
	//记录已加入物品 
	j=W;
	for(i=n;i>=1;i--){
		//当前物品已加入购物车 
		if(c[i][j]>c[i-1][j]){
			x[i]=1;
			j-=w[i];
		}
		//当前物品没加入购物车 
		else{
			x[i]=0;
		}
	}
	printf("装入购物车的物品为：\n");
	for(i=1;i<=n;i++){
		if(x[i]==1){
			printf("%d ",i);
		}
	}
	return 0;
}
