package com.horiaconstantin.javasdk;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Integer has leftmost (Most Significant) bit is a sign bit")
// Java uses two's complement for negative numbers and the basic rule is to take the positive, invert all bits then add one. That gets you the negative.
//https://stackoverflow.com/questions/26315782/binary-presentation-of-negative-integer-in-java
//0b1111 1111 1111 1111 1111 1111 1111 1111
public class IntegerBehavior {

    @Test
    void maxValueToBites() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 31; i++) {
            sb.append(1);
        }
        String stringOf31bitesSet = sb.toString();

        String maxVal = Integer.toBinaryString(Integer.MAX_VALUE);

        assertEquals(stringOf31bitesSet, maxVal);
    }

    @Test
    @DisplayName("!!!Note: Integer.MAX_VALUE+1 = Integer.MIN_VALUE")
    void maxValuePlusOne() {
        int maxPlusOne = Integer.MAX_VALUE + 1;

        assertEquals(Integer.MIN_VALUE, maxPlusOne);

    }

    @Test
    void integerWithAll32BitsSet() {
        int all32BitsSetTo1 = 0xFFFFFFFF;

        assertEquals(-1, all32BitsSetTo1);
    }

    @Test
    void minValueToBites() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 31; i++) {
            sb.append(0);
        }
        sb.insert(0, 1);
        String stringOf32bites = sb.toString(); // equivalent to 0x80000000

        assertEquals(Integer.toBinaryString(Integer.MIN_VALUE), stringOf32bites);
        assertEquals(Integer.toBinaryString(Integer.MIN_VALUE), Integer.toBinaryString(0x80000000));
    }

    @Test
    @DisplayName("MAX_VALUE = 2^31 - 1. (-1) is reserved for 0.")
    void maxValue() {
        assertEquals(Integer.MAX_VALUE, Math.pow(2, 31) - 1);
    }

    @Test
    @DisplayName("counts the '1' bits in the given argument")
    void bitCount() {
        assertEquals(3, Integer.bitCount(0b11001));
    }

    @Test
    void rotateLeft() {
        int value = 0b10000000000000000000000110011000;
        int expected = 0b00000000000000000000110011000100;
        assertEquals(expected, Integer.rotateLeft(value, 3));
    }

    @Test
    void highestOneBit() {
        int value = 0b10000000000000000000000110011000;
        int maskForBitnumber32 = 0x80000000;
        int expected = value & maskForBitnumber32;

        assertEquals(-2147483648, expected);
        assertEquals(expected, Integer.highestOneBit(value));
        assertEquals("10000000000000000000000000000000", Integer.toBinaryString(Integer.highestOneBit(value)));
    }

    @Test
    void numberOfLeadingandTrailingZeros() {
        int value1 = 0b10000000000000000000000110011000;

        assertEquals(0, Integer.numberOfLeadingZeros(value1));
        assertEquals(3, Integer.numberOfTrailingZeros(value1));

        int value2 = 0b00000000000000000000000000000001;

        assertEquals(31, Integer.numberOfLeadingZeros(value2));
        assertEquals(0, Integer.numberOfTrailingZeros(value2));
    }

    @Test
    void reverse() {
        int value1 = 0b10000000000000000000000110011000;

        assertEquals(0b00011001100000000000000000000001, Integer.reverse(value1));
    }
}