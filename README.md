# 💕 LoveBook API

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![MariaDB](https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=mariadb&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)

## 🌟 Sobre o Projeto

**LoveBook API** é uma API REST robusta e escalável desenvolvida em Java/Spring Boot para gerenciar uma plataforma especializada em livros românticos. Esta API oferece funcionalidades completas para autenticação de usuários, gerenciamento de catálogo especializado em romance, processamento de compras, sistema de comentários e muito mais.

### 🔗 Frontend Repository

Este projeto funciona em conjunto com o **LoveBook Frontend**:
- 🎨 **Frontend Repository**: [lovebook-front](https://github.com/mantovaniandre/lovebook-front)
- 🚀 **Tecnologias Frontend**: Angular, TypeScript, Angular Material

## ⚡ Principais Funcionalidades

- 🔐 **Autenticação JWT**: Sistema seguro com Spring Security
- 📚 **Gerenciamento de Livros**: CRUD especializado para literatura romântica
- 👤 **Gestão de Usuários**: Criação, edição e gerenciamento de perfis
- 🛒 **Sistema de Compras**: Processamento completo de pedidos
- 📝 **Sistema de Comentários**: Reviews e avaliações de livros
- 📊 **Dashboard Administrativo**: Painel de controle completo
- 🔍 **Busca Avançada**: Pesquisa por título, autor, categoria romântica
- 💳 **Processamento de Pagamento**: Integração segura de transações
- 📱 **API RESTful**: Endpoints padronizados e documentados

## 🛠 Tecnologias Utilizadas

- **Framework**: Spring Boot 2.5.4
- **Linguagem**: Java 11
- **Segurança**: Spring Security + JWT
- **Banco de Dados**: MariaDB + H2 (desenvolvimento)
- **ORM**: Spring Data JPA
- **Template Engine**: Thymeleaf
- **Build Tool**: Maven
- **Validation**: Spring Boot Starter Validation
- **Dev Tools**: Spring Boot DevTools
- **Utilities**: Google Guava

## 📋 Pré-requisitos

Antes de começar, certifique-se de ter instalado:

- Java 11+
- Maven 3.6+
- MariaDB 10.3+ (ou H2 para desenvolvimento)
- IDE (IntelliJ IDEA, Eclipse, VS Code)

## 🚀 Instalação e Configuração

### 1. Clone o repositório
```bash
git clone https://github.com/mantovaniandre/lovebook-api.git
cd lovebook-api/lovebook
```

### 2. Configure o banco de dados
```sql
-- MariaDB/MySQL
CREATE DATABASE lovebook;
CREATE USER 'lovebook_user'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON lovebook.* TO 'lovebook_user'@'localhost';
FLUSH PRIVILEGES;
```

### 3. Configure application.properties
```properties
# Banco de dados
spring.datasource.url=jdbc:mariadb://localhost:3306/lovebook
spring.datasource.username=lovebook_user
spring.datasource.password=password
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# JWT
jwt.secret=mySuperSecretKey
jwt.expiration=86400000

# Server
server.port=8080
```

### 4. Execute a aplicação
```bash
# Via Maven
mvn spring-boot:run

# Via JAR
mvn clean package
java -jar target/lovebook-0.0.1-SNAPSHOT.jar
```

A API estará disponível em: `http://localhost:8080`

## 📚 Documentação da API

### Base URL
```
http://localhost:8080/api
```

### Autenticação
- `POST /auth/login` - Login de usuário
- `POST /auth/register` - Registro de usuário

### Usuários
- `GET /usuarios` - Listar usuários
- `GET /usuarios/{id}` - Obter usuário por ID
- `POST /usuarios` - Criar usuário
- `PUT /usuarios/{id}` - Atualizar usuário
- `DELETE /usuarios/{id}` - Deletar usuário

### Livros
- `GET /livros` - Listar livros românticos
- `GET /livros/{id}` - Obter livro por ID
- `POST /livros` - Criar livro (requer autenticação)
- `PUT /livros/{id}` - Atualizar livro (requer autenticação)
- `DELETE /livros/{id}` - Deletar livro (requer autenticação)
- `GET /livros/categoria/{categoria}` - Buscar por categoria
- `GET /livros/autor/{autor}` - Buscar por autor

### Compras
- `POST /purchases` - Processar compra (requer autenticação)
- `GET /purchases/user/{userId}` - Histórico de compras
- `GET /purchases/{id}` - Obter compra específica

### Comentários
- `GET /comentarios/livro/{livroId}` - Comentários por livro
- `POST /comentarios` - Adicionar comentário (requer autenticação)
- `PUT /comentarios/{id}` - Editar comentário
- `DELETE /comentarios/{id}` - Deletar comentário

### Dashboard
- `GET /dashboard/stats` - Estatísticas gerais
- `GET /dashboard/vendas` - Relatório de vendas
- `GET /dashboard/usuarios` - Estatísticas de usuários

### Exemplo de Requisições

```bash
# Login
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"email": "user@example.com", "senha": "password123"}'

# Listar livros românticos
curl -X GET http://localhost:8080/api/livros

# Criar livro (com autenticação)
curl -X POST http://localhost:8080/api/livros \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer ${TOKEN}" \
  -d '{"titulo": "Pride and Prejudice", "autor": "Jane Austen", "categoria": "Romance Clássico"}'
```

## 🏗 Arquitetura do Projeto

```
src/main/java/br/com/lovebook/
├── config/
│   └── security/              # Configurações de segurança
│       ├── AutenticacaoService.java
│       ├── SecurityConfigurations.java
│       ├── TokenService.java
│       └── AutenticacaoViaTokenFilter.java
├── controller/                # Controllers REST
│   ├── AutenticacaoController.java
│   ├── ComentariosController.java
│   ├── DashboardController.java
│   ├── LivroController.java
│   ├── PurchaseController.java
│   └── UsuarioController.java
├── model/                    # Entidades JPA
│   ├── Usuario.java
│   ├── Livro.java
│   ├── Compra.java
│   └── Comentario.java
├── repository/               # Repositórios Spring Data
├── service/                  # Lógica de negócios
├── dto/                      # Data Transfer Objects
└── LovebookApplication.java  # Classe principal
```

## 🔒 Segurança

- ✅ **JWT Authentication**: Tokens seguros com expiração
- ✅ **Spring Security**: Configuração robusta de segurança
- ✅ **Password Encoding**: Hash seguro de senhas
- ✅ **CORS Configuration**: Configuração adequada para frontend
- ✅ **Input Validation**: Validação de entrada com Bean Validation
- ✅ **SQL Injection Protection**: JPA/Hibernate com prepared statements

## 🧪 Testando a API

### Usando curl
```bash
# Teste de conectividade
curl http://localhost:8080/api/livros

# Registro de usuário
curl -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "João Silva",
    "email": "joao@example.com",
    "senha": "123456"
  }'
```

### Usando Postman
1. Importe a collection de endpoints
2. Configure environment com `baseUrl = http://localhost:8080/api`
3. Teste fluxo de autenticação e operações CRUD

### Testes Unitários
```bash
# Executar todos os testes
mvn test

# Executar com relatório de cobertura
mvn test jacoco:report
```

## 🚀 Deploy

### Build para Produção
```bash
mvn clean package -DskipTests
```

### Deploy com Docker
```dockerfile
FROM openjdk:11-jre-slim

VOLUME /tmp
COPY target/lovebook-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]
```

```bash
docker build -t lovebook-api .
docker run -p 8080:8080 lovebook-api
```

### Deploy no Heroku
```bash
# Adicionar Heroku remote
heroku create lovebook-api-prod

# Deploy
git push heroku main

# Configurar variáveis de ambiente
heroku config:set SPRING_PROFILES_ACTIVE=prod
heroku config:set DATABASE_URL=your_database_url
```

## 📊 Monitoramento

### Health Check
```bash
curl http://localhost:8080/actuator/health
```

### Métricas
- Spring Boot Actuator habilitado
- Endpoints de monitoramento disponíveis
- Logs estruturados para análise

## 🤝 Contribuindo

1. Faça o fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📞 Contato

**André Mantovani** - Desenvolvedor Full Stack

- 💼 [LinkedIn](https://linkedin.com/in/mantovaniandre)
- 📧 Email: andreluizdiasmantovani@gmail.com
- 🌐 Site: https://amantovani.netlify.app/
- 🐙 GitHub: [@mantovaniandre](https://github.com/mantovaniandre)

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

---

⭐ **Se este projeto foi útil para você, considere dar uma estrela no repositório!**

### 🔗 Projetos Relacionados
- [LoveBook Frontend](https://github.com/mantovaniandre/lovebook-front) - Interface Angular/TypeScript
- [BookWise Frontend](https://github.com/mantovaniandre/bookwise-frontend) - E-commerce Angular
- [BookWise Backend](https://github.com/mantovaniandre/bookwise-backend) - API Python/Flask
- [Outros projetos no meu perfil](https://github.com/mantovaniandre)

---
*Desenvolvido com ❤️ por [André Mantovani](https://github.com/mantovaniandre)*