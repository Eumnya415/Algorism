import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 사용자로부터의 입력을 받기 위한 Scanner 인스턴스 생성
        Scanner scanner = new Scanner(System.in);

        // 사용자로부터 단어를 입력받음
        String word = scanner.nextLine();
        scanner.close();

        // 빈 문자열을 생성
        String reversedWord = "";

        // 입력받은 단어의 끝에서부터 시작하여 앞으로 이동하면서 문자를 reversedWord에 추가
        for (int i = word.length() - 1; i >= 0; i--) {
            reversedWord += word.charAt(i);
        }

        // 원래의 단어와 뒤집힌 단어를 비교하여 팰린드롬 여부를 확인
        System.out.println(word.equals(reversedWord) ? 1 : 0);
    }
}
