package com.horiaconstantin.javasdk;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://www.oracle.com/technetwork/articles/javase/supplementary-142654.html
// A character set is a collection of characters; e.g. ASCII, Han characters, cyrillic
// coded character set is a character set where each character has been assigned a unique number. Example: unicode.
// character encoding scheme: a mapping from the numbers of one or more coded character sets to sequences of one or more fixed-width code units (i.e. bytes).
// UTF-8 is a variable width character encoding scheme capable of encoding all valid code points in Unicode using one to four 8-bit bytes.
//    The Unicode standard always uses hexadecimal numbers
class UTF8andUnicodeTest {

    //    Basic Multilingual Plane (BMP) chars; code points from U+0000 to U+FFFF
    private char euroChar = '\u20AC'; // chars are only 16 bits and can only represent BMP
    private int euroPointCode = euroChar; // ints can also used to represent bmp
    private String euroString = "€";

    // Supplementary/surrogate characters; code points are above U+FFFF (from U+10000 to U+10FFFF).
    private int supplementaryChar1PointCode = 0x2F81A; //CJK COMPATIBILITY IDEOGRAPHS SUPPLEMENT: 冬
    private String supplementaryString1 = "\uD87E\uDC1A";
    private int supplementaryChar2PointCode = 0x10400; // 𐐀
    private String supplementaryString2 = "\uD801\uDC00";

    @Test
    @DisplayName("The set of characters from U+0000 to U+FFFF is referred to as the Basic Multilingual Plane (BMP).")
    void testBMPChars() {
        char[] chars = Character.toChars(euroPointCode);

        assertEquals(1, chars.length);
        assertEquals(euroString, Character.toString(euroChar));
        assertEquals(euroString, Character.toString(chars[0]));
    }

    @Test
    void testSupplementaryChars() {
//       Supplementary characters They take the space of 2 char primitive types
        char[] suppChar1FromPointCode = Character.toChars(supplementaryChar1PointCode);
        char[] suppChar2FromPointCode = Character.toChars(supplementaryChar2PointCode);

        assertEquals(2, suppChar1FromPointCode.length);
        assertEquals(2, suppChar2FromPointCode.length);

        char[] suppChar1Array = supplementaryString1.toCharArray();
        char[] suppChar2Array = supplementaryString2.toCharArray();
        assertEquals(supplementaryChar1PointCode, Character.toCodePoint(suppChar1Array[0], suppChar1Array[1]));

        assertEquals(supplementaryString1, new String(suppChar1FromPointCode, 0, 2));

//        The string madeup from multiple supplementary char  can be represented as an addition of all the chars
        assertEquals(supplementaryString1 + supplementaryString2,
                "" + suppChar1Array[0] + suppChar1Array[1] + suppChar2FromPointCode[0] + suppChar2FromPointCode[1]);
    }
}