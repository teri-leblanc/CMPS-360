package inheritance;


public class point3d extends point {

    private int z;
    
    public point3d() {
        super();
        z = 0;
    }
    
    public point3d(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
    
    public int getZ() {
        return z;
    }   
    
}
