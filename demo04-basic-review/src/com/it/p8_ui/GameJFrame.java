package com.it.p8_ui;

import javax.swing.*;
import java.awt.*;

public class GameJFrame extends JFrame {
    public GameJFrame() throws HeadlessException {
        // 初始化界面
        initFrame();

        // 初始化菜单栏
        initMenuBar();

        // 初始化背景
        initImage();

        // 展示界面，放在最后
        this.setVisible(true);
    }

    private void initImage() {
        ImageIcon icon = new ImageIcon("C:\\Users\\admin\\Desktop\\project-J\\demo04-basic-review\\images\\bg.png");
        JLabel jLabel = new JLabel(icon);
        Container contentPane = this.getContentPane();
        jLabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
        contentPane.add(jLabel);
    }

    private void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu funcMenu = new JMenu("功能");
        JMenu aboutUsMenu = new JMenu("关于我们");

        JMenuItem replayItem = new JMenuItem("重新游戏");
        JMenuItem loginItem = new JMenuItem("重新登录");
        JMenuItem exitItem = new JMenuItem("退出游戏");

        JMenuItem accountItem = new JMenuItem("公众号");

        aboutUsMenu.add(accountItem);

        funcMenu.add(replayItem);
        funcMenu.add(loginItem);
        funcMenu.add(exitItem);

        menuBar.add(funcMenu);
        menuBar.add(aboutUsMenu);

        this.setJMenuBar(menuBar);
    }

    private void initFrame() {
        this.setSize(603, 680);
        this.setTitle("单机游戏");
        this.setAlwaysOnTop(true); // 界面置顶
        this.setLocationRelativeTo(null); // 居中
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // 关闭操作时结束程序
        this.setLayout(null); // 取消默认的居中布局，使用x，y值布局
    }
}
