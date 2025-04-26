# Projeto Fullstack - Plataforma Inspirada no Airbnb

## 🔹 Índice

1. [Visão Geral](#visão-geral)
2. [Tecnologias Utilizadas](#tecnologias-utilizadas)
3. [Arquitetura e Estrutura](#arquitetura-e-estrutura)
4. [Pré-requisitos](#pré-requisitos)
5. [Como Executar o Projeto](#como-executar-o-projeto)
   - [Backend (Quarkus + Docker + PostgreSQL)](#backend)
   - [Frontend (Vue 3 + Tailwind CSS)](#frontend)
6. [Protótipo e Design](#protótipo-e-design)
7. [Fluxo de Dados](#fluxo-de-dados)
8. [Base de Dados](#base-de-dados)
9. [Clean Code e Boas Práticas](#clean-code-e-boas-práticas)
10. [Contribuição](#contribuição)
11. [Licença](#licença)

---

## 🔹 Visão Geral

Este projeto consiste em uma plataforma inspirada no Airbnb, desenvolvida com foco em **experiência do usuário**, **performance** e **escalabilidade**. A aplicação permite usuários visualizarem e reservarem propriedades disponíveis, seguindo padrões de design modernos e boas práticas de desenvolvimento.

O frontend foi construído com **Vue 3** e **Tailwind CSS**, enquanto o backend utiliza **Java Quarkus** para fornecer APIs REST eficientes, persistindo dados em **PostgreSQL**. O ambiente de desenvolvimento e produção é orquestrado via **Docker**.

---

## 🔹 Tecnologias Utilizadas

- **Frontend**:
  - Vue 3
  - Vue Router
  - Pinia (gerenciamento de estado)
  - Tailwind CSS
  - Axios

- **Backend**:
  - Java 17
  - Quarkus Framework
  - RESTEasy JSON-B
  - Hibernate ORM
  - Liquibase (migrações de banco de dados)

- **Banco de Dados**:
  - PostgreSQL

- **Infraestrutura & DevOps**:
  - Docker & Docker Compose
  - Git & GitHub

- **Design & ETL**:
  - Figma (protótipo de layout)
  - Power BI (limpeza e transformação de dados)
  - Dados obtidos do IBGE

---

## 🔹 Arquitetura e Estrutura

```bash
├── backend/
│   ├── src/main/java/...
│   ├── src/main/resources/application.properties
│   ├── Dockerfile
│   └── docker-compose.yml
├── frontend/
│   ├── public/
│   ├── src/
│   │   ├── components/
│   │   ├── views/
│   │   ├── router/
│   │   └── store/
│   ├── tailwind.config.js
│   └── package.json
└── README.md
```

- O diretório **backend/** contém o serviço Quarkus e configuração Docker.
- O diretório **frontend/** abriga a aplicação Vue 3 com Tailwind.

---

## 🔹 Pré-requisitos

Antes de iniciar, certifique-se de ter instalado:

- Docker e Docker Compose
- Node.js (versão >= 16)
- Java 17
- Git

---

## 🔹 Como Executar o Projeto

### 🔹 Backend (Quarkus + Docker + PostgreSQL)

1. Clone o repositório e acesse o diretório backend:
   ```bash
   git clone <url-do-repositorio>
   cd backend
   ```
2. Defina as variáveis de ambiente no `docker-compose.yml` (usuário, senha e nome do banco).
3. Execute o Docker Compose:
   ```bash
   docker-compose up -d --build
   ```
4. O serviço Quarkus estará disponível em `http://localhost:8080`.

### 🔹 Frontend (Vue 3 + Tailwind CSS)

1. Em outra aba do terminal, acesse o diretório frontend:
   ```bash
   cd frontend
   ```
2. Instale as dependências:
   ```bash
   npm install
   ```
3. Inicie o servidor de desenvolvimento:
   ```bash
   npm run dev
   ```
4. A aplicação Vue estará disponível em `http://localhost:3000`.

---

## 🔹 Protótipo e Design

O design do projeto foi prototipado no **Figma**, garantindo alinhamento com o estilo visual do Airbnb, incluindo:

- Layout responsivo para dispositivos móveis e desktop
- Paleta de cores e tipografia inspiradas na identidade visual do Airbnb
- Componentes reutilizáveis e ágeis para desenvolvimento acelerado

Para visualizar o protótipo, acesse o link do arquivo Figma:

> [Protótipo no Figma](<link-figma>)

---

## 🔹 Fluxo de Dados

1. Usuário faz requisição HTTP no frontend (Vue 3).
2. Axios envia chamadas REST para o backend Quarkus.
3. Quarkus processa lógica de negócio e interage com o banco via Hibernate.
4. Dados persistidos ou consultados em PostgreSQL.
5. Backend retorna resposta JSON.
6. Vue 3 atualiza a interface conforme estado.

---

## 🔹 Base de Dados

Os dados populados no banco de dados foram obtidos no site do **IBGE** e tratados no **Power BI**. O processo envolveu:

1. Importação dos conjuntos de dados do IBGE.
2. Limpeza e transformação no Power BI (remoção de duplicados, normalização de campos, formatação de datas).
3. Exportação para CSV.
4. Scripts de migração (Liquibase) para importar os dados tratados em PostgreSQL.

---

## 🔹 Clean Code e Boas Práticas

- **Backend**:
  - Padrão DTO para comunicação entre camadas
  - Injeção de dependência pelo Quarkus
  - Testes unitários com JUnit e Mockito
  - Migrações de banco com Liquibase

- **Frontend**:
  - Componentização em Vue 3 (Composition API)
  - Estado centralizado com Pinia
  - CSS utilitário via Tailwind para consistência visual
  - Linters e formatação automatizada (ESLint, Prettier)

---

## 🔹 Contribuição

Contribuições são bem-vindas! Para contribuir:

1. Fork este repositório.
2. Crie uma branch: `git checkout -b feature/nova-feature`
3. Faça commit das alterações: `git commit -m 'Descrição da feature'`
4. Envie para o branch: `git push origin feature/nova-feature`
5. Abra um Pull Request descrevendo suas mudanças.

---

## 🔹 Licença

Este projeto está licenciado sob a **MIT License**. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

![site-salati-capa](https://github.com/user-attachments/assets/f4789a61-5834-4dc7-a080-cdb0562f4477)


