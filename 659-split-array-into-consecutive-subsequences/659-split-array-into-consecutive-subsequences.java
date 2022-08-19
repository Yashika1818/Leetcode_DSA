class Solution {
    public boolean isPossible(int[] nums) {
//         1 - 2
//         2 - 3
//         3 - 3
//         4 - 3
//         5 - 2
//         f=hm.get(1);
        
//         for
//         if(hm.get(key)>=f)
//         len++;
//         else if(hm.get(key)<f){
//             f=hm.get(key);
//         }
//         if(len==3){cnt+=f;
//         if(hm.get(key)>1) f=hm.get(key)-1;
//                   }
//         1 2 3 
//         3 4 5
            
//         1 - 1
//         2 - 1
//         3 - 1
//         4 - 2
        // 5 - 1
      
    int pre = Integer.MIN_VALUE;
	int p1 = 0;
	int p2 = 0;
	int p3 = 0;
	
    int cur = 0;
	int cnt = 0;
	int c1 = 0;
	int c2 = 0;
	int c3 = 0;
        
    for (int i = 0; i < nums.length; pre = cur, p1 = c1, p2 = c2, p3 = c3) {
        for (cur = nums[i], cnt = 0; i < nums.length && cur == nums[i]; i++) {
			cnt++;
		}
        
        if (cur != pre + 1) {
            if (p1 != 0 || p2 != 0) {
				return false;
			}
			
            c1 = cnt;
			c2 = 0;
			c3 = 0;
            
        } else {
            if (cnt < p1 + p2) {
				return false;
			}
			
            c1 = Math.max(0, cnt - (p1 + p2 + p3));
            c2 = p1;
            c3 = p2 + Math.min(p3, cnt - (p1 + p2));
        }
    }
    
    return (p1 == 0 && p2 == 0);

    }
}