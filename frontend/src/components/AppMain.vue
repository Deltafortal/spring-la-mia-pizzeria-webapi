<!------------------ Script ----------------->
<script>

export default {

    //Data
    data() {
        return {
            
        }
    },

    //Props
    props: {
        pizzas: Array
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
    height: 330px;

    img {
        width: 250px;
    }
}


</style>