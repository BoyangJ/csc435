.source arrays.ir
.class public arrays
.super java/lang/Object

.method public static __main()V
	.limit locals 33
	.var 0 is T0  [I from L_0 to L_1
	.var 1 is T1  [F from L_0 to L_1
	.var 2 is T2  [C from L_0 to L_1
	.var 3 is T3  [Ljava/lang/String; from L_0 to L_1
	.var 4 is T4  [Z from L_0 to L_1
	.var 5 is T5  I from L_0 to L_1
	.var 6 is T6  I from L_0 to L_1
	.var 7 is T7  I from L_0 to L_1
	.var 8 is T8  I from L_0 to L_1
	.var 9 is T9  F from L_0 to L_1
	.var 10 is T10  I from L_0 to L_1
	.var 11 is T11  C from L_0 to L_1
	.var 12 is T12  I from L_0 to L_1
	.var 13 is T13  Ljava/lang/String; from L_0 to L_1
	.var 14 is T14  I from L_0 to L_1
	.var 15 is T15  Z from L_0 to L_1
	.var 16 is T16  I from L_0 to L_1
	.var 17 is T17  I from L_0 to L_1
	.var 18 is T18  I from L_0 to L_1
	.var 19 is T19  I from L_0 to L_1
	.var 20 is T20  I from L_0 to L_1
	.var 21 is T21  I from L_0 to L_1
	.var 22 is T22  F from L_0 to L_1
	.var 23 is T23  I from L_0 to L_1
	.var 24 is T24  I from L_0 to L_1
	.var 25 is T25  C from L_0 to L_1
	.var 26 is T26  I from L_0 to L_1
	.var 27 is T27  I from L_0 to L_1
	.var 28 is T28  Ljava/lang/String; from L_0 to L_1
	.var 29 is T29  I from L_0 to L_1
	.var 30 is T30  I from L_0 to L_1
	.var 31 is T31  Z from L_0 to L_1
	.var 32 is T32  I from L_0 to L_1
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
.line 38
;			T0 := NEWARRAY I 10;
	ldc 10
	newarray int
	astore 0
.line 39
;			T1 := NEWARRAY F 10;
	ldc 10
	newarray float
	astore 1
.line 40
;			T2 := NEWARRAY C 10;
	ldc 10
	newarray char
	astore 2
.line 41
;			T3 := NEWARRAY U 10;
	ldc 10
	anewarray java/lang/String
	astore 3
.line 42
;			T4 := NEWARRAY Z 10;
	ldc 10
	newarray boolean
	astore 4
.line 43
;			T6 := 0;
	ldc 0
	istore 6
.line 44
;			T7 := 4;
	ldc 4
	istore 7
.line 45
;			T0[T6] := T7;
	aload 0
	iload 6
	iload 7
	iastore
.line 46
;			T8 := 3;
	ldc 3
	istore 8
.line 47
;			T9 := 5.6;
	ldc 5.600000
	fstore 9
.line 48
;			T1[T8] := T9;
	aload 1
	iload 8
	fload 9
	fastore
.line 49
;			T10 := 6;
	ldc 6
	istore 10
.line 50
;			T11 := '3';
	ldc 51
	istore 11
.line 51
;			T2[T10] := T11;
	aload 2
	iload 10
	iload 11
	castore
.line 52
;			T12 := 7;
	ldc 7
	istore 12
.line 53
;			T13 := "TL better win";
	ldc "TL better win"
	astore 13
.line 54
;			T3[T12] := T13;
	aload 3
	iload 12
	aload 13
	aastore
.line 55
;			T14 := 9;
	ldc 9
	istore 14
.line 56
;			T15 := FALSE;
	ldc 0
	istore 15
.line 57
;			T4[T14] := T15;
	aload 4
	iload 14
	iload 15
	bastore
.line 58
;			T17 := 0;
	ldc 0
	istore 17
.line 59
;			T16 := T0[T17];
	aload 0
	iload 17
	iaload
	istore 16
.line 60
;			T5 := T16;
	iload 16
	istore 5
.line 61
;			T18 := 5;
	ldc 5
	istore 18
.line 62
;			T20 := 2;
	ldc 2
	istore 20
.line 63
;			T19 := T0[T20];
	aload 0
	iload 20
	iaload
	istore 19
.line 64
;			T0[T18] := T19;
	aload 0
	iload 18
	iload 19
	iastore
.line 65
;			T21 := 1;
	ldc 1
	istore 21
.line 66
;			T23 := 5;
	ldc 5
	istore 23
.line 67
;			T22 := T1[T23];
	aload 1
	iload 23
	faload
	fstore 22
.line 68
;			T1[T21] := T22;
	aload 1
	iload 21
	fload 22
	fastore
.line 69
;			T24 := 5;
	ldc 5
	istore 24
.line 70
;			T26 := 2;
	ldc 2
	istore 26
.line 71
;			T25 := T2[T26];
	aload 2
	iload 26
	caload
	istore 25
.line 72
;			T2[T24] := T25;
	aload 2
	iload 24
	iload 25
	castore
.line 73
;			T27 := 7;
	ldc 7
	istore 27
.line 74
;			T29 := 1;
	ldc 1
	istore 29
.line 75
;			T28 := T3[T29];
	aload 3
	iload 29
	aaload
	astore 28
.line 76
;			T3[T27] := T28;
	aload 3
	iload 27
	aload 28
	aastore
.line 77
;			T30 := 0;
	ldc 0
	istore 30
.line 78
;			T32 := 6;
	ldc 6
	istore 32
.line 79
;			T31 := T4[T32];
	aload 4
	iload 32
	baload
	istore 31
.line 80
;			T4[T30] := T31;
	aload 4
	iload 30
	iload 31
	bastore
.line 81
;			RETURN;
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
