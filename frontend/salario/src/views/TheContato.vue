<template>
    <div class="contact-page">
        <!-- Seção de Contato -->
        <div class="contact-container">
            <div class="contact-header">
                <h1>Contato</h1>
                <p>Entre em contato comigo ou explore meus projetos!</p>
            </div>

            <div class="profile-section">
                <img class="profile-photo" src="@/assets/Minha_foto.jpg" alt="Ewerton Rodrigues">
                <h2>Ewerton Rodrigues</h2>
                <p>Desenvolvedor de Software | Entusiasta de Tecnologia</p>
            </div>

            <div class="social-media">
                <h3>Redes Sociais</h3>
                <div class="social-links">
                    <a href="https://www.linkedin.com/in/ewerton-rodrigues/" target="_blank" title="LinkedIn">
                        <i class="fab fa-linkedin"></i> LinkedIn
                    </a>
                    <a href="https://github.com/ewertondrigues02" target="_blank" title="GitHub">
                        <i class="fab fa-github"></i> GitHub
                    </a>
                    <a href="https://www.instagram.com/ewertonrrodrigues/" target="_blank" title="Instagram">
                        <i class="fab fa-instagram"></i> Instagram
                    </a>
                    <a href="https://www.youtube.com/channel/UCH4G9KvLac6-1MkF_gOwRzQ" target="_blank"
                        title="YouTube - Xereta Sound">
                        <i class="fab fa-youtube"></i>Xereta Sound
                    </a>
                    <a href="https://www.youtube.com/@nerdxereta" target="_blank" title="YouTube - Nerd Xereta">
                        <i class="fab fa-youtube"></i> Nerd Xereta
                    </a>
                    <a href="https://www.youtube.com/@iclasscode6274" target="_blank" title="YouTube - iClassCode">
                        <i class="fab fa-youtube"></i> iClassCode
                    </a>
                </div>
            </div>

            <div class="projects-section">
                <h3>Meus Projetos</h3>
                <div class="projects-list">
                    <div class="project-item" v-for="project in projects" :key="project.id">
                        <h4>
                            <i :class="project.iconClass" v-if="project.iconClass"></i>
                            {{ project.name }}
                        </h4>
                        <p>{{ project.description }}</p>
                        <a :href="project.link" target="_blank" class="project-link">Ver projeto</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
const projects = [
  {
    id: 1,
    name: "Java",
    description: "Projetos diversos em Java.",
    link: "https://github.com/ewertondrigues02/java",
    iconClass: "fas fa-book"
  },
  {
    id: 2,
    name: "Site Salário",
    description: "Simulador de cálculo salarial em Vue.",
    link: "https://github.com/ewertondrigues02/site-salario",
    iconClass: "fas fa-coins"
  },
  {
    id: 3,
    name: "Banco Digital",
    description: "Aplicação Java para simular um banco digital.",
    link: "https://github.com/ewertondrigues02/banco-digital",
    iconClass: "fas fa-money-check-alt"
  },
  {
    id: 4,
    name: "Site Anime",
    description: "Site com catálogo de animes.",
    link: "https://github.com/ewertondrigues02/site-anime",
    iconClass: "fas fa-film"
  },
  {
    id: 5,
    name: "Microserviço: Criação de Pedido",
    description: "Microserviço com Spring Boot para pedidos.",
    link: "https://github.com/ewertondrigues02/micro-service-criacao-de-pedido",
    iconClass: "fas fa-box"
  },
  {
    id: 6,
    name: "Microserviço: Agendamento de Consultas",
    description: "Agendamento médico com Spring Boot.",
    link: "https://github.com/ewertondrigues02/agendamento-consultas",
    iconClass: "fas fa-calendar-check"
  },
  {
    id: 7,
    name: "MongoDB Workshop",
    description: "API com MongoDB + Spring Boot.",
    link: "https://github.com/ewertondrigues02/workshopp-spring-boot-mongodb",
    iconClass: "fas fa-database"
  },
  {
    id: 8,
    name: "Web Services com Spring Boot",
    description: "Serviços escaláveis com Spring Boot e JPA.",
    link: "https://github.com/ewertondrigues02/web-services-escalaveis-com-spring-boot-jpa-e-hibernate",
    iconClass: "fas fa-server"
  },
  {
    id: 9,
    name: "Conversão de Moedas",
    description: "Conversor de moedas com microserviço.",
    link: "https://github.com/ewertondrigues02/micro-services-conversao",
    iconClass: "fas fa-exchange-alt"
  },
  {
    id: 10,
    name: "Loja de Livros",
    description: "Loja virtual usando Thymeleaf.",
    link: "https://github.com/ewertondrigues02/loja-livros-projeto-fullstack",
    iconClass: "fas fa-book-open"
  },
  {
    id: 11,
    name: "Gestão de Pessoas",
    description: "API para cadastro de pessoas.",
    link: "https://github.com/ewertondrigues02/gestao-pessoas",
    iconClass: "fas fa-users"
  },
  {
    id: 12,
    name: "Previsão de Vendas",
    description: "Sistema para previsão de vendas.",
    link: "https://github.com/ewertondrigues02/previsao-de-vendas",
    iconClass: "fas fa-chart-line"
  },
  {
    id: 13,
    name: "Análise de Crédito",
    description: "Analisador de crédito para clientes.",
    link: "https://github.com/ewertondrigues02/analise-de-credito",
    iconClass: "fas fa-credit-card"
  },
  {
    id: 14,
    name: "Site Adote um Animal",
    description: "Site para adoção de animais.",
    link: "https://github.com/ewertondrigues02/site-adote-um-animal",
    iconClass: "fas fa-paw"
  },
  {
    id: 15,
    name: "Calculadora Java",
    description: "Calculadora simples em Java.",
    link: "https://github.com/ewertondrigues02/calculadora-java",
    iconClass: "fas fa-calculator"
  },
  {
    id: 16,
    name: "Gerador de CPF",
    description: "Geração de CPFs válidos.",
    link: "https://github.com/ewertondrigues02/gerador-de-cpf",
    iconClass: "fas fa-id-card"
  },
  {
    id: 17,
    name: 'Paleta de Cores',
    description: 'Gera uma nova paleta de cores aleatória com seus respectivos códigos HEX.',
    link: 'https://github.com/ewertondrigues02/paleta-de-cores',
    iconClass: "fas fa-palette"
  },
  {
    id: 18,
    name: 'Formulário com Validação',
    description: 'Formulário em JavaScript com mensagens de erro e campos destacados.',
    link: 'https://github.com/ewertondrigues02/formulario-com-validacao',
    iconClass: "fas fa-file-alt"
  },
  {
    id: 19,
    name: 'Automação em Python',
    description: 'Web scraping, automação de formulários, e-mails e tarefas com Python.',
    link: 'https://github.com/ewertondrigues02/automacao-em-python',
    iconClass: "fab fa-python"
  },
  {
    id: 20,
    name: 'Engenharia de Dados',
    description: 'Projetos com Airflow, Snowflake, dbt, PostgreSQL, Power BI e mais.',
    link: 'https://github.com/ewertondrigues02/Engenharia-de-Dados',
    iconClass: "fas fa-database"
  },
  {
    id: 21,
    name: 'Web Scraping - SpaceMoney',
    description: 'Coleta automatizada de notícias econômicas com Selenium e Python.',
    link: 'https://github.com/ewertondrigues02/web-scraping',
    iconClass: "fas fa-globe"
  },
  {
    id: 22,
    name: 'Análise - Banco Contoso',
    description: 'Análise de 15 milhões de linhas do Banco Contoso com SQL Server e Excel.',
    link: 'https://github.com/ewertondrigues02/Analise-de-Dados-Banco-Contoso',
    iconClass: "fas fa-chart-bar"
  },
  {
    id: 23,
    name: 'Análise - Telecomunicação',
    description: 'Desafio e insights com dados reais de uma empresa de telecom.',
    link: 'https://github.com/ewertondrigues02/Analise-de-Dados-Empresa-de-Telecomunicacao',
    iconClass: "fas fa-building"
  },
  {
    id: 24,
    name: 'Análise - Imóveis',
    description: 'Exploração de dados de uma seguradora fictícia com Python.',
    link: 'https://github.com/ewertondrigues02/Analise-de-Dados-de-Imoveis',
    iconClass: "fas fa-home"
  },
  {
    id: 25,
    name: 'Dados do COVID-19',
    description: 'Estudo do impacto da COVID-19 em 188 países com Python, Excel e BI.',
    link: 'https://github.com/ewertondrigues02/Dados-do-COVID-19',
    iconClass: "fas fa-syringe"
  },
  {
    id: 26,
    name: 'Java Design Patterns (Fork)',
    description: 'Padrões de projeto em Java implementados em um repositório modelo.',
    link: 'https://github.com/ewertondrigues02/java-design-patterns',
    iconClass: "fas fa-cogs"
  },
  {
    id: 27,
    name: 'Spring Boot (Fork)',
    description: 'Fork oficial do projeto Spring Boot da Spring Team.',
    link: 'https://github.com/ewertondrigues02/spring-boot',
    iconClass: "fas fa-file-code"
  }
]
</script>





<style scoped>
.contact-page {
    padding: 20px;
    max-width: 1200px;
    margin: 0 auto;
    font-family: Arial, sans-serif;
}

.contact-header {
    text-align: center;
    margin-bottom: 40px;
}

.profile-section {
    text-align: center;
    margin-bottom: 40px;
}

.profile-photo {
    width: 150px;
    height: 150px;
    border-radius: 50%;
    margin-bottom: 20px;
}

.social-media {
    margin-bottom: 40px;
}

.social-links a {
    display: block;
    color: #333;
    text-decoration: none;
    margin: 10px 0;
    font-size: 1.2em;
}

.social-links a:hover {
    color: #FF385C;
}

.social-links a i {
    margin-right: 10px;
}

.projects-section {
    margin-bottom: 40px;
}

.projects-section h3 {
    margin-bottom: 1rem;
    font-size: 1.5rem;
}

.projects-list {
    display: grid;
    grid-template-columns: 1fr 1fr;
    gap: 20px;
}

.project-item {
    background-color: #f4f4f4;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.project-item h4 {
    margin: 0;
    font-size: 1.5em;
}

.project-item p {
    font-size: 1em;
    color: #555;
    margin: 10px 0;
}

.project-link {
    font-size: 1.1em;
    color: #50C878;
    text-decoration: none;
}

.project-link:hover {
    text-decoration: none;
    color: #5ff591;
}
</style>