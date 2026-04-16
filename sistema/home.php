<?php
    $arquivoRecebido = false;

    if(isset($_POST['submit'])) {
        session_start();
        $_SESSION['nome']           = $_POST['nome'];
        $_SESSION['data_nasc']      = $_POST['data_nasc'];
        $_SESSION['genero']         = $_POST['genero'];
        $_SESSION['tipoSangue']     = $_POST['tipoSangue'];
        $_SESSION['email']          = $_POST['email'];
        $_SESSION['telefone']       = $_POST['telefone'];
        $_SESSION['endereco']       = $_POST['endereco'];
        $_SESSION['cidade']         = $_POST['cidade'];
        $_SESSION['cep']            = $_POST['cep'];
        $_SESSION['estado']         = $_POST['estado'];
        $_SESSION['freqDoacao']     = $_POST['freqDoacao'];
        $_SESSION['senha']     = $_POST['senha'];

        $pastaDocs = 'documentos';

        if(!is_dir('../'.$pastaDocs)) {
            mkdir('../'.$pastaDocs, 0755, true);
        }

        $arquivo = $_FILES['condSaude'];
        if($arquivo['error'] === UPLOAD_ERR_OK) {
            $extensaoArquivo = pathinfo($arquivo['name'], PATHINFO_EXTENSION);
            $novoArquivo = uniqid('doc_') . '.' . $extensaoArquivo;
            $caminho = $pastaDocs."/".$novoArquivo;

            if(move_uploaded_file($arquivo['tmp_name'], '../'.$caminho)) {
                $_SESSION['avaliacao'] = $pastaDocs."\\".$novoArquivo;
            }
        }
    }
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="../assets/doacaoSangue.png" type="image/x-icon">
    <link rel="stylesheet" href="../assets/styles/home.css">
    <link rel="stylesheet" href="../assets/styles/footer.css">
    <title>Home</title>
</head>
<body>

    <header>
        <div class="logo">
            <img src="../assets/ssLogoVermelha.png" alt="">
        </div>
        <nav>
            <a href="" class="links ativo">Página Inicial</a>
            <a href="meusdados.php" class="links">Meus Dados</a>
            <a href="desenvolvedores.php" class="links">Desenvolvedores</a>
        </nav>
    </header>

    <main>
        <div class="bloco" id="inicio">
            <div class="titulo">
                <h1>Página Inicial</h1>
            </div>

            <div class="card">
                <h3 class="titulo-card">Agendar doação</h3>

                <form action="">
                    <div class="area-input">
                        <label for="marcar_doacao">Data para doar</label>
                        <input type="date" name="marcar_doacao" id="marcar_doacao">
                    </div>
                    <div class="area-input">
                        <label for="local_doacao">Local de doação</label>
                        <select name="local_doacao" id="local_doacao">
                            <option value="">Selecione</option>
                            <option value="">Hospital X</option>
                            <option value="">Hospital Y</option>
                            <option value="">Hemocentro Z</option>
                        </select>
                    </div>
                    <input type="submit" value="Solicitar Agendamento" id="submit">
                </form>
            </div>

            <div class="card">
                <h3 class="titulo-card">próximas doações</h3>
                <table>
                    <thead>
                        <tr>
                            <th>Data</th>
                            <th>local</th>
                            <th>status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>32/13/2024</td>
                            <td>Hemocentro Z</td>
                            <td class="nao-confirmado">Não confirmada</td>
                        </tr>
                        <tr>
                            <td>43/00/2025</td>
                            <td>Hospital Y</td>
                            <td class="confirmado">Confirmada</td>
                        </tr>
                    </tbody>
                </table>                
            </div>
        </div>
    </main>

    <footer>
        <p> IFRN campus Santa Cruz</p>
        <p>Trabalho de Autoria Web</p>
        <p>Prof. Marcelo Figueiredo Barbosa Júnior</p>
        <p>Desenvolvido Por Kellyson Ricardo - Info3v</p>
        <p>Referências: <a href="https://www.flaticon.com/br" target="_blank">Freepik</a>
                        <a href="https://fonts.google.com/" target="_blank">Google Fonts</a>
                        <a href="https://fontawesome.com/" target="_blank">Font Awesome</a> </p>
    </footer>
</body>
</html>