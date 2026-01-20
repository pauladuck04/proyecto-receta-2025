package es.uvigo.dagss.recetas.utils;

public class ValidationUtils{

    public static boolean validarTelefono(String telefono){
        boolean valido = false;
        if(telefono.length() == 9){
            for(int i = 0; i < telefono.length(); i++){
                if(Character.isDigit(telefono.charAt(i))){
                    valido = true;
                } else {
                    valido = false;
                    break;
                }
            }
        }
        return valido;
    }

    public static boolean validarDni(String dni){
        boolean valido = false;
        if(dni.length() == 9){
            for(int i = 0; i < dni.length() - 1; i++){
                if(Character.isDigit(dni.charAt(i))){
                    valido = true;
                } else {
                    valido = false;
                    break;
                }
            }
        }
        return valido;
    }

    public static boolean validarEmail(String email){
        boolean valido = false;
        if(email.contains("@") && email.contains(".")){
            valido = true;
        }
        return valido;
    }
}