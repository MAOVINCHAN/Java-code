package com.project.stusys.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class VerificationCode {

	private int width = 100;// 生成验证码图片的宽度
	private int height = 30;// 生成验证码图片的高度
	//生成的图片中的文本字体
	private String[] fontNames = { "宋体", "楷体", "隶书", "微软雅黑" };
	private Color bgColor = new Color(255, 255, 255);// 定义验证码图片的背景颜色为白色
	private Random random = new Random();
	//将来绘制到图片上的字符
	private String codes = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String text;// 记录随机字符串

	/**
	 * 获取一个随意颜色
	 * 
	 * @return
	 */
	private Color randomColor() {
		int red = random.nextInt(150);
		int green = random.nextInt(150);
		int blue = random.nextInt(150);
		return new Color(red, green, blue);
	}

	/**
	 * 获取一个随机字体
	 * 
	 * @return
	 */
	private Font randomFont() {
		//获取一个随机的字体
		String name = fontNames[random.nextInt(fontNames.length)];
		//随机获取字体样式：斜体、加粗
		int style = random.nextInt(4);
		//获取字体大小
		int size = random.nextInt(5) + 24;
		return new Font(name, style, size);
	}

	/**
	 * 获取一个随机字符
	 * 
	 * @return
	 */
	private char randomChar() {
		return codes.charAt(random.nextInt(codes.length()));
	}

	/**
	 * 创建一个空白的BufferedImage对象
	 * 
	 * @return
	 */
	private BufferedImage createImage() {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//获取一个画笔
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		g2.setColor(bgColor);// 设置验证码图片的背景颜色
		//绘制一个带有填充的矩形
		g2.fillRect(0, 0, width, height);
		return image;
	}

	/**
	 * 这个就是一个图片对象
	 * @return
	 */
	public BufferedImage getImage() {
		BufferedImage image = createImage();
		//拿到画笔
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		//这个对象用来存储文本
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			//获取一个随机字符
			String s = randomChar() + "";
			sb.append(s);
			g2.setColor(randomColor());
			g2.setFont(randomFont());
			float x = i * width * 1.0f / 4;
			g2.drawString(s, x, height - 8);
		}
		this.text = sb.toString();
		drawLine(image);
		return image;
	}

	/**
	 * 绘制干扰线
	 * 
	 * @param image
	 */
	private void drawLine(BufferedImage image) {
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		int num = 5;
		for (int i = 0; i < num; i++) {
			int x1 = random.nextInt(width);
			int y1 = random.nextInt(height);
			int x2 = random.nextInt(width);
			int y2 = random.nextInt(height);
			g2.setColor(randomColor());
			g2.setStroke(new BasicStroke(1.5f));
			g2.drawLine(x1, y1, x2, y2);
		}
	}

	public String getText() {
		return text;
	}

	public static void output(BufferedImage image, OutputStream out) throws IOException {
		ImageIO.write(image, "JPEG", out);
	}
}