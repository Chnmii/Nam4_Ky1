import java.util.Arrays;
import java.util.Objects;
public class Node {
     int arr[][] = new int[3][3];
     int x;
     int y;
     static Facing facing;

    public Node() {
        arr = new int[][]{{2, 8, 3}, {1,0,4}, {7,6,5}};
    }
    public Node(Node node){
        for(int i=0; i<3; i++){
            for (int j = 0; j<3; j++){
               this.arr[i][j] = node.arr[i][j];
            }
        }
        this.x = node.x;
        this.y = node.y;
    }

    public Node(int[][] arr) {
        for(int i=0; i<3; i++){
            for (int j = 0; j<3; j++){
                this.arr[i][j] = arr[i][j];
            }
        }
        for(int i=0; i<3; i++){
            for (int j = 0; j<3; j++){
                if(this.arr[i][j] == 0){
                    x = i;
                    y = j;
                }
            }
        }
    }

    public boolean canMoveLeft(){
        return y > 0;
    }
    public boolean canMoveRight(){
        return y < 2;
    }
    public boolean canMoveUp(){
        return x > 0;
    }
    public boolean canMoveDown(){
        return x < 2;
    }

    public boolean move(Facing f) {
        boolean check = false;
        int i = 0;
        int j = 0;
        if (f == facing.LEFT && canMoveLeft()) {
            check = true;
            j = -1;
        } else if (f == facing.RIGHT && canMoveRight()) {
            check = true;
            j = 1;
        } else if (f == facing.UP && canMoveUp()) {
            check = true;
            i = -1;
        } else if (f == facing.DOWN && canMoveDown()) {
            check = true;
            i = 1;
        }
        if (check) {
            arr[x][y] = arr[x + i][y + j];
            arr[x + i][y + j] = 0;
            x = x + i;
            y = y + j;
            return true;
        }
        return false;
    }
    public boolean checkFinish(){
        for(int i = 0; i<2; i++){
                if(arr[0][i] != i+1 || arr[2][i] != 7-i) return false;;
            }
        return arr[1][0] == 8 && arr[1][2] == 4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x && y == node.y && Arrays.deepEquals(arr, node.arr);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(x, y);
        result = 31 * result + Arrays.deepHashCode(arr);
        return result;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                s += arr[i][j] + " ";
            }
            s += "\n";
        }
        return s;
    }
}
