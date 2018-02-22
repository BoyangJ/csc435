package AST;

public interface Visitor
{
    public void visit (Program p);
    public void visit (Function f);
    public void visit (FunctionDeclaration fd);
    public void visit (FunctionBody fb);
    public void visit (FormalParameter fp);
    public void visit (VariableDeclaration vd);
    public void visit (Identifier i);
    public void visit (TypeNode t);

    public void visit (ExpressionStatement es);
    public void visit (IfStatement e);
    public void visit (WhileStatement e);
    public void visit (PrintStatement e);
    public void visit (PrintlnStatement e);
    public void visit (ReturnStatement e);
    public void visit (AssignmentStatement e);
    public void visit (ArrayAssignmentStatement e);

    public void visit (Block b);

    public void visit (EqualityExpression e);
    public void visit (LessThanExpression e);
    public void visit (AddExpression e);
    public void visit (SubtractExpression e);
    public void visit (MultExpression e);
    public void visit (ParenExpression e);
    public void visit (IdentifierExpression e);
    public void visit (ArrayExpression e);
    public void visit (FunctionExpression e);

    public void visit (IntegerLiteral i);
    public void visit (StringLiteral s);
    public void visit (FloatLiteral f);
    public void visit (CharacterLiteral c);
    public void visit (BooleanLiteral b);
}