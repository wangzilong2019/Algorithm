#include<stdio.h>
#include<string.h>
#define MAX 100
//�����ж�ĳ���ַ����ַ����е�ÿ���ַ��Ƿ����
//��������൱����ȥ�����ַ���
char s1[MAX],s2[MAX];
int d[MAX][MAX];
int len1,len2;
//ȡ������Сֵ 
int min(int a,int b){
	return a<b?a:b;
} 
int editdistance(){
	int i,j,diff;
	for(i=1;i<=len1;i++){
		for(j=1;j<=len2;j++){
			//�ж������ַ��Ƿ���ȣ���������Ϊ0 
			if(s1[i-1]==s2[j-1]){
				diff=0;
			}
			else{
				diff=1;
			}
			//�ҵ����ߵ���Сֵ 
			int temp=min(d[i-1][j]+1,d[i][j-1]+1);
			d[i][j]=min(temp,d[i-1][j-1]+diff);
		}
	}
	return d[len1][len2];
	
}
int main(){
	int i;
	printf("�����������ַ�����");
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
	printf("�༭����Ϊ��");
	printf("%d",editdistance());
	return 0;
} 
