#include<stdio.h>
#define MAX 100
int map[MAX][MAX]={0};  //map[i][j]的值为1表示第i和j个顶点相连
int n;  //定义图中的顶点数
int m;  //定义图中定点之间相连的边数
int bestx[MAX];  //记录最优解
int bestn=0;  //记录最优值
int x[MAX];  //是否将第i个顶点加入团中
int cn=0;  //当前加入图中的顶点数
//约束条件 
int Place(int t){
	int ok=1;
	//判断当前顶点是否与前t-1个顶点相连 
	for(int i=1;i<=t-1;i++){
		//x[i]表示i是被选中的节点 
		if(x[i] && map[t][i]==0){
			ok=0;
			break;
		}
	}
	return ok;
} 
void Backtrack(int t){
	//表示当前节点为叶子节点 
	if(t>n){
		//记录当前最优解
		for(int i=1;i<=n;i++){
			bestx[i]=x[i];
		} 
		bestn=cn;
		return ; 
	}
	//满足约束条件进入左子树，把当前节点t加入团中
	if(Place(t)){
		x[t]=1;
		cn++;
		Backtrack(t+1);
		cn--;
	} 
	//满足条件进入右子树 
	if(cn+n-t>bestn){
		x[t]=0;
		Backtrack(t+1);
	}
}
int main(){
	int i,j,u,v;
	printf("请输入图中的顶点数n：\n");
	scanf("%d",&n);
	printf("请输入图中相连俩顶点的变数m：\n");
	scanf("%d",&m);
	//初始化图的矩阵
	printf("请输入图中相连边的顶点u和v：\n");
	for(int i=1;i<=m;i++){
		scanf("%d %d",&u,&v);
		map[u][v]=map[v][u]=1;
	} 
	Backtrack(1);
	printf("国王护卫队的最大人数为：\n");
	printf("%d\n",bestn); 
	printf("国王护卫队的成员为：\n");
	for(int i=1;i<=n;i++){
		if(bestx[i]==1){
			printf("%d ",i);
		}
	}
	return 0;
} 
