import javafx.util.Pair;
import java.util.*;
public class BFS_DFS {
    static Map<PhuCuop, PhuCuop> map = new HashMap<>();
    static HashSet<PhuCuop> isTham = new HashSet<>();
    static List<Pair<Integer, Integer>> c = new ArrayList<>();
    public static int check(PhuCuop s){
        if(isTham.contains(s)) return -1;
        if(s.getCuop() == 0 && s.getPhu() == 0) return 0;
        if((s.getPhu() <= 3) && (s.getCuop() <= 3) && (s.getPhu() >= 0) && (s.getCuop() >= 0)){
            if(s.getPhu() == s.getCuop() || s.getPhu() == 0 || s.getPhu() == 3) return 1;
        }
        return -1;
    }
    public static boolean BFS(Queue<PhuCuop> queue) {
        if(queue.isEmpty()) return false;
        PhuCuop pc = queue.poll();
        for (Pair<Integer, Integer> i : c) {
            PhuCuop newPC;
            if(pc.isBo()){
                newPC = new PhuCuop(pc.getPhu() - i.getKey(), pc.getCuop() - i.getValue(), false);
            }
            else{
                newPC = new PhuCuop(pc.getPhu() + i.getKey(), pc.getCuop() + i.getValue(), true);
            }
            int check = check(newPC);
            if (check == 1) {
                isTham.add(newPC);
                queue.add(newPC);
                map.put(newPC, pc);
            }
            else if(check== 0){
                map.put(newPC, pc);
                return true;
            }
        }
        return BFS(queue);
    }

    public static boolean DFS(Stack<PhuCuop> stack){
        if(stack.isEmpty()) return false;
        PhuCuop pc = stack.peek();
        for (Pair<Integer, Integer> i : c) {
            PhuCuop newPC;
            if(pc.isBo()){
                newPC = new PhuCuop(pc.getPhu() - i.getKey(), pc.getCuop() - i.getValue(), false);
            }
            else{
                newPC = new PhuCuop(pc.getPhu() + i.getKey(), pc.getCuop() + i.getValue(), true);
            }
            int check = check(newPC);
            if (check == 1) {
                isTham.add(newPC);
                stack.add(newPC);
                map.put(newPC, pc);
            }
            else if(check== 0){
                map.put(newPC, pc);
                return true;
            }
        }
        return DFS(stack);
    }
    public static void runBFS(){
        PhuCuop p = new PhuCuop(3, 3, true);
        isTham.add(p);
        Queue<PhuCuop> queue = new ArrayDeque<>();
        queue.add(p);
        boolean kq = BFS(queue);
        if(kq){
            Stack<PhuCuop> stack = new Stack<>();

            PhuCuop s = new PhuCuop(0,0,false);
            do{
                stack.add(s);
                s = map.get(s);
            }while(s != p);
            System.out.println("Cần " + stack.size() + " bước chuyển. Cách chuyển: ");
            System.out.println(p);
            while (!stack.isEmpty()){
                System.out.println( stack.pop());
            }
        }
        else {
            System.out.println("Không chuyển được!");
        }
    }
    public static void runDFS(){
        PhuCuop p = new PhuCuop(3, 3, true);
        isTham.add(p);
        Stack<PhuCuop> stack = new Stack<>();
        stack.push(p);
        boolean kq = DFS(stack);
        if(kq){
            Stack<PhuCuop> st = new Stack<>();

            PhuCuop s = new PhuCuop(0,0,false);
            do{
                st.add(s);
                s = map.get(s);
            }while(s != p);
            System.out.println("Cần " + st.size() + " bước chuyển. Cách chuyển: ");
            System.out.println(p);
            while (!st.isEmpty()){
                System.out.println( st.pop());
            }
        }
        else {
            System.out.println("Không chuyển được!");
        }

        }
    public static void main(String[] args){

        c.add(new Pair<>(1, 0));
        c.add(new Pair<>(0, 1));
        c.add(new Pair<>(1, 1));
        c.add(new Pair<>(2, 0));
        c.add(new Pair<>(0, 2));


        // BFS
        //runBFS();

        //DFS
        runDFS();
    }
}
