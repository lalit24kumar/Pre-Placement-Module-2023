class Solution {
    public boolean isValid(String s) {
        if (s == null) return true;
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || (c == '(' || c == '{' || c == '[')) stack.push(c);
            else if (validate(stack.peek(), c)) stack.pop();
            else return false;
        }
        return stack.isEmpty();
    }
    
    private boolean validate(char a, char b) {
        if (a == '(') return b == ')';
        if (a == '{') return b == '}';
        if (a == '[') return b == ']';
        return false;
    }
}