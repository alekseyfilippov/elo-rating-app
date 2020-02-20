package org.exapmle.eloapp.algorithm;

import org.exapmle.eloapp.webapp.repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
//simplifyed elo-rating
public class RatingCalculator {
    @Autowired
    private PlayerRepo playerRepo;

    private static int k = 16; //coefficient of maximum rating change

    /**
     * @param x      - current elo 1st player
     * @param y      - current elo 2nd player
     * @param winner - [0;2] - 0 - loss, 1 - win, 2 - draw
     * @return
     */
    public static Double getElo(double x, double y, int winner) throws Exception {
        if (winner < 0 || winner > 2)
            throw new Exception("Incorrect argument 'winner'. It must be [0;2]");
        double e = Math.round((1 / (1 + Math.pow(10, ((y - x) / 400)))) * 10) / 10d; //rating change
        double z;
        if (winner == 2) {
            z = 0.5; //draw
        } else {
            z = winner;
        }
        //player.setElo(x + k * (z - e));

        return Math.round((x + k * (z - e)) * 10) / 10d; //final rating taking the coefficient

    }
}
