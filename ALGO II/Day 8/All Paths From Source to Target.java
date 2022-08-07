class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    int n = graph.length;
    boolean[] used = new boolean[n];
    List<List<Integer>> res = new ArrayList<>();
    dfs(res, new ArrayList<>(), graph, used, 0);
    return res;
}

void dfs(List<List<Integer>> res, List<Integer> list, int[][] graph, boolean[] used, int s) {
    used[s] = true;
    list.add(s);
    for (int i : graph[s]) {
        if (used[i]) {
            continue;
        }
        if (i + 1 == used.length) {
            List<Integer> t = new ArrayList<>();
            t.addAll(list);
            t.add(i);
            res.add(t);
        } else {
            dfs(res, list, graph, used, i);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
}