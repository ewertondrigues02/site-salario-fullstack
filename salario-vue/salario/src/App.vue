<template>
  <div id="app">
    <TheHeader />
    <router-view /> <!-- Aqui renderiza o conteúdo da página -->
    <TheFooter />
  </div>
</template>

<script setup>
import TheHeader from './components/TheHeader.vue';
import TheFooter from './components/TheFooter.vue';
</script>
