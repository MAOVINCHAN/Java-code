package com.learn.Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class LoginCode {
    private static final int width = 100;
    private static final int height = 30;
    private static final Random random = new Random();
    private static final String[] fonts = {"楷体", "行书", "隶书", "宋体", "微软雅黑"};
    private static final String codes = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final Color bgColor = new Color(255, 255, 255);
    private static String text;
    private static Color randomColor() {
        int r = random.nextInt(155);
        int g = random.nextInt(155);
        int b = random.nextInt(155);
        return new Color(r, g, b);
    }

    private static Font randomFont() {
        int i = random.nextInt(fonts.length);
        String font = fonts[i];
        int style = random.nextInt(4);
        int size = random.nextInt(5) + 24;
        return new Font(font, style, size);
    }
    private static char randomCode() {
        return codes.charAt(random.nextInt(codes.length()));
    }

    private static BufferedImage createImage() {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D context = (Graphics2D) image.getGraphics();
        context.setColor(bgColor);
        context.fillRect(0, 0, width, height);
        return image;
    }

    private static void drawLine(BufferedImage image) {
        Graphics2D context = (Graphics2D) image.getGraphics();
        for (int i = 0; i < 4; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);

            context.setColor(randomColor());
            context.setStroke(new BasicStroke(1.5f));
            context.drawLine(x1, y1, x2, y2);
        }
    }

    public static BufferedImage getImage() {
        BufferedImage image = createImage();
        Graphics2D context = (Graphics2D) image.getGraphics();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            String c = randomCode() + "";
            sb.append(c);

            float x = i * width * 1.0f / 4;

            context.setColor(randomColor());
            context.setFont(randomFont());
            context.drawString(c, x, height - 8);
        }
        text = sb.toString();
        drawLine(image);
        return image;
    }

    public static String getText() {
        return text;
    }

    public static void output(BufferedImage image, OutputStream out) throws IOException {
        ImageIO.write(image, "JPEG", out);
    }
}
