package IR;

import AST.*;

public interface TempVisitor
{
    public Temp visit (Program p);
    public Temp visit (Function f);
    public Temp visit (FunctionDeclaration fd);
    public Temp visit (FunctionBody fb);
    public Temp visit (FormalParameter fp);
    public Temp visit (VariableDeclaration vd);
    public Temp visit (Identifier i);
    public Temp visit (TypeNode t);

    public Temp visit (ExpressionStatement es);
    public Temp visit (IfStatement e);
    public Temp visit (WhileStatement e);
    public Temp visit (PrintStatement e);
    public Temp visit (PrintlnStatement e);
    public Temp visit (ReturnStatement e);
    public Temp visit (AssignmentStatement e);
    public Temp visit (ArrayAssignmentStatement e);

    public Temp visit (Block b);

    public Temp visit (EqualityExpression e);
    public Temp visit (LessThanExpression e);
    public Temp visit (AddExpression e);
    public Temp visit (SubtractExpression e);
    public Temp visit (MultExpression e);
    public Temp visit (ParenExpression e);
    public Temp visit (IdentifierExpression e);
    public Temp visit (ArrayExpression e);
    public Temp visit (FunctionExpression e);

    public Temp visit (IntegerLiteral i);
    public Temp visit (StringLiteral s);
    public Temp visit (FloatLiteral f);
    public Temp visit (CharacterLiteral c);
    public Temp visit (BooleanLiteral b);
}