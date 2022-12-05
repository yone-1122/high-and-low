package player;

import beans.Box;
import beans.Card;
import view.Display;

//ゲームマスター用クラス(勝敗のジャッジとカウント、カード・ボックスの管理)
public class Master {
    private int wincnt;
    private Display disp = new Display();

    public int getWincnt() {
        return wincnt;
    }

    //当たり・はずれのジャッジ
    public boolean judge(Card card1, Card card2, int hl) {
        int num1 = card1.getCardnum(), num2 = card2.getCardnum();
        boolean result = true;
        switch(hl) {
        case 1:
            if(num1 > num2) result = false;
            break;
        case 0:
            if(num1 < num2) result = false;
        }
        if(result) wincnt++;
        return result;
    }

    //カードがオープン済みかチェックしてステータス変更
    public boolean cardCheck(Card card) {
        boolean result = (card.getStatus() == 0) ? true : false;
        if(!result) disp.warning(card);
        card.setStatus(1);
        return result;
    }

    //ボックスがオープン済みかチェックしてステータス変更
    public boolean boxCheck(Box box) {
        boolean result = (box.getStatus() == 0) ? true : false;
        if(!result) disp.warning(box);
        box.setStatus(1);
        return result;
    }
}
