package baseball;

import java.util.Objects;

public class Ball {
    private final int ballNo;
    private final int position;

    public Ball(int position, int ballNo) {
        this.position = position;
        this.ballNo = ballNo;
    }

    public BallStatus compareBall(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }

        if (this.ballNo == ball.ballNo) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return ballNo == ball.ballNo && position == ball.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNo, position);
    }
}
