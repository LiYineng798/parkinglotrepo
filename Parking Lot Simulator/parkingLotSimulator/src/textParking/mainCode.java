package textParking;

import com.sun.source.tree.WhileLoopTree;

import java.util.Scanner;

public class mainCode {
    public static void main(String[] args) {
        boolean ifDeved = true;
        boolean ifQuit = false;
        boolean hasSetup = false;

        //long initialTime = System.currentTimeMillis();
        //long currentTime = System.currentTimeMillis();//打上时间戳

        lotOperate lot = new lotOperate();
        userOperate user = new userOperate();//创建
        ParkingTime time = new ParkingTime();

        while (true){
            String temp = "";    //初始化
            String temp1 = "";
            String temp2 = "";
            int numtemp1 = 1;
            int numtemp2 = 1;
            boolean flag;

            developerLogin list = new developerLogin();
            //lotOperate lot = new lotOperate();
            list.setAll();   //set the user name and loginning number
            if(list.checkUser()){
                if(list.checkAll()){
                    ifDeved = false;
                    System.out.println("Login successful!");
                    if(hasSetup != true){
                        lot.setup();//停车场初始化
                        user.setup(lot.getLenth(),lot.getWide());//创建用户数据库
                        time.setup(lot.getLenth(),lot.getWide());//创建时间库
                        hasSetup = true;
                        System.out.println("finish setup!");
                    }
                    Scanner sc = new Scanner(System.in);
                    while (true){
                        developPrint();
                        temp = sc.nextLine();
                        if(temp.equals("1")){
                            System.out.println(lot.getNum());
                        }
                        else if (temp.equals("2")){
                            System.out.println(lot.getIncome());
                        }

                        else if (temp.equals("end")){
                            break;
                        }
                    }

                }
                else {
                    System.out.println("wrong!"+"the system is going to close");
                    break;
                }
            }
            else{
                if (ifDeved){
                    lot.setup(5,5);
                    user.setup(lot.getLenth(),lot.getWide());
                    time.setup(lot.getLenth(),lot.getWide());
                    //lot.setLenth(5);
                    //lot.setWide(5);
                    hasSetup = true;
                }//如果没有管理员登录过，那么就初始化5*5
                while (true) {
                    userPrint();
                    flag = true;
                    Scanner sc = new Scanner(System.in);
                    temp = String.valueOf(sc.nextLine());

                    if (temp.equals("1")){
                        flag = true;
                        lot.display();
                        while (flag){
                            System.out.println("you want to put your car in ?(please input like1,2):");
                            temp1 = String.valueOf(sc.nextLine());
                            if (checkPosForm(temp1, lot.getLenth(), lot.getWide())){
                                numtemp1 = Integer.parseInt(temp1.substring(0, 1))-1;
                                numtemp2 = Integer.parseInt(temp1.substring(2, 3))-1;
                                if(lot.checkEmpty(numtemp1,numtemp2)){
                                    System.out.println("this position has been parked");
                                    System.out.println("please try another");
                                }
                                else{
                                    time.setTime(numtemp1,numtemp2);
                                    System.out.println("first,please set your username and password");
                                    System.out.println("it will be used when you move your car");
                                    System.out.println("please create your username");
                                    temp1 = String.valueOf(sc.nextLine());
                                    while (!user.checkReusedName(temp1)){
                                        System.out.println("that username has been used");
                                        System.out.println("please try again");
                                        temp1 = String.valueOf(sc.nextLine());
                                    }
                                    user.putUsername(numtemp1,numtemp2,temp1);
                                    System.out.println("please create your password");
                                    temp1 = String.valueOf(sc.nextLine());
                                    user.putPassword(numtemp1,numtemp2,temp1);

                                    flag = false;

                                    System.out.println("what is the brand of your car?");
                                    temp1 = String.valueOf(sc.nextLine());
                                    lot.parking(numtemp1,numtemp2,temp1);
                                    System.out.println("what is the color of your car?");
                                    temp1 = String.valueOf(sc.nextLine());
                                    lot.addInf(numtemp1,numtemp2,temp1);
                                    System.out.println("what is your car's number");
                                    temp1 = String.valueOf(sc.nextLine());
                                    lot.addInf(numtemp1,numtemp2,temp1);
                                    lot.display();
                                }
                            }
                        }
                    }
                    else if (temp.equals("2")){
                        System.out.println("please input your car's brand");
                        temp = String.valueOf(sc.nextLine());
                        lot.searchBrand(temp);
                    }
                    else if(temp.equals("3")){
                        System.out.println("please input your car's color");
                        temp = sc.nextLine();
                        lot.searchColor(temp);
                    }
                    else if(temp.equals("4")){
                        System.out.println("please input your car's number");
                        temp = sc.nextLine();
                        lot.searchNumber(temp);
                    }
                    else if (temp.equals("5")){
                        System.out.println("please input your car's brand");
                        temp = sc.nextLine();
                        System.out.println("please input your car's color");
                        temp1 = sc.nextLine();
                        System.out.println("please input your car's number");
                        temp2 = sc.nextLine();
                        lot.searchAccurate(temp,temp1,temp2);
                    }
                    else if (temp.equals("6")){
                        System.out.println("please input your username");
                        temp1 = sc.nextLine();
                        System.out.println("please input your password");
                        temp2 = sc.nextLine();
                        if (user.checkName(temp1)){
                            if (user.checkPassword(temp2)){
                                lot.remove(user.getTempX(), user.getTempY());
                                time.charge(user.getTempX(), user.getTempY());
                                lot.addIncome(time.getMoney());
                                lot.display();
                                System.out.println("your car has been removed");
                            }
                            else {
                                System.out.println("wrong password!!");
                            }
                        }
                        else {
                            System.out.println("there is no such a user!!");
                        }
                    }

                    else if(temp.equals("end")){
                        System.out.println("the project is end");
                        break;
                    }
                    else{
                        System.out.println("there is no such a operation " +
                                "please try it again");
                    }
                }
            }
            Scanner sc1 = new Scanner(System.in);
            System.out.println("if you want to quit all?(yes or no)");
            temp = sc1.nextLine();
            while (!temp.equals("yes") && !temp.equals("no")){
                System.out.println("there is no such a operation,please try it again!");
                temp = sc1.nextLine();
            }
            if(temp.equals("yes")){ifQuit = true;}
            if(ifQuit){
                break;
            }
        }

    }
    public static void userPrint(){
        System.out.println("1)to parking you car");
        System.out.println("2)to search your car by brand");
        System.out.println("3)to searck your car by color");
        System.out.println("4)to searck your car by number");
        System.out.println("5)to search your car accurately");
        System.out.println("6)to remove your car");
        System.out.println("end)if you want to quit,please input'end'");
    }
    public static void developPrint(){
        System.out.println("1)output how many cars are there in lot");
        System.out.println("2)output total incomes");
        System.out.println("end)if you want to quit,please input'end'");
    }
    public static boolean checkPosForm(String pos,int x,int y){
        char [] chars = pos.toCharArray();
        int count = 0;
        int temp = 57;
        for (int i = 0; i < chars.length; i++) {
            temp = (int)chars[i];
            if (chars[i] == ','){
                count ++;
                //获取该点的位置
            }
            else if (!((temp>=49)&&(temp <= 57))){
                System.out.println("wrong format,please try again!");
                return false;
            }
        }
        if (count!=1){
            System.out.println("wrong format,please try again!");
            return false;
        }
        if (count == 1){
            String[] splitArray = pos.split(",", 2); // 使用逗号作为分隔符，并拆分成两个子字符串
            if((int)splitArray[0].charAt(0)>x || (int)splitArray[0].charAt(1)>y){
                System.out.println("that place is out of range,please try again!");
                return false;
            }
        }
        return true;
    }//
}