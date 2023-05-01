package com.cursoceat.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.cursoceat.modell.*;
import com.cursoceat.services.Validaciones;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet implements Validaciones {
	private static final long serialVersionUID = 1L;
	
	ArrayList<Clientes> losClientes = new ArrayList<Clientes>();
	ArrayList<String> msg=new ArrayList <String>();
	String msg2;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		msg.clear();
		String id = request.getParameter("idCliente");
		String opcion = request.getParameter("opcion");
		int idRecibido = Integer.parseInt(id);
		
		
		Iterator<Clientes> cli = losClientes.iterator();
		while (cli.hasNext()) {
			Clientes p = cli.next();
			if (p.getIdCliente() == idRecibido) {
				if (opcion.equals("borrar")) {
					cli.remove();
					msg.add( "Cliente borrado correctamente");
					request.getSession().setAttribute("msg", msg);
					response.sendRedirect("index.jsp");
				}
				if (opcion.equals("modificar")) {
					String telefono = request.getParameter("telefonoNuevo");
					if (!validarTelefono(telefono)) {
						msg2 = "El télefono es invalido";
						request.getSession().setAttribute("msg2", msg2);
						request.getRequestDispatcher("modificar.jsp").forward(request, response);

					} else {
						String nNombre = request.getParameter("nombreNuevo");
						String nApellidos = request.getParameter("apellidosNuevo");
						p.setNombreC(pasarCapitalize(nNombre));
						p.setApellidosC(pasarCapitalize(nApellidos));
						p.setTelefonoC(telefono);
						msg.add("El cliente se ha modificado exitosamente");
						request.getSession().setAttribute("msg", msg);
						response.sendRedirect("index.jsp");
					}

				}
				
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		msg.clear();
		String nombre = pasarCapitalize(request.getParameter("nombre"));
		String apellidos = pasarCapitalize(request.getParameter("apellidos"));
		String telefono = request.getParameter("telefono");

		
		if (nombre.isEmpty() || apellidos.isEmpty() || telefono.isEmpty()) {
			msg.add("Los campos Nombre - Apellidos - Teléfono son obligatorios");
			
		}
		if (!validarTelefono(telefono)) {
			msg.add("El télefono es invalido");
		
		} 
		
		
		
		if (!msg.isEmpty()){
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {

			Clientes cli = new Clientes(nombre, apellidos, telefono);

			msg.add("Cliente creado correctamente");
			request.getSession().setAttribute("msg", msg);
			losClientes.add(cli);
			request.getSession().setAttribute("clientes", losClientes);
			response.sendRedirect("index.jsp");

		}

	}

}
