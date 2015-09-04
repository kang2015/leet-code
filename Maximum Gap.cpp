class Solution {
public:
    int maximumGap(vector<int>& nums) {
        int len = nums.size();
        if(len <= 1){
            return 0;
        }
        int maxV = INT_MIN,minV= INT_MAX;
        for(int i=0;i<len;i++){
            if(nums[i] > maxV){
                maxV = nums[i];
            }
            if(nums[i] < minV){
                minV = nums[i];
            }
        }
        int gap = max(1, (maxV-minV)/(len-1));
        int bucketNum = (maxV-minV)/gap + 1;
        vector<int> bucketMax(bucketNum,INT_MIN);
        vector<int> bucketMin(bucketNum,INT_MAX);
        for(int i=0;i<len;i++){
            int index = (nums[i]-minV)/gap;
            if(nums[i] > bucketMax[index])
                bucketMax[index] = nums[i];
            if(nums[i] < bucketMin[index])
                bucketMin[index] = nums[i];
        }
        int ans = INT_MIN;
        int i=0;
        while(i<bucketNum){
            int j=i+1;
            while(j<bucketNum && bucketMin[j] == INT_MAX) j++;
            if(j == bucketNum) break;
            ans = max(ans,(bucketMin[j]-bucketMax[i]));
            i = j;
        }
        return ans;
    }
};
