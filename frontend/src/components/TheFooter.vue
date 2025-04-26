<template>
  <div class="app-container">
    <div class="main-content">
    </div>
    <footer class="footer">
      <div class="footer-container">
        <div class="footer-section">
          <span>&copy; {{ anoAtual }} Ewerton Rodrigues. Todos os direitos reservados.</span>
        </div>
        <div class="footer-section">
          <span>Contato: desenvolvedor.ewerton.java | (47) 93380-3113</span>
        </div>

        <div class="footer-section social-icons">
          <a href="https://www.linkedin.com/in/ewerton-rodrigues/" target="_blank" title="LinkedIn">
            <i class="fab fa-linkedin"></i>
          </a>
          <a href="https://ewertondrigues02.github.io/meu-portifolio/" target="_blank" title="Portfólio">
            <i class="fas fa-globe"></i>
          </a>
          <a href="https://github.com/ewertondrigues02" target="_blank" title="GitHub">
            <i class="fab fa-github"></i>
          </a>
          <!-- Adicionando os links do YouTube -->
          <a href="https://www.youtube.com/channel/UCH4G9KvLac6-1MkF_gOwRzQ" target="_blank" title="YouTube - XeretaSound">
            <i class="fab fa-youtube"></i>
          </a>
          <a href="https://www.youtube.com/@nerdxereta" target="_blank" title="YouTube - NerdXereta">
            <i class="fab fa-youtube"></i>
          </a>
          <a href="https://www.youtube.com/@iclasscode6274" target="_blank" title="YouTube - iClassCode">
            <i class="fab fa-youtube"></i>
          </a>
          <!-- Adicionando o link do Instagram -->
          <a href="https://www.instagram.com/ewertonrrodrigues/" target="_blank" title="Instagram">
            <i class="fab fa-instagram"></i>
          </a>
        </div>
      </div>
    </footer>
  </div>
</template>


<script setup>
const anoAtual = new Date().getFullYear();
</script>

<style scoped>
html,
body {
  height: 100%;
  margin: 0;
  display: flex;
  flex-direction: column;
}

.app-container {
  display: flex;
  flex-direction: column;
  height: 100%;
}

.main-content {
  flex: 1;
  padding-bottom: 100px;
}

/* Estilo do Footer */
.footer {
  background-color: #f7f7f7;
  color: #333;
  padding: 1rem 2rem;
  border-top: 1px solid #ddd;
  font-family: 'Nunito', sans-serif;
  width: 100%;
  margin-top: auto;
  text-align: center; /* Centraliza o conteúdo */
}

/* Container do Footer com ajuste responsivo */
.footer-container {
  display: flex;
  justify-content: space-between;
  align-items: center;
  gap: 1rem;
  margin-bottom: 0;
  flex-wrap: nowrap; /* Garantir que todos fiquem em linha */
  overflow-x: auto; /* Permitir rolagem horizontal em telas pequenas */
}

/* Ajuste das seções do footer */
.footer-section {
  font-size: 0.9rem; /* Fonte menor */
  margin-bottom: 0;
  text-align: center; /* Centraliza as seções */
  flex: 1;
}

/* Ícones de redes sociais */
.social-icons a {
  margin: 0 0.5rem;
  color: #333;
  font-size: 1rem; /* Tamanho reduzido dos ícones */
  transition: color 0.3s;
}

.social-icons a:hover {
  color: #FF385C;
}

/* Responsividade para dispositivos menores */
@media (max-width: 768px) {
  .footer-container {
    flex-wrap: nowrap; /* Mantém os itens em linha */
    justify-content: center; /* Centraliza os itens */
  }

  .footer-section {
    font-size: 0.75rem; /* Reduz um pouco mais o tamanho da fonte */
    margin-bottom: 0;
  }

  .social-icons a {
    font-size: 0.9rem; /* Ajusta ainda mais o tamanho dos ícones */
  }
}

@media (max-width: 480px) {
  .footer-container {
    flex-wrap: nowrap; /* Mantém os itens em linha */
    justify-content: center; /* Centraliza os itens */
  }

  .footer-section {
    font-size: 0.7rem; /* Fonte bem menor para telas pequenas */
  }

  .social-icons a {
    font-size: 0.8rem; /* Tamanho reduzido dos ícones */
  }
}
</style>

