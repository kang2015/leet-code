public class Solution {
    private boolean dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, boolean[] looped, List<Integer> ans, int cur){
        if(visited[cur]){
            return true;
        }
        if(looped[cur]){
            return false;
        }
        looped[cur] = true;
        for(int i=0;i<graph.get(cur).size();i++){
            if(!dfs(graph,visited,looped,ans,graph.get(cur).get(i)))
                return false;
        }
        visited[cur] = true;
        ans.add(cur);
        return true;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0;i<prerequisites.length;i++){
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        boolean[] visited = new boolean[numCourses];
        for(int i=0;i<numCourses;i++) visited[i] = false;
        boolean[] looped = new boolean[numCourses];
        for(int i=0;i<numCourses;i++) looped[i] = false;
        
        List<Integer> ans = new ArrayList<Integer>();
        for(int i=0;i<numCourses;i++){
            if(!visited[i])
                if(!dfs(graph,visited,looped,ans,i)) 
                    return new int[0];
        }
        int[] ret = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            ret[i] = ans.get(i);
        }
        return ret;
    }
    
}
