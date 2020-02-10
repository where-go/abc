package sss;

import java.awt.Container;
import java.io.File;
import java.util.EmptyStackException;

import javax.swing.*;

public class ImplementsDemo {
     public static void main(String[] args) throws EmptyStackException{
         JFrame f=new JFrame("Welcome To Earth!");
         Container cont=f.getContentPane();
         String picPath="c:"+File.separator+"Users"+File.separator+"Sunboy"+File.separator+"desktop"+File.separator+"¿Î±í.png";
         Icon ico=new ImageIcon(picPath);
         JPanel pan=new JPanel();
         JLabel lab=new JLabel(ico);
         pan.add(lab);
         JScrollPane scr1=new JScrollPane(pan, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
         cont.add(scr1);
         f.setSize(1280,720);
         f.setLocation(300, 200);
         f.setVisible(true);
         
     }     
 }
