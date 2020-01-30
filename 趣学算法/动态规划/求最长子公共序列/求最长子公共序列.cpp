#include<stdio.h>
#define MAX 100
#include<string.h>
int len1,len2;
int c[MAX][MAX],b[MAX][MAX];
char s1[MAX],s2[MAX];
//求解最长公共子序列求解函数
void LCSL(){
	int i,j;
	for(i=1;i<=len1;i++){
		for(j=1;j<=len2;j++){
			//判断当前字符与带比较字符是否相等 
			if(s1[i-1]==s2[j-1]){
				//相等，则取从c[i][j]左上角值加1 
				c[i][j]=c[i-1][j-1]+1;
				b[i][j]=1;
			}
			else{
				//不相等，则比较c[i][j]左侧与上面的大小，选取大值 
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
//根据当前构造信息b[][]中值来逆推 
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
	printf("请输入俩个字符串：\n");
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
	printf("字符串的序列长度是：");
	printf("%d\n",c[len1][len2]);
	printf("最长子公共序列是：\n");
	print(len1,len2);
	return 0;
}
