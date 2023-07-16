<template>
  <div class="clima">
    <div class="clima__componente">
      <header class="clima__header">
        <div class="clima__titulo">
          <h1 class="clima__titulo__texto">Climapp</h1>
          <p class="clima__titulo__descricao">Previsões climáticas</p>
        </div>
        <div class="clima__pesquisa">
          <input
            class="clima__pesquisa-input"
            ref="inputPesquisa"
            type="text"
            v-model="localizacao"
            @keyup.enter="getClima"
            placeholder="Pesquisar localização"
          />
          <button
            class="clima__pesquisa-botao"
            @click="getClima"
          >
            Pesquisar
          </button>
        </div>
      </header>
      <main class="clima__conteudo" v-if="climaData">
        <h1>
    			{{climaData.location.name}} - {{climaData.location.region}}
        </h1>
        <h2>
          O clima atual é: {{climaData.current.condition.text}}
        </h2>
      </main>
    </div>
  </div>
</template>

<script>
const API_KEY = "b40d59c37e514605abb175741231306";

export default {
  name: "ClimaApp",
  data() {
    return {
      localizacao: "",
      climaData: null,
    };
  },
  methods: {
    async getClima() {
      if (this.localizacao === "") {
        this.$refs.inputPesquisa.focus();
        return;
      }

      const formatarLocalizacao = this.localizacao
        .trim()
        .replace(/\s+/g, "+")
        .toLowerCase();

      const API_URL = `https://api.weatherapi.com/v1/current.json?key=${API_KEY}&lang=pt&q=${formatarLocalizacao}`;
      const req = await fetch(API_URL)
      const response = await req.json()
        // Adicionar a chamada da API weatherapi.com
        // Armazenar o resultado em climaData
      this.climaData = response
			console.log(response)
      console.log(API_URL);
    },
  },
};
</script>

<style scoped>
/* Global styles */
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

/* Clima componente styles */
.clima {
  min-width: 100vw;
  min-height: 100vh;
  font-family: apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  background-color: #f8f9fa;
  overflow: hidden;
}
.clima__componente {
  margin: 0 auto;
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 2rem;
  max-width: 1216px;
  height: 100%;
  padding: 32px;
}

@media (max-width: 768px) {
  .clima__componente {
    padding: 32px 16px;
  }
}

/* Clima header styles */
.clima__header {
  margin-bottom: 2rem;
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 100%;
}

@media (max-width: 768px) {
  .clima__header {
    flex-direction: column;
    gap: 32px;
  }
}

/* Clima titulo styles */
.clima__titulo__texto {
  margin: 0;
  font-weight: 800;
  font-size: 36px;
  line-height: 48px;
  color: #22333b;
}

.clima__titulo__descricao {
  margin: 0;
  font-weight: 500;
  font-size: 18px;
  line-height: 32px;
  color: #495057;
}

/* Clima pesquisa styles */
.clima__pesquisa {
  display: flex;
  align-items: center;
  gap: 12px;
  width: 100%;
  max-width: 400px;
}

.clima__pesquisa-input {
  padding: 12px 17px;
  width: 100%;
  border-radius: 6px;
  border: 1px solid #d1d5db;
  outline: transparent;
  transition: all 0.2s ease-in-out;
  box-shadow: 0px 1px 2px rgba(0, 0, 0, 0.05);
}

.clima__pesquisa-input:focus {
  border: 1px solid #f6bd60;
  outline: 4px solid #f6bd60;
}

.clima__pesquisa-botao {
  padding: 12px 17px;
  border-radius: 6px;
  border: transparent;
  outline: transparent;
  font-weight: 500;
  color: #000814;
  background-color: #ffbf69;
  transition: all 0.2s ease-in-out;
  box-shadow: 0px 1px 2px rgba(0, 0, 0, 0.05);
  cursor: pointer;
}

.clima__pesquisa-botao:hover {
  background-color: #f6bd60;
}

.clima__pesquisa-botao:focus {
  border: 1px solid #f6bd60;
  outline: 4px solid #f6bd60;
}
</style>