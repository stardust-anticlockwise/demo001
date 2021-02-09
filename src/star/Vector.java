package star;
public class Vector {
    public int x;
    public int y;
    public Vector(int x,int y){
        this.x=x;
        this.y=y;
    }
    //向量的加和运算
    public void add(Vector vec){
        this.x+=vec.x;
        this.y+=vec.y;
    }
}
