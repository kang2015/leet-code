template<class T> class MaxDeque{
    private:
        deque<T> window;
        T maxV;
    public:
        MaxDeque(){
            maxV = INT_MIN;
        }
        void push_back(T _val){
            window.push_back(_val);
            if(_val > maxV){
                maxV = _val;
            }
        }
        void pop_front(){
            T tmp = window.front();
            window.pop_front();
            if( tmp == maxV){
                updateMax();
            }
        }
        T getMax(){
            return maxV;
        }
        void updateMax(){
            maxV = INT_MIN;
            for(auto it = window.begin();it!=window.end();it++){
                maxV = max(maxV,*it);
            }
        }
};
class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        MaxDeque<int> window;
        vector<int> ans;
        for(int i=0;i<k-1;i++){
            window.push_back(nums[i]);
        }
        for(int i=k-1;i<nums.size();i++){
            window.push_back(nums[i]);
            ans.push_back(window.getMax());
            window.pop_front();
        }
        return ans;
        
    }
    
};
