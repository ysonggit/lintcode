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
     *  L ← Empty list that will contain the sorted elements
        S ← Set of all nodes with no incoming edges
        while S is non-empty do
            remove a node n from S
            add n to tail of L
            for each node m with an edge e from n to m do
                remove edge e from the graph
                if m has no other incoming edges then
                    insert m into S
        if graph has edges then
            return error (graph has at least one cycle)
        else 
            return L (a topologically sorted order)
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        HashSet<Integer> children = new HashSet<Integer>();
        HashMap<Integer, HashSet<Integer>> child_parents = new HashMap<Integer, HashSet<Integer>>();
        for(DirectedGraphNode node : graph){
            for(DirectedGraphNode child : node.neighbors){
                if(!children.contains(child.label)){
                    children.add(child.label);
                }
                if(!child_parents.containsKey(child.label)){
                    HashSet<Integer> parents = new HashSet<Integer>();
                    parents.add(node.label);
                    child_parents.put(child.label, parents);
                }else{
                    child_parents.get(child.label).add(node.label);
                }
            }
        }
        Queue<DirectedGraphNode> src_nodes = new LinkedList<>(); //nodes without incoming edges
        for(DirectedGraphNode n : graph){
            if(!children.contains(n.label) ) {
                src_nodes.add(n);
            }
        }
        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        while(!src_nodes.isEmpty()){
            DirectedGraphNode n = src_nodes.poll(); 
            res.add(n);
            for(DirectedGraphNode m : n.neighbors){
                child_parents.get(m.label).remove(n.label);
                if(child_parents.get(m.label).isEmpty()){
                    src_nodes.add(m);
                }
            }
        }
        return res;
    }
}

