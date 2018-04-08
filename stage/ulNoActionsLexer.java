// $ANTLR 3.0.1 ulNoActions.g 2018-04-08 11:33:20

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ulNoActionsLexer extends Lexer {
    public static final int PRINT=9;
    public static final int PRINTLN=10;
    public static final int COMMENT=22;
    public static final int RETURN=11;
    public static final int UPPER=19;
    public static final int T23=23;
    public static final int T25=25;
    public static final int T24=24;
    public static final int STRINGCONSTANT=12;
    public static final int T27=27;
    public static final int ELSE=7;
    public static final int T26=26;
    public static final int T29=29;
    public static final int ID=4;
    public static final int T28=28;
    public static final int WS=21;
    public static final int EOF=-1;
    public static final int TYPE=5;
    public static final int IF=6;
    public static final int Tokens=37;
    public static final int CHARACTERCONSTANT=15;
    public static final int TRUE=16;
    public static final int FLOATCONSTANT=14;
    public static final int DIGIT=20;
    public static final int T30=30;
    public static final int T32=32;
    public static final int T31=31;
    public static final int INTEGERCONSTANT=13;
    public static final int T34=34;
    public static final int LOWER=18;
    public static final int T33=33;
    public static final int T36=36;
    public static final int T35=35;
    public static final int WHILE=8;
    public static final int FALSE=17;
    public ulNoActionsLexer() {;} 
    public ulNoActionsLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "ulNoActions.g"; }

    // $ANTLR start T23
    public final void mT23() throws RecognitionException {
        try {
            int _type = T23;
            // ulNoActions.g:3:5: ( '(' )
            // ulNoActions.g:3:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T23

    // $ANTLR start T24
    public final void mT24() throws RecognitionException {
        try {
            int _type = T24;
            // ulNoActions.g:4:5: ( ')' )
            // ulNoActions.g:4:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T24

    // $ANTLR start T25
    public final void mT25() throws RecognitionException {
        try {
            int _type = T25;
            // ulNoActions.g:5:5: ( ',' )
            // ulNoActions.g:5:7: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T25

    // $ANTLR start T26
    public final void mT26() throws RecognitionException {
        try {
            int _type = T26;
            // ulNoActions.g:6:5: ( '{' )
            // ulNoActions.g:6:7: '{'
            {
            match('{'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T26

    // $ANTLR start T27
    public final void mT27() throws RecognitionException {
        try {
            int _type = T27;
            // ulNoActions.g:7:5: ( '}' )
            // ulNoActions.g:7:7: '}'
            {
            match('}'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T27

    // $ANTLR start T28
    public final void mT28() throws RecognitionException {
        try {
            int _type = T28;
            // ulNoActions.g:8:5: ( ';' )
            // ulNoActions.g:8:7: ';'
            {
            match(';'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T28

    // $ANTLR start T29
    public final void mT29() throws RecognitionException {
        try {
            int _type = T29;
            // ulNoActions.g:9:5: ( '[' )
            // ulNoActions.g:9:7: '['
            {
            match('['); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T29

    // $ANTLR start T30
    public final void mT30() throws RecognitionException {
        try {
            int _type = T30;
            // ulNoActions.g:10:5: ( ']' )
            // ulNoActions.g:10:7: ']'
            {
            match(']'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T30

    // $ANTLR start T31
    public final void mT31() throws RecognitionException {
        try {
            int _type = T31;
            // ulNoActions.g:11:5: ( '=' )
            // ulNoActions.g:11:7: '='
            {
            match('='); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T31

    // $ANTLR start T32
    public final void mT32() throws RecognitionException {
        try {
            int _type = T32;
            // ulNoActions.g:12:5: ( '==' )
            // ulNoActions.g:12:7: '=='
            {
            match("=="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T32

    // $ANTLR start T33
    public final void mT33() throws RecognitionException {
        try {
            int _type = T33;
            // ulNoActions.g:13:5: ( '<' )
            // ulNoActions.g:13:7: '<'
            {
            match('<'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T33

    // $ANTLR start T34
    public final void mT34() throws RecognitionException {
        try {
            int _type = T34;
            // ulNoActions.g:14:5: ( '+' )
            // ulNoActions.g:14:7: '+'
            {
            match('+'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T34

    // $ANTLR start T35
    public final void mT35() throws RecognitionException {
        try {
            int _type = T35;
            // ulNoActions.g:15:5: ( '-' )
            // ulNoActions.g:15:7: '-'
            {
            match('-'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T35

    // $ANTLR start T36
    public final void mT36() throws RecognitionException {
        try {
            int _type = T36;
            // ulNoActions.g:16:5: ( '*' )
            // ulNoActions.g:16:7: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T36

    // $ANTLR start LOWER
    public final void mLOWER() throws RecognitionException {
        try {
            // ulNoActions.g:260:17: ( 'a' .. 'z' )
            // ulNoActions.g:260:19: 'a' .. 'z'
            {
            matchRange('a','z'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end LOWER

    // $ANTLR start UPPER
    public final void mUPPER() throws RecognitionException {
        try {
            // ulNoActions.g:261:17: ( 'A' .. 'Z' )
            // ulNoActions.g:261:19: 'A' .. 'Z'
            {
            matchRange('A','Z'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end UPPER

    // $ANTLR start DIGIT
    public final void mDIGIT() throws RecognitionException {
        try {
            // ulNoActions.g:262:17: ( '0' .. '9' )
            // ulNoActions.g:262:19: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end DIGIT

    // $ANTLR start IF
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            // ulNoActions.g:265:5: ( 'if' )
            // ulNoActions.g:265:7: 'if'
            {
            match("if"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end IF

    // $ANTLR start ELSE
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            // ulNoActions.g:267:7: ( 'else' )
            // ulNoActions.g:267:9: 'else'
            {
            match("else"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ELSE

    // $ANTLR start PRINT
    public final void mPRINT() throws RecognitionException {
        try {
            int _type = PRINT;
            // ulNoActions.g:269:8: ( 'print' )
            // ulNoActions.g:269:10: 'print'
            {
            match("print"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end PRINT

    // $ANTLR start PRINTLN
    public final void mPRINTLN() throws RecognitionException {
        try {
            int _type = PRINTLN;
            // ulNoActions.g:271:10: ( 'println' )
            // ulNoActions.g:271:12: 'println'
            {
            match("println"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end PRINTLN

    // $ANTLR start RETURN
    public final void mRETURN() throws RecognitionException {
        try {
            int _type = RETURN;
            // ulNoActions.g:273:9: ( 'return' )
            // ulNoActions.g:273:11: 'return'
            {
            match("return"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RETURN

    // $ANTLR start WHILE
    public final void mWHILE() throws RecognitionException {
        try {
            int _type = WHILE;
            // ulNoActions.g:275:8: ( 'while' )
            // ulNoActions.g:275:10: 'while'
            {
            match("while"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WHILE

    // $ANTLR start TYPE
    public final void mTYPE() throws RecognitionException {
        try {
            int _type = TYPE;
            // ulNoActions.g:278:7: ( 'int' | 'float' | 'char' | 'string' | 'boolean' | 'void' )
            int alt1=6;
            switch ( input.LA(1) ) {
            case 'i':
                {
                alt1=1;
                }
                break;
            case 'f':
                {
                alt1=2;
                }
                break;
            case 'c':
                {
                alt1=3;
                }
                break;
            case 's':
                {
                alt1=4;
                }
                break;
            case 'b':
                {
                alt1=5;
                }
                break;
            case 'v':
                {
                alt1=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("278:1: TYPE : ( 'int' | 'float' | 'char' | 'string' | 'boolean' | 'void' );", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ulNoActions.g:278:9: 'int'
                    {
                    match("int"); 


                    }
                    break;
                case 2 :
                    // ulNoActions.g:278:17: 'float'
                    {
                    match("float"); 


                    }
                    break;
                case 3 :
                    // ulNoActions.g:278:27: 'char'
                    {
                    match("char"); 


                    }
                    break;
                case 4 :
                    // ulNoActions.g:278:36: 'string'
                    {
                    match("string"); 


                    }
                    break;
                case 5 :
                    // ulNoActions.g:278:47: 'boolean'
                    {
                    match("boolean"); 


                    }
                    break;
                case 6 :
                    // ulNoActions.g:278:59: 'void'
                    {
                    match("void"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TYPE

    // $ANTLR start STRINGCONSTANT
    public final void mSTRINGCONSTANT() throws RecognitionException {
        try {
            int _type = STRINGCONSTANT;
            // ulNoActions.g:281:17: ( '\"' ( LOWER | UPPER | DIGIT | '_' | '-' | ' ' )* '\"' )
            // ulNoActions.g:281:19: '\"' ( LOWER | UPPER | DIGIT | '_' | '-' | ' ' )* '\"'
            {
            match('\"'); 
            // ulNoActions.g:281:23: ( LOWER | UPPER | DIGIT | '_' | '-' | ' ' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==' '||LA2_0=='-'||(LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ulNoActions.g:
            	    {
            	    if ( input.LA(1)==' '||input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match('\"'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end STRINGCONSTANT

    // $ANTLR start INTEGERCONSTANT
    public final void mINTEGERCONSTANT() throws RecognitionException {
        try {
            int _type = INTEGERCONSTANT;
            // ulNoActions.g:284:17: ( ( DIGIT )+ )
            // ulNoActions.g:284:19: ( DIGIT )+
            {
            // ulNoActions.g:284:19: ( DIGIT )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ulNoActions.g:284:19: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end INTEGERCONSTANT

    // $ANTLR start FLOATCONSTANT
    public final void mFLOATCONSTANT() throws RecognitionException {
        try {
            int _type = FLOATCONSTANT;
            // ulNoActions.g:287:16: ( ( DIGIT )+ '.' ( DIGIT )+ )
            // ulNoActions.g:287:18: ( DIGIT )+ '.' ( DIGIT )+
            {
            // ulNoActions.g:287:18: ( DIGIT )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ulNoActions.g:287:18: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            match('.'); 
            // ulNoActions.g:287:29: ( DIGIT )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ulNoActions.g:287:29: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FLOATCONSTANT

    // $ANTLR start CHARACTERCONSTANT
    public final void mCHARACTERCONSTANT() throws RecognitionException {
        try {
            int _type = CHARACTERCONSTANT;
            // ulNoActions.g:290:20: ( '\\'' ( LOWER | UPPER | DIGIT | ' ' | '_' | '-' ) '\\'' )
            // ulNoActions.g:290:22: '\\'' ( LOWER | UPPER | DIGIT | ' ' | '_' | '-' ) '\\''
            {
            match('\''); 
            if ( input.LA(1)==' '||input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            match('\''); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end CHARACTERCONSTANT

    // $ANTLR start TRUE
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            // ulNoActions.g:293:7: ( 'true' )
            // ulNoActions.g:293:9: 'true'
            {
            match("true"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TRUE

    // $ANTLR start FALSE
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            // ulNoActions.g:296:8: ( 'false' )
            // ulNoActions.g:296:10: 'false'
            {
            match("false"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FALSE

    // $ANTLR start ID
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            // ulNoActions.g:299:5: ( ( LOWER | UPPER | '_' ) ( LOWER | UPPER | DIGIT | '_' )* )
            // ulNoActions.g:299:7: ( LOWER | UPPER | '_' ) ( LOWER | UPPER | DIGIT | '_' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // ulNoActions.g:299:28: ( LOWER | UPPER | DIGIT | '_' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')||(LA6_0>='A' && LA6_0<='Z')||LA6_0=='_'||(LA6_0>='a' && LA6_0<='z')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ulNoActions.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ID

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // ulNoActions.g:307:9: ( ( '\\t' | ' ' | ( '\\r' | '\\n' ) )+ )
            // ulNoActions.g:307:11: ( '\\t' | ' ' | ( '\\r' | '\\n' ) )+
            {
            // ulNoActions.g:307:11: ( '\\t' | ' ' | ( '\\r' | '\\n' ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\t' && LA7_0<='\n')||LA7_0=='\r'||LA7_0==' ') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ulNoActions.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

             channel = HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WS

    // $ANTLR start COMMENT
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            // ulNoActions.g:310:9: ( '//' (~ ( '\\r' | '\\n' ) )* ( '\\r' | '\\n' ) )
            // ulNoActions.g:310:11: '//' (~ ( '\\r' | '\\n' ) )* ( '\\r' | '\\n' )
            {
            match("//"); 

            // ulNoActions.g:310:16: (~ ( '\\r' | '\\n' ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ulNoActions.g:310:16: ~ ( '\\r' | '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

             channel = HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end COMMENT

    public void mTokens() throws RecognitionException {
        // ulNoActions.g:1:8: ( T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | IF | ELSE | PRINT | PRINTLN | RETURN | WHILE | TYPE | STRINGCONSTANT | INTEGERCONSTANT | FLOATCONSTANT | CHARACTERCONSTANT | TRUE | FALSE | ID | WS | COMMENT )
        int alt9=30;
        alt9 = dfa9.predict(input);
        switch (alt9) {
            case 1 :
                // ulNoActions.g:1:10: T23
                {
                mT23(); 

                }
                break;
            case 2 :
                // ulNoActions.g:1:14: T24
                {
                mT24(); 

                }
                break;
            case 3 :
                // ulNoActions.g:1:18: T25
                {
                mT25(); 

                }
                break;
            case 4 :
                // ulNoActions.g:1:22: T26
                {
                mT26(); 

                }
                break;
            case 5 :
                // ulNoActions.g:1:26: T27
                {
                mT27(); 

                }
                break;
            case 6 :
                // ulNoActions.g:1:30: T28
                {
                mT28(); 

                }
                break;
            case 7 :
                // ulNoActions.g:1:34: T29
                {
                mT29(); 

                }
                break;
            case 8 :
                // ulNoActions.g:1:38: T30
                {
                mT30(); 

                }
                break;
            case 9 :
                // ulNoActions.g:1:42: T31
                {
                mT31(); 

                }
                break;
            case 10 :
                // ulNoActions.g:1:46: T32
                {
                mT32(); 

                }
                break;
            case 11 :
                // ulNoActions.g:1:50: T33
                {
                mT33(); 

                }
                break;
            case 12 :
                // ulNoActions.g:1:54: T34
                {
                mT34(); 

                }
                break;
            case 13 :
                // ulNoActions.g:1:58: T35
                {
                mT35(); 

                }
                break;
            case 14 :
                // ulNoActions.g:1:62: T36
                {
                mT36(); 

                }
                break;
            case 15 :
                // ulNoActions.g:1:66: IF
                {
                mIF(); 

                }
                break;
            case 16 :
                // ulNoActions.g:1:69: ELSE
                {
                mELSE(); 

                }
                break;
            case 17 :
                // ulNoActions.g:1:74: PRINT
                {
                mPRINT(); 

                }
                break;
            case 18 :
                // ulNoActions.g:1:80: PRINTLN
                {
                mPRINTLN(); 

                }
                break;
            case 19 :
                // ulNoActions.g:1:88: RETURN
                {
                mRETURN(); 

                }
                break;
            case 20 :
                // ulNoActions.g:1:95: WHILE
                {
                mWHILE(); 

                }
                break;
            case 21 :
                // ulNoActions.g:1:101: TYPE
                {
                mTYPE(); 

                }
                break;
            case 22 :
                // ulNoActions.g:1:106: STRINGCONSTANT
                {
                mSTRINGCONSTANT(); 

                }
                break;
            case 23 :
                // ulNoActions.g:1:121: INTEGERCONSTANT
                {
                mINTEGERCONSTANT(); 

                }
                break;
            case 24 :
                // ulNoActions.g:1:137: FLOATCONSTANT
                {
                mFLOATCONSTANT(); 

                }
                break;
            case 25 :
                // ulNoActions.g:1:151: CHARACTERCONSTANT
                {
                mCHARACTERCONSTANT(); 

                }
                break;
            case 26 :
                // ulNoActions.g:1:169: TRUE
                {
                mTRUE(); 

                }
                break;
            case 27 :
                // ulNoActions.g:1:174: FALSE
                {
                mFALSE(); 

                }
                break;
            case 28 :
                // ulNoActions.g:1:180: ID
                {
                mID(); 

                }
                break;
            case 29 :
                // ulNoActions.g:1:183: WS
                {
                mWS(); 

                }
                break;
            case 30 :
                // ulNoActions.g:1:186: COMMENT
                {
                mCOMMENT(); 

                }
                break;

        }

    }


    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA9_eotS =
        "\11\uffff\1\40\4\uffff\12\34\1\uffff\1\55\1\uffff\1\34\5\uffff\1"+
        "\60\13\34\2\uffff\1\34\1\uffff\1\75\13\34\1\uffff\1\111\5\34\1\75"+
        "\2\34\1\75\1\121\1\uffff\1\123\1\34\1\125\1\126\1\75\2\34\1\uffff"+
        "\1\34\1\uffff\1\132\2\uffff\1\75\1\34\1\134\1\uffff\1\75\1\uffff";
    static final String DFA9_eofS =
        "\135\uffff";
    static final String DFA9_minS =
        "\1\11\10\uffff\1\75\4\uffff\1\146\1\154\1\162\1\145\1\150\1\141"+
        "\1\150\1\164\2\157\1\uffff\1\56\1\uffff\1\162\5\uffff\1\60\1\164"+
        "\1\163\1\151\1\164\1\151\1\154\1\157\1\141\1\162\1\157\1\151\2\uffff"+
        "\1\165\1\uffff\1\60\1\145\1\156\1\165\1\154\1\163\1\141\1\162\1"+
        "\151\1\154\1\144\1\145\1\uffff\1\60\1\164\1\162\2\145\1\164\1\60"+
        "\1\156\1\145\2\60\1\uffff\1\60\1\156\3\60\1\147\1\141\1\uffff\1"+
        "\156\1\uffff\1\60\2\uffff\1\60\1\156\1\60\1\uffff\1\60\1\uffff";
    static final String DFA9_maxS =
        "\1\175\10\uffff\1\75\4\uffff\1\156\1\154\1\162\1\145\1\150\1\154"+
        "\1\150\1\164\2\157\1\uffff\1\71\1\uffff\1\162\5\uffff\1\172\1\164"+
        "\1\163\1\151\1\164\1\151\1\154\1\157\1\141\1\162\1\157\1\151\2\uffff"+
        "\1\165\1\uffff\1\172\1\145\1\156\1\165\1\154\1\163\1\141\1\162\1"+
        "\151\1\154\1\144\1\145\1\uffff\1\172\1\164\1\162\2\145\1\164\1\172"+
        "\1\156\1\145\2\172\1\uffff\1\172\1\156\3\172\1\147\1\141\1\uffff"+
        "\1\156\1\uffff\1\172\2\uffff\1\172\1\156\1\172\1\uffff\1\172\1\uffff";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\13\1\14\1\15"+
        "\1\16\12\uffff\1\26\1\uffff\1\31\1\uffff\1\34\1\35\1\36\1\12\1\11"+
        "\14\uffff\1\27\1\30\1\uffff\1\17\14\uffff\1\25\13\uffff\1\20\7\uffff"+
        "\1\32\1\uffff\1\21\1\uffff\1\24\1\33\3\uffff\1\23\1\uffff\1\22";
    static final String DFA9_specialS =
        "\135\uffff}>";
    static final String[] DFA9_transitionS = {
            "\2\35\2\uffff\1\35\22\uffff\1\35\1\uffff\1\30\4\uffff\1\32\1"+
            "\1\1\2\1\15\1\13\1\3\1\14\1\uffff\1\36\12\31\1\uffff\1\6\1\12"+
            "\1\11\3\uffff\32\34\1\7\1\uffff\1\10\1\uffff\1\34\1\uffff\1"+
            "\34\1\26\1\24\1\34\1\17\1\23\2\34\1\16\6\34\1\20\1\34\1\21\1"+
            "\25\1\33\1\34\1\27\1\22\3\34\1\4\1\uffff\1\5",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\37",
            "",
            "",
            "",
            "",
            "\1\41\7\uffff\1\42",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46",
            "\1\47\12\uffff\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "",
            "\1\56\1\uffff\12\31",
            "",
            "\1\57",
            "",
            "",
            "",
            "",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "",
            "",
            "\1\74",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\117",
            "\1\120",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\13\34\1\122\16\34",
            "\1\124",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\127",
            "\1\130",
            "",
            "\1\131",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\133",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | IF | ELSE | PRINT | PRINTLN | RETURN | WHILE | TYPE | STRINGCONSTANT | INTEGERCONSTANT | FLOATCONSTANT | CHARACTERCONSTANT | TRUE | FALSE | ID | WS | COMMENT );";
        }
    }
 

}