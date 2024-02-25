class Solution {
    public static String p = "()";
    public List<String> generateParenthesis(int n) {
        Set<String> combinations = new HashSet<>();
        combinations.add(p);
        for(int i=1;i<n;i++){
            combinations = generateNewCombinations(combinations);
        }
        return new ArrayList<>(combinations);
    }

    public Set<String> generateNewCombinations(Set<String> oldCombinations){
        Set<String> newCombinations = new HashSet<>();
        for(String c: oldCombinations){
            for(int i=0;i<c.length();i++){
                newCombinations.add(new StringBuilder(c).insert(i,p).toString());
            }
        }
        return newCombinations;
    }
}