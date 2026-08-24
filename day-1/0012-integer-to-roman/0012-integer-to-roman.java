class Solution {
    public String intToRoman(int num) {
        List<String> romanSymbols = List.of(
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X","IX", "V", "IV","I"    
        );
        List<Integer> values = List.of(
            1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        );
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < romanSymbols.size(); i++) {
            while (num >= values.get(i)) {
                num -= values.get(i);
                result.append(romanSymbols.get(i));
            }
        }
        return result.toString();
    }
}
