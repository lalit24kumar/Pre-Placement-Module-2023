class Solution {
    public int findTheWinner(int n, int k) {
         Queue<Integer> circularGame = new LinkedList<>();
        
        for (int i = 1; i <= n; ++i) {
            circularGame.add(i);
        }
        
        while (circularGame.size() > 1) {
            int count = k;
            
            while (count > 1) {
                int current = circularGame.poll();
                circularGame.add(current);
                
                --count;
            }
            
            circularGame.poll();
        }
        
        return circularGame.peek();
    }
}