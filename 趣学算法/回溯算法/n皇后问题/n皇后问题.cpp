#include<stdio.h>
#include<math.h>
#define MAX 100
int n;  //����ʺ������
int x[MAX];  //x[i]��ʾ��i��Ԫ�ط��ڵ�i�е�x[i]��
int countn=0;  //������¼��Żʺ������ 
int Place(int t){
	int ok=1;
	//�жϵ�t���ʺ��Ƿ���ǰt-1������ͬһ�л���ͬһб�� 
	for(int i=1;i<=t-1;i++){ 
		if(x[t]==x[i] || t-i==fabs(x[t]-x[i])){
			ok=0;
			break;
		}
	}
	return ok;
}
void Backtrack(int t){
	//�����ǰλ��Ϊn˵���Ѿ��ҵ��������һ���� 
	if(t>n){
		countn++;
		printf("�����ӡ·����\n");
		for(int i=1;i<=n;i++){
			printf("%d ",x[i]);
		} 
		printf("\n"); 
	}
	//�ֱ��ж�n����֧ 
	else{
		for(int i=1;i<=n;i++){
			x[t]=i;
			//�������ͻ�Ļ�������һ������ 
			if(Place(t)){
				Backtrack(t+1);
			}
		}
	}
}
int main(){
	printf("������ʺ�ĸ���n��\n");
	scanf("%d",&n);
	Backtrack(1);
	printf("�𰸸�����Ϊ��\n");
	printf("%d",countn); 
	return 0;
} 
