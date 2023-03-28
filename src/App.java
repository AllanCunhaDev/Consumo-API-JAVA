import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json";
        URI end = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(end).GET().build();
        var response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // extraindo os dados dos filmes
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        // System.out.println(listaDeFilmes.size());
        // System.out.println(listaDeFilmes.get(0));

        // Exibir e manipular os dados
        var geradora = new GeradorDeImagens();
        for (Map<String, String> filme : listaDeFilmes) {

            String urlImagem = filme.get("image");
            String tituloFilme = filme.get("title");
            double classificacao = Double.parseDouble(filme.get("imDbRating"));

            String textoFigurinha;
            if(classificacao >= 8.0){
                textoFigurinha = "Muito bom!";
            }else{
                textoFigurinha = "Meia Bomba";
            }
            var diretorio = new File("figurinhas/");
            diretorio.mkdir();

            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = "figurinhas/" + tituloFilme.replace(":","-") + ".png";
            
            geradora.cria(inputStream, nomeArquivo, textoFigurinha);
            
            System.out.println(tituloFilme);
            System.out.println();
        }

    }
}
