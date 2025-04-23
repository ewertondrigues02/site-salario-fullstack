import { createRouter, createWebHistory } from 'vue-router';

// Importe suas views
import TheContato from '../views/TheContato.vue';
import TheCargo from '../views/TheCargo.vue'; 
import TheHome from '../views/TheHome.vue';

const routes = [
  { path: '/contato', component: TheContato },
  { path: '/home', component: TheHome },
  { path: '/cargo', component: TheCargo } 
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;
