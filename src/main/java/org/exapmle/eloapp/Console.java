package org.exapmle.eloapp;

public class Console {
    static PlayerPool playerPool = new PlayerPool();
    static Runner runner = new Runner(playerPool);

    public static void main(String[] args) throws InterruptedException {
        runner.play1000Games();
    }
}
