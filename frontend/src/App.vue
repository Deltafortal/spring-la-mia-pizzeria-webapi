<!------------------ Script ----------------->
<script>
    //Import
    import AppHeader from './components/AppHeader.vue';

    export default {
        components: {AppHeader},
    }
</script>




<!------------------ Template ----------------->
<template>

  <!--- Header-->
  <AppHeader />

  <div class="container mb-5">

    <!-- Pages -->
    <main>
      <RouterView />
    </main>
  </div>

</template>




<!------------------ Style ----------------->
<style lang="scss">

</style>
