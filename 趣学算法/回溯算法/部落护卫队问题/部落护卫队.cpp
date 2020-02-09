#include<stdio.h>
#define MAX 100
int map[MAX][MAX]={0};  //map[i][j]��ֵΪ1��ʾ��i��j����������
int n;  //����ͼ�еĶ�����
int m;  //����ͼ�ж���֮�������ı���
int bestx[MAX];  //��¼���Ž�
int bestn=0;  //��¼����ֵ
int x[MAX];  //�Ƿ񽫵�i�������������
int cn=0;  //��ǰ����ͼ�еĶ�����
//Լ������ 
int Place(int t){
	int ok=1;
	//�жϵ�ǰ�����Ƿ���ǰt-1���������� 
	for(int i=1;i<=t-1;i++){
		//x[i]��ʾi�Ǳ�ѡ�еĽڵ� 
		if(x[i] && map[t][i]==0){
			ok=0;
			break;
		}
	}
	return ok;
} 
void Backtrack(int t){
	//��ʾ��ǰ�ڵ�ΪҶ�ӽڵ� 
	if(t>n){
		//��¼��ǰ���Ž�
		for(int i=1;i<=n;i++){
			bestx[i]=x[i];
		} 
		bestn=cn;
		return ; 
	}
	//����Լ�������������������ѵ�ǰ�ڵ�t��������
	if(Place(t)){
		x[t]=1;
		cn++;
		Backtrack(t+1);
		cn--;
	} 
	//������������������ 
	if(cn+n-t>bestn){
		x[t]=0;
		Backtrack(t+1);
	}
}
int main(){
	int i,j,u,v;
	printf("������ͼ�еĶ�����n��\n");
	scanf("%d",&n);
	printf("������ͼ������������ı���m��\n");
	scanf("%d",&m);
	//��ʼ��ͼ�ľ���
	printf("������ͼ�������ߵĶ���u��v��\n");
	for(int i=1;i<=m;i++){
		scanf("%d %d",&u,&v);
		map[u][v]=map[v][u]=1;
	} 
	Backtrack(1);
	printf("���������ӵ��������Ϊ��\n");
	printf("%d\n",bestn); 
	printf("���������ӵĳ�ԱΪ��\n");
	for(int i=1;i<=n;i++){
		if(bestx[i]==1){
			printf("%d ",i);
		}
	}
	return 0;
} 
