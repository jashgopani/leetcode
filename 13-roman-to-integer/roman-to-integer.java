class Solution {
    public int romanToInt(String s) {
        return tokenize(s);
    }
    public int tokenize(String s) {
        int num = 0;
        int prev = 0;

        for (int i = 0; i < s.length(); i++) {
            int current = tokens(s.charAt(i));
            
            if (prev < current) {
                num += current - (2 * prev);
            } else {
                num += current;
            }
            prev = current;
        }
        return num;
    }
    public int tokens(char c) {
        switch(c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }
}