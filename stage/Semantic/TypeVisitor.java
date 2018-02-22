package Semantic;

import AST.*;
import Types.*;

public interface TypeVisitor
{
    public Type visit (Program p) throws SemanticException;
    public Type visit (Function f) throws SemanticException;
    public Type visit (FunctionDeclaration fd) throws SemanticException;
    public Type visit (FunctionBody fb) throws SemanticException;
    public Type visit (FormalParameter fp) throws SemanticException;
    public Type visit (VariableDeclaration vd) throws SemanticException;
    public Type visit (Identifier i) throws SemanticException;
    public Type visit (TypeNode t) throws SemanticException;

    public Type visit (ExpressionStatement es) throws SemanticException;
    public Type visit (IfStatement e) throws SemanticException;
    public Type visit (WhileStatement e) throws SemanticException;
    public Type visit (PrintStatement e) throws SemanticException;
    public Type visit (PrintlnStatement e) throws SemanticException;
    public Type visit (ReturnStatement e) throws SemanticException;
    public Type visit (AssignmentStatement e) throws SemanticException;
    public Type visit (ArrayAssignmentStatement e) throws SemanticException;

    public Type visit (Block b) throws SemanticException;

    public Type visit (EqualityExpression e) throws SemanticException;
    public Type visit (LessThanExpression e) throws SemanticException;
    public Type visit (AddExpression e) throws SemanticException;
    public Type visit (SubtractExpression e) throws SemanticException;
    public Type visit (MultExpression e) throws SemanticException;
    public Type visit (ParenExpression e) throws SemanticException;
    public Type visit (IdentifierExpression e) throws SemanticException;
    public Type visit (ArrayExpression e) throws SemanticException;
    public Type visit (FunctionExpression e) throws SemanticException;

    public Type visit (IntegerLiteral i) throws SemanticException;
    public Type visit (StringLiteral s) throws SemanticException;
    public Type visit (FloatLiteral f) throws SemanticException;
    public Type visit (CharacterLiteral c) throws SemanticException;
    public Type visit (BooleanLiteral b) throws SemanticException;
}