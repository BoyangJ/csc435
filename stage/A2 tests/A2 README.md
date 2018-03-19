NAME: Boyang Jiao
UVicID: V00800928
DATE: Feb 26, 2018
COURSE: CSC 435

Assignment 2

Included in this assignment submission are the following:
updated grammar file
updated Compiler.java file
various tests for A2
makefile for easy compilation
AST, Environment, Semantic, and Types packages

BONUS
For bonus, a few additional type combinations for certain expressions were added:

+ - * < and == expressions with Floats and Ints. (note: I did not implement subtyping, so assigning float values to int variables and vice versa is not supported.)

Char + String, or String + Char produces a String, which is the concatenation of the two. (ex. 'a' + "bcd" produces "abcd")

Char * Int, or Int * Char produces a String, which is the Char character repeated according to the Int. (ex. 'a' * 5 produces "aaaaa")

String * Int, or Int * String produces a String, which is the String repeated according to the Int. (ex. "abc" * 3 produces "abcabcabc")


As a result of these bonus additions, the provided test file woSt_3.2.2.a_invalid.ul is actually valid.