# ProcessoSeletivo-DTI

O projeto consiste em uma aplicação FullStack que permite aos usuários inserir valores correspondentes à data, quantidade de cães pequenos e quantidade de cães grandes. Em resposta, a aplicação exibe um card contendo informações do petShop com o melhor preço e valor incluso.

Para expandir a funcionalidade da aplicação, a proposta é integrar a capacidade de cadastrar novos petshops conforme necessário. Isso implicaria em modificar o código principal para permitir a inclusão dinâmica de novos estabelecimentos na base de dados.

Atualmente, o projeto armazena os dados dos petshops em um Banco de Dados local. No entanto, considerando a conveniência de acesso remoto aos dados, uma possível extensão seria migrar essa base de dados para um ambiente online. Isso possibilitaria ao Senhor Eduardo acessar e gerenciar a base de dados de qualquer dispositivo com conexão à internet.

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

Abrir LiveServer do arquivo index.html, preencher com os dados desejados e clicar no botão "Buscar" - fazer isto com DemoApplication.java em execução.

Ao clicar no botão "Cadastrar", os usuários terão a capacidade de registrar um novo PetShop, permitindo a inclusão de novos estabelecimentos na região. Este recurso oferece a possibilidade de expandir a base de dados com informações atualizadas sobre os estabelecimentos disponíveis para serviços relacionados a animais de estimação na área circundante.

# Experiência Pessoal

Este projeto representou uma excelente oportunidade para aplicar e aprimorar minhas habilidades em frontend, Java Spring Boot e lógica de programação. A escolha do problema proposto foi muito acertada, pois permitiu a criação de um projeto FullStack completo, partindo do zero.

Ao longo do desenvolvimento, pude mergulhar profundamente na implementação de soluções tanto no frontend quanto no backend, explorando os recursos do React para a construção da interface do usuário e utilizando o Java Spring Boot para a criação de uma base sólida no lado do servidor. A jornada de transformar os requisitos do problema em código funcional foi desafiadora, porém extremamente gratificante.
