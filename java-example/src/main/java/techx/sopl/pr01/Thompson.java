package techx.sopl.pr01;
import java.util.*;

public class Thompson {
    public static class LexingError extends Exception {
      public LexingError(String message) {
         super(message);
        }
    }

    public static List<Match> tokenize(List<Instruction> program, byte[] input) throws LexingError {
        ArrayList<Match> matches = new ArrayList<Match>();
        Set<Integer> cqueue = new HashSet();
        Set<Integer> nqueue = new HashSet();
        Integer matchTC = -1;
        Integer matchPC = -1;
        Integer startTC = 0;
        Integer inputLen = input.length;
        int pc;
        cqueue.add(0);
        Instruction inst;

        for(Integer tc = 0; tc <= inputLen; tc++) {
          while(cqueue.size() > 0) {
              Iterator<Integer> curit = cqueue.iterator();
              pc = curit.next();
              curit.remove();
              inst = program.get(pc);

              switch(inst.op) {
                  case "CHAR":
                      if(tc < inputLen && (input[tc] >= inst.X && input[tc] <= inst.Y) ) {
                          nqueue.add(pc+1);
                      }
                      break;
                  case "MATCH":
                      if(matchTC < tc) {
                          matchTC = tc;
                          matchPC = pc;
                      }
                      else if (matchPC > pc ) {
                          matchTC = tc;
                          matchPC = pc;
                      }
                      break;
                  case "JMP":
                      if(inst.X >= program.size()) throw new LexingError("Invalid JUMP at instruction " + pc);
                      cqueue.add(inst.X);
                      break;
                  case "SPLIT":
                      if(inst.X >= program.size() || inst.Y >= program.size()) throw new LexingError("Invalid SPLIT at instruction " + pc);
                      cqueue.add(inst.X);
                      cqueue.add(inst.Y);
                      break;
              }
          }

          Set<Integer> temp = cqueue;
          cqueue = nqueue;
          nqueue = temp;

          if(cqueue.isEmpty() && matchPC != -1) {
              matches.add(new Match(Arrays.copyOfRange(input, startTC, matchTC), matchPC));
              cqueue.add(0);
              startTC = tc;
              matchPC = -1;
              tc -= 1;
          }
        }

        if(matchTC == inputLen){
          return matches;
        }
        else {
          throw new LexingError("Invalid input");
        }
    }
}