public class Validacoes {

    public String formatarTelefone(String telefone){

        int indice = 0;
        String telefoneFormatado = new String();

        for (char caractere: telefone.toCharArray()) {
            if(isNumber (caractere)){
                indice++;
                switch (indice) {
                    case 1:
                        telefoneFormatado = "(" + caractere;
                        break;

                    case 2:
                        telefoneFormatado += caractere + ") ";
                        break;

                    case 3:
                        if (telefone.length() >= 15) {
                            telefoneFormatado += caractere + " ";
                            break;
                        }
                        telefoneFormatado += caractere;
                        break;

                    case 8:
                        telefoneFormatado += "-" + caractere;
                        break;

//                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 9:
                    case 10:
                    case 11:
                        telefoneFormatado += caractere;
                        break;

                    default:
                        telefoneFormatado = telefoneFormatado;
                        break;
                }
            }
        }

        return telefoneFormatado;
    }

    public boolean isNumber(char caractere){

        String valor = "";
        valor += caractere;

        if(valor.matches("\\d")){
            return true;
        }
        return false;
    }

    public boolean isNumber(String valor){

        if(valor.matches("\\d+")){
            return true;
        }
        return false;
    }



    public boolean validarNome(String nome){
        if(nome != null){
            return nome.matches("[a-zA-Z]{2,50}");
        }
        return false;
    }

    public boolean validarTelefone(String telefone){
        if(telefone != null){
//        return  telefone.matches("9{0,1}\\d{4}-{0,1}\\d{4}");
            return  true;//telefone.matches("(\\d{2}) 9? ?\\d{4}-\\d{4}");
        }
        return false;
    }
}
