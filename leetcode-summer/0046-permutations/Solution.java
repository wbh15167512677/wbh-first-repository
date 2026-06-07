import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, new boolean[nums.length], new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums, boolean[] used,
                           List<Integer> path, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;

            backtrack(nums, used, path, result);

            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}