class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    void backtrack(List<String> list, String s, int open, int close, int max){
        if(s.length() == 2*max){
            list.add(s);
            return;
        }
        if(open<max){
            backtrack(list, s+"(", open+1, close, max);
        }
        if(close<open){
            backtrack(list, s+")", open, close+1, max);
        }
    }
}
