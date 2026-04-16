let exibirSenha = document.querySelector("#exibirSenha");
let senha = document.querySelector("#senha");

exibirSenha.addEventListener('click', () => {
    if(senha.getAttribute("type") === "password") {
        senha.setAttribute("type", "text");
        exibirSenha.textContent = "Ocultar";
    }else {
        senha.setAttribute("type", "password");
        exibirSenha.textContent = "Exibir";
    }
})

