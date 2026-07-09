class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();

        for (String path : paths) {
            String[] parts = path.split(" ");
            String dir = parts[0];

            for (int i = 1; i < parts.length; i++) {
                String fileInfo = parts[i];

                int leftParen = fileInfo.indexOf('(');
                int rightParen = fileInfo.indexOf(')');

                String fileName = fileInfo.substring(0, leftParen);
                String content = fileInfo.substring(leftParen + 1, rightParen);

                String fullPath = dir + "/" + fileName;

                // Group file paths by the same file content
                map.putIfAbsent(content, new ArrayList<>());
                map.get(content).add(fullPath);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for (List<String> group : map.values()) {
            // Only groups with at least 2 files are duplicates
            if (group.size() > 1) {
                result.add(group);
            }
        }

        return result;
    }
}