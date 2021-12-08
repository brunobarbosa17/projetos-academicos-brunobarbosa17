#include <stdio.h>
//Verificar triangulos
int main() {
    int a,b,c;
    scanf("%d" ,&a);
    scanf("%d" ,&b);
    scanf("%d" ,&c);
    if (a < 90 && b < 90 & c < 90 && a + b + c == 180) {
        printf("Triangulo Acutangulo!");
    } else if (a == 90 || b == 90 ||c == 90 && a + b + c == 180) {
        printf("Triangulo Retangulo!");
    } else if (a > 90 && a < 180 || b > 90 && b < 180  || c > 90 && a < 180 && a + b + c == 180) {
        printf("Triangulo Obtusangulo!");
    } else if (a + b + c > 180 || a + b + c < 180) {
        printf("Nao eh triangulo!");
    }
}