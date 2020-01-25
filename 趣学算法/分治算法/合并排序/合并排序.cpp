//�ϲ��㷨�����裺
//�ֽ⣺�����������зֽ������������ 
//�����������н������� 
//�ϲ����������кϲ���һ����������� 
#include<stdio.h>
#define MAX 100
void Merge(int a[],int low,int mid,int high){
	int i,j,k;
	int b[MAX];
	i=low;
	j=mid+1;
	k=0;
	while(i<=mid && j<=high){
		if(a[i]<a[j]){
			b[k++]=a[i++];
		}
		else{
			b[k++]=a[j++];
		}
	}
	while(i<=mid){
		b[k++]=a[i++];
	}
	while(j<=high){
		b[k++]=a[j++];
	}
	for(i=low,k=0;i<=high;i++,k++){
		a[i]=b[k];
	}
}
void MergeSort(int a[],int low,int high){
	if(low<high){
		int mid=(low+high)/2;  //ȡ�е� 
		MergeSort(a,low,mid);  //��ǰ�벿�ֽ������� 
		MergeSort(a,mid+1,high);  //�Ժ�벿�ֽ������� 
		Merge(a,low,mid,high);  //���кϲ����� 
	}
}
int main(){  
	int n,i;
	int r[MAX];
	printf("������������Ԫ�صĸ�����\n");
	scanf("%d",&n);
	printf("���������������е�Ԫ�أ�\n");
	for(i=0;i<n;i++){
		scanf("%d",&r[i]);
	}
	MergeSort(r,0,n-1);
	printf("�ϲ�����Ľ���ǣ�\n");
	for(i=0;i<n;i++){
		printf("%d ",r[i]);
	}
	return 0;
} 
