NAME: Boyang Jiao
UVicID: V00800928
DATE: Mar 19, 2018
COURSE: CSC 435

Assignment 3

Included in this assignment submission are the following:
updated Compiler.java file
various tests for A3
makefile for easy compilation
AST, Environment, Semantic, IR, and Types packages
(IR Visitor found in the IR package)


THINGS THAT AREN'T PERFECT:
function calls whose return values are not assigned to a variable still creates a Temp (the Temp is never subsequently used).

CALL foo(T1T2); wasn't working, but
T0 := CALL foo(T1T2); did work.