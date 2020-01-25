//使用分治算法条件：原问题可以分解为若干个子问题
//原问题的解可以由子问题的解合并得到
//子问题相互独立 
//二分搜索法 ：先将待搜索数组排序，在有序数组中折半查找
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
	printf("请输入数列中元素的个数：\n");
	scanf("%d",&m);
	printf("请依次输入数列中的元素：\n");
	for(i=0;i<m;i++){
		scanf("%d",&r[i]);
	}
	//recursionBS(r,x,0,n-1);
	BinarySort(r,m);
	printf("排序后的数组为：\n");
	for(i=0;i<m;i++){
		printf("%d ",r[i]);
	}
	printf("\n");
	printf("请输入要查找的元素：\n");
	scanf("%d",&e);
	printf("要查找的元素在第%d位",BinarySearch(r,m,e));
	//printf("要查找的元素在第%d位",recursionBS(r,e,0,m-1));
	return 0;
} 
