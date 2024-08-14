class Solution {
    public int romanToInt(String inputString) {
        Map<Character,Integer> mapping = new HashMap<>();
        mapping.put('I',1);
        mapping.put('V',5);
        mapping.put('X',10);
        mapping.put('L',50);
        mapping.put('C',100);
        mapping.put('D',500);
        mapping.put('M',1000);

        int res=0;
        char s[] = inputString.toCharArray();
        boolean skipNext=false;
        for (int i=0;i<s.length;i++){
            boolean isNotLast = i < (s.length - 1);
            char c = s[i];
            
            if(skipNext){
                skipNext = false;
            }

            if (c=='I' && isNotLast && (s[i+1]=='V' || s[i+1]=='X')){
                res += (mapping.get(s[i+1])-mapping.get(c));
                skipNext = true;
            }else if(c=='X' && isNotLast && (s[i+1]=='L' || s[i+1]=='C')){
                res += (mapping.get(s[i+1])-mapping.get(c));
                skipNext = true;
            }else if (c=='C' && isNotLast && (s[i+1]=='D' || s[i+1]=='M')){
                res += (mapping.get(s[i+1])-mapping.get(c));
                skipNext = true;
            }else{
                res += mapping.get(c);
            }

            if (skipNext) i++;
        }
        return res;
    }
}