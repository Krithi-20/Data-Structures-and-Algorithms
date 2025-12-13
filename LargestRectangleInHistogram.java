import java.util.Stack;
class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxAr = 0;
        Stack <Integer> s = new Stack <> ();

        for(int i=0; i<=n; i++) {
            int currHeight; 
            if (i == n) {
                currHeight = 0;
            }
            else {
                currHeight = heights[i];
            }
            while(!s.isEmpty() && currHeight < heights[s.peek()]) {
                int height = heights[s.pop()];
                int width;
                if (s.isEmpty()){
                    width = i;
                } else {
                    width = i-s.peek()-1;
                }
                maxAr = Math.max(maxAr, height * width);
            }
            s.push(i);
        }
        return maxAr;
    }
}