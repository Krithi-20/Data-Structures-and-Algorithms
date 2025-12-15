class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for(int pile : piles) {
            right = Math.max(right,pile);
        }

        while(left < right) {
            int mid = left + (right - left) / 2;
            if( canFinish (piles,mid,h)) { //here mid = k = speed of eating (we need to find slowest speed)
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean canFinish(int [] piles, int k, int h) {
        int hrs = 0;
        for(int pile : piles) {
            hrs += Math.ceil((double) pile/k);
        }
        return hrs <=h;
    }
}