public class Solution {
    public int findKthLargest(int[] nums, int k) {// o(n*log(k+1))
        PriorityQueue<Integer> largeK = new PriorityQueue<Integer>(k+1);// min heap
        for(int e:nums){
            largeK.add(e);
            if(largeK.size()>k){
                largeK.poll(); //remove the least of k+1
            }
        }
        return largeK.poll(); // return the least of k
    }
}
