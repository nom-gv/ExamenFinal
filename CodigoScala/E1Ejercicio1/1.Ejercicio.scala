object Primero {
   def main(args: Array[String]) {
        print("Primero numero: ")
        var a = scala.io.StdIn.readInt()
        print("Segundo numero: ")
        var b = scala.io.StdIn.readInt()
        println("Suma: " + calculadora("+",a,b));
        println("Resta: " + calculadora("-",a,b));
        println("Multiplicacion: " + calculadora("*",a,b));
        println("Division: " + calculadora("/",a,b));
        
   }
   def suma(x: Int, y: Int) : Int = {
      return x + y
   }
   def resta(x: Int, y: Int) : Int = {
       return x - y
   }
   def multiplicacion(x: Int, y: Int) : Int = {
       return x * y
   }
   def division(x: Int, y: Int) : Int = {
       return x / y
   }

   def calculadora(x: String, y: Int, z: Int): Int = {
        x match { 
            case "+" => suma(y,z)
            case "-" => resta(y,z) 
            case "*" => multiplicacion(y,z)
            case "/" => division(y,z)
        }
    }
}