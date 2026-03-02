#include <stdio.h>

int main(){
    int num = 5, primeiro = 0, segundo = 1;
    int proximo, c, d = 0;
    for (c = 0; c < num; c++) {
        if (c <= 1) {
            proximo = c;
        } else {
            proximo = primeiro + segundo;
            primeiro = segundo;
            segundo = proximo;
        }
        d += proximo;
    }
    printf("%d\n", d);

    return 0;
}
