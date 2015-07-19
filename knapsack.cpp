#include<vector>
#include<iostream>
using namespace std;
int knapsack01(vector<int> w,vector<int> v, int total){
	int n = w.size();
	vector<vector<int> > dp(n+1,vector<int>(total+1,0));
	for(int i=0;i<n;i++){
		for(int j=0;j<=total;j++){
			if(j<w[i]){
				dp[i+1][j] = dp[i][j];
			}else{
				dp[i+1][j] = max(dp[i][j],dp[i][j-w[i]]+v[i]);
			}
		}
	}
	return dp[n][total];
}

int knapsack01_optimized(vector<int> w,vector<int> v, int total){
	int n = w.size();
	vector<int> dp(total+1,0);
	for(int i=0;i<n;i++){
		for(int j=total;j>=w[i];j--){
			dp[j]=max(dp[j],dp[j-w[i]]+v[i]);
		}
	}
	return dp[total];
}

int knapsackComplete_optimized(vector<int> w,vector<int> v, int total){
	int n= w.size();
	vector<int> dp(total+1,0);
	for(int i=0;i<n;i++){
		for(int j=0;j<=total;j++){
			if(j>=w[i]){
				dp[j] = max(dp[j-w[i]]+v[i],dp[j]);
			}
		}
	}
	return dp[total];
}

int main(){
	vector<int> w;
	w.push_back(2);
	w.push_back(3);
	w.push_back(3);
	w.push_back(1);

	vector<int> v;
	v.push_back(4);
	v.push_back(6);
	v.push_back(7);
	v.push_back(3);
	int total = 7;
	int ans = knapsack01(w,v,total);
	cout << ans << endl;
	ans = knapsack01_optimized(w,v,total);
	cout <<ans << endl;
	ans = knapsackComplete_optimized(w,v,total);
	cout << ans <<endl;
	return 0;
}
