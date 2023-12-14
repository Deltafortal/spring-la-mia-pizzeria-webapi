<!------------------ Script ----------------->
<script>
import axios from 'axios';
export default {

    //Data
    data() {
        return {
            newPizza: {
                nome: "",
                url: "",
                descrizione: "",
                prezzo: "",

            }
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

        <div class="row">
				<div class="col-4">
					<label for="pizza-name" class="form-label">Nome</label>
					<input type="text" class="form-control" id="pizza-name" v-model="newPizza.nome">
				</div>
				
				
				<div class="col-8">
					<label for="pizza-url" class="form-label">Url immagine</label>
					<input type="text" class="form-control" id="pizza-url" th:field="*{url}">
				</div>
				
		</div>

    </form>

</template>




<!------------------ Style ----------------->
<style lang="scss" scoped>



</style>