.source arrays.ul
.class public arrays
.super java/lang/Object

.method public static __main()V
	.limit locals 33
	.var 0 is T0 [I from L_0 to L_1
	.var 1 is T1 [F from L_0 to L_1
	.var 2 is T2 [C from L_0 to L_1
	.var 3 is T3 [Ljava/lang/String; from L_0 to L_1
	.var 4 is T4 [Z from L_0 to L_1
	.var 5 is T5 I from L_0 to L_1
	.var 6 is T6 I from L_0 to L_1
	.var 7 is T7 I from L_0 to L_1
	.var 8 is T8 I from L_0 to L_1
	.var 9 is T9 F from L_0 to L_1
	.var 10 is T10 I from L_0 to L_1
	.var 11 is T11 C from L_0 to L_1
	.var 12 is T12 I from L_0 to L_1
	.var 13 is T13 Ljava/lang/String; from L_0 to L_1
	.var 14 is T14 I from L_0 to L_1
	.var 15 is T15 Z from L_0 to L_1
	.var 16 is T16 I from L_0 to L_1
	.var 17 is T17 I from L_0 to L_1
	.var 18 is T18 I from L_0 to L_1
	.var 19 is T19 I from L_0 to L_1
	.var 20 is T20 I from L_0 to L_1
	.var 21 is T21 I from L_0 to L_1
	.var 22 is T22 F from L_0 to L_1
	.var 23 is T23 I from L_0 to L_1
	.var 24 is T24 I from L_0 to L_1
	.var 25 is T25 C from L_0 to L_1
	.var 26 is T26 I from L_0 to L_1
	.var 27 is T27 I from L_0 to L_1
	.var 28 is T28 Ljava/lang/String; from L_0 to L_1
	.var 29 is T29 I from L_0 to L_1
	.var 30 is T30 I from L_0 to L_1
	.var 31 is T31 Z from L_0 to L_1
	.var 32 is T32 I from L_0 to L_1
	.limit stack 16
L_0:
	aconst_null
	astore 0
	aconst_null
	astore 1
	aconst_null
	astore 2
	aconst_null
	astore 3
	aconst_null
	astore 4
	ldc 0
	istore 5
	ldc 0
	istore 6
	ldc 0
	istore 7
	ldc 0
	istore 8
	ldc 0.0
	fstore 9
	ldc 0
	istore 10
	ldc 0
	istore 11
	ldc 0
	istore 12
	aconst_null
	astore 13
	ldc 0
	istore 14
	ldc 0
	istore 15
	ldc 0
	istore 16
	ldc 0
	istore 17
	ldc 0
	istore 18
	ldc 0
	istore 19
	ldc 0
	istore 20
	ldc 0
	istore 21
	ldc 0.0
	fstore 22
	ldc 0
	istore 23
	ldc 0
	istore 24
	ldc 0
	istore 25
	ldc 0
	istore 26
	ldc 0
	istore 27
	aconst_null
	astore 28
	ldc 0
	istore 29
	ldc 0
	istore 30
	ldc 0
	istore 31
	ldc 0
	istore 32

	ldc 10
	newarray int
	astore 0

	ldc 10
	newarray float
	astore 1

	ldc 10
	newarray char
	astore 2

	ldc 10
	anewarray java/lang/String
	astore 3

	ldc 10
	newarray boolean
	astore 4

	ldc 0
	istore 6

	ldc 4
	istore 7

	aload 0
	iload 6
	iload 7
	iastore

	ldc 3
	istore 8

	ldc 5.6
	fstore 9

	aload 1
	iload 8
	fload 9
	fastore

	ldc 6
	istore 10

	ldc 51
	istore 11

	aload 2
	iload 10
	iload 11
	castore

	ldc 7
	istore 12

	ldc "TL better win"
	astore 13

	aload 3
	iload 12
	aload 13
	aastore

	ldc 9
	istore 14

	ldc 0
	istore 15

	aload 4
	iload 14
	iload 15
	bastore

	ldc 0
	istore 17

	aload 0
	iload 17
	iaload
	istore 16

	iload 16
	istore 5

	ldc 5
	istore 18

	ldc 2
	istore 20

	aload 0
	iload 20
	iaload
	istore 19

	aload 0
	iload 18
	iload 19
	iastore

	ldc 1
	istore 21

	ldc 5
	istore 23

	aload 1
	iload 23
	faload
	fstore 22

	aload 1
	iload 21
	fload 22
	fastore

	ldc 5
	istore 24

	ldc 2
	istore 26

	aload 2
	iload 26
	caload
	istore 25

	aload 2
	iload 24
	iload 25
	castore

	ldc 7
	istore 27

	ldc 1
	istore 29

	aload 3
	iload 29
	aaload
	astore 28

	aload 3
	iload 27
	aload 28
	aastore

	ldc 0
	istore 30

	ldc 6
	istore 32

	aload 4
	iload 32
	baload
	istore 31

	aload 4
	iload 30
	iload 31
	bastore

	return

L_1:
.end method


;--------------------------------------------;
;                                            ;
; Boilerplate                                ;
;                                            ;
;--------------------------------------------;

.method public static main([Ljava/lang/String;)V
	; set limits used by this method
	.limit locals 1
	.limit stack 4
	invokestatic arrays/__main()V
	return
.end method

; standard initializer
.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method
