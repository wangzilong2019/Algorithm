//ʹ�÷����㷨������ԭ������Էֽ�Ϊ���ɸ�������
//ԭ����Ľ������������Ľ�ϲ��õ�
//�������໥���� 
//���������� ���Ƚ����������������������������۰����
#include<stdio.h>
#define MAX 100
void BinarySort(int a[],int n){
	int k,i,j,temp;
	for(i=0;i<n;i++){
		k=i;
		for(j=i+1;j<n;j++){
			if(a[k]<a[j]){
				k=j;
			}
		}
		temp=a[k];
		a[k]=a[i];
		a[i]=temp;
	}
}
//int recursionBS(int a[],int x,int low,int high){
//	if(low>high){
//		return -1;
//	}
//	int mid=(low+high)/2;
//	if(x==a[mid]){
//		return mid;
//	}
//	else{
//		if(x<a[mid]){
//			recursionBS(a,x,low,mid-1);
//		}
//		else{
//			recursionBS(a,x,mid+1,high);
//		}
//	}
//}
int BinarySearch(int a[],int n,int x){
	int low=0;
	int high=n-1;
	int mid;
	while(low<=high){
		mid=(low+high)/2;
		if(x==a[mid]){
			return mid;
		}
		else{
			if(x<a[mid]){
				high=mid-1;
			}
			else{
				low=mid+1;
			}
		}
	}
	return -1;
}
int main(){
	int r[MAX];
	int m,e,i;
	printf("������������Ԫ�صĸ�����\n");
	scanf("%d",&m);
	printf("���������������е�Ԫ�أ�\n");
	for(i=0;i<m;i++){
		scanf("%d",&r[i]);
	}
	//recursionBS(r,x,0,n-1);
	BinarySort(r,m);
	printf("����������Ϊ��\n");
	for(i=0;i<m;i++){
		printf("%d ",r[i]);
	}
	printf("\n");
	printf("������Ҫ���ҵ�Ԫ�أ�\n");
	scanf("%d",&e);
	printf("Ҫ���ҵ�Ԫ���ڵ�%dλ",BinarySearch(r,m,e));
	//printf("Ҫ���ҵ�Ԫ���ڵ�%dλ",recursionBS(r,e,0,m-1));
	return 0;
} 
