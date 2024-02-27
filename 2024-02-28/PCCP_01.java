public class Main {
  // 테스트 코드
    public static void main(String[] args) {
        System.out.println(solution("GRGLGRG")); // [2, 2]
        System.out.println(solution("GRGRGRB")); // [2, 0]
    }

    public static int[] solution(String command) {
        int x = 0, y = 0; // 로봇의 초기 위치
        int dx = 0, dy = 1; // 로봇이 바라보는 방향 (+y 축) => 방향 벡터 : (0,1)

      // (dx,dy) : 2차원 공간에서의 방향 벡터(특정한 방향을 가리킴)

        // 명령어를 한 문자씩 처리하는 for 반복문
        // 명령어는 문자열로 주어지므로, toCharArray 메서드를 사용하여 문자 배열로 변환한 후, 각 문자에 대해 처리
        for (char cmd : command.toCharArray()) {
            switch (cmd) { // 현재 처리하고 있는 명령어에 따라 로봇의 동작을 결정
                case 'R': // 오른쪽으로 90도 회전 (dx,dy) -> (dy, -dx)
                    int temp = dx; // dx의 원래 값을 임시 변수 temp에 저장. 이후 dx의 값을 변경하더라도 원래 값을 유지하기 위함
                    dx = dy; // dx의 값을 dy로 변경 => 방향 벡터를 오른쪽으로 90도 회전한 결과
                    dy = -temp; // dy의 값을 -temp로 변경. temp는 dx의 원래 값을 가지고 있으므로, 방향 벡터를 오른쪽으로 90도 회전한 결과
                    break;
                case 'L': // 왼쪽으로 90도 회전 (dx,dy) -> (-dy, dx)
                    temp = dx; // dx의 원래 값을 임시 변수 temp에 저장. 이후 dx의 값을 변경하더라도 원래 값을 유지하기 위함
                    dx = -dy; // dx의 값을 -dy로 변경. 방향 벡터를 왼쪽으로 90도 회전한 결과
                    dy = temp; // dy의 값을 temp로 변경. temp는 dx의 원래 값을 가지고 있으므로, 방향 벡터를 왼쪽으로 90도 회전한 결
                    break;
                case 'G': // 한 칸 전진
                    x += dx; // 로봇의 x 좌표를 dx만큼 증가시킨다. dx는 로봇이 바라보는 방향의 x 성분이므로, 로봇이 바라보는 방향으로 x좌표를 이동시킴
                    y += dy; // 로봇의 y좌표를 dy만큼 증가시킨다.  dy는 로봇이 바라보는 방향의 y 성분이므로, 로봇이 바라보는 방향으로 y좌표를 이동시킴
                case 'B': // 한 칸 후진
                    x -= dx; // 로봇의 x 좌표를 dx만큼 감소시킨다. dx는 로봇이 바라보는 방향의 x 성분이므로, 로봇이 바라보는 방향의 반대 방향으로 x 좌표를 이동시키는 것
                    y -= dy; // 로봇의 y 좌표를 dy만큼 감소시킨다. dy는 로봇이 바라보는 방향의 y 성분이므로, 로봇이 바라보는 방향의 반대 방향으로 y 좌표를 이동시키는 것
                    break;
            }
        }

        // 최종 위치 반환
        return new int[]{x, y};
    }
}
