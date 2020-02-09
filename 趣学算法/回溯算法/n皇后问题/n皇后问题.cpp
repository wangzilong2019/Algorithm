#include<stdio.h>
#include<math.h>
#define MAX 100
int n;  //定义皇后的数量
int x[MAX];  //x[i]表示第i个元素放在第i行第x[i]列
int countn=0;  //用来记录存放皇后的种数 
int Place(int t){
	int ok=1;
	//判断第t个皇后是否与前t-1个处于同一列或是同一斜线 
	for(int i=1;i<=t-1;i++){ 
		if(x[t]==x[i] || t-i==fabs(x[t]-x[i])){
			ok=0;
			break;
		}
	}
	return ok;
}
void Backtrack(int t){
	//如果当前位置为n说明已经找到了问题的一个解 
	if(t>n){
		countn++;
		printf("输出打印路径：\n");
		for(int i=1;i<=n;i++){
			printf("%d ",x[i]);
		} 
		printf("\n"); 
	}
	//分别判断n个分支 
	else{
		for(int i=1;i<=n;i++){
			x[t]=i;
			//如果不冲突的话进行下一行搜索 
			if(Place(t)){
				Backtrack(t+1);
			}
		}
	}
}
int main(){
	printf("请输入皇后的个数n：\n");
	scanf("%d",&n);
	Backtrack(1);
	printf("答案各个数为：\n");
	printf("%d",countn); 
	return 0;
} 
