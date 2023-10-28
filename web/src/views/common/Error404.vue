<template>
  <div class="error-page">
    <h1>404 - Page Not Found</h1>
    <p>Sorry, the page you are looking for could not be found.</p>
    <router-link to="/">Go back to the home page</router-link>
  </div>
</template>

<script lang="ts">
export default {
  name: 'Error404',
}
</script>

<style>
.error-page {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
  text-align: center;
}

h1 {
  font-size: 6rem;
  margin-bottom: 2rem;
}

p {
  font-size: 2rem;
  margin-bottom: 2rem;
}

router-link {
  font-size: 2rem;
}
</style>
