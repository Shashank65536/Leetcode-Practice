package DynamicProgramming;


/*The question provided involves finding the number of pairs of substrings in a string that are "almost matching." Two substrings are considered almost matching if they are identical except for one character at a specified index
𝑘
k. The task is to count the number of such pairs for a given string s and an integer k.

Key Points:
String s: Consists only of lowercase English letters.
Integer k: Specifies the index (0-based) at which the substrings may differ.
Output: The number of pairs of substrings that differ only at the k-th character.
Example:
For s = "abacaba" and k = 1, the output should be 8.

Steps to Implement:
Substring Extraction: Extract all possible substrings from the string s.
Pair Comparison: Compare each pair of substrings to check if they differ only at the k-th character.
Count Pairs: Count all such pairs that meet the condition.*/
import java.util.*;

public class varadOA1st {

    public static int solution(String s, int k) {
        int n = s.length();
        int count = 0;

        // Create a 2D DP table
        boolean[][] dp = new boolean[n][n];

        // Fill the DP table
        for (int i = 0; i < n - k; ++i) {
            for (int j = i + 1; j < n - k; ++j) {
                if (s.charAt(i + k) != s.charAt(j + k)) {
                    boolean match = true;
                    for (int l = 0; l < k; ++l) {
                        if (s.charAt(i + l) != s.charAt(j + l)) {
                            match = false;
                            break;
                        }
                    }
                    for (int l = k + 1; l <= j - i && match; ++l) {
                        if (s.charAt(i + l) != s.charAt(j + l)) {
                            match = false;
                            break;
                        }
                    }
                    if (match) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        // Count the pairs where dp[i][j] is true
        for (int i = 0; i < n - k; ++i) {
            for (int j = i + 1; j < n - k; ++j) {
                if (dp[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "abacaba";
        int k = 1;
        System.out.println(solution(s, k)); // Output: 8
    }
}

