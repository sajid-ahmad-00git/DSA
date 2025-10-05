package Strings;

public class Add_Strings_Without_converting_to_Int {

    public static void main(String[] args) {
        String n1 = "123";
        String n2 = "11";
        System.out.println(add(n1, n2));

    }

    public static String add(String num1, String num2) {

        StringBuilder st = new StringBuilder();
        String res = "";
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int val1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int val2 = j >= 0 ? num2.charAt(j) - '0' : 0;

            int sum = val1 + val2 + carry;
            st.append(sum % 10);
            carry = sum / 10;

            i--;
            j--;

        }
        return st.reverse().toString();
    }
}
