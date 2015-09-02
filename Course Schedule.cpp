class Solution {
public:
    bool canFinish(int numCourses, vector<pair<int, int>>& prerequisites) {
        vector<list<int>> graph(numCourses);
        for(int i=0;i<prerequisites.size();i++){
            graph[prerequisites[i].first].push_back(prerequisites[i].second);
        }
        vector<bool> vistmp(numCourses,false);
        vector<bool> visglobal(numCourses,false);
        for(int i=0;i<numCourses;i++){
            if(!visglobal[i] && !dfs(i,vistmp,visglobal,graph)){
                return false;
            }
        }
        return true;
        
    }
    bool dfs(int cur,vector<bool> &vistmp,vector<bool> &visglobal,vector<list<int>> &graph){
        if(visglobal[cur]){
            return true;
        }
        if(vistmp[cur]){
            return false;
        }
        vistmp[cur] = true;
        for(auto it=graph[cur].begin();it!=graph[cur].end();it++){
            if(!dfs(*it,vistmp,visglobal,graph)){
                return false;
            }
        }
        visglobal[cur] = true;
        return true;
    }
};
