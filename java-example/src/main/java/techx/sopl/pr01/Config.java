package techx.sopl.pr01;

import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.text.StringEscapeUtils;

public class Config {

  private final Path nfaProgramPath;
  private final byte[] input;

  public Config(String nfaProgramPath, byte[] input) {
    this.nfaProgramPath = Paths.get(nfaProgramPath);
    this.input = input;
  }

  public Path NfaProgramPath() {
    return nfaProgramPath;
  }

  public byte[] Input() {
    return input;
  }

  public String toString() {
    String input;
    try {
      input = new String(this.input, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
    input = StringEscapeUtils.escapeJava(input);
    return String.format("Config(nfa-program-path: %s, input: \"%s\")", nfaProgramPath, input);
  }
}
