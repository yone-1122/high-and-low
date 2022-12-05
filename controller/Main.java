package controller;

import java.util.ArrayList;

import beans.Box;
import beans.Card;
import beans.PropsCreate;
import player.Challenger;
import player.Master;
import view.Display;

//ハイ＆ローゲームの実行
public class Main {
    private PropsCreate pc = new PropsCreate();
    private Display disp = new Display();
    private Challenger ch = new Challenger();
    private Master mas = new Master();

    public static void main(String[] args) throws InterruptedException {
        // TODO 自動生成されたメソッド・スタブ
        Main main = new Main();
        main.mainFlow();
    }

    public void mainFlow() throws InterruptedException {
        //小道具の生成～だよんカードの開示
        int selectcard, hl, selectbox;
        boolean loop = true;
        Card card1 = null, card2 = null;
        Box box;
        ArrayList<Card> cardlist = pc.newCardList();
        ArrayList<Box> boxlist = pc.newBoxList();
        disp.dayonOpen(cardlist.get(cardlist.size() - 1));

        //ゲームの繰り返し(loop = falseで終了)
        while(loop) {
            disp.propsView(cardlist, boxlist, ch.getPresents());
            if(card1 == null) {
                //初回のみ実行する処理
                selectcard = ch.cardSelect(cardlist);
                card1 = cardlist.get(selectcard - 1);
                mas.cardCheck(card1);
                disp.cardOpen(card1);
            } else {
                disp.cardView(card1);
            }
            do {
                selectcard = ch.cardSelect(cardlist); //カード位置番号の指定
                card2 = cardlist.get(selectcard - 1); //指定したカードを取得
                loop = mas.cardCheck(card2);          //オープン済みかチェック
            } while (!loop);

            hl = ch.hlSelect();  //ハイorローの選択
            boolean result = mas.judge(card1, card2, hl);  //勝敗のジャッジ
            Thread.sleep(800);
            disp.cardOpen(card2);
            disp.judgeView(result);
            if(result) {  //勝った場合以下を実行
                do {
                    selectbox = ch.boxSelect(boxlist); //ボックス位置番号の指定
                    box = boxlist.get(selectbox - 1);  //指定したボックスを取得
                    loop = mas.boxCheck(box);          //オープン済みかチェック
                }while(!loop);

                ch.getPresents().add(box.getGift());   //景品を獲得済みプレゼントに追加
                disp.boxOpen(box);
                card1 = card2;
                Thread.sleep(1000);
                if(mas.getWincnt() == 3) { //challengerが3連続で勝ったら結果を表示して終了
                    ArrayList<String> presents = ch.getPresents();
                    disp.gameEnd(presents);
                    loop = false;
                }
            } else {
                loop = false; //負けたら終了
            }
        }
    }
}
