
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;

/**
 *
 * @author victor
 */
public class plp4 {

    /**
     * @param args the command line arguments
     */
    
     public static void main(String[] args) throws Exception {
        plp4Lexer lex = new plp4Lexer(new ANTLRFileStream(args[0]));
        CommonTokenStream tokens = new CommonTokenStream(lex);
        plp4Parser parser = new plp4Parser(tokens);
        try {
            String trad = parser.s(args[0]); // S es la regla inicial
            System.out.println(trad);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
