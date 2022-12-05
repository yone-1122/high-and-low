package beans;

//プレゼントボックスのクラス
public class Box {
    private String name;
    private String gift; //景品の中身
    private int status;  //0 = close, 1 = open

    public Box(String name, String gift, int status) {
        setName(name);
        setGift(gift);
        setStatus(status);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getGift() {
        return gift;
    }

    public int getStatus() {
        return status;
    }
}
