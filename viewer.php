<?php
if (isset($_GET['file'])) {
    $file = $_GET['file'];
    if (file_exists($file)) {
        session_start();
        $pageName = "Avaliação Médica - " . $_SESSION['nome'];
        // Mostra o PDF
        header('Content-Type: application/pdf');
        header('Content-Disposition: inline; filename="' . $pageName . '"');
        readfile($file);
        exit;
    } else {
        echo "Arquivo não encontrado.";
    }
} else {
    echo "Nenhum arquivo especificado.";
}

