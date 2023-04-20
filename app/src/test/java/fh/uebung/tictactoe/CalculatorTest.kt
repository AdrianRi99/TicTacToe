package fh.uebung.tictactoe

import org.junit.Assert.assertEquals
import org.junit.Test

class CalculatorTest {
    @Test
    fun testAddition() {
        val calculator = Calculator()
        val result = calculator.add(2, 3)
        assertEquals(6, result)
    }
}

class Calculator {
    fun add(a: Int, b: Int): Int {
        return a + b
    }
}
