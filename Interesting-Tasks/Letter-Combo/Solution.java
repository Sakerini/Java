class Solution {

     public List<String> letterCombinations(String digits) {
        
        LinkedList<String> outputArray = new LinkedList<>();

        if (digits.length() == 0) return outputArray;
        outputArray.add("");

        String[] charMap = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for (int i = 0; i < digits.length(); i++) {
            int index = Character.getNumericValue(digits.charAt(i));
            while (outputArray.peek().length() == i) {
                String permutation = outputArray.remove();
                for (char c: charMap[index].toCharArray()) {
                    outputArray.add(permutation + c);
                }
            }
        }

        return outputArray;
    }

}
