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
            userInputValidationCheck(userInput)

            val (ball, strike) = checkStrikeBall(userInput, magicNumber)
            outputView.printOutputUserNum(ball, strike)

            if (strike == USER_NUMBER_COUNT) {
                gameOver()
            }
        }
    }

    private fun checkStrikeBall(userInput: String, magicNumber: MutableList<Int>): Pair<Int, Int> {
        for (i in 0 until USER_NUMBER_COUNT) {
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

        val userInput = Console.readLine()
        retryValidationCheck(userInput)

        if (userInput == "1") {
            playGame()
        } else {
            return
        }
    }

    private fun initBallStrike() {
        ball = 0
        strike = 0
    }

    private fun userInputValidationCheck(userInput: String) {
        val isNumbers = userInput.all { it.toString().matches(ONE_TO_NINE_REGEX.toRegex()) }
        val isThreeNumber = userInput.length == USER_NUMBER_COUNT
        val isDuplicate = userInput[0] != userInput[1] && userInput[0] != userInput[2] && userInput[1] != userInput[2]

        require(isNumbers && isThreeNumber && isDuplicate) { println() }
    }

    private fun retryValidationCheck(userInput: String) {
        val isOneOrTwo = userInput.matches(ONE_TO_TWO_REGEX.toRegex())
        val isOneNumber = userInput.length == 1

        require(isOneOrTwo && isOneNumber) { println() }
    }

    companion object {
        const val ONE_TO_NINE_REGEX = "[1-9]"
        const val USER_NUMBER_COUNT = 3
        const val ONE_TO_TWO_REGEX = "[1-2]"
    }
}