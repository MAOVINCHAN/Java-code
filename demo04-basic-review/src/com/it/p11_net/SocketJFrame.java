package com.it.p11_net;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SocketJFrame extends JFrame implements ActionListener {
    public Container container=null;
    JTextField jTextField=new JTextField();//文本输入框
    JButton login=new JButton("登录");
    static JTextArea jTextArea=new JTextArea();//聊天界面文本显示框
    public SocketJFrame(){
        //设置图标
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("TalkWirhMyFriend\\src\\image\\坤坤.jpg"));
        //初始化界面
        initJFrame();
        //初始化组件
        initView();
        this.setVisible(true);
    }
    public void initJButton(){
        login.setBounds(100,90,80,30);
        login.addActionListener(this::loginAction);//添加监听事件
        container.add(login);
    }
    public void initView(){
        //设置文字
        Font codeFont=new Font(null,1,14);
        JLabel code=new JLabel("用户名");
        code.setBounds(90,20,100,40);
        code.setFont(codeFont);
        code.setBackground(Color.BLACK);
        container.add(code);
        //设置输入框
        jTextField.setBounds(90,50,150,30);
        container.add(jTextField);
        //按钮
        initJButton();
    }
    public void initJFrame() {
        this.setSize(300, 200);//设置大小
        this.setTitle("聊天小程序");//设置标题
        this.setDefaultCloseOperation(3);//设置关闭模式
        this.setLocationRelativeTo(null);//设置位置居中
        this.setAlwaysOnTop(true);//设置置顶
        container=this.getContentPane();//获取界面隐藏容器
        container.setLayout(null);//取消内部默认的坐标
        container.setBackground(Color.WHITE);//设置背景颜色
    }
    public JScrollPane initJTextArea(){
        //文本显示器
        jTextArea.setEnabled(false);//设置为不可编辑
        jTextArea.setLineWrap(true);//自动换行
        jTextArea.setWrapStyleWord(true);//单词边界换行
        jTextArea.setFont(new Font(null,1,16));
        jTextArea.setBackground(Color.gray);
        //添加滚动器
        JScrollPane jsp=new JScrollPane(jTextArea);
        jsp.setBounds(30,30,500,300);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        return jsp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public void loginAction(ActionEvent e){//登录
        System.out.println("登录");
        this.setVisible(false);
        //启动聊天界面
        MainJFrame mj=new MainJFrame(jTextField.getText(),jTextArea);
        JScrollPane jsp=initJTextArea();
        mj.container.add(jsp);
    }
}
class Main{
    public static void main(String[] args) {
        new SocketJFrame();
    }
}