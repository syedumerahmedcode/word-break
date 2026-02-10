import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        /**
         * solved using dynamic programming
         */
        // Why s.length() + 1? Because we are using dp[0] as our base case
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        // Why set? Because our lookup time will be faster
        Set<String> wordSet = new HashSet<>(wordDict);

        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];

        
    }

}
