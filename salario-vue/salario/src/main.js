import './assets/css/main.css'
import '@/assets/css/main.css'
import '@fortawesome/fontawesome-free/css/all.css'
import router from './router'


import { createApp } from 'vue'
import App from './App.vue'

createApp(App).use(router).mount('#app')
