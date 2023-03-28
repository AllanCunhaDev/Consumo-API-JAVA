import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.InputStream;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.font.TextLayout;
import java.awt.BasicStroke;

public class GeradorDeImagens {

    public void cria(InputStream inputStream, String nomeArquivo, String textoDaImagem) throws Exception {

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
        var fonte = new Font("Impact", Font.BOLD, 120);
        graphics.setColor(Color.RED);
        graphics.setFont(fonte);

        // Escrever um texto na nossa imagem
        FontMetrics fontMetrics = graphics.getFontMetrics();
        Rectangle2D textWidth = fontMetrics.getStringBounds(textoDaImagem, graphics);
        int widthText = (int) textWidth.getWidth();
        int posicaoTextoX = (largura - widthText) / 2;
        int posicaoTextoY =  newAltura -80;
        graphics.drawString(textoDaImagem, posicaoTextoX, posicaoTextoY);

        // Fazendo o contorno em volta do texto 
        FontRenderContext fontRenderContext = graphics.getFontRenderContext();
        var textLayout = new TextLayout(textoDaImagem, fonte, fontRenderContext);
        Shape outline = textLayout.getOutline(null);
        AffineTransform transform = graphics.getTransform();
        transform.translate(posicaoTextoX, posicaoTextoY);
        graphics.setTransform(transform);

        var outlineStroke = new BasicStroke(largura * 0.004f);
        graphics.setStroke(outlineStroke);

        graphics.setColor(Color.YELLOW);
        graphics.draw(outline);
        graphics.setClip(outline);
        

        // Escrevendo a nova imagem em um arquivo
    
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }
}
