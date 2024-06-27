<template>
    <div class="min-h-screen bg-slate-200 py-6 flex flex-col justify-center relative overflow-hidden sm:py-12">
      <span class="border text-4xl text-yellow-800 px-6 pt-10 pb-8 bg-white w-1/2 max-w-md mx-auto rounded-t-md sm:px-10">
        Modifica Utente
      </span>
  
      <div class="border relative px-4 pt-7 pb-8 bg-white shadow-xl w-1/2 max-w-md mx-auto sm:px-10 rounded-b-md">
        <form @submit.prevent="submitForm">
          <input v-model="utente.codiceFiscale" type="text" class="border w-full h-10 px-3 mb-5 rounded-md" placeholder="Codice Fiscale" required>
          <input v-model="utente.nome" type="text" class="border w-full h-10 px-3 mb-5 rounded-md" placeholder="Nome" required>
          <input v-model="utente.cognome" type="text" class="border w-full h-10 px-3 mb-5 rounded-md" placeholder="Cognome" required>
          <input v-model="utente.organizzazione" type="text" class="border w-full h-10 px-3 mb-5 rounded-md" placeholder="Organizzazione">
          <input v-model="utente.categoria" type="text" class="border w-full h-10 px-3 mb-5 rounded-md" placeholder="Categoria">
          <input v-model="utente.urlFotoProfilo" type="text" class="border w-full h-10 px-3 mb-5 rounded-md" placeholder="URL Foto Profilo">
  
          <button type="submit" class="mt-5 bg-green-500 hover:bg-blue-700 shadow-xl text-white uppercase text-sm font-semibold px-14 py-3 rounded">
            Aggiorna
          </button>
        </form>
      </div>
  
      <div v-if="error" class="bg-red-500 text-white px-4 py-2 mt-4 text-center">
        {{ error }}
      </div>
  
      <div v-if="successMessage" class="bg-green-500 text-white px-4 py-2 mt-4 text-center">
        {{ successMessage }}
      </div>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    data() {
      return {
        utente: {
          codiceFiscale: '',
          nome: '',
          cognome: '',
          email: '',
          organizzazione: '',
          categoria: '',
          urlFotoProfilo: ''
        },
        error: '',
        successMessage: ''
      };
    },
    methods: {
      submitForm() {
        axios.put(`/modifica/${this.utente.codiceFiscale}`, this.utente)
          .then(response => {
            this.successMessage = 'Utente aggiornato con successo!';
            this.error = '';
          })
          .catch(error => {
            if (error.response && error.response.data) {
              this.error = error.response.data;
            } else {
              this.error = 'Errore durante l\'aggiornamento, riprova.';
            }
            this.successMessage = '';
            console.error(error);
          });
      }
    }
  };
  </script>
  
  <style scoped>
  </style>
  