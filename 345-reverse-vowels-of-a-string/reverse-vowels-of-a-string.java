class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('A');
        vowels.add('e');
        vowels.add('E');
        vowels.add('i');
        vowels.add('I');
        vowels.add('o');
        vowels.add('O');
        vowels.add('u');
        vowels.add('U');
        int n=s.length();
        StringBuilder sb = new StringBuilder(s);
        for(int i=0,j=n-1;i<=j;){
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if(vowels.contains(ci) && vowels.contains(cj)){
                sb.setCharAt(i,cj);
                sb.setCharAt(j,ci);
                i++;
                j--;
            }else if(vowels.contains(ci)){
                j--;
            }else if(vowels.contains(cj)){
                i++;
            }else{
                i++;
                j--;
            }
        }
        return sb.toString();
    }
}