package player;

import java.util.ArrayList;
import java.util.Scanner;

import beans.Box;
import beans.Card;
import beans.PropsCreate;
import view.Display;

//チャレンジャー用クラス(カードやボックスの選択、獲得プレゼントの保持)
public class Challenger {
    private Scanner in = new Scanner(System.in);
    private ArrayList<String> presents = new ArrayList<>(); //獲得プレゼント
    private Display disp = new Display();
    private PropsCreate pc = new PropsCreate();
    int cards = pc.getCards(), boxs = pc.getBoxs();
    private int num, hl;

    public void setPresents (String gift) {
        presents.add(gift);
    }

    public ArrayList<String> getPresents(){
        return presents;
    }

    //カードの選択
    public int cardSelect(ArrayList<Card> cardlist) {
        boolean loop = true;
        while(loop){
            System.out.print("★カード番号を選んでね => ");
            try {
                num = Integer.parseInt(in.nextLine());
                if(num > 0 && num <= cards) loop = false;
                else disp.indexCheck();
            } catch (NumberFormatException e) {
                disp.numCheck();
            }
        }
        return num;
    }

    //ハイorローの選択
    public int hlSelect() {
        boolean loop = true;
        while(loop) {
            System.out.print("★ハイ or ロー ？");
            System.out.print("(数字で選んでね) ハイ:1  ロー:0  => ");
            try {
                hl = Integer.parseInt(in.nextLine());
                System.out.println();
                if(hl >= 0 && hl <= 1) loop = false;
                else disp.indexCheck();
            } catch (NumberFormatException e) {
                disp.numCheck();
            }
        }
        return hl;
    }

    //プレゼントボックスの選択
    public int boxSelect(ArrayList<Box> boxlist) {
        boolean loop = true;
        while(loop) {
            System.out.print("★左から何番目のプレゼントボックスを選びますか？");
            System.out.print("(数字で選んでね) => ");
            try {
                num = Integer.parseInt(in.nextLine());
                if(num > 0 && num <= boxs) {
                    loop = false;
                }
                else disp.indexCheck();
            } catch (NumberFormatException e) {
                disp.numCheck();
            }
        }
        return num;
    }
}
