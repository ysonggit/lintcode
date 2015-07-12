/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */
    public void dfs(
        DirectedGraphNode cur, 
        List<Integer> path, 
        HashMap<Integer, Boolean> visited)
    {
        if(visited.get(cur.label)) return;
        visited.put(cur.label, true);
        path.add(cur.label);
        for(DirectedGraphNode next : cur.neighbors){
            dfs(next, path, visited);
        }
    }
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        int n = nodes.size();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n==0) return res;
        // convert the directed graph to the undirected graph
        for(DirectedGraphNode cur : nodes){
            for(DirectedGraphNode nb : cur.neighbors){
                if(!nb.neighbors.contains(cur)) nb.neighbors.add(cur);   
            }
        }
        
        HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
        for(DirectedGraphNode cur : nodes){
            visited.put(cur.label, false);
        }
        
        for(DirectedGraphNode cur : nodes){
            if(visited.get(cur.label)) continue;
            List<Integer> path = new ArrayList<Integer>();
            dfs(cur, path, visited);
            Collections.sort(path);
            res.add(path);
        }
        return res;
    }
}
