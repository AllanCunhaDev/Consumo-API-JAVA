import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo{

    public List<Conteudo> extrairConteudos(String json){

        // extraindo os dados dos conteudos que interessam(titulo, foto e classificação)

        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();
        for(Map<String, String> atributos : listaDeAtributos){
            String titulo = atributos.get("title").replace(":","-");
            String urlImagem = atributos.get("url");
            Conteudo conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
        }
        return conteudos;
    }
}
