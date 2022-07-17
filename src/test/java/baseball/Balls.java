package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> ballList;

    public List<Ball> getBallList() {
        return ballList;
    }

    public Balls(List<Integer> balls) {
        List<Ball> ballList = makeBallList(balls);
        this.ballList = ballList;
    }

    private List<Ball> makeBallList(List<Integer> balls) {
        List<Ball> ballList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ballList.add(new Ball(i + 1, balls.get(i)));
        }
        return ballList;
    }

    public BallStatus compareThreeComputerBallWithOnePlayerBall(Ball userBall) {

       /* for (int i = 0; i < ballList.size(); i++) {
            Ball ComputerBall = ballList.get(i);
            BallStatus result = ComputerBall.compareBall(userBall);
            if(result != BallStatus.NOTHING)
                return result;
        }
        return BallStatus.NOTHING;*/

         /*
        스트림 , 람다, Optional 활용
        1. ball List 가져오기
        2. play를 통해 Stream<BallStatus> 가져오기
        3. BallStatus 중 NOTHING이 아닌 것만 가져오기
        4. findFirst() : 가장 처음으로 나온 값 하나 가져오기. Optional<BallStatus>
        5. NOTHING이 아닌 경우가 아에 없으면 BallStatus.NOTHING return
         */
        return ballList.stream()
                .map(answer -> answer.compareBall(userBall))
                .filter(status -> status.isNotNothing())
                .findFirst()
                .orElse((BallStatus.NOTHING));

    }

    public PlayResult play(Balls playerBalls) {
        PlayResult result = new PlayResult();
        for (Ball playerBall :
                playerBalls.getBallList()) {
            BallStatus status = this.compareThreeComputerBallWithOnePlayerBall(playerBall);
            result.report(status);
        }

        return result;
    }
}
