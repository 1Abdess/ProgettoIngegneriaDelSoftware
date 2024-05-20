const { defineConfig } = require('@vue/cli-service')

module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    port: 8081, // Imposta la porta predefinita del server su 8081
    proxy: {
      '/': {
        target: 'http://localhost:8080', // Indirizzo del tuo backend Spring
        changeOrigin: true,
        ws: false
      }
    }
  }
})