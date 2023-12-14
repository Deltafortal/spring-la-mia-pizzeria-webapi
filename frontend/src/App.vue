<!------------------ Script ----------------->
<script>
    //Import
    import AppHeader from './components/AppHeader.vue';

    import axios from 'axios';

    export default {
        components: {AppHeader},
        //Data
        data() {
            return {
              pizzas: [],
            }
        },

        //methods
        methods: {

          fetchPizza(){

            axios.get('http://localhost:8080/api/pizza').then(response => {
              this.pizzas = response.data;
            }).catch(error => {
              console.error('Errore nella chiamata API', error);
            });
          }

        },


        // Mounted
        mounted() {
          this.fetchPizza()
        }

    } 
</script>




<!------------------ Template ----------------->
<template>

  <!--- Header-->
  <AppHeader />

  <div class="container mb-5">

    <!-- Pages -->
    <main>
      <RouterView :pizzas="pizzas"/>
    </main>
  </div>

</template>




<!------------------ Style ----------------->
<style lang="scss">

</style>
