class Palindrome {
    public static void main(String args[]) {
        String str = "121";

        StringBuilder s1 = new StringBuilder(str);
        StringBuilder s2 = new StringBuilder(str);

        s2.reverse();

        if(s1.toString().equals(s2.toString()))
            System.out.println("The string is palindrome");
        else
            System.out.println("The string is not a palindrome");
    }
}
