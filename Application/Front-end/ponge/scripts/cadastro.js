// Selecione os elementos do formulário
const nomeInput = document.querySelector('input[name="nome"]');
const distanciaInput = document.querySelector('input[name="distancia"]');
const precoPequenoInput = document.querySelector('input[name="preco_CaoPequeno"]');
const precoGrandeInput = document.querySelector('input[name="preco_CaoGrande"]');
const metodoInput = document.querySelector('select[name="metodo_Calcular_Preço"]');
const adicionalInput = document.querySelector('input[name="adicional_FimDeSemana"]');
const cadastrarButton = document.getElementById('btn-cadastrar');

// Adicione um event listener para o botão de cadastro
cadastrarButton.addEventListener('click', async () => {
    // Obtenha os valores dos campos do formulário
    const nome = nomeInput.value;
    const distancia = parseFloat(distanciaInput.value);
    const precoCaoPequeno = parseFloat(precoPequenoInput.value);
    const precoCaoGrande = parseFloat(precoGrandeInput.value);
    const metodoCalcularPreco = metodoInput.value;
    const adicionalFimDeSemana = parseFloat(adicionalInput.value);

    // Construa o objeto JSON com os valores dos campos do formulário
    const requestBody = {
        
        nome: nome,
        distancia: distancia,
        preco_CaoPequeno: precoCaoPequeno,
        preco_CaoGrande: precoCaoGrande,
        metodo_Calcular_Preço: metodoCalcularPreco,
        adicional_FimDeSemana: adicionalFimDeSemana
    };

    // Faça a solicitação POST para o endpoint /petShop
    try {
        const response = await fetch('http://localhost:8080/petShop', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Cookie': 'JSESSIONID=FEE4822DD69297D4B5FC14240C37A18E'
            },
            body: JSON.stringify(requestBody)
        });

        // Verifique se a solicitação foi bem-sucedida
        if (response.ok) {
            const result = await response.text();
            console.log(result);
            alert("PetShop Cadastrado com sucesso!!!")
        } else {
            console.error('Erro ao cadastrar o petshop:', response.statusText);
        }
    } catch (error) {
        console.error('Erro ao fazer a solicitação:', error);
    }
});