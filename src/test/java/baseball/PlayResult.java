package baseball;

public class PlayResult {
    private int ball;
    private int strike;

    public void report(BallStatus status) {
        if (status == BallStatus.STRIKE) {
            this.strike++;
        }
        if (status == BallStatus.BALL) {
            this.ball++;
        }
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public boolean isGameEnd() {
        return this.strike == 3;
    }
}
