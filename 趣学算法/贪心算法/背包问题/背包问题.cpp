#include<stdio.h>
#define MAX 1000
typedef struct{
	double w;
	double v;
	double p;
}NUM_TYPE;
int main(){
	int n,i;
	double weight;
	NUM_TYPE goods[MAX];
	scanf("%d %lf",&n,&weight);
	for(i=0;i<n;i++){
		scanf("%lf %lf",&goods[i].w,&goods[i].v);
		goods[i].p=goods[i].v/goods[i].w;
	}
	double temp;
	int j,k;
	for(i=0;i<n;i++){
		k=i;
		for(j=i+1;j<n;j++){
			if(goods[k].p<goods[j].p){
				k=j;
			}
		}
		temp=goods[i].w;
		goods[i].w=goods[k].w;
		goods[k].w=temp;
		temp=goods[i].p;
		goods[i].p=goods[k].p;
		goods[k].p=temp;
		temp=goods[i].v;
		goods[i].v=goods[k].v;
		goods[k].v=temp;
	}
	double sum=0;
	for(i=0;i<n;i++){
		if(goods[i].w<=weight){
			sum+=goods[i].v; 
		}
		else{
			sum+=goods[i].p*weight;
			break;
		}
		weight-=goods[i].w;
	}
	printf("%lf",sum);
	return 0;
}
