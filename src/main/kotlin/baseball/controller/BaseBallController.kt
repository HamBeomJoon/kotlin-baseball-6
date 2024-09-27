package baseball.controller

import baseball.model.MagicNumberGenerator
import baseball.view.InputView
import baseball.view.OutputView
import camp.nextstep.edu.missionutils.Console
import org.junit.jupiter.api.assertThrows

class BaseBallController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val magicNumberGenerator = MagicNumberGenerator()

    fun playGame() {
        inputView.printPlayGame()

        val magicNumber = magicNumberGenerator.magicNumberGenerate()

        inputView.printInputUserNum()
        val userInput = Console.readLine()
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
    }

}