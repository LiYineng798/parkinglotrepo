package text;

import textParking.mainCode;

import java.lang.invoke.StringConcatFactory;
import java.sql.Time;
import java.util.ArrayList;
import textParking.ParkingTime;
import textParking.mainCode;

public class text {
    public static void main(String[] args) {
        InputThread inputThread = new InputThread();
        inputThread.start();
        int temp = 0;


        while (true) {
            if (inputThread.isInputReceived() && inputThread.getInput().equalsIgnoreCase("")) {
                break;
            }
            System.out.println(temp ++);
            // 在这里编写你的程序逻辑
            // ...

            // 休眠一段时间，避免过于频繁的循环
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("程序结束");
        inputThread.stopInputThread();
    }

}
