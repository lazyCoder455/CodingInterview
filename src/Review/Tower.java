package Review;

import java.util.Stack;

/**
 * Created by faiz on 6/23/14.
 */
public class Tower {
    private int index;
    private Stack<Integer> disks;

    public Tower(int index){
        this.index = index;
        disks = new Stack<Integer>();
    }

    public int getIndex() {
        return index;
    }

    public int getSize() {
        return disks.size();
    }

    public String toString() {
        String str = "";
        for(int i = 0; i < disks.size(); i++){
            str += disks.get(i) + "\n";
        }
        return str;
    }

    public void addDisks(int disk){
        if(disks.size() == 0){
            disks.push(disk);
        } else if(disk < disks.peek()) {
            disks.push(disk);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void moveTop(Tower other){
        other.addDisks(this.disks.pop());
    }

    public static void move(int n, Tower source, Tower buffer, Tower destination){
        if(n < 1){
            return;
        }
        move(n - 1, source, destination, buffer);
        source.moveTop(destination);
        move(n - 1, buffer, source, destination);
    }
}
