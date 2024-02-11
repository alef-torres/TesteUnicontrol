function validar() {
    let nome = document.forms["frmPessoa"]["name"].value;
    let prof = document.forms["frmPessoa"]["profissao"].value;
    let idade = document.forms["frmPessoa"]["idade"].value;

    if (nome === "") {
        alert("Preencha o campo nome");
        document.forms["frmPessoa"]["name"].focus();
        return false;
    } else if (prof === "") {
        alert("Preencha o campo profissão");
        document.forms["frmPessoa"]["profissao"].focus();
        return false;
    } else if (idade === "") {
        alert("Preencha o campo idade");
        document.forms["frmPessoa"]["idade"].focus();
        return false;
    } else {
        document.forms["frmPessoa"].submit();
    }
}
