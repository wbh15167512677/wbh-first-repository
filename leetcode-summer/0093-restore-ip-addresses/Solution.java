import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        backtrack(s, 0, 0, new StringBuilder(), result);

        return result;
    }

    private void backtrack(String s, int index, int part,
                           StringBuilder path, List<String> result) {
        if (part == 4) {
            if (index == s.length()) {
                result.add(path.substring(0, path.length() - 1));
            }
            return;
        }

        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length()) {
                break;
            }

            String segment = s.substring(index, index + len);

            // Skip segments with leading zeros, such as "01" or "001"
            if (segment.length() > 1 && segment.charAt(0) == '0') {
                continue;
            }

            // Each segment must be between 0 and 255
            int value = Integer.parseInt(segment);
            if (value > 255) {
                continue;
            }

            int oldLength = path.length();

            path.append(segment);
            path.append('.');

            backtrack(s, index + len, part + 1, path, result);

            path.setLength(oldLength);
        }
    }
}