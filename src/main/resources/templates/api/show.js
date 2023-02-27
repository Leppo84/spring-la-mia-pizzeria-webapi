const URLParams = new URLSearchParams(window.location.search);
const pizzaId = URLParams.get('id');

axios.get(`http://localhost:8080/api/${pizzaId}`).then((res) => {
	console.log('richiesta ok', res);
	//res.data è una Pizza 
	document.querySelector('#pizza_show').innerHTML += `
			<div class="col-md-4">
			<img src="${res.data.photo}" class="img-fluid" alt="...">
			</div>
			<div class="col-md-8">
				<h5 class="">${res.data.name}</h5>
				<p class="">${res.data.description}</p>
				<h6>Ingredienti: MISSING</h6>
				<p class="">${res.data.price} €</p>
			</div>
            `

//				<span class="col-4" th:each="ingredient : ${pizza.ingredient}" th:text="${ingredient.name}"></span>
//				<span> </span>
    
}).catch ((res) => {
	console.error('errore nella richiesta', res);
	alert('Errore durante la richiesta!');
});