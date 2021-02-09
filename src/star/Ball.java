package star;
public class Ball {
    public Vector location;//位置
    public Vector speed;//速度
    public Vector acce;//加速度

    //构造器传参，设定小球的基本参数
    public Ball(Vector location,Vector speed,Vector acce){
        this.location=location;
        this.speed=speed;
        this.acce=acce;
    }

    //小球移动，这是整个部分的关键！！！每画完一次小球就调用一次move函数，让小球依据速度和加速度来改变一次位置
    public void move(){
        this.speed.x+=acce.x;//每调用一次move函数小球的速度就和加速度做一次加法
        this.speed.y+=acce.y;
        this.location.x+=speed.x;//每调用一次move函数小球的位置坐标就和速度做一次加法
        this.location.y+=speed.y;
    }
}
