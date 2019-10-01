package com.horiaconstantin.javasdk;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// >>> = unsigned (logical) right shift, pads with 0
// >> = signed (arithmetic) right shift, pads with leftmost bit. Equivalent to division by 2^n
// << = logical&aritmetic left shift, pads with 0. Equivalent to multiplication by 2^n
class BitwiseOperationsTest {

    @Test
    void bitwiseXOR() {
        int actual = 0b101010 ^ 0b101001;
        assertEquals(0b000011, actual);
    }

    @Test
    void bitwiseOR() {
        int actual = 0b101010 | 0b101001;
        assertEquals(0b101011, actual);
    }

    @Test
    @DisplayName("Can be used as a bit mask")
    void bitwiseAND() {
        int actual = 0b101010 & 0b101001;
        assertEquals(0b101000, actual);
    }

    @Test
    void bitwiseComplementOperator() {
        int val = 0b00101001; //41
        assertEquals(-42, ~val);

        byte boo = 0b00101001;
        assertEquals((byte) 0b11010110, ~boo);
    }

//    for the bit shift operators: https://stackoverflow.com/questions/141525/what-are-bitwise-shift-bit-shift-operators-and-how-do-they-work

    @Test
    @DisplayName("left shifting a number by n positions is equivalent to multiplication by 2^n")
    void signedLeftshiftOperatorWithPositiveInput() {
        int actual = 0b101001 << 2;
        assertEquals(0b10100100, actual);
        assertEquals(0b101001 * Math.pow(2, 2), actual);

        int negative = Integer.MIN_VALUE;

        int zero = negative << 1;
        assertEquals(0, zero);
    }

    @Test
    @DisplayName("left shifting a number by n positions is equivalent to multiplication by 2^n")
    void signedLeftshiftOperatorWithNegativeInput() {
        int negative = -3;

        int actual = negative << 3;
        assertEquals(-24, actual);
    }

    @Test
    void signedLeftshiftOperatorLosingBites() {
        int value = Integer.MAX_VALUE & 0xF0000000; //0b11110000000000000000000000000000
        int actual = value << 2;
        assertEquals(0b11000000000000000000000000000000, actual);
    }

    @Test
    @DisplayName("is the converse to the left shift. Pads with 0. " +
            "Does not keep the sign of the input.")
        //    Also known as logical right shift
    void unsignedRightshiftOperatorWithNegativeInput() {
        int value = -3;//1111 ... 1111 ... 1101
        int expected = 0b00111111111111111111111111111111;

        int actual = value >>> 2;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("is the converse to the left shift. Pads with 0.")
    void unsignedRightshiftOperator() {
        int value = 0b101001; //41
        int expected = 0b1010; //10

        int actual = value >>> 2;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Using negative value for shift distance is the same as using 32-value")
    void unsignedRightshiftOperatorWithNegativeShift() {
        int value = 0b101001; //41
        int expected = 0b1010; //10

        int actual = value >>> -2;

        assertEquals(value >>> 30, value >>> -2);
    }

    @Test
    @DisplayName("it pads with the most significant bit")
//    Also knows as Arithmetic right shift
    void signedRightshiftOperator() {
        int value = 0b101000; //40
        int expected = 0b1010; //10

        int actual = value >> 2;

        assertEquals(expected, actual);

        int negativeValue = -value;
        int negExpected = -expected;

        int negActual = negativeValue >> 2;

        assertEquals(negExpected, negActual);

    }


}