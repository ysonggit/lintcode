public class Solution {
    /**
     * @param buildings: A list of lists of integers
     * @return: Find the outline of those buildings
     */
    class SegTreeNode{
        int start;
        int end;
        int height;
        SegTreeNode left;
        SegTreeNode right;
        SegTreeNode(){}
        SegTreeNode(int start, int end, int height){
            // should do input check here
            this.start = start;
            this.end = end;
            this.height = height;
            this.left = null;
            this.right = null;
        }
        public boolean overlap(SegTreeNode n){
            if(start> n.end || end < n.start) return false;
            return true;
        }
    }
    
    class SegTree{
        SegTreeNode root; 
        SegTree(){root = null;};
        public void insert(SegTreeNode node){
            root = insert(root, node);
        }
        public SegTreeNode insert(SegTreeNode parent, SegTreeNode node){
            if(parent == null) {
                parent = new SegTreeNode(node.start, node.end, node.height);
                return parent;
            }
            SegTreeNode cur = parent;
            // check overlap
            // if no overlap: insert to either left or right, otherwise, split 
            if(!cur.overlap(node)){
                if(node.end<cur.start){
                    cur.left = insert(cur.left, node);
                }else{
                    // node.start > cur.end
                    cur.right = insert(cur.right, node);
                }
            }else{
                // overlap 
                // if range of node is contained by the range of cur
                // do nothing but return
                if(node.start>=cur.start && node.end<= cur.end){
                    return cur;
                }
                if(node.height == cur.height){ //must merge the buildings with the same height
                    cur.start = Math.min(cur.start, node.start);
                    cur.end = Math.max(cur.end, node.end);
                    return cur;
                }
                
                if(node.end <= cur.end && node.start < cur.start) { 
                    SegTreeNode splitted_left = new SegTreeNode(node.start, cur.start, node.height);
                    cur.left = insert(cur.left, splitted_left);
                }
                if(node.start >= cur.start && node.end >cur.end){
                    SegTreeNode splitted_right = new SegTreeNode(cur.end, node.end, node.height);
                    cur.right = insert(cur.right, splitted_right);
                }
                if(node.start < cur.start && node.end > cur.end){
                    SegTreeNode splitted_left = new SegTreeNode(node.start, cur.start, node.height);
                    cur.left = insert(cur.left, splitted_left);  
                    SegTreeNode splitted_right = new SegTreeNode(cur.end, node.end, node.height);
                    cur.right = insert(cur.right, splitted_right);
                }
            }
            return cur;
        }
        
        ArrayList<ArrayList<Integer>> vals = new ArrayList<ArrayList<Integer>>();
        public void printSegTree(SegTreeNode node){
            if(node == null) return;
            printSegTree(node.left);
            ArrayList<Integer> cur_val = new ArrayList<Integer>(Arrays.asList(node.start, node.end, node.height));
            vals.add(cur_val);
            printSegTree(node.right);
        }
    }
    
    class CmpSegTreeNode implements Comparator<SegTreeNode>{
        public int compare(SegTreeNode a, SegTreeNode b){
            return b.height-a.height;
        }  
    };
    
    public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        int n = buildings.length;
        ArrayList<ArrayList<Integer>> skyline = new ArrayList<ArrayList<Integer>>();
        if (n==0) return skyline;
        ArrayList<SegTreeNode> nodes = new ArrayList<SegTreeNode>();
        for(int i=0; i<n; i++){
            nodes.add(new SegTreeNode(buildings[i][0], buildings[i][1], buildings[i][2]));
        }
        Collections.sort(nodes, new CmpSegTreeNode());
        SegTree st = new SegTree();
        for(SegTreeNode node : nodes){
            st.insert(node);
        }
        st.printSegTree(st.root);
        return st.vals;
    }
}

