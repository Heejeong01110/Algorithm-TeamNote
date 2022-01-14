import java.io.*;
import java.util.*;

public class q1718 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input = br.readLine();
    String rock = br.readLine();
    StringBuilder output = new StringBuilder();

    Integer inputIndex = 0;
    Character cha;
    for (int i = 0; i < input.length(); i++) {
      inputIndex = i % rock.length();

      if (input.charAt(i) == ' ') {
        output.append(" ");
      } else {
        if('a' + (input.charAt(i) - rock.charAt(inputIndex) - 1) > 'z'){
          cha = (char) ('a' + (input.charAt(i) - rock.charAt(inputIndex) - 27));
        }else if('a' + (input.charAt(i) - rock.charAt(inputIndex) - 1) < 'a'){
          cha = (char) ('a' + (input.charAt(i) - rock.charAt(inputIndex) + 25));
        } else {
          cha = (char) ('a' + (input.charAt(i) - rock.charAt(inputIndex) - 1));          
        }
        output.append(cha);
      }
      
    }
    
    System.out.println(output.toString());

    br.close();
  }

}
