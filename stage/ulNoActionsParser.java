// $ANTLR 3.0.1 ulNoActions.g 2018-03-18 16:19:24

  import AST.*;
  import Types.*;
  import Environment.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class ulNoActionsParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "TYPE", "IF", "ELSE", "WHILE", "PRINT", "PRINTLN", "RETURN", "STRINGCONSTANT", "INTEGERCONSTANT", "FLOATCONSTANT", "CHARACTERCONSTANT", "TRUE", "FALSE", "LOWER", "UPPER", "DIGIT", "WS", "COMMENT", "'('", "')'", "','", "'{'", "'}'", "';'", "'['", "']'", "'='", "'=='", "'<'", "'+'", "'-'", "'*'"
    };
    public static final int PRINT=9;
    public static final int PRINTLN=10;
    public static final int COMMENT=22;
    public static final int RETURN=11;
    public static final int UPPER=19;
    public static final int STRINGCONSTANT=12;
    public static final int ELSE=7;
    public static final int ID=4;
    public static final int WS=21;
    public static final int EOF=-1;
    public static final int TYPE=5;
    public static final int IF=6;
    public static final int CHARACTERCONSTANT=15;
    public static final int TRUE=16;
    public static final int FLOATCONSTANT=14;
    public static final int DIGIT=20;
    public static final int INTEGERCONSTANT=13;
    public static final int LOWER=18;
    public static final int WHILE=8;
    public static final int FALSE=17;

        public ulNoActionsParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[43+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "ulNoActions.g"; }


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



    // $ANTLR start program
    // ulNoActions.g:35:1: program returns [Program p] : (f= function )* EOF ;
    public final Program program() throws RecognitionException {
        Program p = null;

        Function f = null;



          p = new Program();

        try {
            // ulNoActions.g:40:3: ( (f= function )* EOF )
            // ulNoActions.g:40:5: (f= function )* EOF
            {
            // ulNoActions.g:40:5: (f= function )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==TYPE) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ulNoActions.g:40:7: f= function
            	    {
            	    pushFollow(FOLLOW_function_in_program45);
            	    f=function();
            	    _fsp--;
            	    if (failed) return p;
            	    if ( backtracking==0 ) {
            	       p.addElement(f); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match(input,EOF,FOLLOW_EOF_in_program52); if (failed) return p;

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return p;
    }
    // $ANTLR end program


    // $ANTLR start function
    // ulNoActions.g:43:1: function returns [Function f] : fd= functionDecl fb= functionBody ;
    public final Function function() throws RecognitionException {
        Function f = null;

        FunctionDeclaration fd = null;

        FunctionBody fb = null;


        try {
            // ulNoActions.g:43:30: (fd= functionDecl fb= functionBody )
            // ulNoActions.g:44:3: fd= functionDecl fb= functionBody
            {
            pushFollow(FOLLOW_functionDecl_in_function71);
            fd=functionDecl();
            _fsp--;
            if (failed) return f;
            pushFollow(FOLLOW_functionBody_in_function75);
            fb=functionBody();
            _fsp--;
            if (failed) return f;
            if ( backtracking==0 ) {
               f = new Function(fd, fb); 
            }

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return f;
    }
    // $ANTLR end function


    // $ANTLR start functionDecl
    // ulNoActions.g:47:1: functionDecl returns [FunctionDeclaration fd] : t= compoundType i= identifier '(' fp= formalParameters ')' ;
    public final FunctionDeclaration functionDecl() throws RecognitionException {
        FunctionDeclaration fd = null;

        TypeNode t = null;

        Identifier i = null;

        FormalParameterList fp = null;


        try {
            // ulNoActions.g:47:46: (t= compoundType i= identifier '(' fp= formalParameters ')' )
            // ulNoActions.g:48:3: t= compoundType i= identifier '(' fp= formalParameters ')'
            {
            pushFollow(FOLLOW_compoundType_in_functionDecl95);
            t=compoundType();
            _fsp--;
            if (failed) return fd;
            pushFollow(FOLLOW_identifier_in_functionDecl99);
            i=identifier();
            _fsp--;
            if (failed) return fd;
            match(input,23,FOLLOW_23_in_functionDecl101); if (failed) return fd;
            pushFollow(FOLLOW_formalParameters_in_functionDecl105);
            fp=formalParameters();
            _fsp--;
            if (failed) return fd;
            match(input,24,FOLLOW_24_in_functionDecl107); if (failed) return fd;
            if ( backtracking==0 ) {
               fd = new FunctionDeclaration(t, i, fp); 
            }

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return fd;
    }
    // $ANTLR end functionDecl


    // $ANTLR start formalParameters
    // ulNoActions.g:51:1: formalParameters returns [FormalParameterList fpList] : (t= compoundType i= identifier (fp= moreFormals )* | );
    public final FormalParameterList formalParameters() throws RecognitionException {
        FormalParameterList fpList = null;

        TypeNode t = null;

        Identifier i = null;

        FormalParameter fp = null;



          fpList = new FormalParameterList();

        try {
            // ulNoActions.g:56:1: (t= compoundType i= identifier (fp= moreFormals )* | )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==TYPE) ) {
                alt3=1;
            }
            else if ( (LA3_0==24) ) {
                alt3=2;
            }
            else {
                if (backtracking>0) {failed=true; return fpList;}
                NoViableAltException nvae =
                    new NoViableAltException("51:1: formalParameters returns [FormalParameterList fpList] : (t= compoundType i= identifier (fp= moreFormals )* | );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ulNoActions.g:57:3: t= compoundType i= identifier (fp= moreFormals )*
                    {
                    pushFollow(FOLLOW_compoundType_in_formalParameters134);
                    t=compoundType();
                    _fsp--;
                    if (failed) return fpList;
                    pushFollow(FOLLOW_identifier_in_formalParameters138);
                    i=identifier();
                    _fsp--;
                    if (failed) return fpList;
                    if ( backtracking==0 ) {
                       fpList.addElement(new FormalParameter(t, i)); 
                    }
                    // ulNoActions.g:57:81: (fp= moreFormals )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==25) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ulNoActions.g:57:83: fp= moreFormals
                    	    {
                    	    pushFollow(FOLLOW_moreFormals_in_formalParameters146);
                    	    fp=moreFormals();
                    	    _fsp--;
                    	    if (failed) return fpList;
                    	    if ( backtracking==0 ) {
                    	       fpList.addElement(fp); 
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // ulNoActions.g:59:3: 
                    {
                    }
                    break;

            }
        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return fpList;
    }
    // $ANTLR end formalParameters


    // $ANTLR start moreFormals
    // ulNoActions.g:61:1: moreFormals returns [FormalParameter fp] : ',' t= compoundType i= identifier ;
    public final FormalParameter moreFormals() throws RecognitionException {
        FormalParameter fp = null;

        TypeNode t = null;

        Identifier i = null;


        try {
            // ulNoActions.g:61:41: ( ',' t= compoundType i= identifier )
            // ulNoActions.g:62:3: ',' t= compoundType i= identifier
            {
            match(input,25,FOLLOW_25_in_moreFormals173); if (failed) return fp;
            pushFollow(FOLLOW_compoundType_in_moreFormals177);
            t=compoundType();
            _fsp--;
            if (failed) return fp;
            pushFollow(FOLLOW_identifier_in_moreFormals181);
            i=identifier();
            _fsp--;
            if (failed) return fp;
            if ( backtracking==0 ) {
               fp = new FormalParameter(t, i); 
            }

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return fp;
    }
    // $ANTLR end moreFormals


    // $ANTLR start functionBody
    // ulNoActions.g:65:1: functionBody returns [FunctionBody fb] : '{' (vd= varDecl )* (s= statement )* '}' ;
    public final FunctionBody functionBody() throws RecognitionException {
        FunctionBody fb = null;

        VariableDeclaration vd = null;

        Statement s = null;



          fb = new FunctionBody();

        try {
            // ulNoActions.g:70:3: ( '{' (vd= varDecl )* (s= statement )* '}' )
            // ulNoActions.g:70:5: '{' (vd= varDecl )* (s= statement )* '}'
            {
            match(input,26,FOLLOW_26_in_functionBody205); if (failed) return fb;
            // ulNoActions.g:70:9: (vd= varDecl )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==TYPE) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ulNoActions.g:70:11: vd= varDecl
            	    {
            	    pushFollow(FOLLOW_varDecl_in_functionBody211);
            	    vd=varDecl();
            	    _fsp--;
            	    if (failed) return fb;
            	    if ( backtracking==0 ) {
            	       fb.vdList.addElement(vd); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // ulNoActions.g:70:54: (s= statement )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==ID||LA5_0==IF||(LA5_0>=WHILE && LA5_0<=FALSE)||LA5_0==23||LA5_0==28) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ulNoActions.g:70:56: s= statement
            	    {
            	    pushFollow(FOLLOW_statement_in_functionBody221);
            	    s=statement();
            	    _fsp--;
            	    if (failed) return fb;
            	    if ( backtracking==0 ) {
            	       fb.sList.addElement(s); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match(input,27,FOLLOW_27_in_functionBody227); if (failed) return fb;

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return fb;
    }
    // $ANTLR end functionBody


    // $ANTLR start varDecl
    // ulNoActions.g:73:1: varDecl returns [VariableDeclaration vd] : t= compoundType i= identifier ';' ;
    public final VariableDeclaration varDecl() throws RecognitionException {
        VariableDeclaration vd = null;

        TypeNode t = null;

        Identifier i = null;


        try {
            // ulNoActions.g:73:41: (t= compoundType i= identifier ';' )
            // ulNoActions.g:74:3: t= compoundType i= identifier ';'
            {
            pushFollow(FOLLOW_compoundType_in_varDecl247);
            t=compoundType();
            _fsp--;
            if (failed) return vd;
            pushFollow(FOLLOW_identifier_in_varDecl251);
            i=identifier();
            _fsp--;
            if (failed) return vd;
            match(input,28,FOLLOW_28_in_varDecl253); if (failed) return vd;
            if ( backtracking==0 ) {
               vd = new VariableDeclaration(t, i); 
            }

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return vd;
    }
    // $ANTLR end varDecl


    // $ANTLR start compoundType
    // ulNoActions.g:77:1: compoundType returns [TypeNode tn] : (t= type | t= type '[' i= intLiteral ']' );
    public final TypeNode compoundType() throws RecognitionException {
        TypeNode tn = null;

        TypeNode t = null;

        IntegerLiteral i = null;


        try {
            // ulNoActions.g:77:35: (t= type | t= type '[' i= intLiteral ']' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==TYPE) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==ID) ) {
                    alt6=1;
                }
                else if ( (LA6_1==29) ) {
                    alt6=2;
                }
                else {
                    if (backtracking>0) {failed=true; return tn;}
                    NoViableAltException nvae =
                        new NoViableAltException("77:1: compoundType returns [TypeNode tn] : (t= type | t= type '[' i= intLiteral ']' );", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return tn;}
                NoViableAltException nvae =
                    new NoViableAltException("77:1: compoundType returns [TypeNode tn] : (t= type | t= type '[' i= intLiteral ']' );", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ulNoActions.g:78:3: t= type
                    {
                    pushFollow(FOLLOW_type_in_compoundType274);
                    t=type();
                    _fsp--;
                    if (failed) return tn;
                    if ( backtracking==0 ) {
                       tn = t; 
                    }

                    }
                    break;
                case 2 :
                    // ulNoActions.g:79:5: t= type '[' i= intLiteral ']'
                    {
                    pushFollow(FOLLOW_type_in_compoundType284);
                    t=type();
                    _fsp--;
                    if (failed) return tn;
                    match(input,29,FOLLOW_29_in_compoundType286); if (failed) return tn;
                    pushFollow(FOLLOW_intLiteral_in_compoundType290);
                    i=intLiteral();
                    _fsp--;
                    if (failed) return tn;
                    match(input,30,FOLLOW_30_in_compoundType292); if (failed) return tn;
                    if ( backtracking==0 ) {
                       tn = new TypeNode(t.type, i, t.line, t.offset); 
                    }

                    }
                    break;

            }
        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return tn;
    }
    // $ANTLR end compoundType


    // $ANTLR start identifier
    // ulNoActions.g:82:1: identifier returns [Identifier i] : ID ;
    public final Identifier identifier() throws RecognitionException {
        Identifier i = null;

        Token ID1=null;

        try {
            // ulNoActions.g:82:34: ( ID )
            // ulNoActions.g:83:3: ID
            {
            ID1=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_identifier311); if (failed) return i;
            if ( backtracking==0 ) {
               i = new Identifier(ID1.getText(), ID1.getLine(), ID1.getCharPositionInLine()); 
            }

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return i;
    }
    // $ANTLR end identifier


    // $ANTLR start type
    // ulNoActions.g:86:1: type returns [TypeNode ty] : t= TYPE ;
    public final TypeNode type() throws RecognitionException {
        TypeNode ty = null;

        Token t=null;

        try {
            // ulNoActions.g:86:27: (t= TYPE )
            // ulNoActions.g:87:3: t= TYPE
            {
            t=(Token)input.LT(1);
            match(input,TYPE,FOLLOW_TYPE_in_type334); if (failed) return ty;
            if ( backtracking==0 ) {

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

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return ty;
    }
    // $ANTLR end type


    // $ANTLR start statement
    // ulNoActions.g:116:1: statement returns [Statement s] options {backtrack=true; } : ( ';' | es= expressionStatement | is= ifStatement | ws= whileStatement | ps= printStatement | pls= printlnStatement | rs= returnStatement | as= assignmentStatement | aas= arrayAssignmentStatement );
    public final Statement statement() throws RecognitionException {
        Statement s = null;

        ExpressionStatement es = null;

        IfStatement is = null;

        WhileStatement ws = null;

        PrintStatement ps = null;

        PrintlnStatement pls = null;

        ReturnStatement rs = null;

        AssignmentStatement as = null;

        ArrayAssignmentStatement aas = null;


        try {
            // ulNoActions.g:116:63: ( ';' | es= expressionStatement | is= ifStatement | ws= whileStatement | ps= printStatement | pls= printlnStatement | rs= returnStatement | as= assignmentStatement | aas= arrayAssignmentStatement )
            int alt7=9;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt7=1;
                }
                break;
            case ID:
                {
                int LA7_2 = input.LA(2);

                if ( (synpred2()) ) {
                    alt7=2;
                }
                else if ( (synpred8()) ) {
                    alt7=8;
                }
                else if ( (true) ) {
                    alt7=9;
                }
                else {
                    if (backtracking>0) {failed=true; return s;}
                    NoViableAltException nvae =
                        new NoViableAltException("116:1: statement returns [Statement s] options {backtrack=true; } : ( ';' | es= expressionStatement | is= ifStatement | ws= whileStatement | ps= printStatement | pls= printlnStatement | rs= returnStatement | as= assignmentStatement | aas= arrayAssignmentStatement );", 7, 2, input);

                    throw nvae;
                }
                }
                break;
            case STRINGCONSTANT:
            case INTEGERCONSTANT:
            case FLOATCONSTANT:
            case CHARACTERCONSTANT:
            case TRUE:
            case FALSE:
            case 23:
                {
                alt7=2;
                }
                break;
            case IF:
                {
                alt7=3;
                }
                break;
            case WHILE:
                {
                alt7=4;
                }
                break;
            case PRINT:
                {
                alt7=5;
                }
                break;
            case PRINTLN:
                {
                alt7=6;
                }
                break;
            case RETURN:
                {
                alt7=7;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return s;}
                NoViableAltException nvae =
                    new NoViableAltException("116:1: statement returns [Statement s] options {backtrack=true; } : ( ';' | es= expressionStatement | is= ifStatement | ws= whileStatement | ps= printStatement | pls= printlnStatement | rs= returnStatement | as= assignmentStatement | aas= arrayAssignmentStatement );", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ulNoActions.g:117:3: ';'
                    {
                    match(input,28,FOLLOW_28_in_statement367); if (failed) return s;
                    if ( backtracking==0 ) {
                       s = new ExpressionStatement(); 
                    }

                    }
                    break;
                case 2 :
                    // ulNoActions.g:118:5: es= expressionStatement
                    {
                    pushFollow(FOLLOW_expressionStatement_in_statement377);
                    es=expressionStatement();
                    _fsp--;
                    if (failed) return s;
                    if ( backtracking==0 ) {
                       s = es; 
                    }

                    }
                    break;
                case 3 :
                    // ulNoActions.g:119:5: is= ifStatement
                    {
                    pushFollow(FOLLOW_ifStatement_in_statement387);
                    is=ifStatement();
                    _fsp--;
                    if (failed) return s;
                    if ( backtracking==0 ) {
                       s = is; 
                    }

                    }
                    break;
                case 4 :
                    // ulNoActions.g:120:5: ws= whileStatement
                    {
                    pushFollow(FOLLOW_whileStatement_in_statement397);
                    ws=whileStatement();
                    _fsp--;
                    if (failed) return s;
                    if ( backtracking==0 ) {
                       s = ws; 
                    }

                    }
                    break;
                case 5 :
                    // ulNoActions.g:121:5: ps= printStatement
                    {
                    pushFollow(FOLLOW_printStatement_in_statement407);
                    ps=printStatement();
                    _fsp--;
                    if (failed) return s;
                    if ( backtracking==0 ) {
                       s = ps; 
                    }

                    }
                    break;
                case 6 :
                    // ulNoActions.g:122:5: pls= printlnStatement
                    {
                    pushFollow(FOLLOW_printlnStatement_in_statement417);
                    pls=printlnStatement();
                    _fsp--;
                    if (failed) return s;
                    if ( backtracking==0 ) {
                       s = pls; 
                    }

                    }
                    break;
                case 7 :
                    // ulNoActions.g:123:5: rs= returnStatement
                    {
                    pushFollow(FOLLOW_returnStatement_in_statement427);
                    rs=returnStatement();
                    _fsp--;
                    if (failed) return s;
                    if ( backtracking==0 ) {
                       s = rs; 
                    }

                    }
                    break;
                case 8 :
                    // ulNoActions.g:124:5: as= assignmentStatement
                    {
                    pushFollow(FOLLOW_assignmentStatement_in_statement437);
                    as=assignmentStatement();
                    _fsp--;
                    if (failed) return s;
                    if ( backtracking==0 ) {
                       s = as; 
                    }

                    }
                    break;
                case 9 :
                    // ulNoActions.g:125:5: aas= arrayAssignmentStatement
                    {
                    pushFollow(FOLLOW_arrayAssignmentStatement_in_statement447);
                    aas=arrayAssignmentStatement();
                    _fsp--;
                    if (failed) return s;
                    if ( backtracking==0 ) {
                       s = aas; 
                    }

                    }
                    break;

            }
        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return s;
    }
    // $ANTLR end statement


    // $ANTLR start expressionStatement
    // ulNoActions.g:128:1: expressionStatement returns [ExpressionStatement es] : e= expr ';' ;
    public final ExpressionStatement expressionStatement() throws RecognitionException {
        ExpressionStatement es = null;

        Expression e = null;


        try {
            // ulNoActions.g:128:53: (e= expr ';' )
            // ulNoActions.g:129:3: e= expr ';'
            {
            pushFollow(FOLLOW_expr_in_expressionStatement468);
            e=expr();
            _fsp--;
            if (failed) return es;
            match(input,28,FOLLOW_28_in_expressionStatement470); if (failed) return es;
            if ( backtracking==0 ) {
               es = new ExpressionStatement(e); 
            }

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return es;
    }
    // $ANTLR end expressionStatement


    // $ANTLR start assignmentStatement
    // ulNoActions.g:132:1: assignmentStatement returns [AssignmentStatement as] : ID '=' e= expr ';' ;
    public final AssignmentStatement assignmentStatement() throws RecognitionException {
        AssignmentStatement as = null;

        Token ID2=null;
        Expression e = null;


        try {
            // ulNoActions.g:132:53: ( ID '=' e= expr ';' )
            // ulNoActions.g:133:3: ID '=' e= expr ';'
            {
            ID2=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_assignmentStatement489); if (failed) return as;
            match(input,31,FOLLOW_31_in_assignmentStatement491); if (failed) return as;
            pushFollow(FOLLOW_expr_in_assignmentStatement495);
            e=expr();
            _fsp--;
            if (failed) return as;
            match(input,28,FOLLOW_28_in_assignmentStatement497); if (failed) return as;
            if ( backtracking==0 ) {
               as = new AssignmentStatement(new Identifier(ID2.getText(), ID2.getLine(), ID2.getCharPositionInLine()), e); 
            }

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return as;
    }
    // $ANTLR end assignmentStatement


    // $ANTLR start arrayAssignmentStatement
    // ulNoActions.g:136:1: arrayAssignmentStatement returns [ArrayAssignmentStatement aas] : ID '[' e1= expr ']' '=' e2= expr ';' ;
    public final ArrayAssignmentStatement arrayAssignmentStatement() throws RecognitionException {
        ArrayAssignmentStatement aas = null;

        Token ID3=null;
        Expression e1 = null;

        Expression e2 = null;


        try {
            // ulNoActions.g:136:64: ( ID '[' e1= expr ']' '=' e2= expr ';' )
            // ulNoActions.g:137:3: ID '[' e1= expr ']' '=' e2= expr ';'
            {
            ID3=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_arrayAssignmentStatement516); if (failed) return aas;
            match(input,29,FOLLOW_29_in_arrayAssignmentStatement518); if (failed) return aas;
            pushFollow(FOLLOW_expr_in_arrayAssignmentStatement522);
            e1=expr();
            _fsp--;
            if (failed) return aas;
            match(input,30,FOLLOW_30_in_arrayAssignmentStatement524); if (failed) return aas;
            match(input,31,FOLLOW_31_in_arrayAssignmentStatement526); if (failed) return aas;
            pushFollow(FOLLOW_expr_in_arrayAssignmentStatement530);
            e2=expr();
            _fsp--;
            if (failed) return aas;
            match(input,28,FOLLOW_28_in_arrayAssignmentStatement532); if (failed) return aas;
            if ( backtracking==0 ) {
               aas = new ArrayAssignmentStatement(new ArrayExpression(new Identifier(ID3.getText(), ID3.getLine(), ID3.getCharPositionInLine()), e1), e2); 
            }

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return aas;
    }
    // $ANTLR end arrayAssignmentStatement


    // $ANTLR start ifStatement
    // ulNoActions.g:140:1: ifStatement returns [IfStatement is] : IF '(' e= expr ')' b1= block (b2= elseStatement )? ;
    public final IfStatement ifStatement() throws RecognitionException {
        IfStatement is = null;

        Expression e = null;

        Block b1 = null;

        Block b2 = null;


        try {
            // ulNoActions.g:140:37: ( IF '(' e= expr ')' b1= block (b2= elseStatement )? )
            // ulNoActions.g:141:3: IF '(' e= expr ')' b1= block (b2= elseStatement )?
            {
            match(input,IF,FOLLOW_IF_in_ifStatement551); if (failed) return is;
            match(input,23,FOLLOW_23_in_ifStatement553); if (failed) return is;
            pushFollow(FOLLOW_expr_in_ifStatement557);
            e=expr();
            _fsp--;
            if (failed) return is;
            match(input,24,FOLLOW_24_in_ifStatement559); if (failed) return is;
            pushFollow(FOLLOW_block_in_ifStatement563);
            b1=block();
            _fsp--;
            if (failed) return is;
            if ( backtracking==0 ) {
               is = new IfStatement(e, b1); 
            }
            // ulNoActions.g:141:63: (b2= elseStatement )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ELSE) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ulNoActions.g:141:65: b2= elseStatement
                    {
                    pushFollow(FOLLOW_elseStatement_in_ifStatement571);
                    b2=elseStatement();
                    _fsp--;
                    if (failed) return is;
                    if ( backtracking==0 ) {
                       is = new IfStatement(e, b1, b2); 
                    }

                    }
                    break;

            }


            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return is;
    }
    // $ANTLR end ifStatement


    // $ANTLR start elseStatement
    // ulNoActions.g:144:1: elseStatement returns [Block b] : ELSE b1= block ;
    public final Block elseStatement() throws RecognitionException {
        Block b = null;

        Block b1 = null;


        try {
            // ulNoActions.g:144:32: ( ELSE b1= block )
            // ulNoActions.g:145:3: ELSE b1= block
            {
            match(input,ELSE,FOLLOW_ELSE_in_elseStatement593); if (failed) return b;
            pushFollow(FOLLOW_block_in_elseStatement597);
            b1=block();
            _fsp--;
            if (failed) return b;
            if ( backtracking==0 ) {
               b = b1; 
            }

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return b;
    }
    // $ANTLR end elseStatement


    // $ANTLR start whileStatement
    // ulNoActions.g:148:1: whileStatement returns [WhileStatement ws] : WHILE '(' e= expr ')' b= block ;
    public final WhileStatement whileStatement() throws RecognitionException {
        WhileStatement ws = null;

        Expression e = null;

        Block b = null;


        try {
            // ulNoActions.g:148:43: ( WHILE '(' e= expr ')' b= block )
            // ulNoActions.g:149:3: WHILE '(' e= expr ')' b= block
            {
            match(input,WHILE,FOLLOW_WHILE_in_whileStatement616); if (failed) return ws;
            match(input,23,FOLLOW_23_in_whileStatement618); if (failed) return ws;
            pushFollow(FOLLOW_expr_in_whileStatement622);
            e=expr();
            _fsp--;
            if (failed) return ws;
            match(input,24,FOLLOW_24_in_whileStatement624); if (failed) return ws;
            pushFollow(FOLLOW_block_in_whileStatement628);
            b=block();
            _fsp--;
            if (failed) return ws;
            if ( backtracking==0 ) {
               ws = new WhileStatement(e, b); 
            }

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return ws;
    }
    // $ANTLR end whileStatement


    // $ANTLR start printStatement
    // ulNoActions.g:152:1: printStatement returns [PrintStatement ps] : PRINT e= expr ';' ;
    public final PrintStatement printStatement() throws RecognitionException {
        PrintStatement ps = null;

        Expression e = null;


        try {
            // ulNoActions.g:152:43: ( PRINT e= expr ';' )
            // ulNoActions.g:153:3: PRINT e= expr ';'
            {
            match(input,PRINT,FOLLOW_PRINT_in_printStatement647); if (failed) return ps;
            pushFollow(FOLLOW_expr_in_printStatement651);
            e=expr();
            _fsp--;
            if (failed) return ps;
            match(input,28,FOLLOW_28_in_printStatement653); if (failed) return ps;
            if ( backtracking==0 ) {
               ps = new PrintStatement(e); 
            }

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return ps;
    }
    // $ANTLR end printStatement


    // $ANTLR start printlnStatement
    // ulNoActions.g:156:1: printlnStatement returns [PrintlnStatement pls] : PRINTLN e= expr ';' ;
    public final PrintlnStatement printlnStatement() throws RecognitionException {
        PrintlnStatement pls = null;

        Expression e = null;


        try {
            // ulNoActions.g:156:48: ( PRINTLN e= expr ';' )
            // ulNoActions.g:157:3: PRINTLN e= expr ';'
            {
            match(input,PRINTLN,FOLLOW_PRINTLN_in_printlnStatement672); if (failed) return pls;
            pushFollow(FOLLOW_expr_in_printlnStatement676);
            e=expr();
            _fsp--;
            if (failed) return pls;
            match(input,28,FOLLOW_28_in_printlnStatement678); if (failed) return pls;
            if ( backtracking==0 ) {
               pls = new PrintlnStatement(e); 
            }

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return pls;
    }
    // $ANTLR end printlnStatement


    // $ANTLR start returnStatement
    // ulNoActions.g:160:1: returnStatement returns [ReturnStatement rs] : RETURN (e= expr )? ';' ;
    public final ReturnStatement returnStatement() throws RecognitionException {
        ReturnStatement rs = null;

        Expression e = null;



          rs = new ReturnStatement();

        try {
            // ulNoActions.g:165:1: ( RETURN (e= expr )? ';' )
            // ulNoActions.g:165:3: RETURN (e= expr )? ';'
            {
            match(input,RETURN,FOLLOW_RETURN_in_returnStatement700); if (failed) return rs;
            // ulNoActions.g:165:10: (e= expr )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==ID||(LA9_0>=STRINGCONSTANT && LA9_0<=FALSE)||LA9_0==23) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ulNoActions.g:165:11: e= expr
                    {
                    pushFollow(FOLLOW_expr_in_returnStatement705);
                    e=expr();
                    _fsp--;
                    if (failed) return rs;
                    if ( backtracking==0 ) {
                       rs = new ReturnStatement(e); 
                    }

                    }
                    break;

            }

            match(input,28,FOLLOW_28_in_returnStatement712); if (failed) return rs;

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return rs;
    }
    // $ANTLR end returnStatement


    // $ANTLR start block
    // ulNoActions.g:168:1: block returns [Block b] : '{' (s= statement )* '}' ;
    public final Block block() throws RecognitionException {
        Block b = null;

        Statement s = null;



          b = new Block();

        try {
            // ulNoActions.g:173:1: ( '{' (s= statement )* '}' )
            // ulNoActions.g:173:3: '{' (s= statement )* '}'
            {
            match(input,26,FOLLOW_26_in_block733); if (failed) return b;
            // ulNoActions.g:173:7: (s= statement )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==ID||LA10_0==IF||(LA10_0>=WHILE && LA10_0<=FALSE)||LA10_0==23||LA10_0==28) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ulNoActions.g:173:8: s= statement
            	    {
            	    pushFollow(FOLLOW_statement_in_block738);
            	    s=statement();
            	    _fsp--;
            	    if (failed) return b;
            	    if ( backtracking==0 ) {
            	       b.sList.addElement(s); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            match(input,27,FOLLOW_27_in_block745); if (failed) return b;

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return b;
    }
    // $ANTLR end block


    // $ANTLR start expr
    // ulNoActions.g:177:1: expr returns [Expression e] : e1= lessExpr ( '==' e2= lessExpr )* ;
    public final Expression expr() throws RecognitionException {
        Expression e = null;

        Expression e1 = null;

        Expression e2 = null;



          Expression it = null;

        try {
            // ulNoActions.g:186:3: (e1= lessExpr ( '==' e2= lessExpr )* )
            // ulNoActions.g:186:5: e1= lessExpr ( '==' e2= lessExpr )*
            {
            pushFollow(FOLLOW_lessExpr_in_expr776);
            e1=lessExpr();
            _fsp--;
            if (failed) return e;
            if ( backtracking==0 ) {
               it = e1; 
            }
            // ulNoActions.g:186:30: ( '==' e2= lessExpr )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==32) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ulNoActions.g:186:32: '==' e2= lessExpr
            	    {
            	    match(input,32,FOLLOW_32_in_expr782); if (failed) return e;
            	    pushFollow(FOLLOW_lessExpr_in_expr786);
            	    e2=lessExpr();
            	    _fsp--;
            	    if (failed) return e;
            	    if ( backtracking==0 ) {
            	       it = new EqualityExpression(it, e2); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

            if ( backtracking==0 ) {

                e = it;

            }
        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return e;
    }
    // $ANTLR end expr


    // $ANTLR start lessExpr
    // ulNoActions.g:189:1: lessExpr returns [Expression e] : e1= addExpr ( '<' e2= addExpr )* ;
    public final Expression lessExpr() throws RecognitionException {
        Expression e = null;

        Expression e1 = null;

        Expression e2 = null;


        try {
            // ulNoActions.g:189:32: (e1= addExpr ( '<' e2= addExpr )* )
            // ulNoActions.g:190:3: e1= addExpr ( '<' e2= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_lessExpr811);
            e1=addExpr();
            _fsp--;
            if (failed) return e;
            if ( backtracking==0 ) {
               e = e1; 
            }
            // ulNoActions.g:190:26: ( '<' e2= addExpr )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==33) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ulNoActions.g:190:28: '<' e2= addExpr
            	    {
            	    match(input,33,FOLLOW_33_in_lessExpr817); if (failed) return e;
            	    pushFollow(FOLLOW_addExpr_in_lessExpr821);
            	    e2=addExpr();
            	    _fsp--;
            	    if (failed) return e;
            	    if ( backtracking==0 ) {
            	       e = new LessThanExpression(e, e2); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return e;
    }
    // $ANTLR end lessExpr


    // $ANTLR start addExpr
    // ulNoActions.g:193:1: addExpr returns [Expression e] : e1= multExpr ( '+' e2= multExpr | '-' e2= multExpr )* ;
    public final Expression addExpr() throws RecognitionException {
        Expression e = null;

        Expression e1 = null;

        Expression e2 = null;


        try {
            // ulNoActions.g:193:31: (e1= multExpr ( '+' e2= multExpr | '-' e2= multExpr )* )
            // ulNoActions.g:194:3: e1= multExpr ( '+' e2= multExpr | '-' e2= multExpr )*
            {
            pushFollow(FOLLOW_multExpr_in_addExpr845);
            e1=multExpr();
            _fsp--;
            if (failed) return e;
            if ( backtracking==0 ) {
               e = e1; 
            }
            // ulNoActions.g:194:27: ( '+' e2= multExpr | '-' e2= multExpr )*
            loop13:
            do {
                int alt13=3;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==34) ) {
                    alt13=1;
                }
                else if ( (LA13_0==35) ) {
                    alt13=2;
                }


                switch (alt13) {
            	case 1 :
            	    // ulNoActions.g:194:29: '+' e2= multExpr
            	    {
            	    match(input,34,FOLLOW_34_in_addExpr851); if (failed) return e;
            	    pushFollow(FOLLOW_multExpr_in_addExpr855);
            	    e2=multExpr();
            	    _fsp--;
            	    if (failed) return e;
            	    if ( backtracking==0 ) {
            	       e = new AddExpression(e, e2); 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // ulNoActions.g:195:27: '-' e2= multExpr
            	    {
            	    match(input,35,FOLLOW_35_in_addExpr886); if (failed) return e;
            	    pushFollow(FOLLOW_multExpr_in_addExpr890);
            	    e2=multExpr();
            	    _fsp--;
            	    if (failed) return e;
            	    if ( backtracking==0 ) {
            	       e = new SubtractExpression(e, e2); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return e;
    }
    // $ANTLR end addExpr


    // $ANTLR start multExpr
    // ulNoActions.g:198:1: multExpr returns [Expression e] : e1= atom ( '*' e2= atom )* ;
    public final Expression multExpr() throws RecognitionException {
        Expression e = null;

        Expression e1 = null;

        Expression e2 = null;


        try {
            // ulNoActions.g:198:32: (e1= atom ( '*' e2= atom )* )
            // ulNoActions.g:199:3: e1= atom ( '*' e2= atom )*
            {
            pushFollow(FOLLOW_atom_in_multExpr914);
            e1=atom();
            _fsp--;
            if (failed) return e;
            if ( backtracking==0 ) {
               e = e1; 
            }
            // ulNoActions.g:199:23: ( '*' e2= atom )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==36) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ulNoActions.g:199:25: '*' e2= atom
            	    {
            	    match(input,36,FOLLOW_36_in_multExpr920); if (failed) return e;
            	    pushFollow(FOLLOW_atom_in_multExpr924);
            	    e2=atom();
            	    _fsp--;
            	    if (failed) return e;
            	    if ( backtracking==0 ) {
            	       e = new MultExpression(e, e2); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return e;
    }
    // $ANTLR end multExpr


    // $ANTLR start parenExpr
    // ulNoActions.g:202:1: parenExpr returns [ParenExpression e] : '(' e1= expr ')' ;
    public final ParenExpression parenExpr() throws RecognitionException {
        ParenExpression e = null;

        Expression e1 = null;


        try {
            // ulNoActions.g:202:38: ( '(' e1= expr ')' )
            // ulNoActions.g:203:3: '(' e1= expr ')'
            {
            match(input,23,FOLLOW_23_in_parenExpr946); if (failed) return e;
            pushFollow(FOLLOW_expr_in_parenExpr950);
            e1=expr();
            _fsp--;
            if (failed) return e;
            match(input,24,FOLLOW_24_in_parenExpr952); if (failed) return e;
            if ( backtracking==0 ) {
               e = new ParenExpression(e1); 
            }

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return e;
    }
    // $ANTLR end parenExpr


    // $ANTLR start atom
    // ulNoActions.g:206:1: atom returns [Expression e] : ( ID | l= literal | e1= parenExpr | ID '[' arrayexpr= expr ']' | ID '(' funclist= exprList ')' );
    public final Expression atom() throws RecognitionException {
        Expression e = null;

        Token ID4=null;
        Token ID5=null;
        Token ID6=null;
        Expression l = null;

        ParenExpression e1 = null;

        Expression arrayexpr = null;

        ExpressionList funclist = null;


        try {
            // ulNoActions.g:206:28: ( ID | l= literal | e1= parenExpr | ID '[' arrayexpr= expr ']' | ID '(' funclist= exprList ')' )
            int alt15=5;
            switch ( input.LA(1) ) {
            case ID:
                {
                switch ( input.LA(2) ) {
                case 29:
                    {
                    alt15=4;
                    }
                    break;
                case 23:
                    {
                    alt15=5;
                    }
                    break;
                case 24:
                case 25:
                case 28:
                case 30:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                    {
                    alt15=1;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return e;}
                    NoViableAltException nvae =
                        new NoViableAltException("206:1: atom returns [Expression e] : ( ID | l= literal | e1= parenExpr | ID '[' arrayexpr= expr ']' | ID '(' funclist= exprList ')' );", 15, 1, input);

                    throw nvae;
                }

                }
                break;
            case STRINGCONSTANT:
            case INTEGERCONSTANT:
            case FLOATCONSTANT:
            case CHARACTERCONSTANT:
            case TRUE:
            case FALSE:
                {
                alt15=2;
                }
                break;
            case 23:
                {
                alt15=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return e;}
                NoViableAltException nvae =
                    new NoViableAltException("206:1: atom returns [Expression e] : ( ID | l= literal | e1= parenExpr | ID '[' arrayexpr= expr ']' | ID '(' funclist= exprList ')' );", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ulNoActions.g:207:3: ID
                    {
                    ID4=(Token)input.LT(1);
                    match(input,ID,FOLLOW_ID_in_atom971); if (failed) return e;
                    if ( backtracking==0 ) {
                       e = new IdentifierExpression(new Identifier(ID4.getText(), ID4.getLine(), ID4.getCharPositionInLine())); 
                    }

                    }
                    break;
                case 2 :
                    // ulNoActions.g:208:5: l= literal
                    {
                    pushFollow(FOLLOW_literal_in_atom981);
                    l=literal();
                    _fsp--;
                    if (failed) return e;
                    if ( backtracking==0 ) {
                       e = l; 
                    }

                    }
                    break;
                case 3 :
                    // ulNoActions.g:209:5: e1= parenExpr
                    {
                    pushFollow(FOLLOW_parenExpr_in_atom991);
                    e1=parenExpr();
                    _fsp--;
                    if (failed) return e;
                    if ( backtracking==0 ) {
                       e = e1; 
                    }

                    }
                    break;
                case 4 :
                    // ulNoActions.g:210:5: ID '[' arrayexpr= expr ']'
                    {
                    ID5=(Token)input.LT(1);
                    match(input,ID,FOLLOW_ID_in_atom999); if (failed) return e;
                    match(input,29,FOLLOW_29_in_atom1001); if (failed) return e;
                    pushFollow(FOLLOW_expr_in_atom1005);
                    arrayexpr=expr();
                    _fsp--;
                    if (failed) return e;
                    match(input,30,FOLLOW_30_in_atom1007); if (failed) return e;
                    if ( backtracking==0 ) {
                       e = new ArrayExpression(new Identifier(ID5.getText(), ID5.getLine(), ID5.getCharPositionInLine()), arrayexpr); 
                    }

                    }
                    break;
                case 5 :
                    // ulNoActions.g:211:5: ID '(' funclist= exprList ')'
                    {
                    ID6=(Token)input.LT(1);
                    match(input,ID,FOLLOW_ID_in_atom1015); if (failed) return e;
                    match(input,23,FOLLOW_23_in_atom1017); if (failed) return e;
                    pushFollow(FOLLOW_exprList_in_atom1021);
                    funclist=exprList();
                    _fsp--;
                    if (failed) return e;
                    match(input,24,FOLLOW_24_in_atom1023); if (failed) return e;
                    if ( backtracking==0 ) {
                       e = new FunctionExpression(new Identifier(ID6.getText(), ID6.getLine(), ID6.getCharPositionInLine()), funclist); 
                    }

                    }
                    break;

            }
        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return e;
    }
    // $ANTLR end atom


    // $ANTLR start literal
    // ulNoActions.g:214:1: literal returns [Expression e] : (sl= stringLiteral | il= intLiteral | fl= floatLiteral | cl= characterLiteral | bl= booleanLiteral );
    public final Expression literal() throws RecognitionException {
        Expression e = null;

        StringLiteral sl = null;

        IntegerLiteral il = null;

        FloatLiteral fl = null;

        CharacterLiteral cl = null;

        BooleanLiteral bl = null;


        try {
            // ulNoActions.g:214:31: (sl= stringLiteral | il= intLiteral | fl= floatLiteral | cl= characterLiteral | bl= booleanLiteral )
            int alt16=5;
            switch ( input.LA(1) ) {
            case STRINGCONSTANT:
                {
                alt16=1;
                }
                break;
            case INTEGERCONSTANT:
                {
                alt16=2;
                }
                break;
            case FLOATCONSTANT:
                {
                alt16=3;
                }
                break;
            case CHARACTERCONSTANT:
                {
                alt16=4;
                }
                break;
            case TRUE:
            case FALSE:
                {
                alt16=5;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return e;}
                NoViableAltException nvae =
                    new NoViableAltException("214:1: literal returns [Expression e] : (sl= stringLiteral | il= intLiteral | fl= floatLiteral | cl= characterLiteral | bl= booleanLiteral );", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ulNoActions.g:215:3: sl= stringLiteral
                    {
                    pushFollow(FOLLOW_stringLiteral_in_literal1044);
                    sl=stringLiteral();
                    _fsp--;
                    if (failed) return e;
                    if ( backtracking==0 ) {
                       e = sl; 
                    }

                    }
                    break;
                case 2 :
                    // ulNoActions.g:216:5: il= intLiteral
                    {
                    pushFollow(FOLLOW_intLiteral_in_literal1054);
                    il=intLiteral();
                    _fsp--;
                    if (failed) return e;
                    if ( backtracking==0 ) {
                       e = il; 
                    }

                    }
                    break;
                case 3 :
                    // ulNoActions.g:217:5: fl= floatLiteral
                    {
                    pushFollow(FOLLOW_floatLiteral_in_literal1064);
                    fl=floatLiteral();
                    _fsp--;
                    if (failed) return e;
                    if ( backtracking==0 ) {
                       e = fl; 
                    }

                    }
                    break;
                case 4 :
                    // ulNoActions.g:218:5: cl= characterLiteral
                    {
                    pushFollow(FOLLOW_characterLiteral_in_literal1074);
                    cl=characterLiteral();
                    _fsp--;
                    if (failed) return e;
                    if ( backtracking==0 ) {
                       e = cl; 
                    }

                    }
                    break;
                case 5 :
                    // ulNoActions.g:219:5: bl= booleanLiteral
                    {
                    pushFollow(FOLLOW_booleanLiteral_in_literal1084);
                    bl=booleanLiteral();
                    _fsp--;
                    if (failed) return e;
                    if ( backtracking==0 ) {
                       e = bl; 
                    }

                    }
                    break;

            }
        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return e;
    }
    // $ANTLR end literal


    // $ANTLR start stringLiteral
    // ulNoActions.g:222:1: stringLiteral returns [StringLiteral sl] : STRINGCONSTANT ;
    public final StringLiteral stringLiteral() throws RecognitionException {
        StringLiteral sl = null;

        Token STRINGCONSTANT7=null;

        try {
            // ulNoActions.g:222:41: ( STRINGCONSTANT )
            // ulNoActions.g:223:3: STRINGCONSTANT
            {
            STRINGCONSTANT7=(Token)input.LT(1);
            match(input,STRINGCONSTANT,FOLLOW_STRINGCONSTANT_in_stringLiteral1103); if (failed) return sl;
            if ( backtracking==0 ) {
               sl = new StringLiteral(STRINGCONSTANT7.getText(), STRINGCONSTANT7.getLine(), STRINGCONSTANT7.getCharPositionInLine()); 
            }

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return sl;
    }
    // $ANTLR end stringLiteral


    // $ANTLR start intLiteral
    // ulNoActions.g:226:1: intLiteral returns [IntegerLiteral il] : INTEGERCONSTANT ;
    public final IntegerLiteral intLiteral() throws RecognitionException {
        IntegerLiteral il = null;

        Token INTEGERCONSTANT8=null;

        try {
            // ulNoActions.g:226:39: ( INTEGERCONSTANT )
            // ulNoActions.g:227:3: INTEGERCONSTANT
            {
            INTEGERCONSTANT8=(Token)input.LT(1);
            match(input,INTEGERCONSTANT,FOLLOW_INTEGERCONSTANT_in_intLiteral1122); if (failed) return il;
            if ( backtracking==0 ) {
               il = new IntegerLiteral(Integer.parseInt(INTEGERCONSTANT8.getText()), INTEGERCONSTANT8.getLine(), INTEGERCONSTANT8.getCharPositionInLine()); 
            }

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return il;
    }
    // $ANTLR end intLiteral


    // $ANTLR start floatLiteral
    // ulNoActions.g:230:1: floatLiteral returns [FloatLiteral fl] : FLOATCONSTANT ;
    public final FloatLiteral floatLiteral() throws RecognitionException {
        FloatLiteral fl = null;

        Token FLOATCONSTANT9=null;

        try {
            // ulNoActions.g:230:39: ( FLOATCONSTANT )
            // ulNoActions.g:231:3: FLOATCONSTANT
            {
            FLOATCONSTANT9=(Token)input.LT(1);
            match(input,FLOATCONSTANT,FOLLOW_FLOATCONSTANT_in_floatLiteral1140); if (failed) return fl;
            if ( backtracking==0 ) {
               fl = new FloatLiteral(Float.parseFloat(FLOATCONSTANT9.getText()), FLOATCONSTANT9.getLine(), FLOATCONSTANT9.getCharPositionInLine()); 
            }

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return fl;
    }
    // $ANTLR end floatLiteral


    // $ANTLR start characterLiteral
    // ulNoActions.g:234:1: characterLiteral returns [CharacterLiteral cl] : CHARACTERCONSTANT ;
    public final CharacterLiteral characterLiteral() throws RecognitionException {
        CharacterLiteral cl = null;

        Token CHARACTERCONSTANT10=null;

        try {
            // ulNoActions.g:234:47: ( CHARACTERCONSTANT )
            // ulNoActions.g:235:3: CHARACTERCONSTANT
            {
            CHARACTERCONSTANT10=(Token)input.LT(1);
            match(input,CHARACTERCONSTANT,FOLLOW_CHARACTERCONSTANT_in_characterLiteral1158); if (failed) return cl;
            if ( backtracking==0 ) {
               cl = new CharacterLiteral(CHARACTERCONSTANT10.getText().charAt(1), CHARACTERCONSTANT10.getLine(), CHARACTERCONSTANT10.getCharPositionInLine()); 
            }

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return cl;
    }
    // $ANTLR end characterLiteral


    // $ANTLR start booleanLiteral
    // ulNoActions.g:238:1: booleanLiteral returns [BooleanLiteral bl] : ( TRUE | FALSE );
    public final BooleanLiteral booleanLiteral() throws RecognitionException {
        BooleanLiteral bl = null;

        Token TRUE11=null;
        Token FALSE12=null;

        try {
            // ulNoActions.g:238:43: ( TRUE | FALSE )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==TRUE) ) {
                alt17=1;
            }
            else if ( (LA17_0==FALSE) ) {
                alt17=2;
            }
            else {
                if (backtracking>0) {failed=true; return bl;}
                NoViableAltException nvae =
                    new NoViableAltException("238:1: booleanLiteral returns [BooleanLiteral bl] : ( TRUE | FALSE );", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ulNoActions.g:239:3: TRUE
                    {
                    TRUE11=(Token)input.LT(1);
                    match(input,TRUE,FOLLOW_TRUE_in_booleanLiteral1176); if (failed) return bl;
                    if ( backtracking==0 ) {
                       bl = new BooleanLiteral(true, TRUE11.getLine(), TRUE11.getCharPositionInLine()); 
                    }

                    }
                    break;
                case 2 :
                    // ulNoActions.g:240:5: FALSE
                    {
                    FALSE12=(Token)input.LT(1);
                    match(input,FALSE,FOLLOW_FALSE_in_booleanLiteral1184); if (failed) return bl;
                    if ( backtracking==0 ) {
                       bl = new BooleanLiteral(false, FALSE12.getLine(), FALSE12.getCharPositionInLine()); 
                    }

                    }
                    break;

            }
        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return bl;
    }
    // $ANTLR end booleanLiteral


    // $ANTLR start exprList
    // ulNoActions.g:243:1: exprList returns [ExpressionList eList] : (e= expr (em= exprMore )* | );
    public final ExpressionList exprList() throws RecognitionException {
        ExpressionList eList = null;

        Expression e = null;

        Expression em = null;



          eList = new ExpressionList();

        try {
            // ulNoActions.g:248:1: (e= expr (em= exprMore )* | )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==ID||(LA19_0>=STRINGCONSTANT && LA19_0<=FALSE)||LA19_0==23) ) {
                alt19=1;
            }
            else if ( (LA19_0==24) ) {
                alt19=2;
            }
            else {
                if (backtracking>0) {failed=true; return eList;}
                NoViableAltException nvae =
                    new NoViableAltException("243:1: exprList returns [ExpressionList eList] : (e= expr (em= exprMore )* | );", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ulNoActions.g:249:3: e= expr (em= exprMore )*
                    {
                    pushFollow(FOLLOW_expr_in_exprList1211);
                    e=expr();
                    _fsp--;
                    if (failed) return eList;
                    if ( backtracking==0 ) {
                       eList.addElement(e); 
                    }
                    // ulNoActions.g:249:35: (em= exprMore )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==25) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ulNoActions.g:249:36: em= exprMore
                    	    {
                    	    pushFollow(FOLLOW_exprMore_in_exprList1218);
                    	    em=exprMore();
                    	    _fsp--;
                    	    if (failed) return eList;
                    	    if ( backtracking==0 ) {
                    	      eList.addElement(em); 
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // ulNoActions.g:251:3: 
                    {
                    }
                    break;

            }
        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return eList;
    }
    // $ANTLR end exprList


    // $ANTLR start exprMore
    // ulNoActions.g:253:1: exprMore returns [Expression e] : ',' e1= expr ;
    public final Expression exprMore() throws RecognitionException {
        Expression e = null;

        Expression e1 = null;


        try {
            // ulNoActions.g:253:32: ( ',' e1= expr )
            // ulNoActions.g:254:3: ',' e1= expr
            {
            match(input,25,FOLLOW_25_in_exprMore1246); if (failed) return e;
            pushFollow(FOLLOW_expr_in_exprMore1250);
            e1=expr();
            _fsp--;
            if (failed) return e;
            if ( backtracking==0 ) {
               e = e1; 
            }

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return e;
    }
    // $ANTLR end exprMore

    // $ANTLR start synpred2
    public final void synpred2_fragment() throws RecognitionException {   
        // ulNoActions.g:118:5: ( expressionStatement )
        // ulNoActions.g:118:5: expressionStatement
        {
        pushFollow(FOLLOW_expressionStatement_in_synpred2377);
        expressionStatement();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred2

    // $ANTLR start synpred8
    public final void synpred8_fragment() throws RecognitionException {   
        // ulNoActions.g:124:5: ( assignmentStatement )
        // ulNoActions.g:124:5: assignmentStatement
        {
        pushFollow(FOLLOW_assignmentStatement_in_synpred8437);
        assignmentStatement();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred8

    public final boolean synpred8() {
        backtracking++;
        int start = input.mark();
        try {
            synpred8_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred2() {
        backtracking++;
        int start = input.mark();
        try {
            synpred2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_function_in_program45 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_EOF_in_program52 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDecl_in_function71 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_functionBody_in_function75 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compoundType_in_functionDecl95 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_functionDecl99 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_functionDecl101 = new BitSet(new long[]{0x0000000001000020L});
    public static final BitSet FOLLOW_formalParameters_in_functionDecl105 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_functionDecl107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compoundType_in_formalParameters134 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_formalParameters138 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_moreFormals_in_formalParameters146 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_moreFormals173 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_compoundType_in_moreFormals177 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_moreFormals181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_functionBody205 = new BitSet(new long[]{0x000000001883FF70L});
    public static final BitSet FOLLOW_varDecl_in_functionBody211 = new BitSet(new long[]{0x000000001883FF70L});
    public static final BitSet FOLLOW_statement_in_functionBody221 = new BitSet(new long[]{0x000000001883FF50L});
    public static final BitSet FOLLOW_27_in_functionBody227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compoundType_in_varDecl247 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_varDecl251 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_varDecl253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_compoundType274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_compoundType284 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_compoundType286 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_intLiteral_in_compoundType290 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_compoundType292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_identifier311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPE_in_type334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_statement367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStatement_in_statement377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statement387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStatement_in_statement397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_printStatement_in_statement407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_printlnStatement_in_statement417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statement427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_statement437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayAssignmentStatement_in_statement447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_expressionStatement468 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_expressionStatement470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_assignmentStatement489 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_assignmentStatement491 = new BitSet(new long[]{0x000000000083F010L});
    public static final BitSet FOLLOW_expr_in_assignmentStatement495 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_assignmentStatement497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_arrayAssignmentStatement516 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_arrayAssignmentStatement518 = new BitSet(new long[]{0x000000000083F010L});
    public static final BitSet FOLLOW_expr_in_arrayAssignmentStatement522 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_arrayAssignmentStatement524 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_arrayAssignmentStatement526 = new BitSet(new long[]{0x000000000083F010L});
    public static final BitSet FOLLOW_expr_in_arrayAssignmentStatement530 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_arrayAssignmentStatement532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifStatement551 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ifStatement553 = new BitSet(new long[]{0x000000000083F010L});
    public static final BitSet FOLLOW_expr_in_ifStatement557 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ifStatement559 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_block_in_ifStatement563 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_elseStatement_in_ifStatement571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSE_in_elseStatement593 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_block_in_elseStatement597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILE_in_whileStatement616 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_whileStatement618 = new BitSet(new long[]{0x000000000083F010L});
    public static final BitSet FOLLOW_expr_in_whileStatement622 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_whileStatement624 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_block_in_whileStatement628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINT_in_printStatement647 = new BitSet(new long[]{0x000000000083F010L});
    public static final BitSet FOLLOW_expr_in_printStatement651 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_printStatement653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINTLN_in_printlnStatement672 = new BitSet(new long[]{0x000000000083F010L});
    public static final BitSet FOLLOW_expr_in_printlnStatement676 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_printlnStatement678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURN_in_returnStatement700 = new BitSet(new long[]{0x000000001083F010L});
    public static final BitSet FOLLOW_expr_in_returnStatement705 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_returnStatement712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_block733 = new BitSet(new long[]{0x000000001883FF50L});
    public static final BitSet FOLLOW_statement_in_block738 = new BitSet(new long[]{0x000000001883FF50L});
    public static final BitSet FOLLOW_27_in_block745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lessExpr_in_expr776 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_expr782 = new BitSet(new long[]{0x000000000083F010L});
    public static final BitSet FOLLOW_lessExpr_in_expr786 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_addExpr_in_lessExpr811 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_lessExpr817 = new BitSet(new long[]{0x000000000083F010L});
    public static final BitSet FOLLOW_addExpr_in_lessExpr821 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_multExpr_in_addExpr845 = new BitSet(new long[]{0x0000000C00000002L});
    public static final BitSet FOLLOW_34_in_addExpr851 = new BitSet(new long[]{0x000000000083F010L});
    public static final BitSet FOLLOW_multExpr_in_addExpr855 = new BitSet(new long[]{0x0000000C00000002L});
    public static final BitSet FOLLOW_35_in_addExpr886 = new BitSet(new long[]{0x000000000083F010L});
    public static final BitSet FOLLOW_multExpr_in_addExpr890 = new BitSet(new long[]{0x0000000C00000002L});
    public static final BitSet FOLLOW_atom_in_multExpr914 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_36_in_multExpr920 = new BitSet(new long[]{0x000000000083F010L});
    public static final BitSet FOLLOW_atom_in_multExpr924 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_23_in_parenExpr946 = new BitSet(new long[]{0x000000000083F010L});
    public static final BitSet FOLLOW_expr_in_parenExpr950 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parenExpr952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_atom981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parenExpr_in_atom991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom999 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_atom1001 = new BitSet(new long[]{0x000000000083F010L});
    public static final BitSet FOLLOW_expr_in_atom1005 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_atom1007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom1015 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_atom1017 = new BitSet(new long[]{0x000000000183F010L});
    public static final BitSet FOLLOW_exprList_in_atom1021 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_atom1023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringLiteral_in_literal1044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_intLiteral_in_literal1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_floatLiteral_in_literal1064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_characterLiteral_in_literal1074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanLiteral_in_literal1084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRINGCONSTANT_in_stringLiteral1103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGERCONSTANT_in_intLiteral1122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOATCONSTANT_in_floatLiteral1140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARACTERCONSTANT_in_characterLiteral1158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_booleanLiteral1176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_booleanLiteral1184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_exprList1211 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_exprMore_in_exprList1218 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_exprMore1246 = new BitSet(new long[]{0x000000000083F010L});
    public static final BitSet FOLLOW_expr_in_exprMore1250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStatement_in_synpred2377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_synpred8437 = new BitSet(new long[]{0x0000000000000002L});

}