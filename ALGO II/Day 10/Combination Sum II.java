class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (validate(candidates, target)) return result;

        Arrays.sort(candidates); // critical to skip duplicates
        dfs(result, new ArrayList<>(), candidates, 0, target);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list,
                     int[] candidates, int index, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        // for loop, where dfs is performed
        for (int i = index; i < candidates.length; i++) {
            // ensures at same for loop round, the same item (sorted && neighbor) won't be picked 2 times
            if (i > index && candidates[i] == candidates[i - 1]) continue;

            int value = candidates[i];
            list.add(value);
            if (target - value >= 0) dfs(result, list, candidates, i + 1, target - value);
            list.remove(list.size() - 1); // backtrack
        }
    }

    private boolean validate(int[] candidates, int target) {
        return candidates == null || candidates.length == 0 || target <= 0;
    }
}


