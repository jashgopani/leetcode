/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node,Node> clones = new HashMap<>();
        return clone(node,clones);
    }
    public Node clone(Node node, Map<Node,Node> clones){
        if (null==node) return null;

        if (clones.containsKey(node)) return clones.get(node);

        Node copy = new Node(node.val);
        clones.put(node,copy);
        for(Node n:node.neighbors){
            copy.neighbors.add(clone(n,clones));
        }
        return copy;
    }
}