import java.util.Scanner;

public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        int n = s.length();
        int[] stack = new int[n + 1];
        int top = -1;
        int maxLength = 0;

        top++;
        stack[top] = -1;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                top++;
                stack[top] = i;
            } else {
                top--;
                if (top == -1) {
                    top++;
                    stack[top] = i;
                } else {
                    int length = i - stack[top];
                    if (length > maxLength) {
                        maxLength = length;
                    }
                }
            }
        }
        return maxLength;
    }

    public static boolean isValidInput(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '(' && c != ')') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Input : ");
        String input = scanner.nextLine();

        if (!isValidInput(input)) {
            System.out.println("Invalid input");
        } else {
            int result = longestValidParentheses(input);
            System.out.println("Length of longest valid parentheses substring: " + result);
        }
        scanner.close();
    }
}