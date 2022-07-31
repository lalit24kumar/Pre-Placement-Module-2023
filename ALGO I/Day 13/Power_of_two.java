class Solution {
    public boolean isPowerOfTwo(int n) {
        // Corner case
        if(n == 0) return false;
        
        while(n % 2 == 0) n /= 2;
        
        return n == 1;
    }
}