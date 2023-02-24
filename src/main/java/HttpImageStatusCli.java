import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter HTTP status code");
            String code = scanner.nextLine();
            while(!code.matches("[0-9]{3}")){
            System.out.println("Please enter valid number");
            code = scanner.nextLine();}
            int result = Integer.parseInt(code);
        new HttpStatusImageDownloader().downloadStatusImage(result);
    }

    public static void main(String[] args) throws Exception {
        new HttpImageStatusCli().askStatus();
    }
}
