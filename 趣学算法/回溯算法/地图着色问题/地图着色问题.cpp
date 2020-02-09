#include<stdio.h>
#define MAX 100
int edge;  //地图中的边数
int map[MAX][MAX]={0};  //map[i][j]的值为1表示i与j俩个顶点之间连通，0表示不连通
int n;  //图中的顶点数
int m;  //绘制地图的颜色
int x[MAX];  //x[i]=j表示第i个顶点绘制j号颜色
int countn=0;  //记录可用的颜色方法
//约束条件 
int Ok(int t){
	int ok=1;
	//判断第t个顶点与前t-1个相连接颜色是否相同 
	for(int i=1;i<=t-1;i++){
		if(map[t][i]==1){
			if(x[t]==x[i]){
				ok=0;
			}
		} 
	}
	return ok;
} 
void Backtrack(int t){
	//到达叶子节点，找到一个颜色方案
	if(t>n){
		countn++;
		printf("第%d中方案为：\n",countn);
		for(int i=1;i<=n;i++){
			printf("%d ",x[i]);
		}
		printf("\n");
	} 
	else{
		//每个节点尝试m种颜色
		for(int i=1;i<=m;i++){
			x[t]=i;
			if(Ok(t)){
				Backtrack(t+1);
			}
		} 
	}
}
//创建邻接矩阵
void Creatmap(){
	int i,j;
	int u,v;
	printf("输入地图中连接的边数edge：\n");
	scanf("%d",&edge);
	printf("请依次输入有边相连的俩个顶点u和v：\n");
	for(int i=1;i<=edge;i++){
		scanf("%d %d",&u,&v);
		map[u][v]=map[v][u]=1;
	}
} 
int main(){
	printf("输入图中的结点数n：\n");
	scanf("%d",&n);
	printf("请输入可用的颜色数m：\n");
	scanf("%d",&m);
	printf("初始化图的邻接矩阵：\n");
	Creatmap();
	Backtrack(1);
	return 0;
} 
