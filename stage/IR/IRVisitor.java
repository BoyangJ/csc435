package IR;

import java.util.Iterator;
import AST.*;
//import Types.*;
import Environment.*;

public class IRVisitor implements TempVisitor
{

    public Temp visit (Program p){return null;}
    public Temp visit (Function f){return null;}
    public Temp visit (FunctionDeclaration fd){return null;}
    public Temp visit (FunctionBody fb){return null;}
    public Temp visit (FormalParameter fp){return null;}
    public Temp visit (VariableDeclaration vd){return null;}
    public Temp visit (Identifier i){return null;}
    public Temp visit (TypeNode t){return null;}

    public Temp visit (ExpressionStatement es){return null;}
    public Temp visit (IfStatement e){return null;}
    public Temp visit (WhileStatement e){return null;}
    public Temp visit (PrintStatement e){return null;}
    public Temp visit (PrintlnStatement e){return null;}
    public Temp visit (ReturnStatement e){return null;}
    public Temp visit (AssignmentStatement e){return null;}
    public Temp visit (ArrayAssignmentStatement e){return null;}

    public Temp visit (Block b){return null;}

    public Temp visit (EqualityExpression e){return null;}
    public Temp visit (LessThanExpression e){return null;}
    public Temp visit (AddExpression e){return null;}
    public Temp visit (SubtractExpression e){return null;}
    public Temp visit (MultExpression e){return null;}
    public Temp visit (ParenExpression e){return null;}
    public Temp visit (IdentifierExpression e){return null;}
    public Temp visit (ArrayExpression e){return null;}
    public Temp visit (FunctionExpression e){return null;}

    public Temp visit (IntegerLiteral i){return null;}
    public Temp visit (StringLiteral s){return null;}
    public Temp visit (FloatLiteral f){return null;}
    public Temp visit (CharacterLiteral c){return null;}
    public Temp visit (BooleanLiteral b){return null;}

}