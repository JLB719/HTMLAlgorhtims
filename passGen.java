import java.lang.*;
import java.util.Scanner;
public class passGen {
  public static void main(String[] args) {
    System.out.println(password(5, 12));
  }
  public static String password(int mLength, int lLength) {
    int length = (int)(Math.random() * ((mLength - lLength) + 1)) + lLength;
    String password = passwordGen(length);
    boolean checked = check(password, false, true, true, true);
    while(!checked) {
      System.out.println(password);
      password = passwordGen(length);
      checked = check(password, false, true, true, true);
    }
    return password;
  }
  public static char gen() {
    int max = 94;
    int min = 1;
    int random = (int)(Math.random() * ((max - min) + 1)) + min;
    int con = random + 32;
    return (char)con;
  }
  public static String passwordGen(int maxLen) {
    String password = "";
    for(int i = 0; i < maxLen; i++) {
      password += gen();
    }
    return password;
  }
  public static boolean check(String password, boolean l, boolean u, boolean s, boolean n) {
    //lowercase
    //uppercase
    //number
    //special characters
    if (l) {
      l = lower(password);
    } else {
      l = true;
    }
    if(u) {
      u = upper(password);
    } else {
      u = true;
    }
    if(s) {
      s = symbol(password);
    } else {
      s = true;
    }
    if(n) {
      n = digit(password);
    } else {
      n =true;
    }
    return l && u && s && n;

  }
  public static boolean upper(String password) {
    for (int i = 0; i < password.length(); i++) {
      char ex = password.charAt(i);
      if (Character.isUpperCase(ex)) {
        return true;
      }
    }
    return false;
  }
  public static boolean lower(String password) {
    for (int i = 0; i < password.length(); i++) {
      char ex = password.charAt(i);
      if (Character.isLowerCase(ex)) {
        return true;
      }
    }
    return false;
  }
  public static boolean digit(String password) {
    for (int i = 0; i < password.length(); i++) {
      char ex = password.charAt(i);
      if (Character.isDigit(ex)) {
        return true;
      }
    }
    return false;
  }
  public static boolean symbol(String password) {
    for (int i = 0; i < password.length(); i++) {
      char ex = password.charAt(i);
      if (!Character.isLetterOrDigit(ex)) {
        return true;
      }
    }
    return false;
  }
}
