#include<stdio.h>
#define MAX 100
int edge;  //��ͼ�еı���
int map[MAX][MAX]={0};  //map[i][j]��ֵΪ1��ʾi��j��������֮����ͨ��0��ʾ����ͨ
int n;  //ͼ�еĶ�����
int m;  //���Ƶ�ͼ����ɫ
int x[MAX];  //x[i]=j��ʾ��i���������j����ɫ
int countn=0;  //��¼���õ���ɫ����
//Լ������ 
int Ok(int t){
	int ok=1;
	//�жϵ�t��������ǰt-1����������ɫ�Ƿ���ͬ 
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
	//����Ҷ�ӽڵ㣬�ҵ�һ����ɫ����
	if(t>n){
		countn++;
		printf("��%d�з���Ϊ��\n",countn);
		for(int i=1;i<=n;i++){
			printf("%d ",x[i]);
		}
		printf("\n");
	} 
	else{
		//ÿ���ڵ㳢��m����ɫ
		for(int i=1;i<=m;i++){
			x[t]=i;
			if(Ok(t)){
				Backtrack(t+1);
			}
		} 
	}
}
//�����ڽӾ���
void Creatmap(){
	int i,j;
	int u,v;
	printf("�����ͼ�����ӵı���edge��\n");
	scanf("%d",&edge);
	printf("�����������б���������������u��v��\n");
	for(int i=1;i<=edge;i++){
		scanf("%d %d",&u,&v);
		map[u][v]=map[v][u]=1;
	}
} 
int main(){
	printf("����ͼ�еĽ����n��\n");
	scanf("%d",&n);
	printf("��������õ���ɫ��m��\n");
	scanf("%d",&m);
	printf("��ʼ��ͼ���ڽӾ���\n");
	Creatmap();
	Backtrack(1);
	return 0;
} 
