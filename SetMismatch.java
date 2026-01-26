class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;

        long sn = (long) (n * (n+1)) / 2;
        long s2n = (long) (n * (n+1) * (2L*n+1)) / 6;

        long s = 0;
        long s2 = 0;

        for(int i=0; i<n; i++) {
            s += nums[i];
            s2 += (long) nums[i] * nums[i];
        } 

        long val1 = s-sn; //x-y
        long val2 = s2-s2n;
        val2 = val2/val1; //x+y

        long x = (val1+val2)/2;
        long y = x-val1;

        return new int [] {(int)x,(int)y};
    }
}