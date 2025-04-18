import java.util.Scanner;

public class FollowUp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        int[] suffix = new int[n];
        char mx = s.charAt(n - 1);
        suffix[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) > mx) {
                mx = s.charAt(i);
                suffix[i] = i;
            } else if (s.charAt(i) == mx) {
                suffix[i] = i;
            } else {
                suffix[i] = suffix[i + 1];
            }
        }
        boolean[] used = new boolean[26];
        int i = 0;
        StringBuilder result = new StringBuilder();
        char lastAdded = '{';

        while (i < n) {
            char ch = s.charAt(suffix[i]);
            if (!used[ch - 'a'] && ch < lastAdded) {
                result.append(ch);
                used[ch - 'a'] = true;
                lastAdded = ch;
            }
            i = suffix[i] + 1;
        }

        System.out.println(result.toString());
    }
}
