class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        f(ans, new ArrayList<>(), s, 0);
        return ans;
    }
    public void f(List<List<String>> ans, List<String> ds, String s, int idx){
        if(idx == s.length()){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = idx; i<s.length(); i++){
            if(isPalindrome(s, idx, i)){
                ds.add(s.substring(idx, i+1));
                f(ans, ds, s, i+1);
                ds.remove(ds.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int start, int end){
        while(start<end){
            if(s.charAt(start)!= s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
