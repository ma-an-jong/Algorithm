package Algorithm.Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 동전_뒤집기 {

    static int ans = Integer.MAX_VALUE;
    static char[][] arr;
    static int N;
    // 'T'인거 찾기

    static char toggle(char c)
    {
        if(c == 'T') return 'H';
        else return 'T';
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new char[N][N];

        for(int i = 0 ; i < N;i++)
        {
            String str = br.readLine();
            for(int j = 0 ; j < N;j++)
            {
                arr[i][j] = str.charAt(j);
            }
        }

        for(int i = 0 ; i < (1 << N) -1; i++)
        {
            int sum = 0;

            for(int x = 0 ; x < N ; x++)
            {
                int colCount = 0;

                for(int y = 0 ; y < N ; y++)
                {
                    char c = arr[y][x];
                    if((i&(1 << y)) != 0)
                    {
                        c = toggle(c);
                    }

                    if(c == 'T') colCount++;

                }

                sum += Math.min(colCount, N-colCount);
            }

            ans = Math.min(ans,sum);
        }

        System.out.println(ans);

    }
}


/*
8
THTHHHTH
TTHTHHTH
HHHTHHHH
TTTHHTHH
HHHTHHHH
TTHTHTHT
HTHHTTHT
HHHTHTTH
15

17
THHTHHHHHTTTTTTTH
THTHHTHHTHHTTHTHT
HTTTHTTHTTHTTTHTH
HTTTTTTHHTHHHHHHH
HHTHTHHHTTHTTHHHH
HHTHHTHTTHHHTTTTT
HHHTHTHTTHHHTTTTH
HHTHTTTHTHHHTHHHT
TTTTTTTTTTHTHHHHH
THHTHTHTHTHTTTHHT
HHHHTHTHHTHTTHHHH
TTHTHTTTHTTHTHTTH
TTHHTHHHTTHTTTTTT
HTHHHHHHHTTHTTHHH
HHTHTHTTHHTHHHTHH
HHTTTHHHTHHTTTTHH
TTHHHTTTHTTTTHTHT
93

19
HTTHHTHTTHTHHTTHTTH
THHTTTTHTTTTHTTTTHH
THHTHHTHTHTTTTTHHHT
THTHHHTHHHTTTHTHHTH
TTHHHTTHTHHHHTTHTHT
THHHHHHTTHTTHTTHTHH
THHTTHTTTTHTHTTTHTT
TTHHHHHHTHTHHHTTTHH
TTHHHTHTTHHHHTHHTTH
HHTHHTHHHTHTHTTHHTH
HTTTHTTTHTHHHTHTTTT
HHHHHHTTTTTHHHHTHTH
THTHHTTTHHTTHTHTHTT
THHHTHTHTHTHHHTTHHH
THTTTTTHHTHTHTTTTTT
THHTTHHHHHTTHTTTTTT
HTHTHHTTTTTTHHHTTHH
TTTHTHHTHTHHTHTTTTH
HTTHHHTHTHTTHHHTHHT
120

20
THHTHTTHTTHTHHHTTHTH
TTTTHHTTHTTTTTHTHTTT
TTHHTHTHHTHTHHHTTHTT
THTHTTHHHTTTHHHHTTTT
HHTHHTHTTTHHHTHTTTHT
HTHHHTTHHHTHTTTTTHTT
THTTHTTTTTTHHHHTHHHH
HTTHHHTHTTHTHTTHHTTT
HHTHHTTTTTHHTHHTTHHH
HHHTTHTHHTTTHHTHHHHH
HHTTTHTTTTHHHHHTTHHH
HTHTHTHHHTTTHHHHHHTT
HTHTTHTTHHTHHHTTTHTH
TTTTTHHTTHTHHTHTHHTT
TTTTTHHTHTTTTHTHHHHT
HHHHTTTTTHHTHTHHTTHT
HTTHHHHTTHTTTTTHTHTH
HTTHHHTTHTHTTHHHHHTT
HHHTHTHTTHTHTTHTTHHH
HTTTHHHHTHHHTHHHTHHT
137

17
HHHHHHTHTTTTTTHHH
THTHTHTTHTHTTHTHT
HTHHHTTTTTHTTHHHH
TTHTHHHHHHTHHTTTT
TTTTTHHTTHHTHTHTT
TTHHHTHHHHHTHHHTT
HHHHTHHHTHTTTTTHH
THTHHTHHHTHTHTTHH
HTHTHHHTHTHHHTTTH
THTHTHHHHTHHHTHHT
TTHTHHTHTHTHTTHTT
HTHTHTTTTHHTHTHHT
TTTTTHHHHTHTTHHHT
HTTTTTTTHHHHHTHHT
HTHTHHHHHHTHTTTHT
THHHHTTHTHTTTTHHT
HHHHHTHHTHTTHHHHT
94

20
HHHTHTHHTTTTTTHHHTTH
TTHHHTTHHTHHTTTTHHTH
THHHTTTHTTHHTHTTTTTH
THHHHHTHTTTHHHHTHTTH
THHHTTTHHTTHHHTHTHHH
THTHHHHTHHTHHTHTTHTT
THHHHTHTHTTTTHHTTHTT
HHTTHHTTTHHTHHHTTTHH
TTHHTTTTTHHHTTHHTTHH
TTTTTHHHHTTTHTTHTTTH
HTHHTHHHTTTTTTHTTHHH
TTHHHTHHHTTHTTTHTTHH
THTTTTHHTHHTHHTHTTHT
HTHHHHTTTTTHTTTTHHTT
TTHTTHTTHHTTHTTHHTHT
THTHHHHTHHTHHTHTHTHT
THHHHHTHHTTHTHHTTTTH
HTTTHHTHTHTHTHTTTTHT
HHHTHHTHHTTTTTHTTTTT
HTTTHHTTTHTHHHTTHHHT
133

9
HTHTHHTTT
TTTHTTHHT
HHTTTHTHH
HTHTHTHHH
THHHHHHTH
HHTTHTHHT
THTHTHTHT
THHTHTHTH
HHHHTHHHT
23

15
TTTHTTTTTTHTTTT
HTTHHHHTTHHTHTT
HTHHTHTHHHTTTHT
TTHTHHTTHTHTTTH
HTTTTTTHTTHTTHH
HHTHHTTHHTTTHTT
TTTTTTHTTHHTTTT
HTHHHHTTHHHTHHT
THHTHTTHHHTTTHH
THTTTTHHHTHHHTT
HTHHHTHTTHHTTTT
HTHTHTTTTHTHTTH
HHTTHHTHHTTTHHH
TTTHTTTTTTTHTTT
HHTTTTTHHHHTTHT
71

9
THTTHTHTT
HTTTHHHHT
HHTHHTTHT
HTHHHHTTT
TTTHTTHTT
THTHTHHHT
HTTHTTHTT
HTTHTHTHT
TTTHTHHHT
22

13
TTHTHTHTTHHTH
THHTHTHHHHTTH
THHTHHHTTTTTH
THHTTTHHTHTHT
HHTHHHTHTTHTH
TTTTHHTHTTTHH
THHHHTHTHTHHH
HTHHTTTTHHHHH
HTTHHTTHHTTTT
HTTTHHTTHHHHT
THTHHTTHTTHTT
THHTHTTHHTTTT
HTHTHTTTTHTTT
53

16
TTTHHTTTTTTTHTHH
HTHTHHTHHHHTTHTT
HTHHHHHTTTHHHTTT
HTHTTHTHTTTTHTHH
THTHTTTTTTHTHTTT
THTHTTHTHHTHTHHT
HTHTHHTTHTHTHHTH
TTTHHHTHTTHHHHHT
THTTTTTHHHTTHHTH
HTHHTHHTHTTTHTHT
THTTHTTHHTTHHHHT
HTTHTHTHTHTHTHTT
HTTTTHTTHTTHTHHT
HHTHHTTTHTHHTHHT
HTHTTTHTHTHHHTHH
TTTHHTTHTHTTTTTH
85

9
THTTTTHTT
HHTTTHTHH
HHTTHHHTH
THTTHHTTH
TTTTHHHHT
TTHHHHHHT
HTHHTHTTH
HHHHTHHHT
HHHHHTTHH
23

18
HHTHHHTHHHTTHTTHHT
HHHTHTHTTTTHTHTHTT
THHHTTHTTTHTHTHTHT
HHHTTHTTHHTTTTTHTT
HHTHTHTHTHTTHHTTHT
HTTTHTHHHTHHTHTTTT
HTTHTTHHHHHTHTTHTH
HHHTTTHHHTTHTTHTTH
HHTHHTHHHHTHTHHHTH
TTTTTTHHHTTHHHHTHT
HHHTTHTHTHTTTTHHTT
HTTTHTTHTHTTTTTTHT
TTHHTTTHHTTTTHHTTT
HTTTTTHHHTHHTHHHTT
HHHHTTTTTTHHHTHHTH
THHHHHTHTTHTTTHHTT
HTTHHHHHHTTTHTTHTH
TTTTHTTHTTTHTHHTHH
105

13
TTTHHTHTHHTHT
HHHHTHTHHHTTH
TTTTTHTTHTHTH
HHTHTTTHHTTTH
HHHHHHTHTTTTH
TTTTHHTTTTHTH
TTHHTTHHHHHHT
THHHHTTHTHHHH
HTTTHHTTHHHHH
TTTTHTHTTHTHH
TTTHTTTHTHTHH
TTHTTHHTTTTHH
HHTTTTTTTHHTH
52

14
THHHTTHTHHHHHT
HTHTTTTHTTTTHT
THHTHTHHHHTTHT
THHTTHHHTTTHHT
HTHTHHTTHHTTTT
HTHHHTTHTTTHHT
HTHHHTHTHTHTHH
TTTHHHHTTHTTHT
TTHTTTHTTTHHHT
THTTTTTTTTTHHH
HHHHTTHTHHTHHT
HTTHHTTTTHTHTT
THTTHTTHHHHHTH
HHHHTTHHHTTHTT
61

13
TTHTTTHTTHHHH
THTTHHTHTHTTT
THHHTTTTHHHTH
THTHHTTHTTHTH
THTHTTHHTHTHT
THHHTHHTHTTTH
HTHTHHTTHHTTT
HTTHTTHHHTTTH
HHHTTTHHTHHTH
HHHTHHTTHHTHT
TTTTTHHHHTTHH
THHHHHHTHHTHT
TTHTHHHTTTTTT
52

17
HHTTHTTTHHTTHTTTH
HTTTHTTHTHHTHTHHH
TTTHHTTTHTHHTTTTT
HHTTHHHHTHTHTTTTH
HHTHHHTTTTTHHTTHH
HHTTHHHHHHTTHTHHH
TTHHTTHTTTHTTHHTT
HHTHTHHHHTHTHTTTT
HTHHTTHTHTTHTTHTT
HHTTHHHTHTHHHTHTT
THTTHHTTHHHTHTTHH
HHHTHHHHTHTHHHTHT
HTHHHTHTHTHTTHHHH
THTTHHHHTHTHHHHTH
HTTHHHTHHHHTHHTHT
TTHHHTHTTHTTTTTTH
THTTHTHHTTHHHTHHT
86

12
TTTTTTHHHHTT
TTTTTHHHHTTH
TTHTTHTHTHTT
HHTTTHHTTHHH
HTHHHHTTTTHT
HHHHHHTHHHHH
TTHTTTTTTHTH
THHTTHHTHHTH
TTHTHTHTHTHT
HHTTTHHHHHHH
HTHHTHTHHTHH
HHHHHTHHHHTT
44

6
HHTTHH
TTHHTH
TTTHTH
HTTTTT
TTTHHT
TTHTTT
9

10
HTTTHHTHHH
TTTHHHHHTH
THHTHHHHHT
HHHHHTTTTT
THHTTHTHTT
THTHHTTTTH
HHHHTTTTTT
HHTTTHTTHT
THHTHHHHTT
HTHHTTHTTT
26
 */