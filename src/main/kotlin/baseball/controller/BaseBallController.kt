package baseball.controller

import baseball.view.InputView
import baseball.view.OutputView

class BaseBallController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun playGame() {
        inputView.printPlayGame()
    }

}