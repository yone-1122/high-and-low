package beans;

import java.util.ArrayList;
import java.util.Collections;

//小道具作成クラス
public class PropsCreate {

    //カード用フィールド
    private ArrayList<Card> cardlist = new ArrayList<>();
    private final int CARDS = 10;
    private String[] cardname = {" いぬ "," ねこ "," うし "," さる ","うさぎ"," くま "," ぶた "," ぞう ","パンダ"};
    private int[] cardnum = {1,2,3,4,5,6,7,8,9,10};

    //ボックス用フィールド
    private ArrayList<Box> boxlist = new ArrayList<>();
    private final int BOXS = 5;
    private String[] boxname = {"Oh","バ","ン","デ","ス"};
    private String[] giftlist = {"牛タン司 商品券1万円分", "一の坊 お食事券1万円分",
            "伊達麦茶 1ケース", "うまい鮨勘 お食事券5千円分", "フラワーギフト 商品券5千円分"};


    public int getCards() {
        return CARDS;
    }

    public int getBoxs(){
        return BOXS;
    }

    //ランダムな数字を持った10枚のカードを作成
    public ArrayList<Card> newCardList() {
        for(int i = 0; i < CARDS; i++) {      //1～10の数字を持ったカードを作成
            cardlist.add(new Card(null, cardnum[i], 0));
        }
        Collections.shuffle(cardlist);       //カードをシャッフル
        for(int i = 0; i < CARDS - 1; i++) {  //先頭から9枚に名前を設定
            cardlist.get(i).setName(cardname[i]);
        }
        cardlist.get(CARDS - 1).setName("だよん");    //最後のカードをだよんカードに設定
        return cardlist;
    }

    //ランダムな景品を持ったプレゼントボックスを5個作成
    public ArrayList<Box> newBoxList(){
        for(int i = 0; i < BOXS; i++) {              //景品入りのボックスを作成
            boxlist.add(new Box(null, giftlist[i], 0));
        }
        Collections.shuffle(boxlist);               //ボックスをシャッフル
        for(int i = 0; i < BOXS; i++) {
            boxlist.get(i).setName(boxname[i]);      //ボックスの名前を設定
        }
        return boxlist;
    }

}
