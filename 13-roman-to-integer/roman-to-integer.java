class Solution {
    static Map<Character,Integer> mapping = new HashMap<>();
    static {
        mapping.put('I',1);
        mapping.put('V',5);
        mapping.put('X',10);
        mapping.put('L',50);
        mapping.put('C',100);
        mapping.put('D',500);
        mapping.put('M',1000);
    }

    public int romanToInt(String s) {
        int num = 0;
        int prev = 0;

        for (int i = 0; i < s.length(); i++) {
            int current = mapping.get(s.charAt(i));
            
            if (prev < current) {
                num += current - (2 * prev);
            } else {
                num += current;
            }
            prev = current;
        }
        return num;
    }
}