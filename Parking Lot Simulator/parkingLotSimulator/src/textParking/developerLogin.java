package textParking;

import java.util.Scanner;

public class developerLogin {
    private String [] developer;
    private int [] loginningCode;
    public void developer(){
        developer = new String[5];
        developer[0] = "Dave";
        developer[1] = "Dave";
        developer[2] = "Dave";
        developer[3] = "Dave";
        developer[4] = "Dave";
    }
    public void loginningCode(){
        loginningCode = new int[5];
        loginningCode[0] = 12345;
        loginningCode[1] = 12345;
        loginningCode[2] = 12345;
        loginningCode[3] = 12345;
        loginningCode[4] = 12345;
    }
    public boolean checkAll(){
        String developerTemp;
        int loginningCodeTemp;
        Scanner sc = new Scanner(System.in);
        System.out.println("please input your developer name");
        developerTemp = sc.nextLine();
        System.out.println("please input your loginning number");
        loginningCodeTemp = sc.nextInt();
        for (int i = 0; i < this.developer.length; i++) {
            if (this.developer[i].equals(developerTemp)){
                for (int j = 0; j < this.loginningCode.length; j++) {
                    if(this.loginningCode[j]==loginningCodeTemp){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean checkUser(){
        Scanner sc = new Scanner(System.in);
        int identity;
        boolean flag = true;
        //System.out.println("if you are user,input 1 ;if you are developer input 2");
        //identity = sc.nextInt();
        while(flag){
            System.out.println("1)you are user");
            System.out.println("2)you are developer");
            if(sc.hasNextInt()){
                identity = sc.nextInt();
                if(identity == 2){
                    break;
                }
                else if(identity == 1){
                    flag = false;
                }
                else {
                    System.out.println("please try again in number 1 or 2");
                }
            }
            else {
                sc.next();
                System.out.println("please try again in number 1 or 2");
            }
        }
        return flag;
    }
    public void setAll(){
        developer();
        loginningCode();
    }
}
