package beans;

//カードのクラス
public class Card {
    private String name;  //カードの名前
    private int cardnum;  //カードの番号
    private int status;   //0 = close, 1 = open

    public Card(String name, int num, int status) {
        setName(name);
        setCardnum(num);
        setStatus(status);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCardnum(int num) {
        cardnum = num;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public int getCardnum() {
        return cardnum;
    }

    public int getStatus() {
        return status;
    }
}
