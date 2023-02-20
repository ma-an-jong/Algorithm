package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class DSLR {

    static List<Character> commands = List.of('D','S','L','R');

    static class Register{
        int[] arr;

        public Register(int[] arr) {
            this.arr = arr;
        }

        Register action(char c){
            if(c == 'D') {
                int v = (parseInt() * 2) % 10_000;
                int[] tmp = new int[4];

                for (int i = 3; i >= 0; i--) {
                    tmp[i] = v % 10;
                    v /= 10;
                }

                return new Register(tmp);

            } else if(c == 'S') {

                int i = 3;
                int[] tmp = new int[4];

                while(i >= 0 && arr[i] == 0) {
                    i--;
                }

                if(i == -1) {
                    Arrays.fill(tmp,9);
                    return new Register(tmp);
                }

                for (int j = i+1; j < 4; j++) {
                    tmp[j]=9;
                }
                tmp[i] = arr[i] -1;
                for (int j = 0; j < i; j++) {
                    tmp[j] = arr[j];
                }

                return new Register(tmp);

            } else if(c == 'L') {
                return leftRotate();
            } else  if(c == 'R') {
                return rightRotate();
            } else throw new RuntimeException();
        }


        Register leftRotate() {
            int[] tmp = new int[4];

            for (int i = 0; i < 4; i++) {
                tmp[(i + 3) % 4] = arr[i];
            }

            return new Register(tmp);
        }

        Register rightRotate() {
            int[] tmp = new int[4];

            for (int i = 0; i < 4; i++) {
                tmp[(i + 1) % 4] = arr[i];
            }

            return new Register(tmp);
        }

        int parseInt(){
            int sum =0;

            for (int i = 0; i < 4; i++) {
                sum *= 10;
                sum += arr[i];
            }

            return sum;
        }

        public boolean equals(Register o) {
            return parseInt() == o.parseInt();
        }


    }

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseSize = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < testCaseSize; testCase++) {
            String[] str = br.readLine().split(" ");
            int A = Integer.parseInt(str[0]);
            int B = Integer.parseInt(str[1]);
            boolean[] visited = new boolean[10000];

            Queue<Register> q = new LinkedList<>();
            Queue<String> commandQ = new LinkedList<>();
            visited[A] = true;
            int[] arr = new int[4];
            for (int i = 3; i >= 0; i--) {
                arr[i] = A % 10;
                A /= 10;
            }

            q.add(new Register(arr));
            commandQ.add("");


            while (!q.isEmpty()) {

                Register register = q.remove();
                String command = commandQ.remove();
                //System.out.println(command + " -> " + register.parseInt() + " == " + B + " = " +(register.parseInt() == B));

                if(register.parseInt() == B) {
                    bw.write(command+"\n");
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    char nextCommand = commands.get(i);

                    Register newRegister = register.action(nextCommand);
                    int value = newRegister.parseInt();

                    if(visited[value]) continue;

                    visited[value] = true;
                    q.add(newRegister);
                    commandQ.add(command + nextCommand);
                }
            }

        }

        bw.flush();

    }
}
