# ProcessoSeletivo-DTI

Foi desenvolvido uma Aplicação FullStack que tem como entrada os valores de <data> <quantidade de cães pequenos> <quantidade cães grandes> e retorna um Card com as informações
do petShop com o melhor preço e valor incluso.
A ideia era extender o código principal para que possa cadastrar novos petshops conforme necessário.

O projeto foi desenvolvido para armazenar os petshops da região em um Banco de Dados local. E caso fosse de interesse do Senhor Eduardo, armazenar essa base de dados online para poder acessá-la de qualquer dispositivo



O projeto foi desenvolvido com as tecnologias Java Spring Boot, HTML, CSS e JavaScript.
Não foi usado a tecnologia React.



# Para executar o código corretamente é necessário a intalação de:

JAVA versão 21: https://www.oracle.com/br/java/technologies/downloads/

Apache Maven 3.9.5: https://maven.apache.org/

MySQL: https://www.mysql.com/downloads/

HeidSQL: https://www.heidisql.com/download.php - opcional apenas para visualização da base de dados

Configurar ambiente de Trabalho Corretamente.

Para mais informações sobre a instalação de recursos necessários acessar o seguinte documento: 
https://docs.google.com/document/d/1DQzt7ar_4M7rSRLL9yTqYQJVs6kh6sSO195UgC97jT8/edit?usp=sharing



# Modo de Uso:

Abrir arquivo "application.properties" no diretório: "Application/demo(2)/src/main/resources/" - 
e modificar os campos "spring.datasource.username= " e "spring.datasource.password= " com a senha de acesso ao SGBD local do mySQL ou outro Workbench instalado. Acessar este video em caso de dúvidas: https://www.youtube.com/watch?v=nEfKhzueCsc&t=115s

Acessar arquivo DemoApplication.java em 'demo(2)/src/main/java/' e executá-lo (dar Run no SpringBootApplication),

Abrir LiveServer do arquivo index.html, preencher com os dados desejados e clicar no botão "Buscar", 

Ao clicar no botáo "Cadastrar" será possível cadastrar um novo PetShop (no caso do Senhor Eduardo poderia abrir um novo PetShop em uma região perto a do canil e ser de interesse dele cadastrar um novo PetShop).

