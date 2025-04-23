<template>
  <div class="cargo-container">

    <!-- Campo de busca -->
    <div class="search-container">
      <input v-model="searchTerm" placeholder="Buscar cargo por nome..." />
      <button v-if="searchTerm" @click="limparFiltro" class="clear-search">
        Limpar
      </button>
    </div>

    <!-- Filtro de A a Z -->
    <div class="alphabet-filter">
      <button v-for="letter in alphabet" :key="letter" @click="filterByLetter(letter)"
        :class="{ active: currentLetter === letter }">
        {{ letter }}
      </button>
    </div>

    <!-- Lista em 3 colunas -->
    <div v-if="paginatedCargos.length > 0" class="cargo-columns">
      <div v-for="(coluna, index) in dividirEmColunas(paginatedCargos, 3)" :key="index" class="cargo-column">
        <ul>
          <li v-for="cargo in coluna" :key="cargo.id">
            <strong>{{ cargo.cargo }}</strong>
          </li>
        </ul>
      </div>
    </div>
    <p v-else>Nenhum cargo encontrado.</p>

    <!-- Paginação -->
    <div class="pagination">
      <button @click="paginaAnterior" :disabled="paginaAtual === 1">
        Anterior
      </button>
      <span>Página {{ paginaAtual }} de {{ totalPaginas }}</span>
      <button @click="proximaPagina" :disabled="paginaAtual === totalPaginas">
        Próximo
      </button>
    </div>

  </div>
</template>



<script>
import axios from 'axios';

export default {
  data() {
    return {
      cargos: [], // Lista completa de cargos
      searchTerm: '', // Termo de busca
      currentLetter: '', // Letra inicial selecionada para filtro
      paginaAtual: 1, // Página atual
      itensPorPagina: 15, // Quantidade de itens por página
      alphabet: 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'.split('') // Alfabeto A-Z para filtro de letras
    };
  },
  computed: {
    // Filtrando os cargos com base no termo de busca e na letra inicial
    cargosFiltrados() {
      return this.cargos.filter(cargo => {
        if (!cargo || !cargo.cargo) return false; // Verifica se 'cargo' e 'cargo.cargo' existem
        const nome = cargo.cargo.toLowerCase();
        const searchMatch = nome.includes(this.searchTerm.toLowerCase());
        const letterMatch = !this.currentLetter || nome.startsWith(this.currentLetter.toLowerCase());
        return searchMatch && letterMatch;
      });
    },
    // Paginação dos cargos
    paginatedCargos() {
      const start = (this.paginaAtual - 1) * this.itensPorPagina;
      return this.cargosFiltrados.slice(start, start + this.itensPorPagina);
    },
    totalPaginas() {
      return Math.ceil(this.cargosFiltrados.length / this.itensPorPagina);
    }
  },
  methods: {
    // Carregando os cargos da API
    async carregarCargos() {
      try {
        const response = await axios.get('http://localhost:8081/api/salarios');
        console.log('Dados da API:', response.data);  // Verificando a estrutura dos dados
        this.cargos = response.data; // Salvando os dados no estado
      } catch (erro) {
        console.error('Erro ao buscar cargos:', erro);
      }
    },

    // Limpando o filtro
    limparFiltro() {
      this.searchTerm = '';
      this.currentLetter = '';
      this.paginaAtual = 1;
    },

    // Filtrando cargos pela letra A-Z
    filterByLetter(letra) {
      this.currentLetter = letra;
      this.paginaAtual = 1; // Reseta a página para a primeira ao filtrar por letra
    },

    // Navegar para a página anterior
    paginaAnterior() {
      if (this.paginaAtual > 1) this.paginaAtual--;
    },

    // Navegar para a próxima página
    proximaPagina() {
      if (this.paginaAtual < this.totalPaginas) this.paginaAtual++;
    },

    // Dividindo os cargos em colunas (número de colunas como parâmetro)
    dividirEmColunas(cargos, numColunas) {
      const colunas = [];
      for (let i = 0; i < numColunas; i++) {
        colunas.push([]);
      }

      cargos.forEach((cargo, index) => {
        colunas[index % numColunas].push(cargo);
      });

      return colunas;
    }
  },
  mounted() {
    this.carregarCargos(); // Carregar os cargos assim que o componente for montado
  }
};
</script>

<style scoped>
:root {
  --primary: #FF385C;
  --secondary: #717171;
  --background: #F0FFF0;
  --light-gray: #F7F7F7;
  --font: 'Nunito', sans-serif;
}

.cargo-container {
  padding: 1.5rem;
  flex: 1;
  padding-bottom: 100px;
  font-family: var(--font);
  background-color: var(--background);
  font-size: 0.85rem;
  overflow-x: auto; /* Adiciona rolagem horizontal quando necessário */
}

/* Campo de busca centralizado e menor */
.search-container {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 0.5rem;
  margin-bottom: 1.5rem;
}

.search-container input {
  width: 180px; /* Diminuído o tamanho do campo de busca */
  padding: 8px 12px;
  border: none;
  border-bottom: 2px solid #ccc;
  border-radius: 10px;
  font-size: 0.9rem;
  box-sizing: border-box;
  outline: none;
  transition: border-color 0.3s;
}

.search-container input:focus {
  border-bottom: 2px solid var(--primary);
}

.search-container button {
  padding: 6px 10px;
  background-color: var(--primary);
  color: white;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  font-weight: bold;
  transition: background-color 0.3s ease;
}

.search-container button:hover {
  background-color: #e0364e;
}

/* Colunas centralizadas e ajustadas */
.cargo-columns {
  display: flex;
  justify-content: center;
  gap: 1rem;
  margin-bottom: 1.5rem;
  flex-wrap: wrap;
}

.cargo-column {
  width: 100%;
  max-width: 300px;
  background-color: var(--light-gray);
  border-radius: 8px;
  padding: 1rem;
  margin-bottom: 1rem;
}

.cargo-column ul {
  list-style-type: none;
  padding: 0;
  margin: 0;
}

.cargo-column li {
  padding: 0.75rem;
  border-bottom: 1px solid #ddd;
  background-color: #f9f9f9;
  border-radius: 8px;
  font-size: 0.85rem;
}

/* Filtro A-Z - Botões menores */
.alphabet-filter {
  display: flex;
  justify-content: center;
  flex-wrap: nowrap; /* Mantém em linha */
  gap: 0.4rem;
  margin-bottom: 1rem;
  max-width: 100%;
  overflow-x: auto; /* Garante que não quebre em telas estreitas */
  padding: 0 0.5rem;
}

.alphabet-filter button {
  padding: 4px 8px;
  font-size: 0.75rem;
  background-color: #f0f0f0;
  color: #333;
  border: 1px solid #ddd;
  border-radius: 6px;
  cursor: pointer;
  transition: background-color 0.3s ease;
  white-space: nowrap; /* Impede quebra de texto */
}


.alphabet-filter button:hover {
  background-color: #e0e0e0;
}

.alphabet-filter button.active {
  background-color: #50C878;
  color: white;
}

/* Paginação */
.pagination {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-wrap: wrap;
  gap: 0.5rem;
  margin-top: 1.5rem;
}

.pagination button {
  padding: 6px 10px;
  background-color: var(--primary);
  color: white;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  font-weight: bold;
  transition: background-color 0.3s ease;
}

.pagination button:hover:not(:disabled) {
  background-color: #e0364e;
}

.pagination button:disabled {
  background-color: #ccc;
  color: #666;
  cursor: not-allowed;
}

.pagination span {
  font-size: 0.85rem;
  color: #333;
}

/* Tabela Responsiva */
.table-container {
  width: 100%;
  overflow-x: auto; /* Garante que a tabela tenha rolagem quando necessário */
}

.table {
  width: 100%;
  border-collapse: collapse;
}

.table th,
.table td {
  padding: 12px 20px;
  text-align: center;
  border: 1px solid #ddd;
  font-size: 0.9rem; /* Ajuste na fonte da tabela */
}

/* Responsivo */
@media (max-width: 768px) {
  .search-container {
    flex-direction: column;
    align-items: stretch;
  }

  .search-container input,
  .search-container button {
    width: 100%;
  }

  .cargo-columns {
    flex-direction: column;
    align-items: center;
  }

  .cargo-column {
    width: 100%;
    max-width: 400px;
  }

  .alphabet-filter {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(28px, 1fr));
    gap: 0.4rem;
    max-width: 400px;
    margin-left: auto;
    margin-right: auto;
    overflow-x: unset;
    padding: 0;
  }
}

@media (max-width: 480px) {
  .cargo-columns {
    flex-direction: column;
    align-items: center;
  }

  .cargo-column {
    width: 100%;
    max-width: 90%;
  }

  .alphabet-filter {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(28px, 1fr));
    gap: 0.4rem;
    max-width: 400px;
    margin-left: auto;
    margin-right: auto;
    overflow-x: unset;
    padding: 0;
  }

  .search-container input {
    width: 90%;
  }

  .search-container button {
    width: 90%;
  }
}
</style>









