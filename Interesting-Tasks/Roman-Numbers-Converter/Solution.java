class Solution {

    public int romanToInt(String s) {
        int[] arabics = {1000, 500, 100, 50, 10, 5, 1};
        char[] romanStatic = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        List<Character> romanDyn = new ArrayList<>();
        for (int i = 0; i < romanStatic.length; i++) {
            romanDyn.add(romanStatic[i]);
        }

        int lastNumber = arabics[romanDyn.indexOf(s.charAt(0))];
        int num = lastNumber;
        for (int i = 1; i < s.length(); i++) {
            int index = romanDyn.indexOf(s.charAt(i));
            num += arabics[index];
            if (lastNumber < arabics[index])
                num -= 2 * lastNumber;
            lastNumber = arabics[index];
        }

        return num;
    }
   
    public static String intToRoman(int num) {
        int[] arabics = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arabics.length; i++) {
            while (num - arabics[i] >= 0) {
                sb.append(roman[i]);
                num = num - arabics[i];
            }
        }

        return sb.toString();
    }
}
