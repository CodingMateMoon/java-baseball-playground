package baseball;

public enum BallStatus {
    NOTHING, STRIKE, BALL;

    public boolean isNotNothing() {
        return this != BallStatus.NOTHING;
    }
}
