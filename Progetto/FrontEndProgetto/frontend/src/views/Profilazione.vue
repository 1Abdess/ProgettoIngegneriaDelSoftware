<template>
    <div class="min-h-screen bg-slate-200 py-6 flex flex-col justify-center relative overflow-hidden sm:py-12">
      <form @submit.prevent="submitForm" class="border relative px-4 pt-7 pb-8 bg-white shadow-xl max-w-md mx-auto sm:px-10 rounded-b-md">
        <label for="codiceFiscale" class="block mb-3">Ricerca Persona Tramite Codice Fiscale:</label>
        <input v-model="codiceFiscale" type="text" id="codiceFiscale" class="border w-full h-10 px-3 mb-5 rounded-md" required>
        <button type="submit" class="bg-green-500 hover:bg-blue-700 shadow-xl text-white uppercase text-sm font-semibold px-14 py-3 rounded">Cerca</button>
      </form>
  
      <div v-if="loading" class="text-center mt-4">Caricamento...</div>
      <div v-if="error" class="error-message mt-4">{{ error }}</div>
  
      <div v-if="profilazione" class="border relative px-4 pt-7 pb-8 bg-white shadow-xl max-w-md mx-auto mt-4 sm:px-10 rounded-b-md">
        <h2>Profilazione</h2>
        <img :src="profilazione.urlFotoProfilo" alt="Foto Profilo" class="w-full mt-4">
        <p>Nome: {{ profilazione.nome }}</p>
        <p>Cognome: {{ profilazione.cognome }}</p>
        <p>Email: {{ profilazione.email }}</p>
        <p>Organizzazione: {{ profilazione.organizzazione }}</p>
        <p>Categoria: {{ profilazione.categoria }}</p>
      </div>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    data() {
      return {
        codiceFiscale: '',
        loading: false,
        error: null,
        profilazione: null
      };
    },
    methods: {
      submitForm() {
        this.loading = true;
        axios.get(`/profilazione/${this.codiceFiscale}`)
          .then(response => {
            this.loading = false;
            this.profilazione = response.data;
            
            // Verifica se l'URL dell'immagine è null assegna un'immagine di fallback
            if (!this.profilazione.urlFotoProfilo) {
              this.profilazione.urlFotoProfilo = 'https://www.pngitem.com/pimgs/m/302-3028991_incognito-icon-fedora-incognito-clipart-hd-png-download.png'; // Immagine di fallback
            }
          })
          .catch(error => {
            this.loading = false;
            this.error = 'Si è verificato un errore durante il recupero dei dati dell\'utente. Riprova più tardi.';
            console.error(error);
          });
      }
    }
  };
  </script>
  
  
  <style scoped>
  .error-message {
    color: red;
    font-weight: bold;
  }
  </style>
  
