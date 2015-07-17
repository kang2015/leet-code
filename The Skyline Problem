vector<pair<int, int>> getSkyline(vector<vector<int>>& buildings) {
        vector<pair<int,int>> ans;
        if(buildings.size() == 0){
            return ans;
        }
        multimap<int,pair<bool,int>> mp;
        for(int i=0;i<buildings.size();i++){
            int first = buildings[i][0],  height = buildings[i][2];
            mp.insert(make_pair(first,make_pair(true,height)));
        }
        for(int i=0;i<buildings.size();i++){
            int second = buildings[i][1], height = buildings[i][2];
            mp.insert(make_pair(second,make_pair(false,height)));
        }
        multiset<int> container;//maintain the current started and not finished height, better to use a heap//(priority_queque)?
        auto it = mp.begin();
        int last = it->second.second;
        container.insert(last);
        ans.push_back(make_pair(it->first,last));
        for(it++;it != mp.end();it++){
            int cur = it->second.second;
            if(it->second.first == true){
                if(cur > last){
                    ans.push_back(make_pair(it->first,cur));
                    last = cur;
                }
                container.insert(cur);
                
            }else{
                container.erase(container.lower_bound(cur));
                if(container.size() == 0){
                    ans.push_back(make_pair(it->first,0));
                    last = 0;
                    continue;
                }
                int tmp = *container.rbegin();
                if(tmp < cur){
                    ans.push_back(make_pair(it->first,tmp));
                    last = tmp;
                }
            }
        }
        for(int i= 1 ;i<ans.size();i++){
            if(ans[i].first == ans[i-1].first){
                ans.erase(ans.begin()+i-1);
                i--;
            }
        }
        return ans;
    }
