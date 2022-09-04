package com.ehsegohc.ui;
import javax.swing.*;
import javax.swing.JMenuItem;
import java.util.Random;


public class GameJFrame extends JFrame {
    int[][] data = new int[4][4];

    public GameJFrame() {
        //初始化界面
        initFrame();
        //初始化菜单
        initJMenu();
        //初始化数据（打乱）
        initData();
        //初始化图片（按照打乱
        initImage();

        //显示图面
        this.setVisible(true);
    }


    public void initData() {
    //给二维数组添加随机数据
    int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    Random r = new Random();
    for(int i = 0; i<tempArr.length;i++){
        int index =r.nextInt(tempArr.length);
        int temp = tempArr[i];
        tempArr[i] = tempArr[index];
        tempArr[index] = temp;
    }
    for (int i = 0; i < tempArr.length; i++) {
            data[i/4][i%4] = tempArr[i];
        }

}


    private void initImage() {
        //创建一个图片ImageIcon的对象
        //创建一个管理容器
        //合并两行代码
        //指定图片位置
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = data[i][j];
                JLabel jLabel1 = new JLabel(new ImageIcon("C:\\Users\\game of pingtu v3.0\\image\\animal\\animal3\\"+num+".jpg"));
                jLabel1.setBounds(105 * j, 105 * i, 105, 105);
                //把管理容器添加到界面中
                //this.add(jLabel);
                this.getContentPane().add(jLabel1);
            }

        }
    }


    private void initFrame() {
        //设置界面的宽高
        this.setSize(603,680);
        //设置界面的标题
        this.setTitle(("拼图单机版 v1.0"));
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(3);
        //取消默认的居中放置，只有取消了才会按照xy轴形式添加组件
        this.setLayout(null);
    }

    private void initJMenu() {
        //初始化菜单
        JMenuBar jmenuBar = new JMenuBar();

        JMenu functionJmenu = new JMenu("功能");
        JMenu aboutJmenu = new JMenu("关于我们");

        JMenuItem replayItem = new JMenuItem("重新游戏");
        JMenuItem reloginItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");
        JMenuItem accountItem = new JMenuItem("公众号");

        //添加菜单关系
        functionJmenu.add(replayItem);
        functionJmenu.add(reloginItem);
        functionJmenu.add(closeItem);

        aboutJmenu.add(accountItem);

        jmenuBar.add(functionJmenu);
        jmenuBar.add(aboutJmenu);

        //给整个界面设置菜单
        this.setJMenuBar(jmenuBar);
    }


}
