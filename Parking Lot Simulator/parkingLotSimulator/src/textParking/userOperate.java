package textParking;

public class userOperate {
    private int length;
    private String colour;
    private String userName;

    public void setLength(int length){
        this.length = length;
    }
    public void setColour(String colour){
        this.colour = colour;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setup(String userName,int length,String colour){
        this.length = length;
        this.colour = colour;
        this.userName = userName;
    }

}
