import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtrack(result, new StringBuilder(), 0, 0, n);

        return result;
    }

    private void backtrack(List<String> result, StringBuilder path,
                           int open, int close, int n) {
        if (path.length() == n * 2) {
            result.add(path.toString());
            return;
        }

        if (open < n) {
            path.append('(');
            backtrack(result, path, open + 1, close, n);
            path.deleteCharAt(path.length() - 1);
        }

        if (close < open) {
            path.append(')');
            backtrack(result, path, open, close + 1, n);
            path.deleteCharAt(path.length() - 1);
        }
    }
}