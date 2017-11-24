package com.example.redsocialcartelesled.services;


import java.util.List;
import java.util.Objects;

import com.example.redsocialcartelesled.daosImpl.HibernateDAOServicioUsuario;
import com.example.redsocialcartelesled.daosgenericos.DAOServicioUsuario;
import com.example.redsocialcartelesled.domainmodel.Usuario;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServicioUsuario {
	private DAOServicioUsuario usuarioDAO=new HibernateDAOServicioUsuario();
	
	
	public boolean registrar(Usuario usuario){ //teniendo como boolean podemos notificar que no se pudo realizar
												//registro por algun motivo (por ej: cuit invalido)
//		if(esValidoCuitDe(usuario)){
			usuarioDAO.persistir(usuario);
			return true;
//		}
//		return false;
	}
	
	public boolean login(Usuario usuario){
		
		
		List<Usuario> usuarios=usuarioDAO.recuperarTodo(usuario);
		for (int i=0;i<usuarios.size();i++){
			if((usuarios.get(i).getUsername().equals(usuario.getUsername())) && (usuarios.get(i).getContraseña().equals(usuario.getContraseña()))){
				return true;
			}

			
		}
		return false;
	}
	
	public String tipoUsuario(Usuario usuario){
		if(usuario.getPuntosPrestigio()>1){ //modificar el 1,por lo que configura el admin
											//probablemente haya que enlazar con el servicio admin.
			return "Usuario Prestigioso";
		}
		else{
			return "Usuario Común";
		}
	}
	
	private boolean esValidoCuitDe(Usuario usuario){ //NOTA:codigo sacado de la Web
		
		String cuit= Long.toString(usuario.getCuit_cuil());
		
	    //Controlamos si son 11 números los que quedaron, si no es el caso, ya devuelve falso
	    if (cuit.length() != 11){
	        return false;
	    }
	    //Convertimos la cadena que quedó en una matriz de caracteres
	    char[] cuitArray = cuit.toCharArray();
	    //Inicializamos una matriz por la cual se multiplicarán cada uno de los dígitos
	    Integer[] serie = {5, 4, 3, 2, 7, 6, 5, 4, 3, 2};
	    //Creamos una variable auxiliar donde guardaremos los resultados del cálculo del número validador
	    Integer aux = 0;
	    //Recorremos las matrices de forma simultanea, sumando los productos de la serie por el número en la misma posición
	    for (int i=0; i<10; i++){
	        aux += Character.getNumericValue(cuitArray[i]) * serie[i];
	    }
	    //Hacemos como se especifica: 11 menos el resto de de la división de la suma de productos anterior por 11
	    aux = 11 - (aux % 11);
	    //Si el resultado anterior es 11 el código es 0
	    if (aux == 11){
	        aux = 0;
	    }
	    //Si el resultado anterior es 10 el código no tiene que validar, cosa que de todas formas pasa
	    //en la siguiente comparación.
	    //Devuelve verdadero si son iguales, falso si no lo son
	    //(Esta forma esta dada para prevenir errores, en java 6 se puede usar: return aux.equals(Character.getNumericValue(cuitArray[10]));)
	    return Objects.equals(Character.getNumericValue(cuitArray[10]), aux);
	}
	
///////////////////////////////////////VERIFICADOR MAIL////////////////////////////////

private boolean VerificarMail(String mail)
{
Pattern pattern= Pattern.compile("[a-z,A-Z,0-9-_]{1,20}\\@[a-z,A-Z]{1,12}\\.com");
Matcher matcher= pattern.matcher(mail);


if (matcher.matches()) {
return true;
}
return false;


}

///////////////////////////////////////// VERIFICADOR USUARIO////////////////////////////

private boolean VerificarUsuario(String user){
Pattern pattern= Pattern.compile("[A-Z]{1}\\[a-z,A-Z]{1,12}\\[0-9]{1,4}");
Matcher matcher= pattern.matcher(user);


if (matcher.matches()) {
return true;
}
return false;


}

///////////////////////////////////////// VERIFICADOR PASSWORD///////////////////////////

private boolean VerificarPassword(String password){
Pattern pattern= Pattern.compile("[a-z,A-Z,0-9]{4,12}");
Matcher matcher= pattern.matcher(password);


if (matcher.matches()) {
return true;
}
return false;

}

/////////////////////////////////////VERIFICADOR CUIT///////////////////////////////////


private boolean VerificarCuit(String cuit){
Pattern pattern= Pattern.compile("[20,23,24,27,30,33,34]{2}\\[0-9]{8}\\[7,9]{1}");
Matcher matcher= pattern.matcher(cuit);

if (matcher.matches()) {
return true;
}
return false;

}
		
}
