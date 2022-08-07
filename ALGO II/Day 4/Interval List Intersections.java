class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<>();

        int i = 0, j = 0;
        int m = A.length, n = B.length;
        while (i < m && j < n) {
            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);
            if (lo <= hi) list.add(new int[]{lo, hi});
           
            if (A[i][1] < B[j][1]) i++;
            else j++;
        }
       
        int[][] rst = new int[list.size()][2];
        for (int k = 0; k < list.size(); k++) {
            rst[k] = list.get(k);
        }
       
        return rst;
    }
   
}


