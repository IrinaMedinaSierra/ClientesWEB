package com.cursoceat.services;

public interface Validaciones {

	public default  boolean validarDNI(String dni) {	
	    String dniChars="TRWAGMYFPDXBNJZSQVHLCKE"; 
	    try {
	    String intPartDNI = dni.substring(0, 8);
        char ltrDNI = dni.charAt(8);
        int valNumDni = Integer.parseInt(intPartDNI) % 23;
        if (dni.length()== 9 && dniChars.charAt(valNumDni)== ltrDNI) {
            return true;
        } else {
            return false;
        }
		
	}catch(Exception e) {
		return false;
	}
	
	}
	
	public default String pasarCapitalize(String texto) {
		try {
		String[] arraycadenaStrings=texto.split(" ");
		String temp="";
		for (int i=0; i<arraycadenaStrings.length; i++) {
			arraycadenaStrings[i]=arraycadenaStrings[i].substring(0, 1).toUpperCase()+
					arraycadenaStrings[i].substring(1).toLowerCase();
			temp+=arraycadenaStrings[i]+" ";
		}
		return temp.trim();
		}catch (Exception e) {
			return "";
		}
	}
	
	public default  boolean validarTelefono(String telefono) {
		boolean correcto=false;
		try {
		if ((telefono.startsWith("9") || telefono.startsWith("6") || telefono.startsWith("7")) 
				&& telefono.length()==9) {
			correcto=true;
		} 
		}catch (Exception e) {
			correcto=false;
	}
	return correcto;
}
}