package com.cursoceat.modell;

public class Clientes {

		static private int idGeneral;
		private int idCliente;
		private String nombreC;
		private String apellidosC;
		private String telefonoC;
		public Clientes(String nombreC, String apellidosC, String telefonoC) {
			super();
			this.nombreC = nombreC;
			this.apellidosC = apellidosC;
			this.telefonoC = telefonoC;
			this.idCliente=++idGeneral;
			
		}
		public Clientes() {
			this.idCliente=++idGeneral;
		}
		/**
		 * @return the nombreC
		 */
		public String getNombreC() {
			return nombreC;
		}
		/**
		 * @param nombreC the nombreC to set
		 */
		public void setNombreC(String nombreC) {
			this.nombreC = nombreC;
		}
		/**
		 * @return the apellidosC
		 */
		public String getApellidosC() {
			return apellidosC;
		}
		/**
		 * @param apellidosC the apellidosC to set
		 */
		public void setApellidosC(String apellidosC) {
			this.apellidosC = apellidosC;
		}
		/**
		 * @return the telefonoC
		 */
		public String getTelefonoC() {
			return telefonoC;
		}
		/**
		 * @param telefonoC the telefonoC to set
		 */
		public void setTelefonoC(String telefonoC) {
			this.telefonoC = telefonoC;
		}
		/**
		 * @return the idCliente
		 */
		public int getIdCliente() {
			return idCliente;
		}
		
		
		
		
	}


