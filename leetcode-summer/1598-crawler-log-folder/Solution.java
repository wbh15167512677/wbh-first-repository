 class Solution {
    public int minOperations(String[] logs) {
        int depth = 0;

        for (String log : logs) {
            if (log.equals("../")) {
                // Move to the parent folder, but cannot go above the main folder
                if (depth > 0) {
                    depth--;
                }
            } else if (log.equals("./")) {
                // Stay in the same folder
                continue;
            } else {
                // Move into a child folder
                depth++;
            }
        }

        return depth;
    }
}