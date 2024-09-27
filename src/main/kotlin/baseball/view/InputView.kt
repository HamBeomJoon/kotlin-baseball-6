package baseball.view

class InputView {
    fun printPlayGame() = println(START_GAME_MESSAGE)
    fun printInputUserNum() = print(INPUT_USER_NUMBER)
    fun printInputRestartNum() = println(INPUT_RESTART_NUMBER)

    companion object {
        const val START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다."
        const val INPUT_USER_NUMBER = "숫자를 입력해주세요 : "
        const val INPUT_RESTART_NUMBER = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
    }
}