public class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        
        int[] res = new int[ len1 + len2];
        
        for(int i = len1 - 1; i >= 0; i-- ){
            for(int j = len2 - 1; j >=0; j-- ){
                int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + res[i + j + 1];
                res[i + j] += temp / 10;
                res[i + j + 1] = temp % 10;
            }
        }
        
        StringBuilder resString = new StringBuilder();
        
        for(int i = 0; i < res.length; i++){
            if( resString.length() == 0 && res[i] == 0){
                continue;
            }
            resString.append(res[i]);
        }
        
        return resString.length() == 0 ? "0" : resString.toString();
    }
}