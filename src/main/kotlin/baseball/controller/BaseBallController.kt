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

        val magicNumber = magicNumberGenerator.magicNumberGenerate()

        inputView.printInputUserNum()
        var userInput = Console.readLine()
        if (userInput.isEmpty() || userInput.length > 3) {
            throw IllegalArgumentException("3자리 수를 입력해야 합니다.")
        }
        if (userInput[0] == userInput[1] || userInput[0] == userInput[2] || userInput[1] == userInput[2]) {
            throw IllegalArgumentException("서로 다른 3자리 수를 입력해야 합니다.")
        }
        for (num in userInput) {
            if (num < '1' || num > '9') {
                throw IllegalArgumentException("1 ~ 9 사이의 숫자만 입력해야 합니다.")
            }
        }

        val (ball, strike) = checkStrikeBall(userInput, magicNumber)
        outputView.printOutputUserNum(ball, strike)

        if (strike == 3) {
            gameOver()

            userInput = Console.readLine()
            if (userInput.isEmpty() || userInput.length > 1) {
                throw IllegalArgumentException("1과 2중 하나만 입력해야 합니다.")
            }
            if (userInput[0] != '1' || userInput[0] != '2') {
                throw IllegalArgumentException("1과 2중 하나만 입력해야 합니다.")
            }

            playGame()
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
        userInput = Console.readLine()
    }
}