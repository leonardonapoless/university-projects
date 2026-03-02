#include <stdio.h>

int main(){
    int cln = 0;
    int z = 10;             // line 1   
    do {                    // line 2 
        z++;                // line 3
        cln++;
    } while (z < 1);        // line 4

    printf("line 3 was executed %d times", cln);
    return 0;
}
