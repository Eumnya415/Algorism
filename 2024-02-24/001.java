import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 사용자로부터의 입력을 받기 위한 Scanner 인스턴스 생성
        Scanner scanner = new Scanner(System.in);
        
        // 사용자로부터 단어를 입력받음
        String word = scanner.nextLine();
        scanner.close();
        
        // 팰린드롬 판별 함수 호출
        System.out.println(isPalindrome(word));
    }
    
    // 팰린드롬 판별을 위한 함수
    public static int isPalindrome(String word) {
        int start = 0; // 시작 인덱스
        int end = word.length() - 1; // 끝 인덱스

        // 시작 인덱스가 끝 인덱스보다 작을 동안 반복
        while (start < end) {
            // 시작 인덱스의 문자와 끝 인덱스의 문자가 다르다면 팰린드롬이 아님 (0 반환)
            if (word.charAt(start) != word.charAt(end))
                return 0;
            
            // 시작 인덱스는 1증가, 끝 인덱스는 1감소
            start++;
            end--;
        }
        
        // 모든 검사를 통과하면 팰린드롬 (1 반환)
        return 1;
    }
}
