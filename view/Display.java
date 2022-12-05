package view;

import java.util.ArrayList;

import beans.Box;
import beans.Card;

//様々な画面表示用クラス
public class Display {

    //ゲームの状況を表示
    public void propsView(ArrayList<Card> cardlist, ArrayList<Box> boxlist,
            ArrayList<String> presents) {
        System.out.println("＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝\n");
        System.out.println("  ----プレゼントボックス----");
        for(Box b : boxlist) {
            System.out.printf("【%s】", b.getName());
        }
        System.out.println("\n\n獲得したプレゼント");
        if(presents.size() == 0) System.out.println("なし\n");
        else{
            for(String p : presents ) {
                System.out.printf("● %s\n", p);
            }
            System.out.println();
        }
        for(int i = 0; i < cardlist.size() / 2; i++) {
            System.out.printf("%2d【%s】", i + 1, cardlist.get(i).getName());
        }
        System.out.println();
        for(int i = cardlist.size() / 2; i < cardlist.size(); i++) {
            System.out.printf("%2d【%s】", i + 1, cardlist.get(i).getName());
        }
        System.out.println("\n");
    }

    //だよんカードオープン
    public void dayonOpen(Card card) {
        System.out.println("「ゲームスタート！」");
        System.out.printf("だよんカードの数字は %d です！\n\n", card.getCardnum());
    }

    //カードオープン
    public void cardOpen(Card card) {
        String name = card.getName();
        String num = String.valueOf(card.getCardnum());
        System.out.printf("【%s】カードの数字は %s です！\n\n", name, num);
        if(num.length() == 1) num = " " + num;
        card.setName("  " + num + "  ");
    }

    //前のカード(比較対象)の表示
    public void cardView(Card card) {
        System.out.printf("前のカードの数字：%d\n\n", card.getCardnum());
    }

    //ボックスオープン
    public void boxOpen(Box box) {
        System.out.println("\nおめでとうございます！");
        System.out.println(box.getGift() + "を獲得しました！\n\n");
        box.setName("  ");
    }

    //勝敗の表示
    public void judgeView(boolean result) {
        if(result) System.out.println("当たり！プレゼント獲得！");
        else System.out.println("残念、はずれ…終了です");
    }

    //challengerが3連続で勝った時
    public void gameEnd(ArrayList<String> presents){
        System.out.println("おめでとうございます！3連続で成功したため終了です");
        System.out.println("☆☆獲得したプレゼント☆☆");
        for(String p : presents) {
            System.out.println("● " + p);
        }
    }

    //選択済みカードまたはボックスの警告
    public void warning(Object obj) {
        String str;
        if(obj instanceof Card) str = "カード";
        else str = "ボックス";
        System.out.println("[!]この" + str + "は選択済みです\n");
    }

    //数字入力の警告
    public void numCheck() {
        System.out.println("[!]数字で入力してください\n");
    }

    //範囲外の数字の警告
    public void indexCheck() {
        System.out.println("[!]範囲内の数字を入力してください");
        System.out.println("   (カード:1～10  ボックス:1～5  ハイorロー:0～1)\n");
    }
}
