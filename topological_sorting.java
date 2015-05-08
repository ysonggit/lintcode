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
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> toporder = new ArrayList<DirectedGraphNode>();
        if(graph.size()==0) return toporder;
        Queue<DirectedGraphNode> nodes_without_inedge = new LinkedList<DirectedGraphNode>();
        HashMap<Integer, DirectedGraphNode> nodes = new HashMap<Integer, DirectedGraphNode>();
        // assume node label are from 0 to n
        int indegree[] = new int [graph.size()];// indegree[i] = j means node.label i has j inedges
        for(int i=0; i<graph.size(); i++){
            DirectedGraphNode cur = graph.get(i);
            nodes.put(cur.label, cur);
            for(DirectedGraphNode neighbor : cur.neighbors){
                indegree[neighbor.label]++; 
            }
        }
        // put nodes without indegree to queue
        for(int i=0; i<indegree.length; i++){
            if(indegree[i]==0) nodes_without_inedge.offer(nodes.get(i));
        }
        while(!nodes_without_inedge.isEmpty()){
            DirectedGraphNode n = nodes_without_inedge.poll();
            toporder.add(n);
            // for each node m with edge e from n->m
            // remove e from graph 
            for(DirectedGraphNode m : n.neighbors){
                indegree[m.label]--;
                if(indegree[m.label]==0) nodes_without_inedge.offer(m);
            }
        }
        return toporder;
    }
}



