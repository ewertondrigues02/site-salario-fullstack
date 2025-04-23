<!-- src/components/NomeDoComponente.vue -->
<template>
  <header>
    <h1>Salário Fácil</h1>
    <div class="menu-toggle" @click="toggleMenu">
      <div></div>
      <div></div>
      <div></div>
    </div>
    <nav class="nav-1" :class="{ open: isMenuOpen }">
      <a href="http://localhost:5173/home">Home</a>
      <a href="http://localhost:5173/cargo">Cargo</a>
      <a href="http://localhost:5173/contato">Contato</a>
    </nav>
  </header>
</template>

<script setup>
import { ref } from 'vue';

const isMenuOpen = ref(false);

function toggleMenu() {
  isMenuOpen.value = !isMenuOpen.value;
}
</script>

<style>
:root {
  --primary: #ff6b81;
  --secondary: #717171;
  --background: #ffffff;
  --light-gray: #F7F7F7;
  --font: 'Nunito', sans-serif;
}

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: var(--font);
}

header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 1.5rem 3rem;
  background-color: var(--background);
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.05);
  position: sticky;
  top: 0;
  z-index: 1000;
  animation: slideDown 0.5s ease-out;
  max-height: 4.5rem;
}

header h1 {
  color: #FF385C;
  font-weight: 800;
  font-size: 1.8rem;
}

.nav-1 {
  display: flex;
  gap: 1rem;
  
}

.nav-1 a {
  padding: 0.3rem 0.8rem;
  background-color: transparent;
  text-decoration: none;
  color: var(--secondary);
  font-weight: 600;
  border-radius: 0.7rem;
  transition: all 0.3s ease;
  border-bottom: 2px solid #ccc;
  font-size: 1.2rem;
}

.nav-1 a:hover {
  border-bottom: 2px solid var(--primary);
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.3);
  color: rgba(0, 0, 0, 0.8);
}


.menu-toggle {
  display: none;
  cursor: pointer;
  flex-direction: column;
  gap: 4px;
}

.menu-toggle div {
  width: 25px;
  height: 3px;
  background-color: #333;
  transition: transform 0.3s ease;
}

@keyframes slideDown {
  from {
    opacity: 0;
    transform: translateY(-20px);
  }

  to {
    opacity: 1;
    transform: translateY(0);
  }
}


@media (max-width: 768px) {
  header {
    padding: 1rem;
  }

  header h1 {
    font-size: 1.3rem;
  }


  .menu-toggle {
    display: flex;
  }


  .nav-1 {
    display: none;
    flex-direction: column;
    gap: 1rem;
    position: absolute;
    top: 4rem;
    right: 2rem;
    background-color: var(--background);
    padding: 1rem;
    border-radius: 10px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  }


  .nav-1.open {
    display: flex;
  }

  .nav-1 a {
    font-size: 1rem;
    padding: 1rem;
    border-bottom: 2px solid #ccc;
  }
}

@media (max-width: 480px) {
  header {
    padding: 0.8rem;
  }

  header h1 {
    font-size: 1.2rem;
  }

  .nav-1 {
    gap: 0.7rem;
  }

  .nav-1 a {
    padding: 0.2rem 0.5rem;
    font-size: 0.8rem;
  }

  .menu-toggle div {
    width: 20px;
    height: 2px;
  }
}

.menu-toggle.open div:nth-child(1) {
  transform: rotate(45deg) translateY(8px);
}

.menu-toggle.open div:nth-child(2) {
  opacity: 0;
}

.menu-toggle.open div:nth-child(3) {
  transform: rotate(-45deg) translateY(-8px);
}
</style>
