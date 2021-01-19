package jp.ac.uryukyu.ie.e205733;

import java.util.*;

/**
 * ブラックジャッククラス
 * ①カードを配る②バトル③勝敗判定の順にゲームが進んでいく。
 */
public class BlackJack {

    int playerPoint;
    int dealerPoint;
    int[] playerCard = new int[22]; // おそらく最高22まいかな・・・
    int[] dealerCard = new int[22];
    int numPlayerCard;
    int numDealerCard;


    /**
     * プレイメソッド：play()
     * ブラックジャッククラス内のメソッドをここでまとめて動かしている。
     */
    void play() {
        distribute();
        battle();
        checkWinner();
    }

    /**
     * カードを配るメソッド:distribute
     * プレイヤー側にカードを二枚、ディーラー側は最初にみることにできる一枚だけを配布
     */
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
    /**
     * 実際のゲームのメインとなるバトルメソッド：battle()
     * プレイヤー側からの入力に対して、ヒットならカードを一枚ひく。スタンドならディーラー側のカードをひく。
     * どちらかが１７点以上になるまでバトルは行われる
     */
    void battle() {

        Random random = new Random();
        for (int i = 2; playerPoint < 22; i++) {
            System.out.println("現在のあなたの点数は" + playerPoint + "です。");
            System.out.println("現在の相手の点数は" + dealerPoint + "です");
            System.out.println("次の手を入力してください。ヒット or スタンド");
            String str = new Scanner(System.in).nextLine();

            // メソッドとしてやった方がテストのときよき
            if (str.equals("ヒット")) {
                playerCard[i] = random.nextInt(13) + 1;
                numPlayerCard += 1;
                if (playerCard[i] >= 10) {
                    playerCard[i] = 10;
                }
                if (playerCard[i] == 1) {
                    playerCard[i] = 11;
                }
                playerPoint += playerCard[i];

                for (int l = 0; l <= numPlayerCard; l++) {
                    if (playerPoint >= 22) {
                        if (playerCard[l] == 11) {
                            playerCard[l] = 1;
                            playerPoint -= 10;
                        }
                    }
                }

                if (playerPoint >= 22) {
                    System.out.println("何やってんのよばか！！");
                    System.out.println("あなたの点数は" + playerPoint + "点になりました");
                    System.out.println("プレイヤーはバスト！！！！");
                    break;
                }
            }

            if (str.equals("スタンド")) {
                for (int j = 1; dealerPoint < 17; j++) {
                    dealerCard[j] = random.nextInt(13) + 1;
                    numDealerCard += 1;
                    if (dealerCard[j] >= 10) {
                        dealerCard[j] = 10;
                    }
                    if (dealerCard[j] == 1) {
                        dealerCard[j] = 11;
                    }
                    dealerPoint += dealerCard[j];

                    for (int l = 0; l <= numDealerCard; l++) {
                        if (dealerPoint >= 22) {
                            if (dealerCard[l] == 11) {
                                dealerCard[l] = 1;
                                dealerPoint -= 10;
                            }
                        }
                    }
                    if (dealerPoint >= 22) {
                        System.out.println("やったわね！！");
                        System.out.println("ディーラーの点数は" + dealerPoint + "点になりました");
                        System.out.println("ディーラーはバスト！！！！" + "\n");
                        break;
                    }
                }
            }
            if (dealerPoint >= 17) {
                System.out.println("↓↓↓↓↓↓今回の勝敗は以下の通りです↓↓↓↓↓↓" + "\n");
                break;
            }
        }
    }
    /**
     * 勝敗判定をするメソッド：checkWinner()
     * ブラックジャックのルールにのっとり、勝敗判定を行う。
     */
    void checkWinner() {

        if (dealerPoint > 21 && playerPoint < 22) {
            System.out.println("あなたの点数は" + playerPoint + "点でした");
            System.out.println("ディーラーの点数は" + dealerPoint + "点でした");
            System.out.println("プレイヤーの勝ち");
        } else if (dealerPoint < 22 && playerPoint > 21) {
            System.out.println("あなたの点数は" + playerPoint + "点でした");
            System.out.println("ディーラーの点数は" + dealerPoint + "点でした");
            System.out.println("ディーラーの勝ち");
        } else if (dealerPoint > playerPoint) {
            System.out.println("あなたの点数は" + playerPoint + "点でした");
            System.out.println("ディーラーの点数は" + dealerPoint + "点でした");
            System.out.println("ディーラーの勝ち");
        } else if (dealerPoint < playerPoint) {
            System.out.println("あなたの点数は" + playerPoint + "点でした");
            System.out.println("ディーラーの点数は" + dealerPoint + "点でした");
            System.out.println("プレイヤーの勝ち");
        } else if (dealerPoint == playerPoint) {
            System.out.println("あなたの点数は" + playerPoint + "点でした");
            System.out.println("ディーラーの点数は" + dealerPoint + "点でした");
            System.out.println("引き分け");
        } else if (dealerPoint > 21 && playerPoint > 21) {
            System.out.println("あなたの点数は" + playerPoint + "点でした");
            System.out.println("ディーラーの点数は" + dealerPoint + "点でした");
            System.out.println("ディーラーの勝ち");
        }
    }
}
