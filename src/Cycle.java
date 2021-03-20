public class Cycle {
    int numOfWheel = -1;
    public int wheel(){
        return numOfWheel;
    }
    public void ride(Cycle c){
        System.out.println("Ride a cycle of "+c.wheel()+" wheels.");
    }

    public static void main(String[] args){
        System.out.println("The results of upcasting and downcasting:");
        Cycle[] cyc={new Unicycle(),new Bicycle(),new Tricycle()};
        for(int i=0;i<cyc.length;i++) {
            cyc[i].ride(cyc[i]);
            if (cyc[i] instanceof Unicycle)
                ((Unicycle) cyc[i]).balance();
            else if (cyc[i] instanceof Bicycle)
                ((Bicycle) cyc[i]).balance();
        }
    }
}
class Unicycle extends Cycle{
    int numOfWheel=1;
    public int wheel(){ return numOfWheel; }
    public void balance(){ System.out.println("Keep balance on Unicycle."); }
}
class Bicycle extends Cycle{
    int numOfWheel=2;
    public int wheel(){ return numOfWheel; }
    public void balance(){ System.out.println("Keep balance on Bicycle."); }
}

class Tricycle extends Cycle{
    int numOfWheel=3;
    public int wheel(){ return numOfWheel; }
}
