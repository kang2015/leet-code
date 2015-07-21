public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> largeK = new PriorityQueue<Integer>(k+1);
        for(int e:nums){
            largeK.add(e);
            if(largeK.size()>k){
                largeK.poll();
            }
        }
        return largeK.poll();
    }
}
