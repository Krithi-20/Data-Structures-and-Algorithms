class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxAr = 0;
        int left = 0;
        int right = height.length-1;

        while(left < right) {
            int width = right-left;
            int area = Math.min(height[left],height[right]) * width;
            maxAr = Math.max(maxAr,area);
            if(height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxAr;
    }
}