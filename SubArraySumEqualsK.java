import java.util.HashMap;


class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int prefixSum = 0, count = 0;
        HashMap <Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        for(int i=0; i<n; i++) {
            prefixSum += nums[i];
            int remove = prefixSum - k;

            if(map.containsKey(remove)) {
                count += map.get(remove);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}