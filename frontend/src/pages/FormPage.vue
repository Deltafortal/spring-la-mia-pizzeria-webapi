<!------------------ Script ----------------->
<script>
import axios from 'axios';
export default {

    //Data
    data() {
        return {
            
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
    },

}


</script>




<!------------------ Template ----------------->
<template>
    
    <h1 class="text-center mb-5">Le pizze:</h1>

    <form @submit.prevent="submit">

    </form>

</template>




<!------------------ Style ----------------->
<style lang="scss" scoped>



</style>