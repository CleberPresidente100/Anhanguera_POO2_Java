public class Validacoes {

    public Validacoes(){}

    public String validarNomeUsuario(String nomeUsuario){

        if(IsNullOrWhiteSpace(nomeUsuario)){
            return "O Nome de Usuário não pode estar em branco.";
        }

        if(Character.isLowerCase(nomeUsuario.charAt(0))){
            return "O Nome de Usuário deve começar com uma Letra Maiúscula.";
        }

        if(nomeUsuario.length() < 3){
            return "O Nome de Usuário deve mais do que 2 caracteres.";
        }

        return null;
    }



    public boolean IsNullOrWhiteSpace(String value)
    {
        if (value == null) return true;

        for (int index = 0; index < value.length(); ++index)
        {
            if (value.charAt(index) != ' ') return false;
        }

        return true;
    }


}
