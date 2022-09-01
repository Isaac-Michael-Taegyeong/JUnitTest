package isaac.junit.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public CalculatorService() {
    }

    public int calculatorPlus(Calculator calculator) {

        int resultPlus = calculator.getFirstNm() + calculator.getSecondNm();

        return resultPlus;
    }

    public int calculatorMinus(Calculator calculator) {

        int resultMinus = calculator.getFirstNm() - calculator.getSecondNm();

        return resultMinus;
    }

    public int calculatorMultiply(Calculator calculator) {

        int resultMultiply = calculator.getFirstNm() * calculator.getSecondNm();

        return resultMultiply;
    }

    public int calculatorDivide(Calculator calculator) {

        int resultDivide = calculator.getFirstNm() / calculator.getSecondNm();

        return resultDivide;
    }

}
