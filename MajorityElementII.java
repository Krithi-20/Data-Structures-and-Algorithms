import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {

        int n = nums.length;

        int cnt1 = 0, cnt2 = 0;
        int ele1 = 0, ele2 = 1;

        for(int i=0; i<n; i++) {
            if(cnt1 == 0 && nums[i]!= ele2) {
                cnt1 = 1;
                ele1 = nums[i];
            }
            else if(cnt2 == 0 && nums[i]!=ele1) {
                cnt2 = 1;
                ele2 = nums[i];
            }
            else if(ele1 == nums[i]) {
                cnt1++;
            } else if(ele2 == nums[i]) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        List<Integer> ls = new ArrayList<>();
        int cont1 = 0, cont2 = 0;
        for(int i=0; i<n; i++) {
            if(ele1 == nums[i]) cont1++;
            if(ele2 == nums[i]) cont2++;
        }

        int min = (int) (n/3) +1;
        if(cont1 >= min) ls.add(ele1);
        if(cont2 >= min) ls.add(ele2);

        Collections.sort(ls);

        return ls;

    }
}