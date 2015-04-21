/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * };
 */
public class Solution {
   /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, 
                            DirectedGraphNode s, DirectedGraphNode t) {
        if(graph.size()==0 || s==null || t== null) return false;
        if(!graph.contains(s) || !graph.contains(t) ) return false;
        Queue<DirectedGraphNode> Q = new LinkedList<DirectedGraphNode>();
        HashSet<Integer> visited = new HashSet<Integer>();
        Q.add(s);
        visited.add(s.label);
        while(!Q.isEmpty()){
            DirectedGraphNode cur = Q.poll();
            if(cur.label == t.label) return true;
            for(DirectedGraphNode neighbor : cur.neighbors){
                if(!visited.contains(neighbor.label)){
                    Q.add(neighbor);
                    visited.add(neighbor.label);
                }
            }
        }
        return false;
    }
}

