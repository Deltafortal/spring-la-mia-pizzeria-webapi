<!------------------ Script ----------------->
<script>
    //Import
    import AppHeader from './components/AppHeader.vue';
    import AppMain from './components/AppMain.vue';
    import axios from 'axios';

    export default {
        components: { AppHeader, AppMain },

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
    <!--- Main -->
    <AppMain :pizzas="this.pizzas" />
  </div>

</template>




<!------------------ Style ----------------->
<style lang="scss">

</style>
