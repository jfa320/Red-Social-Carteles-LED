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
	
	
	public void registrar(Usuario usuario){ //teniendo como boolean podemos notificar que no se pudo realizar
												//registro por algun motivo (por ej: cuit invalido)
//		if(esValidoCuitDe(usuario)){
		
		
			usuarioDAO.persistir(usuario);
		
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
	
	
///////////////////////////////////////VERIFICADOR MAIL////////////////////////////////

public boolean VerificarMail(Usuario usuario)
{
Pattern pattern= Pattern.compile("[a-z,0-9-_]{1,20}\\@[a-z,A-Z]{1,12}\\.com");
Matcher matcher= pattern.matcher(usuario.getMail());


if (matcher.matches()) {
return true;
}
return false;


}


///////////////////////////////////////// VERIFICADOR PASSWORD///////////////////////////

public boolean VerificarPassword(Usuario usuario){
Pattern pattern= Pattern.compile("[a-z,A-Z,0-9]{4,12}");
Matcher matcher= pattern.matcher(usuario.getContraseña());


if (matcher.matches()) {
return true;
}
return false;

}

/////////////////////////////////////VERIFICADOR CUIT///////////////////////////////////


public boolean VerificarCuit(Usuario usuario){
	Pattern pattern= Pattern.compile("[20,23,24,27,30,33,34]{2}\\[0-9]{8}\\[7,9]{1}");
	Matcher matcher= pattern.matcher(Long.toString(usuario.getCuit_cuil()));

	if (matcher.matches()) {
			return true;
	}
	return false;

}
		
}
