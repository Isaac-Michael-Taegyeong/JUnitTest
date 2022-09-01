package isaac.junit.calculator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    @Autowired
    private CalculatorCheck calculatorCheck;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/plus")
    public String calculatorPlus(@RequestBody Calculator calculator) {
        log.info("calculatorPlus() : " + calculator.getFirstNm() + ", " + calculator.getSecondNm());

        Boolean checkZero = calculatorCheck.checkInputZero(calculator);
        if (checkZero == false) {
            return "Input Number has a zero";
        }

        int resultPlus = calculatorService.calculatorPlus(calculator);

        return String.valueOf(resultPlus);
    }

    @PostMapping("/minus")
    public String calculatorMinus(@RequestBody Calculator calculator) {
        log.info("calculatorMinus() : " + calculator.getFirstNm() + ", " + calculator.getSecondNm());

        Boolean checkZero = calculatorCheck.checkInputZero(calculator);
        if (checkZero == false) {
            return "Input Number has a zero";
        }

        int resultMinus = calculatorService.calculatorMinus(calculator);

        return String.valueOf(resultMinus);
    }

    @PostMapping("/multiply")
    public String calculatorMultiply(@RequestBody Calculator calculator) {
        log.info("calculatorMultiply() : " + calculator.getFirstNm() + ", " + calculator.getSecondNm());

        Boolean checkZero = calculatorCheck.checkInputZero(calculator);
        if (checkZero == false) {
            return "Input Number has a zero";
        }

        int resultMultiply = calculatorService.calculatorMultiply(calculator);

        return String.valueOf(resultMultiply);
    }

    @PostMapping("/divide")
    public String calculatorDivide(@RequestBody Calculator calculator) {
        log.info("calculatorDivide() : " + calculator.getFirstNm() + ", " + calculator.getSecondNm());

        Boolean checkZero = calculatorCheck.checkInputZero(calculator);
        if (checkZero == false) {
            return "Input Number has a zero";
        }

        int resultDivide = calculatorService.calculatorDivide(calculator);

        return String.valueOf(resultDivide);
    }

}
