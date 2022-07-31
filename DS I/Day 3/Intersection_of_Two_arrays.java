class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = nums1.length<nums2.length ? nums1.length :nums2.length;
        
        int[] res = new int[n];
        int index = 0;
        
        for(int i=0;i<nums1.length;i++)
            if(hm.containsKey(nums1[i]))
                hm.put(nums1[i],hm.get(nums1[i])+1);
            else
                 hm.put(nums1[i],1);
        
        for(int i=0;i<nums2.length;i++)
             if(hm.containsKey(nums2[i])&&hm.get(nums2[i])>0){
                 res[index++] = nums2[i] ;
                 
                  hm.put(nums2[i],hm.get(nums2[i])-1);   
             }
          
            
        return Arrays.copyOfRange(res,0,index);
        
    }
}