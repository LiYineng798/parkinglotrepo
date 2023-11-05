package textParking;

import java.lang.reflect.Array;

public class userOperate {
    private String [][]username;
    private String [][]password;
    private int tempX;
    private int tempY;

    public int getTempX(){
        return this.tempX;
    }
    public int getTempY(){
        return this.tempY;
    }

    public void setup(int len,int wide){
        username = new String[len][wide];
        password = new String[len][wide];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < wide; j++) {
                username[i][j] = "";
                password[i][j] = "";
            }
        }
    }
    public void putUsername(int x,int y,String username){
        this.username[x][y] = username;
    }
    public void putPassword(int x,int y,String password){
        this.password[x][y] = password;
    }

    public boolean checkName(String name){
        for (int i = 0; i < this.username.length; i++) {
            for (int j = 0; j < this.username[i].length; j++) {
                if (this.username[i][j].equals(name)){
                    this.tempX = i;
                    this.tempY = j;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean checkPassword(String password){
        if (this.password[this.tempX][this.tempY].equals(password)){
            return true;
        }
        return false;
    }

    public boolean checkReusedName(String name){
        for (int i = 0; i < this.username.length; i++) {
            for (int j = 0; j < this.username[i].length; j++) {
                if (this.username[i][j].equals(name)){
                    return false;
                }
            }
        }
        return true;
    }
}
