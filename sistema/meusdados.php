<?php 
    session_start();
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="../assets/doacaoSangue.png" type="image/x-icon">
    <link rel="stylesheet" href="../assets/styles/home.css">
    <link rel="stylesheet" href="../assets/styles/footer.css">
    <script src="../assets/scripts/senha.js" defer></script>
    <title>Home</title>
</head>
<body>
    <header>
        <div class="logo">
            <img src="../assets/ssLogoVermelha.png" alt="">
        </div>
        <nav>
            <a href="home.php" class="links">Página Inicial</a>
            <a href="" class="links ativo">Meus Dados</a>
            <a href="desenvolvedores.php" class="links">Desenvolvedores</a>
        </nav>
    </header>

    <main>
        <div class="bloco" id="mdados">
            <div class="titulo">
                <h1>Meus Dados</h1>
            </div>
            
            <table id="dados">
                <tr>
                    <th>Nome</th>
                    <td><?php echo $_SESSION['nome'] ?></td>
                </tr>
                <tr>
                    <th>Nascimento</th>
                    <?php
                        $dataNasc = explode('-', $_SESSION['data_nasc']);

                        $mes = "";
                        switch($dataNasc[1]) {
                            case 1: $mes = "Janeiro"; break;
                            case 2: $mes = "Fevereiro"; break;
                            case 3: $mes = "Março"; break;
                            case 4: $mes = "Abril"; break;
                            case 5: $mes = "Maio"; break;
                            case 6: $mes = "Junho"; break;
                            case 7: $mes = "Julho"; break;
                            case 8: $mes = "Agosto"; break;
                            case 9: $mes = "Setembro"; break;
                            case 10: $mes = "Outubro"; break;
                            case 11: $mes = "Novembro"; break;
                            case 12: $mes = "Dezembro"; break;
                        }
                    ?>
                    <td><?php echo $dataNasc[2] . " de " . $mes . " de " . $dataNasc[0]?></td>
                </tr>
                <tr>
                    <th>Gênero</th>
                    <td><?php echo $_SESSION['genero'] ?></td>
                </tr>
                <tr>
                    <th>Tipo Sanguíneo</th>
                    <td><?php echo $_SESSION['tipoSangue'] ?></td>
                </tr>
                <tr>
                    <th>Endereço</th>
                    <td><?php echo $_SESSION['endereco'].", ".$_SESSION['cidade']."/".$_SESSION['estado']." — ".$_SESSION['cep']?></td>
                </tr>
                <tr>
                    <th>E-mail</th>
                    <td><?php echo $_SESSION['email'] ?></td>
                </tr>
                <tr>
                    <th>Telefone</th>
                    <td><?php echo $_SESSION['telefone'] ?></td>
                </tr>
                <tr>
                    <th>Já é doador?</th>
                    <td><?php echo ($_SESSION['freqDoacao'] === "novoDoador") ? "Não, serei um novo doador" : "Sim, já sou doador" ?></td>
                </tr>
                <tr>
                    <th>Avaliação médica</th>
                    <td><a href="../viewer.php?file=<?php echo $_SESSION['avaliacao']?>" target="_blank">Ver arquivo</a></td>
                </tr>
                <tr>
                    <th>Senha informada</th>
                    <td id="senhatd">
                        <input type="password" name="senha" id="senha" value="<?php echo $_SESSION['senha']?>" disabled>
                        <button id="exibirSenha">Exibir</button>
                    </td>
                </tr>
            </table>
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