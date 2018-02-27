grammar ulNoActions;
@header
{
  import AST.*;
  import Types.*;
  import Environment.*;
}

@members
{
protected void mismatch (IntStream input, int ttype, BitSet follow)
        throws RecognitionException
{
        throw new MismatchedTokenException(ttype, input);
}
public void recoverFromMismatchedSet (IntStream input,
                                      RecognitionException e,
                                      BitSet follow)
        throws RecognitionException
{
        reportError(e);
        throw e;
}
}

@rulecatch {
        catch (RecognitionException ex) {
                reportError(ex);
                throw ex;
        }
}

/* GRAMMAR */

program returns [Program p]
@init
{
  p = new Program();
}
  : ( f=function { p.addElement(f); } )* EOF 
  ;

function returns [Function f]:
  fd=functionDecl fb=functionBody { f = new Function(fd, fb); }
  ;

functionDecl returns [FunctionDeclaration fd]:
  t=compoundType i=identifier '(' fp=formalParameters ')' { fd = new FunctionDeclaration(t, i, fp); }
  ;

formalParameters returns [FormalParameterList fpList]
@init
{
  fpList = new FormalParameterList();
}
: 
  t=compoundType i=identifier { fpList.addElement(new FormalParameter(t, i)); } ( fp=moreFormals { fpList.addElement(fp); } )*
  | 
  ;

moreFormals returns [FormalParameter fp]: 
  ',' t=compoundType i=identifier { fp = new FormalParameter(t, i); }
  ;

functionBody returns [FunctionBody fb]
@init
{
  fb = new FunctionBody();
}
  : '{' ( vd=varDecl { fb.vdList.addElement(vd); })* ( s=statement { fb.sList.addElement(s); })* '}' 
  ;

varDecl returns [VariableDeclaration vd]: 
  t=compoundType i=identifier ';' { vd = new VariableDeclaration(t, i); }
  ;

compoundType returns [TypeNode tn]: 
  t=type { tn = t; }
  | t=type '[' i=intLiteral ']' { tn = new TypeNode(t.type, i, t.line, t.offset); }
  ;

identifier returns [Identifier i]: 
  ID { i = new Identifier($ID.text, $ID.line, $ID.pos); }
  ;

type returns [TypeNode ty]: 
  t = TYPE
  {
    if (t.getText().equals("void"))
    {
      ty = new TypeNode(new VoidType(), t.getLine(), t.getCharPositionInLine());
    }
    else if (t.getText().equals("int"))
    {
      ty = new TypeNode(new IntegerType(), t.getLine(), t.getCharPositionInLine());
    }
    else if (t.getText().equals("float"))
    {
      ty = new TypeNode(new FloatType(), t.getLine(), t.getCharPositionInLine());
    }
    else if (t.getText().equals("char"))
    {
      ty = new TypeNode(new CharType(), t.getLine(), t.getCharPositionInLine());
    }
    else if (t.getText().equals("string"))
    {
      ty = new TypeNode(new StringType(), t.getLine(), t.getCharPositionInLine());
    }
    else if (t.getText().equals("boolean"))
    {
      ty = new TypeNode(new BooleanType(), t.getLine(), t.getCharPositionInLine());
    }
  }
  ;

statement returns [Statement s] options { backtrack = true; } : 
  ';' { s = new ExpressionStatement(); }
  | es=expressionStatement { s = es; }
  | is=ifStatement { s = is; }
  | ws=whileStatement { s = ws; }
  | ps=printStatement { s = ps; }
  | pls=printlnStatement { s = pls; }
  | rs=returnStatement { s = rs; }
  | as=assignmentStatement { s = as; }
  | aas=arrayAssignmentStatement { s = aas; }
  ;

expressionStatement returns [ExpressionStatement es]: 
  e=expr ';' { es = new ExpressionStatement(e); }
  ;

assignmentStatement returns [AssignmentStatement as]: 
  ID '=' e=expr ';' { as = new AssignmentStatement(new Identifier($ID.text, $ID.line, $ID.pos), e); }
  ;

arrayAssignmentStatement returns [ArrayAssignmentStatement aas]: 
  ID '[' e1=expr ']' '=' e2=expr ';' { aas = new ArrayAssignmentStatement(new ArrayExpression(new Identifier($ID.text, $ID.line, $ID.pos), e1), e2); }
  ;

ifStatement returns [IfStatement is]: 
  IF '(' e=expr ')' b1=block { is = new IfStatement(e, b1); } ( b2=elseStatement { is = new IfStatement(e, b1, b2); } )?
  ;

elseStatement returns [Block b]: 
  ELSE b1=block { b = b1; }
  ;

whileStatement returns [WhileStatement ws]: 
  WHILE '(' e=expr ')' b=block { ws = new WhileStatement(e, b); }
  ;

printStatement returns [PrintStatement ps]: 
  PRINT e=expr ';' { ps = new PrintStatement(e); }
  ;

printlnStatement returns [PrintlnStatement pls]: 
  PRINTLN e=expr ';' { pls = new PrintlnStatement(e); }
  ;

returnStatement returns [ReturnStatement rs]
@init
{
  rs = new ReturnStatement();
}
: RETURN (e=expr { rs = new ReturnStatement(e); } )? ';'
  ;

block returns [Block b]
@init 
{
  b = new Block();
}
: '{' (s=statement { b.sList.addElement(s); } )* '}'
  ;


expr returns [Expression e]
@init 
{
  Expression it = null;
}
@after
{
  e = it;
}
  : e1=lessExpr { it = e1; } ( '==' e2=lessExpr { it = new EqualityExpression(it, e2); } )* 
  ;

lessExpr returns [Expression e]: 
  e1=addExpr { e = e1; } ( '<' e2=addExpr { e = new LessThanExpression(e, e2); } )*
  ;

addExpr returns [Expression e]: 
  e1=multExpr { e = e1; } ( '+' e2=multExpr { e = new AddExpression(e, e2); } 
                        | '-' e2=multExpr { e = new SubtractExpression(e, e2); } )*
  ;

multExpr returns [Expression e]: 
  e1=atom { e = e1; } ( '*' e2=atom { e = new MultExpression(e, e2); } )*
  ;

parenExpr returns [ParenExpression e]: 
  '(' e1=expr ')' { e = new ParenExpression(e1); }
  ;

atom returns [Expression e]: 
  ID { e = new IdentifierExpression(new Identifier($ID.text, $ID.line, $ID.pos)); }
  | l=literal { e = l; }
  | e1=parenExpr { e = e1; }
  | ID '[' arrayexpr=expr ']' { e = new ArrayExpression(new Identifier($ID.text, $ID.line, $ID.pos), arrayexpr); }
  | ID '(' funclist=exprList ')' { e = new FunctionExpression(new Identifier($ID.text, $ID.line, $ID.pos), funclist); }
  ;

literal returns [Expression e]: 
  sl=stringLiteral { e = sl; }
  | il=intLiteral { e = il; }
  | fl=floatLiteral { e = fl; }
  | cl=characterLiteral { e = cl; }
  | bl=booleanLiteral { e = bl; }
  ;

stringLiteral returns [StringLiteral sl]: 
  STRINGCONSTANT { sl = new StringLiteral($STRINGCONSTANT.text, $STRINGCONSTANT.line, $STRINGCONSTANT.pos); }
  ;

intLiteral returns [IntegerLiteral il]: 
  INTEGERCONSTANT { il = new IntegerLiteral(Integer.parseInt($INTEGERCONSTANT.text), $INTEGERCONSTANT.line, $INTEGERCONSTANT.pos); }
  ;

floatLiteral returns [FloatLiteral fl]:
  FLOATCONSTANT { fl = new FloatLiteral(Float.parseFloat($FLOATCONSTANT.text), $FLOATCONSTANT.line, $FLOATCONSTANT.pos); }
  ;

characterLiteral returns [CharacterLiteral cl]:
  CHARACTERCONSTANT { cl = new CharacterLiteral($CHARACTERCONSTANT.text.charAt(1), $CHARACTERCONSTANT.line, $CHARACTERCONSTANT.pos); }
  ;

booleanLiteral returns [BooleanLiteral bl]:
  TRUE { bl = new BooleanLiteral(true, $TRUE.line, $TRUE.pos); }
  | FALSE { bl = new BooleanLiteral(false, $FALSE.line, $FALSE.pos); }
  ;

exprList returns [ExpressionList eList]
@init
{
  eList = new ExpressionList();
}
: 
  e=expr { eList.addElement(e); } (em=exprMore {eList.addElement(em); } )* 
  | 
  ;

exprMore returns [Expression e]: 
  ',' e1=expr { e = e1; }
  ;

/* Lexer */

/* Fragments */
fragment LOWER  : 'a'..'z' ;
fragment UPPER  : 'A'..'Z' ;
fragment DIGIT  : '0'..'9' ;
   
/* Keywords */
IF  : 'if'
  ;
ELSE  : 'else'
  ;
PRINT  : 'print'
  ;
PRINTLN  : 'println'
  ;
RETURN  : 'return'
  ;
WHILE  : 'while'
  ;

TYPE  : 'int' | 'float' | 'char' | 'string' | 'boolean' | 'void'
  ;

STRINGCONSTANT  : '"' (LOWER | UPPER | DIGIT | '_' | '-' | ' ')* '"'
  ;

INTEGERCONSTANT : DIGIT+
  ;

FLOATCONSTANT  : DIGIT+ '.' DIGIT+
  ;

CHARACTERCONSTANT  : '\'' (LOWER | UPPER | DIGIT | ' ' | '_' | '-') '\''
  ;

TRUE  : 'true'
  ;

FALSE  : 'false'
  ;

ID  : (LOWER | UPPER | '_')(LOWER | UPPER | DIGIT | '_')*
  ;

/* These two lines match whitespace and comments 
 * and ignore them.
 * You want to leave these as last in the file.  
 * Add new lexical rules above 
 */
WS      : ( '\t' | ' ' | ('\r' | '\n') )+ { $channel = HIDDEN;}
        ;

COMMENT : '//' ~('\r' | '\n')* ('\r' | '\n') { $channel = HIDDEN;}
        ;