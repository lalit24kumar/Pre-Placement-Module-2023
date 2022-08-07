public class Solution {
    
    public String countChar(String str){
        int[] vector = new int[26];
        for(char c : str.toCharArray()){
            vector[c - 'a']++;
        }
        return Arrays.toString(vector);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<String, List<String>>();
        for(String str : strs){
            String temp = countChar(str);
            if(!map.containsKey(temp)){
                map.put(temp, new ArrayList<String>());
            } 
            map.get(temp).add(str);
        }
        
        return new ArrayList<List<String>>(map.values());
    }
}