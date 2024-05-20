<template>
    <div class="min-h-screen bg-slate-200 py-6 flex flex-col justify-center relative overflow-hidden sm:py-12">
  
      <span class="border text-4xl text-yellow-800 px-6 pt-10 pb-8 bg-white w-1/2 max-w-md mx-auto rounded-t-md sm:px-10">
          REGISTRAZIONE
      </span>
  
      <div class="border relative px-4 pt-7 pb-8 bg-white shadow-xl w-1/2 max-w-md mx-auto sm:px-10 rounded-b-md">
          <form @submit.prevent="submitForm">
              <input v-model="CodiceFiscale" type="text" class="border w-full h-10 px-3 mb-5 rounded-md" placeholder="Codice Fiscale" required> 
              <input v-model="Password" type="password" class="border w-full h-10 px-3 mb-5 rounded-md" placeholder="Password"required>
              <input v-model="Nome" type="text" class="border w-full h-10 px-3 mb-5 rounded-md" placeholder="nome" required>
              <input v-model="Cognome" type="text" class="border w-full h-10 px-3 mb-5 rounded-md" placeholder="cognome" required>
              <input v-model="Email" type="email" class="border w-full h-10 px-3 mb-5 rounded-md" placeholder="email" required>
              <input v-model="Organizzazione" type="text" class="border w-full h-10 px-3 mb-5 rounded-md" placeholder="organizzazione">
              <input v-model="Categoria" type="text" class="border w-full h-10 px-3 mb-5 rounded-md" placeholder="categoria">
              <input v-model="FotoProfilo" type="text" class="border w-full h-10 px-3 mb-5 rounded-md" placeholder="Url Foto Profilo">
  
    
              <button type="submit" class="mt-5 bg-green-500 hover:bg-blue-700 shadow-xl text-white uppercase text-sm font-semibold px-14 py-3 rounded">
              Login
              </button>
          </form>
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
        Nome: '',
        Cognome: '',
        Email: '',
        Organizzazione: '',
        Categoria: '',
        FotoProfilo: ''
      };
    },
    methods: {
      submitForm() {
        const formData = {
          codiceFiscale: this.CodiceFiscale.toUpperCase(),
          password: this.Password,
          nome: this.Nome,
          cognome: this.Cognome,
          email: this.Email,
          organizzazione: this.Organizzazione,
          categoria: this.Categoria,
          fotoProfilo: this.FotoProfilo
        };
  
        axios.post('/registrazione', formData)
          .then(response => {
            console.log(response.data);
            this.$router.push('/login')
          })
          .catch(error => {
            console.error(error);
          });
      }
    }
  };
  </script>
  
  <style scoped>
  /* I tuoi stili rimangono invariati */
  </style>
  