import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalGoogleBooks {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do livro que deseja procurar: ");
        String nomeLivro = scanner.nextLine();
        nomeLivro = nomeLivro.replaceAll("\\s", "+");

        HttpClient client = HttpClient.newHttpClient();

        String endereco = "https://www.googleapis.com/books/v1/volumes?q="+nomeLivro+"intitle:"+nomeLivro;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
