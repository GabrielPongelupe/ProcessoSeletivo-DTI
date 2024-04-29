// variáveis necessárias da busca dos petshops
const dataBusca = document.getElementById('data-busca');
const botaoBusca = document.getElementById('btn-buscar');
const resultado = document.getElementById('resultado');

// url da api
const url = 'http://localhost:8080/petShop/melhorPreco';

// get o petshop de menor valor com axios

/*async function getPetshopMenorValor() {

    try{

        const data = dataBusca.value;
        const caesGrandesValor = document.getElementById('grandes-busca').value;
        const caesPequenosValor = document.getElementById('pequenos-busca').value;

        const response = await axios.get(url , {
            params: {
                data: data,
                caesGrandes: caesGrandesValor,
                caesPequenos: caesPequenosValor
            }
        });
        console.log(response.data);
        return response.data;
        } catch (error) {
            console.error(error);
        }
        
    }*/

async function getPetshopMenorValor() {
    const data = dataBusca.value;
    const caesGrandesValor = document.getElementById('grandes-busca').value;
    const caesPequenosValor = document.getElementById('pequenos-busca').value;

    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");
    myHeaders.append("Cookie", "JSESSIONID=FEE4822DD69297D4B5FC14240C37A18E");

    var raw = JSON.stringify({
        "data": data,
        "caesGrandes": caesGrandesValor,
        "caesPequenos": caesPequenosValor
    });

    var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    };

    fetch(url, requestOptions)
    .then(response => response.json()) // Parseia a resposta como JSON
    .then(result => {
        console.log(result); // Aqui você pode ver o objeto retornado
        resultado.innerHTML = `<div class="card">
        <img id= "img" src="img/PetShopIMG.jpg">
        <div>
          
          <h4>nome: ${result.petShop.nome}</h4>
          <h5>O PetShop mais barato é o "${result.petShop.nome}" com o preço total de R$${result.value}
            <br> Caes Pequenos: R$ ${result.petShop.preco_CaoPequeno} <br>
            Caes Grandes: R$ ${result.petShop.preco_CaoGrande} 
            
          </h4>
          <span> Total: R$ ${result.value}</span>
          
        </div>
      </div>`;
    })
    .catch(error => console.log('error', error));
}

// função para buscar o petshop de menor valor
botaoBusca.addEventListener('click', async () => {
    const petshop = await getPetshopMenorValor();
    resultado.innerHTML = `<div class="card" style="width: 18rem;">
    <img class="card-img-top" src="..." alt="Card image cap">
    <div class="card-body">
      <h5 class="card-title">${result.petShop.nome}</h5>
      <p class="card-text">O PetShop mais barato é o ${result.petShop.nome} com o preço de R$${result.value}</p>
      <a href="#" class="btn btn-primary">Go somewhere</a>
    </div>
  </div>`;
});



/*try {
    const data = dataBusca.value;
    const caesGrandesValor = document.getElementById('grandes-busca').value;
    const caesPequenosValor = document.getElementById('pequenos-busca').value;

    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");
    myHeaders.append("Cookie", "JSESSIONID=FEE4822DD69297D4B5FC14240C37A18E");

    var raw = JSON.stringify({
        "data": data,
        "caesGrandesValor": caesGrandesValor,
        "caesPequenosValor": caesPequenosValor
    });

    var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    };

    const response = await fetch("http://localhost:8080/petShop/melhorPreco", requestOptions);
    const result = await response.json();
    console.log(result);
    return result;
} catch (error) {
    console.error(error);
}*/