package techx.sopl.pr01;

import java.io.UnsupportedEncodingException;
import org.apache.commons.text.StringEscapeUtils;

public class Match {
    private Integer MatchPC;
    private byte[] Lexeme = new byte[]{};
    
    Match(byte[] Lexeme, Integer MatchPC) {
        this.MatchPC = MatchPC;
        this.Lexeme = Lexeme;
    }
    
    private String LexToString() {
        String lexString;
        try {
          lexString = new String(this.Lexeme, "UTF-8");
        } catch (UnsupportedEncodingException e) {
          throw new RuntimeException(e);
        }
        return StringEscapeUtils.escapeJava(lexString);
    }
    
    public void print() {
       System.out.println(this.MatchPC + ":" + "\"" + LexToString() + "\"");
    }
}