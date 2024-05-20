import { createRouter, createWebHistory } from 'vue-router'

import HomeView from '../views/Home.vue'
import LoginView from '../views/Login.vue'
import RegistrazioneView from '../views/Registrazione.vue'
import ProfilazioneView from '../views/Profilazione.vue'


const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/login',
    name: 'login',
    component: LoginView
  },
  {
    path: '/registrazione',
    name: 'registrazione',
    component: RegistrazioneView
  },
  {
    path: '/profilazione',
    name: 'profilazione',
    component: ProfilazioneView
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
