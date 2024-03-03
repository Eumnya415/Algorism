/**
Q: 2024-03-04 MON 
BOJ_2606
컴퓨터 네트워크에서 웜 바이러스가 어떻게 퍼져나가는지 살펴보는 코드
컴퓨터의 수와 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수를 입력받고,
이를 기반으로 네트워크를 구성
*/

import java.util.*;

public class Main {
  // 각 컴퓨터와 연결된 컴퓨터를 저장하는 리스트
    static ArrayList<Integer>[] a;
  // 각 컴퓨터를 방문했는지 여부를 저장하는 배열
    static boolean[] c;

  // DFS (깊이 우선 탐색) 알고리즘
    public static void dfs(int x) {
      // 이미 방문 컴퓨터면 함수 종료
        if (c[x]) {
            return;
        }
      // 컴퓨터 방문 표시
        c[x] = true;
      // 인접한 컴퓨터를 방문
        for (int y : a[x]) {
            if (c[y] == false) {
                dfs(y);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      // 컴퓨터의 수를 입력받음
        int n = sc.nextInt();
      // 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수를 입력받음
        int m = sc.nextInt();
      // 각 컴퓨터와 연결된 컴퓨터를 저장하는 리스트 초기화
        a = (ArrayList<Integer>[]) new ArrayList[n+1];
      // 각 컴퓨터의 리스트 초기화
        for (int i=1; i<=n; i++) {
            a[i] = new ArrayList<Integer>();
        }

      // 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍을 입력 받음
        for (int i=0; i<m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
          // 각 컴퓨터와 연결도 컴퓨터를 리스트에 추가
            a[u].add(v);
            a[v].add(u);
        }
      
      // 각 컴퓨터를 방문했는지 여부를 저장하는 배열 초기화
        c = new boolean[n+1];
      // 1번 컴퓨터 DFS부터 시작
        dfs(1);

      // 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수 세기
        int count = 0;
        for (int i=2; i<=n; i++) {
            if (c[i]) {
                count += 1;
            }
        }

      // 웜 바이러스에 걸리게 되는 컴퓨터의 수 출
        System.out.println(count);
    }
}
