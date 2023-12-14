import { createRouter, createWebHistory } from 'vue-router';
import MainPage from '../pages/MainPage.vue';
import ShowPage from '../pages/ShowPage.vue';
import FormPage from '../pages/FormPage.vue';

const router = createRouter({
    history: createWebHistory(),
    routes: [
        { path: '/', name: 'home', component: MainPage },
        { path: '/pizza/:id', name: 'pizza', component: ShowPage },
        { path: '/pizza/create', name: 'create', component: FormPage },
    ]
});

export { router };