import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.InputStream;
import java.awt.Color;
import java.awt.Font;

public class GeradorDeImagens {

    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

        // InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs_2.jpg").openStream();

        BufferedImage imagenOriginal = ImageIO.read(inputStream);

        // Criando nova imagem
        int largura = imagenOriginal.getWidth();
        int altura = imagenOriginal.getHeight();
        int newAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, newAltura, BufferedImage.TRANSLUCENT);
        

        // Passando imagem original para a nova imagem
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagenOriginal, 0, 0, null);

        // Configurando a Font
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        // Escrever um texto na nossa imagem
        graphics.drawString("Aprovado!", 100, newAltura -100);

        // Escrevendo a nova imagem em um arquivo
    
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }
}
