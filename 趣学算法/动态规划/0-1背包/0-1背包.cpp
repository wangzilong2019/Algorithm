#include<stdio.h>
#define MAX 100 //���������Ʒ���� 
#define MAXV 100 //���幺�ﳵ�������
int c[MAX][MAXV],w[MAX],v[MAX],x[MAX];
int n,W;
int main(){
	int i,j;
	printf("��������Ʒ�ĸ���n��\n");
	scanf("%d",&n);
	printf("�����빺�ﳵ���������W��\n"); 
	scanf("%d",&W);
	printf("������ÿ����Ʒ����w�ͼ�ֵv��\n");
	for(i=1;i<=n;i++){
		scanf("%d %d",&w[i],&v[i]);
	}
	//��ʼ����ά����c[i][j]
	for(i=0;i<=n;i++){
		c[i][0]=0;
	} 
	for(j=0;j<=W;j++){
		c[0][j]=0;
	}
	for(i=1;i<=n;i++){
		for(j=1;j<=W;j++){
			//�жϵ�ǰ��Ʒ�����빺�ﳵ���ش�С 
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
	printf("װ�빺�ﳵ������ֵ��\n");
	printf("%d\n",c[n][W]);
	//��¼�Ѽ�����Ʒ 
	j=W;
	for(i=n;i>=1;i--){
		//��ǰ��Ʒ�Ѽ��빺�ﳵ 
		if(c[i][j]>c[i-1][j]){
			x[i]=1;
			j-=w[i];
		}
		//��ǰ��Ʒû���빺�ﳵ 
		else{
			x[i]=0;
		}
	}
	printf("װ�빺�ﳵ����ƷΪ��\n");
	for(i=1;i<=n;i++){
		if(x[i]==1){
			printf("%d ",i);
		}
	}
	return 0;
}
