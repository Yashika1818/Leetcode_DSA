import java.util.Arrays;
class Solution {
    //we can't directly implement merge sort here bcoz if left[i]>right[j] , we do inv+ nd j++, i.e we have included all the ith after that in inv+ but in this case we do inv+ only when left[i]>(2*right[j]) this is satisfied , it means all the ith elements after the curr i value are considered nd we are moving to j++ to check for next j with the curr i but this is not the case, suppose left[i]!>(2*right[j]) for current ith but for next ith element , it is poss for this jth but due to increment in this jth , we are ignoring this case and hence this algo is wrong.
  
    static int merge(int[] nums, int low, int mid, int high) {
        int cnt = 0;
        int j = mid + 1; 
        for(int i = low;i<=mid;i++) {
            while(j<=high && nums[i] > (2 * (long) nums[j])) {
                j++;
            }
            cnt += (j - (mid+1));
        }
        
        ArrayList<Integer> temp = new ArrayList<>(); 
        int left = low, right = mid+1; 
        while(left <= mid && right<=high) {
            if(nums[left]<=nums[right]) {
                temp.add(nums[left++]); 
            }
            else {
                temp.add(nums[right++]); 
            }
        }
        
        while(left<=mid) {
            temp.add(nums[left++]); 
        }
        while(right<=high) {
            temp.add(nums[right++]); 
        }
        
        for(int i = low; i<=high;i++) {
            nums[i] = temp.get(i - low); 
        }
        return cnt; 
    }
    static int mergeSort(int[] nums, int low, int high) {
        if(low>=high) return 0; 
        int mid = (low + high) / 2;
        int inv = mergeSort(nums, low, mid); 
        inv += mergeSort(nums, mid+1, high); 
        inv += merge(nums, low, mid, high); 
        return inv; 
    }
   static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1); 
    }

}