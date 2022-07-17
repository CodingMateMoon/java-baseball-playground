package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {
    @Test
    void 컴퓨터볼3_플레이어볼1개_비교_NOTHING() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));
        BallStatus result = computerBalls.compareThreeComputerBallWithOnePlayerBall(new Ball(1, 7));
        assertThat(result).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void 컴퓨터볼3_플레이어볼1개_비교_BALL() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));
        BallStatus result = computerBalls.compareThreeComputerBallWithOnePlayerBall(new Ball(2, 3));
        assertThat(result).isEqualTo(BallStatus.BALL);
    }

    @Test
    void 컴퓨터볼3_플레이어볼1개_비교_STRIKE() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));
        BallStatus result = computerBalls.compareThreeComputerBallWithOnePlayerBall(new Ball(1, 1));
        assertThat(result).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void play_out() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = computerBalls.play(new Balls(Arrays.asList(4, 5, 6)));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void play_3strike() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = computerBalls.play(new Balls(Arrays.asList(1,2,3)));
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.isGameEnd()).isTrue();
    }

    @Test
    void play_1strike_1ball() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = computerBalls.play(new Balls(Arrays.asList(1,3,7)));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }
}
