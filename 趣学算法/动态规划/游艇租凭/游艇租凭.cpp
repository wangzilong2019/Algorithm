#include<stdio.h>
#define MAX 100
int r[MAX][MAX],m[MAX][MAX],s[MAX][MAX];
int b,n;
//��С�����⺯�� 
void rent(){
	int k,d,i,j,temp;
	//��3���㵽n���㣬���μ������С���� 
	for(k=3;k<=n;k++){
		for(i=b;i<=n-k+1;i++){
		//for(i=1;i<=n-k+1;i++){
			j=i+k-1;
			for(d=i+1;d<j;d++){
				//�������С����Ϊm[][] 
				if(m[i][d]+m[d][j]<m[i][j]){
					m[i][j]=m[i][d]+m[d][j];
					//��¼����վ̨ 
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
	printf("��������ͧ����վ�ĸ�����\n");
	scanf("%d",&n);
	//��ʼ��s[][] 
	for(i=1; i<=n; i++){
		for(j=i+1; j<=n; j++){
			s[i][j]=0;
		}
	}
	for(i=1;i<=n;i++){
		for(j=i+1;j<=n;j++){
			printf("�������%dվ̨����%dվ̨�����\n",i,j);
			scanf("%d",&r[i][j]);
			//��ʼ��m[][]Ϊr[][] 
			m[i][j]=r[i][j];
		}
	} 
	rent();
	printf("������ӵ�iվ̨����jվ̨��\n");
	scanf("%d %d",&i,&j);
	printf("��վ̨i��վ̨j����С���Ѵ���Ϊ%d\n",m[i][j]);
	//printf("��վ̨1��վ̨n����С���Ѵ���Ϊ%d\n",m[1][n]);
	printf("��������վ̨Ϊ��\n");
	//printf("1->");
	printf("%d->",i);
	print(i,j);
	//print(1,n);
	return 0;
}
