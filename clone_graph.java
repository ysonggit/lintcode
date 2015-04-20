/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null) return null;
        HashMap<Integer, UndirectedGraphNode> copied = new HashMap<Integer, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> Q = new LinkedList<UndirectedGraphNode>();
        Q.add(node);
        copied.put(node.label, new UndirectedGraphNode(node.label));
        while(!Q.isEmpty()){
            UndirectedGraphNode cur = Q.poll();
            for(UndirectedGraphNode neighbor : cur.neighbors){
                int nb_label = neighbor.label;
                if(!copied.containsKey(nb_label)){
                    copied.put(nb_label, new UndirectedGraphNode(nb_label));
                    Q.add(neighbor); // enqueue original node
                }
                // connected copied nodes
                copied.get(cur.label).neighbors.add(copied.get(nb_label));
            }
        }
        return copied.get(node.label);
    }
}
