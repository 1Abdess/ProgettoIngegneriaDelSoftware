<template>
  <div class="min-h-screen bg-slate-200 py-6 flex flex-col justify-center relative overflow-hidden sm:py-12">
  
    <span class="border text-4xl text-yellow-800 px-6 pt-10 pb-8 bg-white w-1/2 max-w-md mx-auto rounded-t-md sm:px-10">
      LOGIN
    </span>
  
    <div class="border relative px-4 pt-7 pb-8 bg-white shadow-xl w-1/2 max-w-md mx-auto sm:px-10 rounded-b-md">
        <!-- Utilizziamo la direttiva @submit.prevent per intercettare il submit del form -->
        <form @submit.prevent="submitForm">
            <!-- Aggiunta dell'attributo required per i campi obbligatori -->
            <input v-model="CodiceFiscale" type="text" class="border w-full h-10 px-3 mb-5 rounded-md" placeholder="Codice Fiscale" required> 
            <input v-model="Password" type="password" class="border w-full h-10 px-3 mb-5 rounded-md" placeholder="Password" required>
            
            <!-- Cambiato il testo del pulsante a "Registrati" -->
            <button type="submit" class="mt-5 bg-green-500 hover:bg-blue-700 shadow-xl text-white uppercase text-sm font-semibold px-14 py-3 rounded">
                Registrati
            </button>
        </form>
    </div>

    <!-- Aggiunto il blocco per mostrare il messaggio di errore -->
    <div v-if="error" class="bg-red-500 text-white px-4 py-2 mt-4 text-center">
        {{ error }}
    </div>
  </div>
</template>
  
<script>
import axios from 'axios';

export default {
  data() {
    return {
      CodiceFiscale: '',
      Password: '',
      error: '' // Aggiunto il dato per gestire il messaggio di errore
    };
  },
  methods: {
    submitForm() {
      const formData = {
        codiceFiscale: this.CodiceFiscale.toUpperCase(),
        password: this.Password,
      };

      axios.post('/login', formData)
        .then(response => {
          // Se la registrazione ha avuto successo, reindirizza a profilazione
          this.$router.push('/profilazione');
        })
        .catch(error => {
          if (error.response && error.response.data && error.response.data.message) {
            this.error = error.response.data.message;
          } else {
            // Se il messaggio di errore non è disponibile nel formato atteso, mostra un messaggio generico
            this.error = 'Errore di registrazione, riprova.';
          }
          console.error(error);
        });
    }
  }
};
</script>

<style scoped>
/* I tuoi stili rimangono invariati */
</style>
