package aed;

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
            for (int i = 0; i<= n; i++){
                if (n % i == 0) {
                    divisores = divisores + 1;
                }if (divisores == 3){
                    return false;
                }
            }
        
        return true;
    }

    int sumatoria(int[] numeros) {
        // COMPLETAR
        return 0;
    }

    int busqueda(int[] numeros, int buscado) {
        // COMPLETAR
        return 0;
    }

    boolean tienePrimo(int[] numeros) {
        // COMPLETAR
        return false;
    }

    boolean todosPares(int[] numeros) {
        // COMPLETAR
        return false;
    }

    boolean esPrefijo(String s1, String s2) {
        // COMPLETAR
        return false;
    }

    boolean esSufijo(String s1, String s2) {
        // COMPLETAR
        return false;
    }
}
