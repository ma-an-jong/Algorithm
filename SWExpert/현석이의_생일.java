package Algorithm.SWExpert;

import Algorithm.Stub;

import java.util.*;
class 현석이의_생일
{
    static char x;
    static char y;

    public static void main(String[] args) throws Exception
    {
        Stub.stub();
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String N = sc.next();
            x = sc.next().charAt(0);
            y = sc.next().charAt(0);

            StringBuilder sb = new StringBuilder();
            int i = 0;
            int j = 0;
            for (i = 0; i < N.length(); i++) {
                char c = N.charAt(i);

                if(c >= y) {
                    sb.append(y);
                    if(c > y) break;
                }
                else if (c >= x) {
                    sb.append(x);
                    if(c > x) break;
                }
                else {
                    for (j = 0; j < i; j++) {
                        char before = sb.charAt(i-j-1);
                        if(before == y){
                            sb.replace(i - j - 1, i - j, String.valueOf(x));
                            i--;
                            break;
                        }
                        sb.deleteCharAt(i-j-1);
                    }
                    i = i - j;
                    break;
                }
            }

            for (int k = 0; k < N.length()-i-1;k++) {
                sb.append(y);
            }

            String ans = sb.toString();
            if(ans.equals("")){
                System.out.println("#"+test_case+" -1");
            }
            else {
                int size = sb.length();
                for(int k = 0 ; k < size;k++){
                    if(sb.charAt(k) == '0'){
                        sb.deleteCharAt(k);
                        size--;
                        k--;
                    }
                    else {
                        break;
                    }
                }

                if(sb.toString().equals("")){
                    System.out.println("#"+test_case+" -1");
                }
                else
                    System.out.println("#" + test_case+ " "+sb.toString());
            }






        }

    }
}
