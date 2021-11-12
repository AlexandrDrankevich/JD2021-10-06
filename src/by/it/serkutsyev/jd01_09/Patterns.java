package by.it.serkutsyev.jd01_09;

public interface Patterns {
   String SEPARATOR =  "[-+/*]";

   String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
   String VECTOR="\\{"+SCALAR+"(,"+SCALAR+")*}";
   String MATRIX = "\\{"+VECTOR+"(,"+VECTOR+")*}";
}
