import java.util.ArrayList;
import java.util.List;

class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<> ();

        for(int row=0; row<numRows; row++) {
            List<Integer> temp = new ArrayList<> ();
            for(int col=0; col<=row; col++) {
                temp.add(ncr(row,col));
            }
            ans.add(temp);
        }
        return ans;
    }

    public int ncr(int n, int r) {
        long ans = 1;
        for(int i=1; i<=r; i++) {
            ans = ans*(n-i+1);
            ans = ans/i;
        }
        return (int) ans;
    }
}