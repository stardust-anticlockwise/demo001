package star;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class ThreadClass extends Thread{

    public Graphics g;
    public ArrayList<Ball> balls =new ArrayList<>();

    //用构造器传参的办法将画布传入ThreadClass类中
    public ThreadClass(Graphics g,ArrayList<Ball> balls){
        this.g=g;
        this.balls=balls;
    }
    public void run(){
        while(true){
//            g.setColor(Color.white);
//            g.fillRect(300,0,600,900);
            for(int i=0;i<balls.size();i++){
                g.setColor(Color.black);
                g.fillOval(balls.get(i).location.x,balls.get(i).location.y,30,30);
                balls.get(i).move();
            }
            try{
                Thread.sleep(30);
            }catch(Exception ef){
            }
        }
    }

}