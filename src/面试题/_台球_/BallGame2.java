package 面试题._台球_;

import java.awt.*;
import javax.swing.*;


public class BallGame2 extends JFrame {
    //加载图片
    private Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
    private Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");

    //定义小球移动的坐标
    private Calculate calculate;

    public BallGame2(Calculate calculate) throws HeadlessException {
        this.calculate = calculate;
    }

    //绘制窗口
    public void paint(Graphics graphics) {
        System.out.println("窗口被画了一次");

        //double v = 400;
/*        double time = (System.currentTimeMillis()-startTime)/1000;
        //double timeLimitX = (500 - 40 -30 - 40 + 40)/(v* Math.cos(degree));
        double ballX = Math.abs((ballXStart + time *v * Math.cos(degree))%(2*(865 - 40 -30 - 40)) -(865 - 40-70 ))+30;
        double ballY = Math.abs((ballYStart + time *v * Math.sin(degree))%(2*(500 - 40 -30 - 40 - 40)) -(500 - 40 -30 -80))+80;*/
        double[] ballLocation = calculate.locationMethod();
        double ballY = ballLocation[1];
        double ballX = ballLocation[0];
        System.out.println("ballY = " + ballY);
        System.out.println("ballX = " + ballX);
        graphics.drawImage(desk, 0, 0, null);//画出桌台
        graphics.drawImage(ball, (int) ballX, (int) ballY, null);//画出小球


/*        //小球上下移动 500是窗口高度，40是桌子的边框，30是小球的直径，另一个40是标题栏的高度
        if(ballY < 40 + 40 || ballY > 500 - 40 -30) {
            degree = -degree;
        }
        //小球左右移动
        if(ballX < 40 || ballX > 865 - 40 -30) {
            degree = 3.14-degree;
        }*/


    }

    //加载窗口
    void launchFrame() {
        setSize(865, 500);//设置长宽
        setLocation(50, 50);//设置坐标轴
        setVisible(true);//启用窗口

        //重画窗口，每秒画25次
        while (true) {
            repaint();
            try {
                Thread.sleep(40);//40ms,1s = 1000ms
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    //main方法是程序执行的入口
    public static void main(String[] args) {
        System.out.println("第一个桌球游戏");
        Calculate calculate = new Calculate(200, 100, 300, -3);
        BallGame2 ballGame = new BallGame2(calculate);
        ballGame.launchFrame();
    }
}

