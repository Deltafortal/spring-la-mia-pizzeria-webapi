<!------------------ Script ----------------->
<script>
import axios from 'axios';
export default {

    //Data
    data() {
        return {
            pizza: null
        }
    },

    methods: {

        fetchPizza(){

            axios.get(`http://localhost:8080/api/pizza/${this.$route.params.id}`).then(response => {
            this.pizza = response.data;
            }).catch(error => {
            console.error('Errore nella chiamata API', error);
            });
        },

        deletePizza(){
            axios.delete(`http://localhost:8080/api/pizza/${this.$route.params.id}`, { key: 'value' }).then(response => {
                console.log(response.data);
            }).catch(error => {
                console.error('Errore nella chiamata API', error);
            });
        }
    },

    created() {
        this.fetchPizza()
    }
}


</script>




<!------------------ Template ----------------->
<template>
    <h1 class="text-center mb-5">Le pizze:</h1>

    <div v-if="this.pizza != null">
        <div class="card" style="width: 18rem;">
            <img :src="this.pizza.url" class="card-img-top" :alt="this.pizza.nome">
            <div class="card-body">
                <h5 class="card-title">{{ this.pizza.nome }}</h5>
                <p class="card-text">{{ this.pizza.descrizione }}</p>
                <RouterLink class="btn btn-danger" @click="deletePizza" to="/">Cancella</RouterLink>
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
    height: 330px;

    img {
        width: 250px;
    }
}


</style>