package by.it.astapchik.calculator;


public class VarCreator {
     static Var create(String stringVarValue){
          if (stringVarValue.matches(Patterns.SCALAR)){
               return new Scalar(stringVarValue);
          } else if (stringVarValue.matches(Patterns.VECTOR)){
               return new Vector(stringVarValue);
          } else if (stringVarValue.matches(Patterns.MATRIX)){
               return new Matrix(stringVarValue);
          } else{
               return null;
          }
     }
}
