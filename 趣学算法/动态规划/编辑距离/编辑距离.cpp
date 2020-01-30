#include<stdio.h>
#include<string.h>
#define MAX 100
//首先判断某个字符与字符串中的每个字符是否相等
//不相等则相当于求去掉此字符的
char s1[MAX],s2[MAX];
int d[MAX][MAX];
int len1,len2;
//取俩数最小值 
int min(int a,int b){
	return a<b?a:b;
} 
int editdistance(){
	int i,j,diff;
	for(i=1;i<=len1;i++){
		for(j=1;j<=len2;j++){
			//判断俩个字符是否相等，相等则代价为0 
			if(s1[i-1]==s2[j-1]){
				diff=0;
			}
			else{
				diff=1;
			}
			//找到三者的最小值 
			int temp=min(d[i-1][j]+1,d[i][j-1]+1);
			d[i][j]=min(temp,d[i-1][j-1]+diff);
		}
	}
	return d[len1][len2];
	
}
int main(){
	int i;
	printf("请输入俩个字符串：");
	gets(s1);
	gets(s2);
	len1=strlen(s1);
	len2=strlen(s2);
	for(i=0;i<=len1;i++){
		d[i][0]=i;
	}
	for(i=0;i<=len2;i++){
		d[0][i]=i;
	}
	printf("编辑距离为：");
	printf("%d",editdistance());
	return 0;
} 
