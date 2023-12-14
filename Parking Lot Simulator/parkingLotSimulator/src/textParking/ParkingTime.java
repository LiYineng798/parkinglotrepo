package textParking;

import java.util.Scanner;

public class ParkingTime {
    private long[][] timeArry;
    private long money;

    public ParkingTime() {
    }

    public ParkingTime(long[][] timeArry) {
        this.timeArry = timeArry;
    }

    public long[][] getTimeArry() {
        return timeArry;
    }

    public void setTimeArry(long[][] timeArry) {
        this.timeArry = timeArry;
    }

    //初始化时间库
    public void setup(int len, int wide) {
        timeArry = new long[len][wide];
        for (int i1 = 0; i1 < timeArry.length; i1++) {
            for (int j1 = 0; j1 < timeArry[i1].length; j1++) {
                timeArry[i1][j1] = -1;
            }
        }
    }

    //全部输出时间库
    public void show() {
        for (int i1 = 0; i1 < timeArry.length; i1++) {
            for (int j1 = 0; j1 < timeArry[i1].length; j1++) {
                System.out.print(timeArry[i1][j1]);
            }
            System.out.println();
        }
    }

    //具体设置入库时间
    public void setTime(int i, int j) {
        timeArry[i][j] = System.currentTimeMillis();
    }

    //根据时间收费
    public void charge(int i, int j) {
        Scanner sc = new Scanner(System.in);
        long time;
        time = (System.currentTimeMillis() - timeArry[i][j]) / 1000;//进行做差并且取整1000
        money = time*2;
        System.out.println("your car has parked" + getTime(time) + ",you need to pay " + getPrice(time));
        System.out.println("please Press Enter to continue...");
        sc.nextLine();
    }

    //计算~分~秒
    public String getTime(long time) {
        long min = time / 60;
        long sec = time % 60;
        return min + " minute(s) and " + sec + " second(s)";
    }

    //一秒一元，计算收费
    public String getPrice(long time) {
        return time*2 + " yuan";
    }

    public long getMoney() {
        return money;
    }
}