 //�����������޵�ʱ���ڿ�����Ļ���
//�ȶԽ���ʱ�����絽�������ҳ������ݵļ�Ϊ 
#include<stdio.h>
#define MAX 1000
typedef struct{
	int beg;
	int end;
	int num;
}MEETING_TYPE;
int main(){
	MEETING_TYPE meet[MAX];
	int last,n,i,j,k,temp,count=1;
	scanf("%d",&n);
	for(i=0;i<n;i++){
		scanf("%d %d",&meet[i].beg,&meet[i].end);
		meet[i].num=i+1;
	}
	//�Ի������ʱ��������� 
	for(i=0;i<n;i++){
		k=i;
		for(j=i+1;j<n;j++){
			if(meet[j].end<meet[k].end){
				k=j;
			}
		}
		temp=meet[i].beg;
		meet[i].beg=meet[k].beg;
		meet[k].beg=temp;
		temp=meet[i].end;
		meet[i].end=meet[k].end;
		meet[k].end=temp;
		temp=meet[i].num;
		meet[i].num=meet[k].num;
		meet[k].num=temp;
	}
	//�������ŵ�ʱ��
	printf("���������ʱ�����£�\n");
	printf("  ������   ��ʼʱ��   ����ʱ��\n");
	for(i=0;i<n;i++){
		printf("  %d   %d   %d\n",meet[i].num,meet[i].beg,meet[i].end);
	} 
	printf("��ѡ��Ļ������\n");
	last=meet[0].end;
	printf("  ѡ���%d������\n",meet[0].num); 
	for(i=0;i<n;i++){
		if(meet[i].beg>=last){
			count++;
			last=meet[i].end;
			printf("  ѡ���%d������\n",meet[i].num);
		}
	}
	printf("�ܹ���ѡ��%d������",count);
	return 0;
}
