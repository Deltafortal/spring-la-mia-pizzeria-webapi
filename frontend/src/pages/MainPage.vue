<!------------------ Script ----------------->
<script>

import axios from 'axios';

export default {
    //Data
    data() {
        return {
          pizzas: [],
        }
    },

    //methods
    methods: {

      fetchPizzas(){

        axios.get('http://localhost:8080/api/pizza').then(response => {
          this.pizzas = response.data;
        }).catch(error => {
          console.error('Errore nella chiamata API', error);
        });
      }

    },


    // Mounted
    mounted() {
      this.fetchPizzas()
    }

}


</script>




<!------------------ Template ----------------->
<template>
    <h1 class="text-center mb-5">Le pizze:</h1>


    <div class="row row-cols-1 row-cols-md-2 g-4">
        <div v-for="pizza in this.pizzas" class="col">
            <div class="card text-center">
                <img :src="pizza.url" class="card-img-top" :alt="pizza.nome">
                <div class="card-body">
                    <h5 class="card-title">{{ pizza.nome }}</h5>
                    <p class="card-text">{{ pizza.descrizione }}</p>
                    <RouterLink class="btn btn-primary" :to="`/pizza/${pizza.id}`">Mostra</RouterLink>
                </div>
            </div>
        </div>
    </div>


</template>




<!------------------ Style ----------------->
<style lang="scss" scoped>

.card {

    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 15px;
    min-height: 380px;

    img {
        width: 250px;
    }
}


</style>