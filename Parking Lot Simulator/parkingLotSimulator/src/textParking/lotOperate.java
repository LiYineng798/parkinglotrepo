package textParking;

import java.security.PrivateKey;
import java.util.Scanner;

public class lotOperate {
    private int length;
    private int wide;
    private String [][]arry;
    private int num;
    String sep = "__________________________________";
    public void setup(){                //setup the lot by feedback
        boolean flag = true;
        int temp1 = 1;
        int temp2 = 1;
        Scanner sc = new Scanner(System.in);
        while (flag) {
            //System.out.println("请输入一个数字：");
            System.out.println("please input your lot length");

            if (sc.hasNextInt()) {
                temp1 = sc.nextInt();
                flag = false;
            } else {
                System.out.println("Please enter a positive integer!");
                System.out.println("try it again!");
                sc.next();
            }
        }
        flag = true;
        while (flag) {
            System.out.println("please input your lot wide");
            if (sc.hasNextInt()) {
                temp2 = sc.nextInt();
                flag = false;
            } else {
                System.out.println("Please enter a positive integer!");
                System.out.println("try it again!");
                sc.next();
            }
        }
        setup(temp1,temp2);
    }

    public void setup(int length,int wide){                     //just setup the lot by parameter
        this.length = length;
        this.wide = wide;
        //arry= new int[length][wide];
        arry = new String[length][wide];
        for (int i = 0; i < this.arry.length; i++) {
            for (int j = 0; j < this.arry[i].length; j++) {
                arry[i][j] = "[]";
            }
        }
        System.out.println("following is initialization");
        display();
        System.out.println(sep);
    }
    public int getLenth(){return this.length;}//getter
    public int getWide(){return this.wide;}
    public void setLenth(int len){this.length = len;}
    public void setWide(int wid){this.wide = wid;}
    //public int[][] getArry(){return this.arry;}

    public void display(){//display the lot
        for (int i = 0; i < this.arry.length; i++) {
            for (int j = 0; j < this.arry[i].length; j++) {
                System.out.print(this.arry[i][j]);
                //System.out.print(" ");
            }
            System.out.println();
        }
    }
    public void setArry(int x,int y,String temp){//setup the 1
        //this.arry[x][y] = 1;
        this.arry[x][y] = temp;
    }

    public void parking(int posX,int posY,String brand){
        System.out.println("you park the car in the("+(posX+1)+","+(posY+1)+")");
        setArry(posX,posY,brand);
        //display();
    }
    public void addInf(int x,int y,String temp){
        this.arry[x][y] = this.arry[x][y] + "|" + temp;
    }

    public int getNum(){
        this.num =this.length*this.wide;
        for (int i = 0; i < this.arry.length; i++) {
            for (int j = 0; j < this.arry[i].length; j++) {
                if(this.arry[i][j].equals("[]")){
                    num--;
                }
            }
        }
        return num;
    }
    public void searchBrand(String brand){
        boolean flag = false;
        for (int i = 0; i < this.arry.length; i++) {
            for (int j = 0; j < this.arry[i].length; j++) {
                for (int i1 = 0; i1 < arry[i][j].length(); i1++) {
                    if(arry[i][j].substring(i1,i1+1).equals("|")){
                        if(arry[i][j].substring(0,i1).equals(brand)){
                            flag = true;
                            System.out.println(Integer.toString(i+1) + "," +Integer.toString(j+1));
                        }
                    }
                }
            }
        }
        if (flag){
            System.out.println("your brand car may be here");
        }
        else {
            System.out.println("there is no such a car");
        }
        System.out.println(sep);
    }
    public void searchColor(String color){
        boolean flag = false;
        int sum;
        int temp = 0;
        for (int i = 0; i < this.arry.length; i++) {
            for (int j = 0; j < this.arry[i].length; j++) {
                sum = 0;
                for (int i1 = 0; i1 < arry[i][j].length(); i1++) {
                    if(arry[i][j].substring(i1,i1+1).equals("|")){
                        sum ++;
                        temp = i1+1;
                    }
                    else if ((sum == 1)&&(arry[i][j].substring(temp,i1+1).equals(color))){
                        flag = true;
                        System.out.println(Integer.toString(i+1) + "," +Integer.toString(j+1));
                    }
                }
            }
        }
        if (flag){
            System.out.println("your brand car may be here");
        }
        else {
            System.out.println("there is no such a car");
        }
        System.out.println(sep);
    }

    public void searchNumber(String number){
        boolean flag = false;
        int sum;
        int temp = 0;
        for (int i = 0; i < this.arry.length; i++) {
            for (int j = 0; j < this.arry[i].length; j++) {
                sum = 0;
                for (int i1 = 0; i1 < arry[i][j].length(); i1++) {
                    if(arry[i][j].substring(i1,i1+1).equals("|")){
                        sum ++;
                        temp = i1+1;
                    }
                    else if ((sum == 2)&&(arry[i][j].substring(temp,i1+1).equals(number))){
                        flag = true;
                        System.out.println(Integer.toString(i+1) + "," +Integer.toString(j+1));
                    }
                }
            }
        }
        if (flag){
            System.out.println("your brand car may be here");
        }
        else {
            System.out.println("there is no such a car");
        }
        System.out.println(sep);
    }

    public void searchAccurate(String brand,String color,String number){
        boolean flag = false;
        boolean flagTime = true;
        String tempBrand = "";
        String tempColor = "";
        int temp1;
        int temp2;
        for (int i = 0; i < this.arry.length; i++) {
            for (int j = 0; j < this.arry[i].length; j++) {
                temp1 = 0;
                for (int i1 = 0; i1 < arry[i][j].length(); i1++) {
                    if((flagTime)&& (arry[i][j].substring(i1,i1+1).equals("|") ) ){
                        tempBrand = arry[i][j].substring(0,i1);
                        temp1 = i1+1;
                        flagTime = false;
                    }
                    else if ((!flagTime)&& (arry[i][j].substring(i1,i1+1).equals("|") ) ){
                        tempColor = arry[i][j].substring(temp1,i1);
                        temp2 = i1+1;
                    }
                    if( (tempBrand.equals(brand)) && (tempColor.equals(color)) && (arry[i][j].substring(i1,this.arry[i][j].length()).equals(number))){
                        flag = true;
                        System.out.println(Integer.toString(i+1) + "," +Integer.toString(j+1));
                    }
                }
            }
        }
        if (flag){
            System.out.println("your brand car may be here");
        }
        else {
            System.out.println("there is no such a car");
        }
        System.out.println(sep);
    }

    public boolean checkEmpty(int x,int y) {
        if(arry[x][y].equals("[]")){
            return false;
        }
        else{return true;}
    }
    public void remove(int x,int y){
        arry[x][y] = "[]";
    }
}
