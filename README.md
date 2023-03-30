<h1>Imersão Java</h1>

Aula 1 - Consumo de API
Nessa aula foi utilizada a API pública do site IMDB
##
Com o pacote java.net.http foi realizado:
<ol>
<li>A conexão com a API.</li>
<li>A demanda dos dados com uma classe própria disponibilizada em aula.</li>
<li>A impressão em tela dos seguintes dados do sfilmes: título, imagem, avaliação.</li>
<li>Com o desafio proposto pelos mentores foi refatorada a pontuação de modo a possuir um melhor layout com cores e emojis.</li>
</ol>


<div>
<img src="https://user-images.githubusercontent.com/106753195/228088988-58e67d6c-6d79-4333-ab60-4d7c99a12075.jpg">
</div>

##
Aula 2 - Gerador de Figurinhas para WhatsApp 
##
No segundo dia as imagens disponíveis nos dados do pedido (JSON) foram utilizadas para criar stickers. Com o auxílio dos pacotes java.awt, java.io e java.ImageIO, foi possível editar imagens e inserir textos.
<ol>
<li>Caso o filme tenha nota 8 ou superior, será impresso "Muito bom!"</li>
<li>Caso o filme tenha nota menor que 8, será impresso "Talvez vale a pena!"</li>
</ol>
<div align="center">
<img width="300px" heigth="300px" src="https://user-images.githubusercontent.com/106753195/228392755-a3ad75ce-459d-45df-a8be-ece2fb250d7c.png">
<img width="300px" heigth="300px" src="https://user-images.githubusercontent.com/106753195/228392949-8ac8ceef-0cbf-4d8b-9d17-eef727efd65f.png">
</div>

## 
Aula 3 - Refatorando e criando componentes mais organizados
##
No terceiro dia refatoramos o código para deixar ele mais flexivel, aproveitável e mais fácil de compreender. Para obter novas imagens foi utilizada a APi da Nasa. 
<ol>
<li>ransforme uma classe que representa os conteúdos em um Record, disponível a partir do Java 16.</li>
<li>Crie as suas próprias pessoas e use-las na classe que implementa o cliente HTTP.</li>
<li>Use recursos do Java 8 e posteriores, como Streams e Lambdas, para mapear uma lista em uma outra.</li>
<li>Crie uma Enum que une, como configurações, a URL da API e o extrator usado.</li>
</ol>
<div align="center">
<img   width="300px" heigth="300px" src="https://user-images.githubusercontent.com/106753195/228725354-64172240-34a9-455e-ab87-0e1e85cc6222.png">
</div>

##