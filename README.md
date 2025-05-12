
# 🚀 NEKI API - Sistema de Gerenciamento de Eventos

Esta API permite o gerenciamento completo de eventos e usuários administradores. Os dados trafegam em formato **JSON** e a API conta com suporte para upload de imagens, autenticação e associação de eventos a administradores.

---

## 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- MySQL / PostgreSQL (compatível)
- Bean Validation (Jakarta)
- Swagger (OpenAPI)
- JWT (JSON Web Token) - Autenticação
- Multipart (upload de imagens)
- REST (padrão de APIs)

---

## 📁 Estrutura de Pacotes

```
com.desafio.neki
├── controllers
├── dtos
├── exception
├── models
├── repositories
├── security
├── services
└── config
```

---

## 📌 Endpoints Disponíveis

### 👤 Usuários (Admins)

| Método | Rota                                | Descrição                                 |
|--------|-------------------------------------|--------------------------------------------|
| GET    | `/users`                            | Lista todos os usuários                    |
| GET    | `/users/{id}`                       | Retorna um usuário por ID                  |
| GET    | `/users/username/{username}`        | Retorna um usuário pelo nome de login      |
| POST   | `/users`                            | Cadastra um novo usuário                   |
| DELETE | `/users/{id}`                       | Remove um usuário                          |

---

### 📅 Eventos

| Método | Rota                                 | Descrição                                      |
|--------|--------------------------------------|------------------------------------------------|
| POST   | `/event/create`                      | Cria um novo evento                            |
| GET    | `/event/list`                        | Lista todos os eventos                         |
| GET    | `/event/{id}`                        | Busca um evento por ID                         |
| PUT    | `/event/update/{id}`                 | Atualiza um evento existente                   |
| DELETE | `/event/delete/{id}`                 | Deleta um evento                               |
| GET    | `/event/admin/{adminId}`             | Lista todos os eventos de um administrador     |

---

### 🖼️ Imagens de Eventos

| Método | Rota                                      | Descrição                             |
|--------|-------------------------------------------|----------------------------------------|
| POST   | `/event/{id}/upload-image`                | Faz o upload de uma imagem do evento   |
| GET    | `/event/{id}/imagem`                      | Retorna a imagem associada ao evento   |

---

## 🔐 Segurança

- A autenticação é baseada em JWT.
- O usuário realiza login e recebe um token para acessar os endpoints protegidos.
- Apenas admins autenticados podem cadastrar eventos.

---

## 🧪 Testes e Documentação

- A API conta com integração Swagger/OpenAPI.
- Acesse a documentação interativa no endpoint:
  ```
  http://localhost:8080/swagger-ui.html
  ```

---

## 📝 Como rodar o projeto

```bash
# Clone o projeto
git clone https://github.com/cintra444/desafio_neki-api.git
cd desafio_neki-api

# Configure o banco de dados em application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/neki
spring.datasource.username=seu_nome_usuario
spring.datasource.password=sua_senha

# Execute a aplicação
./mvnw spring-boot:run
```

---

## 💬 Contato

- Eber Cintra: cintra.eber@gmail.com
- https://portifolio-eber.netlify.app/
- (22) 98835-5740
            

---
