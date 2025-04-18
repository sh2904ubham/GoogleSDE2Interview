import java.util.Scanner;

public class MAin {
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

        int i = 0;
        StringBuilder result = new StringBuilder();

        while (i < n) {
            result.append(s.charAt(suffix[i]));
            i = suffix[i] + 1;
        }

        System.out.println(result.toString());
    }
}
