package camp.bso.inf.myapplication;


/**
 * Created by MUL17 on 2/8/2018.
 */

public class Food {
    private int id;
    private String name;
    private String asal;
    private byte[] image;

    public Food (String name, String asal,byte[] image,int id){
        this.name = name;
        this.asal = asal;
        this.image = image;
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id =id;
    }
    public String getName(){
        return name;
    }
    public void setName (String name){
        this.name = name;
    }
    public String getAsal(){
        return asal;
    }
    public void setAsal(String asal){
        this.asal=asal;
    }
    public byte[] getImage(){
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}