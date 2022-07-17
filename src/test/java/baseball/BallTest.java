package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    @Test
    void nothing() {
        Ball computerBall = new Ball(1, 1);
        BallStatus status = computerBall.compareBall(new Ball(1, 2));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void ball() {
        Ball computerBall = new Ball(1, 1);
        BallStatus status = computerBall.compareBall(new Ball(2, 1));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void strike() {
        Ball computerBall = new Ball(1, 1);
        BallStatus status = computerBall.compareBall(new Ball(1, 1));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }
}
