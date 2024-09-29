package baseball.controller

import baseball.model.MagicNumberGenerator
import baseball.view.InputView
import baseball.view.OutputView
import camp.nextstep.edu.missionutils.Console

class BaseBallController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val magicNumberGenerator = MagicNumberGenerator()

    private var strike = 0
    private var ball = 0

    fun playGame() {
        inputView.printPlayGame()
        initBallStrike()

        val magicNumber = magicNumberGenerator.magicNumberGenerate()

        while (strike < 3) {
            initBallStrike()

            inputView.printInputUserNum()
            var userInput = Console.readLine()
            validationCheck(userInput)

            val (ball, strike) = checkStrikeBall(userInput, magicNumber)
            outputView.printOutputUserNum(ball, strike)

            if (strike == 3) {
                gameOver()

                userInput = Console.readLine()
                if (userInput.isEmpty() || userInput.length > 1) {
                    throw IllegalArgumentException("1과 2중 하나만 입력해야 합니다.")
                }
                if (userInput[0] != '1' && userInput[0] != '2') {
                    throw IllegalArgumentException("1과 2중 하나만 입력해야 합니다.")
                }

                if (userInput[0] == '1') {
                    playGame()
                } else {
                    return
                }
            }
        }
    }

    private fun checkStrikeBall(userInput: String, magicNumber: MutableList<Int>): Pair<Int, Int> {
        for (i in 0 until 3) {
            val userNum = userInput[i].digitToInt()
            if (magicNumber.contains(userNum)) {
                if (magicNumber[i] == userNum) {
                    strike++
                } else {
                    ball++
                }
            }
        }
        return Pair(ball, strike)
    }

    private fun gameOver() {
        outputView.printGameOver()
        inputView.printInputRestartNum()
    }

    private fun initBallStrike() {
        ball = 0
        strike = 0
    }

    private fun validationCheck(userInput: String) {

    }
}