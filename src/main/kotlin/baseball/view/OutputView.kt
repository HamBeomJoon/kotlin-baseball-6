package baseball.view

class OutputView {
    fun printGameOver() = println(GAME_OVER_MESSAGE)
    fun printOutputUserNum(ball: Int, strike: Int) =
        if (ball == 0 && strike == 0) println(NOTHING_MESSAGE)
        else {
            println("${ball}$BALL_MESSAGE ${strike}$STRIKE_MESSAGE")
        }

    companion object {
        const val GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
        const val STRIKE_MESSAGE = "스트라이크"
        const val BALL_MESSAGE = "볼"
        const val NOTHING_MESSAGE = "낫싱"
    }
}