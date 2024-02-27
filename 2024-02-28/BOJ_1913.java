/**
BOJ_1913
Date: 2024-02-28
['달팽이' 알고리즘] : 은 2차원 배열을 달팽이가 나선형으로 움직이는 것처럼 방향을 바꿔가며 순회하는 방식을 말한다. 
이 문제의 경우, 중앙에서 시작하여 외각으로 나아가는 달팽이 알고리즘을 사용하였다.

주어진 크기(n)의 배열에 1부터 n*n까지의 숫자를 달팽이 모양으로 채운 후, 
특정 숫자(t)의 위치를 찾는 프로그램
*/

import java.io.BufferedReader; // 문자열 입력을 받기 위한 클래스
import java.io.IOException; // 입력-출력 과정에서 발생할 수 있는 예외 처리 클래스
import java.io.InputStreamReader; // 문자열 입력을 받기 위한 클래스

class Main {

    public static void main(String[] args) throws IOException {
      
      // BufferedReader를 사용하여 표준 입력을 받는다. 
      // 입력받은 문자열은 readLine 메서드로 읽어들여 Integer.parseInt를 통해 정수로 변환한 후 n과 t에 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());

      // 입력받은 두 정수 n과 t를 매개변수로 solve 메서드를 호출
        solve(n, t);
    }

  // 입력받은 두 정수 n과 t를 이용하여 문제를 해결
  // StringBuilder는 문자열을 저장하고 연산을 수행하는 데 사용되며, 이후에 출력할 결과를 저장하는 데 사용
    private static void solve(int n, int t) {
        StringBuilder sb = new StringBuilder();

      // map은 n*n 크기의 2차원 배열로, 달팽이 모양으로 숫자를 채워 넣을 공간
        int[][] map = new int[n][n];

      // limit과 value라는 두 개의 정수 변수를 선언하고 1로 초기화
      // limit은 달팽이 모양을 만들기 위해 한 방향으로 이동할 횟수를 저장
      // value는 채워 넣을 숫자를 저장
        int limit = 1, value = 1;

      // x와 y는 현재 위치를 나타냄
      // n/2로 초기화하여 배열의 중앙에서 시작
      // 배열의 인덱스는 0부터 시작하므로 실제 좌표 값은 n/2 + 1이 된다.
        int x = n / 2;
        int y = n / 2;

      // ans_x와 ans_y는 찾고자 하는 숫자 t의 위치를 저장
      // 초기값으로 0을 할당
        int ans_x = 0, ans_y = 0;

        while (true) {

          // 반복문 시
          // 위쪽 방향으로 limit만큼 이동하면서 숫자를 채워 넣는다.
          // x 좌표를 감소시키면서 위쪽으로 이동하고, value를 1씩 증가시키면서 숫자를 채워 넣는다.
            for (int i = 0; i < limit; i++) {
                map[x--][y] = value++;
            }

          // value가 n*n을 초과하면 모든 숫자를 채워 넣은 것이므로 반복문을 종료
            if (value > n * n)
                break;

          // 두 번째 for 루프에서는 오른쪽 방향으로 limit만큼 이동하면서 숫자를 채워 넣는다.
          // y 좌표를 증가시키면서 오른쪽으로 이동하고, value를 1씩 증가시키면서 숫자를 채워 넣는다.
            for (int i = 0; i < limit; i++) {
                map[x][y++] = value++;
            }
          
          // 이동이 끝나면 limit을 1 증가시킨다.
            limit++;

          // 이러한 과정을 반복하면서 아래쪽, 왼쪽 방향으로도 숫자를 채워 넣는다.
            for (int i = 0; i < limit; i++) {
                map[x++][y] = value++;
            }

            for (int i = 0; i < limit; i++) {
                map[x][y--] = value++;
            }

          // 다시 위쪽 방향으로 이동하기 전에 limit을 1 증가시킨다.
            limit++;
        }

      // 모든 숫자를 채워 넣은 2차원 배열 map을 순회하면서 StringBuilder에 저장. 
      // 찾고자 하는 숫자 t의 위치를 찾아 ans_x와 ans_y에 저장.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j] + " ");
                if (t == map[i][j]) {
                    ans_x = i + 1;
                    ans_y = j + 1;
                }
            }
            sb.append("\n");
        }

      // 찾은 위치를 StringBuilder에 추가하고, toString 메서드를 사용하여 StringBuilder의 내용을 문자열로 변환한 후 출력
        sb.append(ans_x + " " + ans_y);
        System.out.println(sb.toString());
    }

}
