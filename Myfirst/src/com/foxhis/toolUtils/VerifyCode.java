package com.foxhis.toolUtils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

/***
 * 生成验证码
 * 思路：1.需要0-9，a-z的字符
 *      2.随机产生4个
 *      3.加上干扰线
 * @author tq
 *
 */
public class VerifyCode {
    
	public static final char[] code={'0','1','2', '3', '4', '5', '6', '7', '8',  
            '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M',  
            'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm',  
            'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	public Random rd = new Random();
	
	
	public String getRandomStr()
	{
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<4;i++)
		{
			sb.append(code[rd.nextInt(code.length)]);
		}
		return sb.toString();
	}
	
	public  Color getRandomColor() {  
        return new Color(rd.nextInt(255), rd.nextInt(255), rd.nextInt(255));  
    }  
	
	 public  Color getReverseColor(Color c) {  
	        return new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue());  
	    }  
	
	 public BufferedImage getImage(int width,int height ){  
		 Color color = getRandomColor();
		 Color reColor =getReverseColor(color);
		 
		 //新建画框
		 BufferedImage bImage= new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		 //创建画笔
		 Graphics2D g2d = bImage.createGraphics();
		 //设置字体
		 g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD,20));
		 //设置背景色
		 g2d.setColor(color);
		 //用color绘制一个矩形
		 g2d.fillRect(0, 0, width, height);
		 //设置随机数字颜色
		 g2d.setColor(reColor);
		 //绘制随机字体
		 g2d.drawString(text, 10, 22);
		 //干扰
		 for (int i = 0, n = rd.nextInt(80); i < n; i++) {  
	            g2d.drawRect(rd.nextInt(width), rd.nextInt(height), 1, 1);  
	        }  
		 
		 return bImage;
		 
	 }
	 
	 String text = getRandomStr();
	 public String getText() {
		
		 return text;
	}
	 public static void output(BufferedImage image, OutputStream out) throws IOException{  
	        ImageIO.write(image, "JPEG", out);  
	    }  
	
	
	
	public static void main(String[] args) {
		System.out.println(new Random().nextInt(10));
	}
}
