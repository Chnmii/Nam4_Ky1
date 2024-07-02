import java.util.*;
public class runMain {
    static Map<Node, Node> map = new HashMap<>();
    static HashSet<Node> isTham = new HashSet<>();

    public static void main(String[] args) {
        Node node = new Node(new int[][]{{2, 8, 3}, {1,0,4}, {7,6,5}});
        isTham.add(node);
        // BFD
        runBFS(node);
        // DFS
//        runDFS(node);
        Node present = new Node(new int[][]{{1, 2, 3}, {8,0,4}, {7,6,5}});
        while(!present.equals( node)){
            System.out.println(present + "\n");
            present = map.get(present);
        }
        System.out.println(node);
    }

    private static void runBFS(Node node){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        BFS(queue);
    }

    private static void runDFS(Node node){
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        DFS(stack);
    }

    private static boolean BFS(Queue<Node> queue) {
        if(queue.isEmpty()) return false;
        Node root = new Node(queue.poll());
        for(Facing f : Facing.values()){
            Node node = new Node(root);
            if(node.move(f)){
                if(!isTham.contains(node)) {
                    queue.add(node);
                    map.put(node, root);
                    isTham.add(node);
                }
                if(node.checkFinish()) return true;
            }
        }
        return BFS(queue);
    }

    private static boolean DFS(Stack<Node> stack){
        if(stack.isEmpty()) return false;
        Node root = new Node(stack.pop());
        for(Facing f : Facing.values()){
            Node node = new Node(root);
            if(node.move(f)){
                if(!isTham.contains(node)) {
                    stack.add(node);
                    map.put(node, root);
                    isTham.add(node);
                }
                if(node.checkFinish()) return true;
            }
        }
        return DFS(stack);
    }
}
