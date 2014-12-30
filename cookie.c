#include <stdio.h>
#include <stdlib.h>

void handleSolution(int caseNum, FILE *fp)
{
    long double c, f, x;
    long double cookie = 0;    
    long double prod = 2;
    long double time;
    long double time2;
    long double r = 0;
    fscanf(fp, "%Lf %Lf %Lf\n", &c, &f, &x);

    while(1) {
         time =  r + (x / prod);
         time2 = r + (c / prod) + (x / (prod + f));
         if(time2 < time) {
            r = r +  (c / prod);  
            prod = prod + f;
         }
         else {
            r = time;
            break;
         }
    }
    printf("Case #%d: %.7Lf\n",caseNum, r);
}

int main(int argc, char *argv[])
{
    FILE *fp = fopen("cinput.txt", "r");
    int cases;
    int i;

    fscanf(fp, "%d\n", &cases);
    for(i=0; i<cases; i++) {
       handleSolution(i+1, fp);
    }
    fclose(fp);
}
