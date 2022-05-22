import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/*
打开记事本
 */
public class ShowLove {
    public static void main(String[] args) throws IOException {
        //单例模式：
        Runtime r1 = Runtime.getRuntime();
        r1.exec("notepad");
        //开启线程 播放音乐
        Thread t1 = new Thread(()->{
            //播放音乐
            music.paly("E:\\Idea\\File\\项目一：音乐\\src\\Welcome.mp3");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();

        //读取文件
        FeadFiles("E:\\Idea\\File\\项目一：音乐\\src\\my.txt");
    }
    /*
    读取文件到记事本中
     */
    public static void FeadFiles(String path){
        try (FileReader fr = new FileReader(path)){

            int c;
            //一个一个读
            while ((c=fr.read())!=-1){
                copy(String.valueOf((char) c));
            }
          /*
            // FileInputStream一次性读完
            byte[] by = new byte[fr.available()];
            while ((c=fr.read(by))!=-1){
                copy(String.valueOf(new String(by, 0, c)));
                Thread.sleep(1000);
            }*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*
    将文字传入记事本
     */
    public static void copy(String sr){
        // StringSelection对象，将sr放入
        StringSelection stringSelection= new StringSelection(sr);
        //toolkit可以将数据放到剪切板中
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,stringSelection);

        Robot robot=null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        Random r = new Random();
        int delay = r.nextInt(200);
        if(delay<100){
            delay+=100;
        }
        robot.delay(delay);
    }

}
