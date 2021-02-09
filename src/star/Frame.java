package star;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame {
    //声明画布对象
    public Graphics g;

    public ArrayList<Ball> balls =new ArrayList<Ball>();

    //主函数
    public static void main(String[] args) {
        //创建Frame类，然后运行showFrame函数
        Frame fr=new Frame();
        fr.showFrame();
    }

    //编写窗体显示的函数
    public void showFrame(){

        //创建窗体
        JFrame jf=new JFrame();
        jf.setTitle("小球演示");//设置窗体标题
        jf.setSize(900,900);//设置窗体大小
        jf.setDefaultCloseOperation(3);//设置点击窗体右上角的叉叉后做什么操作，这里的3代表点击叉叉后关闭程序
        jf.setLocationRelativeTo(null);//设置窗体居中显示
        FlowLayout flow=new FlowLayout();//设置窗体布局为流式布局
        jf.setLayout(flow);

        Mouse mou=new Mouse();//创建监听器对象
        jf.addMouseListener(mou);//为窗体添加鼠标监听器

        JButton jbu=new JButton("START");//创建按钮，按下按钮后可以在画布中间画一个圆
        jbu.addActionListener(mou);//为按钮添加事件监听器
        jf.add(jbu);

        //设置窗体可见
        jf.setVisible(true);

        //从窗体获取画布
        g=jf.getGraphics();

        ThreadClass thc=new ThreadClass(g,balls);
        thc.start();
    }

    //创建内部类监听器（也可以重新创建一个文件编写该类）
    //创建内部类监听器（也可以重新创建一个文件编写该类）
    class Mouse implements ActionListener, MouseListener {
        int prx=0;
        int pry=0;//记录按下鼠标的点的坐标

        //重写按钮监听方法
        public void actionPerformed(ActionEvent e){}

        public void mouseClicked(MouseEvent e) {}

        public void mousePressed(MouseEvent e) {
            prx=e.getX();
            pry=e.getY();//获取按下鼠标的点的坐标
        }
        @Override
        public void mouseReleased(MouseEvent e) {
            int speedx=(int)((e.getX()-prx)/10);
            int speedy=(int)((e.getY()-pry)/10);

            Vector location=new Vector(e.getX(),e.getY());
            Vector speed=new Vector(speedx,speedy);
            Vector acce=new Vector(0,1);
            Ball ball=new Ball(location,speed,acce);
            balls.add(ball);
        }
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
    }

}
