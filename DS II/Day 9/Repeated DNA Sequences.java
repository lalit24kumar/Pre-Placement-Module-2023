class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        Set<Integer> set = new HashSet<Integer>();
        Set<String> res = new HashSet<String>();
        
        char[] map = new char[26];
        int len = s.length();
        
        // Hashing function. We have only 4 letters which we can represent by 2 bits.
        map['A' - 'A'] = 0; // A = 00
        map['C' - 'A'] = 1; // B = 01
        map['G' - 'A'] = 2; // C = 10
        map['T' - 'A'] = 3; // D = 11
        
        for(int i=0; i<= len - 10; i++)
        {
            int sequence = 0;
            for(int j=i; j< i+10; j++)
            {
                // Shift existing sequence by two to make space for the new character coming
                sequence = sequence << 2;
                
                // Copy the character from the map 
                // and paste those two bits in the newly created space. Read bit wise OR.
                sequence = sequence | map[s.charAt(j) - 'A'];
            }
            
            
            if( set.contains(sequence) )
                res.add(s.substring(i, i+10));
            else
                set.add(sequence);
        }
         return new ArrayList(res);
    }
}