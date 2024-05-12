package aed;

// Cambio para push 

class Funciones {
    int cuadrado(int x) {
        x = x * x;
        return x;
    }

    double distancia(double x, double y) {
        double res = Math.sqrt(x * x + y * y);
        return res;
    }

    boolean esPar(int n) {
        if (n % 2 == 0)
            return true;
        return false;
    }

    boolean esBisiesto(int n) {
        boolean res;
        if (n % 400 == 0 || n % 4 == 0 && n % 100 != 0) {
            res = true;
        } else {
            res = false;
        }
        return res;
    }

    int factorialIterativo(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res = res * i;
        }
        return res;
    }

    int factorialRecursivo(int n) {
        int res = 1;
        if (n != 0) {
            res = n*factorialIterativo(n - 1);
        }
        return res;
    }

    boolean esPrimo(int n) {
        int divisores = 0;
            if (n == 0 || n == 1) {
                return false;
            }for (int i = 1; i<= n; i++) {
                if (n % i == 0) {
                    divisores = divisores + 1;
            } if (divisores == 3) { 
                   return false;
            }
        }
        return true;
    }
    
    int sumatoria(int[] numeros) {
        int res = 0;
            for (int i = 0; i<numeros.length; i++) {
                res = res + numeros[i];
            }
        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        int res = -1;
        for (int i = 0; i<numeros.length; i++) {
            if (numeros[i] == buscado){
                res = i;
            }
        }
        return res;
    }

    boolean tienePrimo(int[] numeros) {
        for (int i=0; i<numeros.length; i++){
            if (esPrimo(numeros[i]) == true){
                return true;
            }
        }
        return false;
    }

    boolean todosPares(int[] numeros) {
            for(int i=0; i<numeros.length; i++){
                if(!(numeros[i] % 2 == 0)){
                    return false;
            }
        }
        return true;
    }

    boolean esPrefijo(String s1, String s2) {
        boolean res = true;
        if(s2.length() < s1.length()){
            res = false;
        }        
        else{
            for (int i=0; i<s1.length(); i++){
                if (!(s1.charAt(i) == s2.charAt(i))){
                    res = false;
                }
            }
        }
        return res;
    }

    boolean esSufijo(String s1, String s2) {
        boolean res = true;
        if (s1.length()>s2.length()){
            res = false;
        }
        else{
            String s2DadoVuelta = "";
            for (int n = (s2.length()-1); n>=0; n = n-1){
                s2DadoVuelta = s2DadoVuelta + (s2.charAt(n));
            }
            String s1DadoVuelta = "";
            for (int i = (s1.length()-1); i >= 0; i = i -1){
            s1DadoVuelta = s1DadoVuelta + (s1.charAt(i));
            }
            res = esPrefijo(s1DadoVuelta , s2DadoVuelta);
            }     
        return res;
    }

}