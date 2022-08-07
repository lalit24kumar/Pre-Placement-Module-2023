class Solution {
    // O(N)time
// O(N)space
public boolean backspaceCompare(String S, String T) {
    LinkedList<Character> listS = new LinkedList<>();
    LinkedList<Character> listT = new LinkedList<>();
    update(S, listS);
    update(T, listT);
    if(listS.size() != listT.size()) return false;
    while(!listS.isEmpty()){
        if(listS.removeLast() != listT.removeLast()) return false;
    }
    return true;
}

void update(String s, LinkedList<Character> list){
    for(char c : s.toCharArray()){
        if(c == '#'){
            if(!list.isEmpty()) list.removeLast();
        } else list.add(c);
    }
}
}