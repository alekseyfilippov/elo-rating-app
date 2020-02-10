package org.exapmle.eloapp;

import java.util.Random;

public class RandomNumberGenerator {
    public int generateNumber(int upperLimit) {
        Random random = new Random();
        int randomNumber = random.nextInt(upperLimit);
        return randomNumber;
    }
}
