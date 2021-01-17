package jp.ac.uryukyu.ie.e205733;
import java.util.*;


public class BlackJack {

    int playerPoint;
    int dealerPoint;
    int[] playerCard = new int[22]; // おそらく最高22まいかな・・・
    int[] dealerCard = new int[22];
    int numPlayerCard;
    int numDealerCard;

    void play() {
        distribute();
        battle();
        checkWinner();
    }

    void distribute() {

        Random random = new Random();

        dealerCard[0] = random.nextInt(9) + 1;
        dealerPoint += dealerCard[0]; // ディーラーの一枚目
        numDealerCard += 1;

        for (int i = 0; i < 2; i++) {
            playerCard[i] = random.nextInt(13) + 1;
            numPlayerCard += 1;
            if (playerCard[i] >= 10) {
                playerCard[i] = 10;
            }
            if (playerCard[i] == 1) {
                playerCard[i] = 11;
            }
            playerPoint += playerCard[i];

            for (int l = 0; l <= 2; l++) {
                if (playerPoint >= 22) {
                    if (playerCard[l] == 11) {
                        playerCard[l] = 1;
                        playerPoint -= 10;
                    }
                } // １１を１として置き換えるやつ
            }

        }
    }    
    
    void battle(){

    }
    void checkWinner(){
        
    }
}
