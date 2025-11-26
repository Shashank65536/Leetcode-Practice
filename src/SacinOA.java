import java.io.*;
import java.util.*;

public class SacinOA {

    public static String mergePalindromes(String s1, String s2) {
        int[] f1 = new int[26], f2 = new int[26];

        // count only lowercase letters
        for (char c : s1.toCharArray()) if (c >= 'a' && c <= 'z') f1[c - 'a']++;
        for (char c : s2.toCharArray()) if (c >= 'a' && c <= 'z') f2[c - 'a']++;

        int[] basePairs = new int[26];
        int baseLen = 0;
        for (int i = 0; i < 26; i++) {
            basePairs[i] = f1[i] / 2 + f2[i] / 2;
            baseLen += basePairs[i] * 2;
        }

        List<Integer> odd1 = new ArrayList<>(), odd2 = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if ((f1[i] & 1) == 1) odd1.add(i);
            if ((f2[i] & 1) == 1) odd2.add(i);
        }
        odd1.add(-1);
        odd2.add(-1);

        String best = "";
        int bestLen = -1;

        for (int o1 : odd1) {
            for (int o2 : odd2) {
                int[] cnt = new int[26];
                for (int i = 0; i < 26; i++) cnt[i] = basePairs[i] * 2;

                int extraLen = 0, center = -1;
                if (o1 != -1 && o1 == o2) {
                    cnt[o1] += 2;                    // make a new pair
                    extraLen = 2;
                } else {
                    if (o1 != -1 || o2 != -1) {
                        center = (o1 == -1) ? o2 : (o2 == -1 ? o1 : Math.min(o1, o2));
                        cnt[center] += 1;
                        extraLen = 1;
                    }
                }

                int candLen = baseLen + extraLen;
                if (candLen < bestLen) continue;

                String cand = buildPalindrome(cnt, center);
                if (candLen > bestLen || cand.compareTo(best) < 0) {
                    bestLen = candLen;
                    best = cand;
                }
            }
        }
        return best;
    }

    private static String buildPalindrome(int[] cnt, int centerIdx) {
        StringBuilder left = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int k = 0, p = cnt[i] / 2; k < p; k++)
                left.append((char) ('a' + i));
        }
        StringBuilder res = new StringBuilder();
        res.append(left);
        if (centerIdx != -1 && (cnt[centerIdx] & 1) == 1)
            res.append((char) ('a' + centerIdx));
        res.append(left.reverse());
        return res.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        System.out.println(mergePalindromes(s1, s2));
    }
}
