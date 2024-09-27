package baseball.controller

import baseball.model.MagicNumberGenerator
import baseball.view.InputView
import baseball.view.OutputView

class BaseBallController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val magicNumberGenerator = MagicNumberGenerator()

    fun playGame() {
        inputView.printPlayGame()
        val magicNumber = magicNumberGenerator.magicNumberGenerate()
    }

}