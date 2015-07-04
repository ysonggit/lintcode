/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public void dfs(UndirectedGraphNode cur, List<Integer> path, HashMap<Integer, Boolean> visited){
        if(visited.get(cur.label)) return;
        visited.put(cur.label, true);
        path.add(cur.label);
        for(UndirectedGraphNode next : cur.neighbors){
            dfs(next, path, visited);
        }
    }
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        List<List<Integer>> components = new ArrayList<List<Integer>>();
        int n = nodes.size();
        if(n==0) return components;
        // can not use boolean [] to mark visited, like visited[1] = true
        // since node value may be negative
        HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
        for(UndirectedGraphNode cur : nodes){
            visited.put(cur.label, false);
        }
        for(UndirectedGraphNode cur : nodes){
            if(visited.get(cur.label)) continue;
            List<Integer> path = new ArrayList<Integer>();
            dfs(cur, path, visited);
            Collections.sort(path); // results are sorted lists
            components.add(path);
        }
        return components;
    }
}
