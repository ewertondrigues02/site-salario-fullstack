<template>
    <main>
        <section class="table-section">
            <div class="table-container">
                <!-- Campo de pesquisa -->
                <div class="mb-4">
                    <input v-model="termoPesquisa" type="text" placeholder="PESQUISAR POR CARGO OU CBO"
                        class="input-pesquisa" />
                </div>

                <!-- Tabela -->
                <table class="table">
                    <thead>
                        <tr>
                            <th style="width: 30%;">Cargo</th>
                            <th>CBO</th>
                            <th>Salário Júnior</th>
                            <th>Salário Pleno</th>
                            <th>Salário Sênior</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="salario in salariosPaginados" :key="salario.cbo">
                            <td style="width: 30%; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;"
                                :title="salario.cargo">
                                {{ salario.cargo }}
                            </td>
                            <td>{{ salario.cbo }}</td>
                            <td>{{ salario.salarioJunior }}</td>
                            <td>{{ salario.salarioPleno }}</td>
                            <td>{{ salario.salarioSenior }}</td>
                        </tr>
                    </tbody>
                </table>

                <!-- Paginação -->
                <div class="pagination">
                    <button @click="paginaAnterior" :disabled="paginaAtual === 1">Anterior</button>
                    <span>Página {{ paginaAtual }} de {{ totalPaginas }}</span>
                    <button @click="proximaPagina" :disabled="paginaAtual >= totalPaginas">Próxima</button>
                </div>
            </div>
        </section>
    </main>
</template>

<script setup>
import { ref, computed, onMounted, watch } from 'vue'
import axios from 'axios'

const salarios = ref([])
const termoPesquisa = ref('')
const paginaAtual = ref(1)
const itensPorPagina = 6

const salariosFiltrados = computed(() => {
    console.log('Valor da pesquisa:', termoPesquisa.value);
    if (!termoPesquisa.value.trim()) return salarios.value;
    const termo = termoPesquisa.value.toLowerCase();
    return salarios.value.filter(s => {
        const cargo = s.cargo ? s.cargo.toLowerCase() : '';
        const cbo = s.cbo ? s.cbo.toLowerCase() : '';

        return cargo.includes(termo) || cbo.includes(termo);
    });
});


const salariosPaginados = computed(() => {
    const inicio = (paginaAtual.value - 1) * itensPorPagina
    const fim = inicio + itensPorPagina
    const paginados = salariosFiltrados.value.slice(inicio, fim)
    console.log('Paginados:', paginados)
    return paginados
})

const totalPaginas = computed(() => {
    const total = Math.ceil(salariosFiltrados.value.length / itensPorPagina)
    console.log('Total de páginas:', total)
    return total || 1
})

onMounted(async () => {
    try {
        const response = await axios.get('http://localhost:8081/api/salarios')
        console.log('Resposta da API:', response.data);
        salarios.value = response.data
    } catch (error) {
        console.error('Erro ao buscar salários:', error)
    }
})

watch(termoPesquisa, () => {
    paginaAtual.value = 1
})

const paginaAnterior = () => {
    if (paginaAtual.value > 1) {
        paginaAtual.value--
    }
}

const proximaPagina = () => {
    if (paginaAtual.value < totalPaginas.value) {
        paginaAtual.value++
    }
}
</script>

<style scoped>
:root {
  --primary: #FF385C;
  --secondary: #717171;
  --background: #F0FFF0;
  --light-gray: #F7F7F7;
  --font: 'Nunito', sans-serif;
}

body {
  background-color: var(--background);
  font-family: var(--font);
  margin: 0;
  padding: 0;
  line-height: 1.6;
}

/* Estilo geral com aparência de app */
.table-section {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 1rem;
  background-color: var(--background);
  min-height: 100vh;
  box-sizing: border-box;
}

/* Caixa com efeito de cartão */
.table-container {
  width: 100%;
  max-width: 900px;
  background-color: #fff;
  border-radius: 1rem;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
  overflow-x: auto;
  padding: 1rem;
  box-sizing: border-box;
}

/* Tabela adaptativa */
.table {
  width: 100%;
  border-collapse: collapse;
  table-layout: auto;
  min-width: 600px;
  border-radius: 8px;
  padding: 1rem;
  margin-bottom: 1rem;
  
}

th,
td {
  padding: 1rem;
  text-align: left;
  border-bottom: 1px solid #eee;
  font-size: 0.8rem;
  word-break: break-word;  
}

th {
  background-color: var(--light-gray);
  font-weight: 600;
  position: sticky;
  top: 0;
  z-index: 1;
  
}

tbody tr:hover {
  background-color: #f4f4f4;
 
}

/* Input de pesquisa com estilo app */
.input-pesquisa {
  width: 100%;
  max-width: 400px;
  padding: 0.75rem 1rem;
  margin: 0 auto 1.5rem auto;
  font-size: 1rem;
  border: none; 
  border-bottom: 2px solid #ccc;
  border-radius: 12px;
  outline: none;
  transition: 0.3s border-color;
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.05);
  max-height: 2.5rem;
}

.input-pesquisa:focus {
  border-bottom-color: var(--primary); 
}


/* Paginação em estilo botão-app */
.pagination {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 0.5rem;
  margin-top: 1.5rem;
}

.pagination button {
  padding: 0.6rem 1.2rem;
  border: none;
  background-color: var(--primary);
  color: #fff;
  border-radius: 0.75rem;
  font-size: 1rem;
  cursor: pointer;
  transition: background-color 0.3s ease;
  box-shadow: 0 2px 6px rgba(0, 0, 0, 0.15);
}

.pagination button:hover {
  background-color: #e83050;
}

.pagination button:disabled {
  background-color: #ccc;
  cursor: not-allowed;
}

/* Responsivo para tablets e celulares */
@media (max-width: 768px) {
  .table-container {
    padding: 1rem 0.5rem;
  }

  .table {
    min-width: 100%;
    font-size: 0.9rem;
  }

  th,
  td {
    padding: 0.75rem;
  }

  .input-pesquisa {
    max-width: 100%;
    font-size: 1rem;
  }

  .pagination button {
    font-size: 0.9rem;
    padding: 0.5rem 1rem;
  }
}

@media (max-width: 480px) {
  .table-section {
    padding: 0.5rem;
  }

  .table-container {
    border-radius: 0.75rem;
    box-shadow: none;
  }

  th,
  td {
    padding: 0.5rem;
    font-size: 0.85rem;
  }

  .pagination button {
    font-size: 0.85rem;
    padding: 0.4rem 0.8rem;
  }
}
</style>
