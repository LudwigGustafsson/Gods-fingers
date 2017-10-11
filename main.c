#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define SIZE 1200
static int spaces = 50;
void print(char *text)
{
    int i = 0;
    while (1)
    {
        printf("%c", text[i]);
        i++;
        if (i>SIZE)
            break;
    }
}

void scan (char *text)
{
    int i = 0;
    int s = 0;
    while (1)
    {
        if (text[i] == 32)
        {
            s++;
            if (s > spaces)
            {
                spaces = s;
                print (&text);
            }
        }
        i++;
        if (i>SIZE-3)
            break;
    }
}

void sum (char *text)
{
    int s = 0;
    int i = 0;
    while (1)
    {
        s = s + text[i];
        i++;
        if (i > SIZE)
            break;
    }
    printf("\nSum = %d", s);
}

void crack (char *text, char code[])
{
    int i=0,j=0;
    char test[SIZE];
    while (1)
    {
        test[i] = code[j] ^ text[i];
        i++;
        j++;
        if (j>2)
        {
            j=0;
        }
        if (i>SIZE)
        {
            i = 0;
            int s = 0;
            while (1)
            {
                if (test[i] == 32)
                {
                    s++;
                }
                i++;
                if (i>SIZE-3)
                {
                    if (s > spaces)
                    {
                        spaces = s;
                        print (&test);
                        printf("\nPassword = %s", code);
                        sum (&test);
                    }
                    return;
                }
            }
        }
    }
}

int main()
{
    char a[3203];
    char t[2];
    char b[SIZE];
    FILE *fp;
    fp = fopen("t.txt", "r");
    if (!fp)
        exit (1);
    int i = 0;
    int j = 0;
    int k = 0;
    char password[3];
    while (a[i-1] != EOF)
    {
        a[i] = fgetc( fp );
        t[j]=a[i];
        if (a[i] == 44)
        {
            b[k]=atoi(t);
            k++;
            j=-1;
            t[0]=0;
            t[1]=0;
            t[2]=0;
        }
        i++;
        j++;
    }
    fclose(fp);
    i = 0;
    j = 0;
    k = 0;
    strcpy(password, "aaa");
    b[SIZE]=73;
    while (1)
    {
        crack(&b, password);
        if (password[0] == 'z')
        {
            password[1]++;
            password[0]= 'a';
            if (password[1] == 'z')
            {
                password[2]++;
                password[1]= 'a';
                if (password[2] == 'z')
                {
                    break;
                }
            }
        }
        password[0]++;
        i++;
    }
    return 0;
}
