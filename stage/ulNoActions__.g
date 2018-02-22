lexer grammar ulNoActions;

T23 : '(' ;
T24 : ')' ;
T25 : ',' ;
T26 : '{' ;
T27 : '}' ;
T28 : ';' ;
T29 : '[' ;
T30 : ']' ;
T31 : '=' ;
T32 : '==' ;
T33 : '<' ;
T34 : '+' ;
T35 : '-' ;
T36 : '*' ;

// $ANTLR src "ulNoActions.g" 260
fragment LOWER  : 'a'..'z' ;
// $ANTLR src "ulNoActions.g" 261
fragment UPPER  : 'A'..'Z' ;
// $ANTLR src "ulNoActions.g" 262
fragment DIGIT  : '0'..'9' ;
   
/* Keywords */
// $ANTLR src "ulNoActions.g" 265
IF  : 'if'
  ;
// $ANTLR src "ulNoActions.g" 267
ELSE  : 'else'
  ;
// $ANTLR src "ulNoActions.g" 269
PRINT  : 'print'
  ;
// $ANTLR src "ulNoActions.g" 271
PRINTLN  : 'println'
  ;
// $ANTLR src "ulNoActions.g" 273
RETURN  : 'return'
  ;
// $ANTLR src "ulNoActions.g" 275
WHILE  : 'while'
  ;

// $ANTLR src "ulNoActions.g" 278
TYPE  : 'int' | 'float' | 'char' | 'string' | 'boolean' | 'void'
  ;

// $ANTLR src "ulNoActions.g" 281
STRINGCONSTANT  : '"' (LOWER | UPPER | DIGIT | '_' | '-' | ' ')* '"'
  ;

// $ANTLR src "ulNoActions.g" 284
INTEGERCONSTANT : DIGIT+
  ;

// $ANTLR src "ulNoActions.g" 287
FLOATCONSTANT  : DIGIT+ '.' DIGIT+
  ;

// $ANTLR src "ulNoActions.g" 290
CHARACTERCONSTANT  : '\'' (LOWER | UPPER | DIGIT | ' ' | '_' | '-') '\''
  ;

// $ANTLR src "ulNoActions.g" 293
TRUE  : 'true'
  ;

// $ANTLR src "ulNoActions.g" 296
FALSE  : 'false'
  ;

// $ANTLR src "ulNoActions.g" 299
ID  : (LOWER | UPPER | '_')(LOWER | UPPER | DIGIT | '_')*
  ;

/* These two lines match whitespace and comments 
 * and ignore them.
 * You want to leave these as last in the file.  
 * Add new lexical rules above 
 */
// $ANTLR src "ulNoActions.g" 307
WS      : ( '\t' | ' ' | ('\r' | '\n') )+ { $channel = HIDDEN;}
        ;

// $ANTLR src "ulNoActions.g" 310
COMMENT : '//' ~('\r' | '\n')* ('\r' | '\n') { $channel = HIDDEN;}
        ;