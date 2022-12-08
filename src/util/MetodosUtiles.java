package util;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Date;

import javax.swing.JOptionPane;

import clase.AgenciaEmpleadora;
import clase.Candidato;
import clase.Documento;
import clase.Empresa;
import clase.Entrevista;
import clase.Oferta;
import clase.Rama;
import clase.Sector;
import excepcionesPropias.YaExisteExceptions;

public class MetodosUtiles {
	@SuppressWarnings("deprecation")
	public static void validacionJTextLetra(int tamActual,KeyEvent e){
		Character letra=e.getKeyChar();
		if(tamActual>=30 || (!(Character.isLetter(letra))&& !(Character.isSpace(letra)) && e.getExtendedKeyCode()!=KeyEvent.VK_BACK_SPACE)){
			e.consume();
			Toolkit x= Toolkit.getDefaultToolkit();
			x.beep();
		}
	}
	public static void validacionJTextNumero(int tamActual,int tamMax,KeyEvent e){
		Character letra=e.getKeyChar();
		if(tamActual==tamMax || (!(Character.isDigit(letra))&& e.getExtendedKeyCode()!=8)){
			e.consume();
			Toolkit x= Toolkit.getDefaultToolkit();
			x.beep();
		}
	}
	public static void validacionJTextCharacter(int tamActual,KeyEvent e){
		if(tamActual>=30){
			e.consume();
			Toolkit x= Toolkit.getDefaultToolkit();
			x.beep();
		}
	}
	public static void mostrarMensaje(YaExisteExceptions e){
		JOptionPane.showMessageDialog(null, e.getMessage());
	}

	@SuppressWarnings("deprecation")
	public static void RellenoAutomatico(){
		try{
			AgenciaEmpleadora agencia=AgenciaEmpleadora.CrearInstancia("Agencia");

			Documento a = new Documento("Pasaporte", true);
			Documento b = new Documento("Certificado de 9no grado", true);
			Documento c = new Documento("Certificado de 12 grado", true);
			Documento d = new Documento("Licencia de camion", false);
			Documento e = new Documento("licencia de carro", true);
			Documento f = new Documento("Licencia de guagua", true);
			//			Documento g = new Documento("Certificado de curso de alturas", false);
			Documento h = new Documento("Titulo de ing. civil",true);
			Documento i = new Documento("Titulo a nivel de especialista en Vias Terrestres", false);
			Documento j = new Documento("Licenciatura en Fisica", false);
			Documento k = new Documento("Titulo a nivel de especialista en Hidrologia", false);
			Documento m = new Documento("Certificado de idiomas", true);
			Documento n = new Documento("Licenciatura en Magisterio en Educacion", true);
			Documento o = new Documento("Licenciatura en Historia", false);
			Documento p = new Documento("Licenciatura en Biologia", false);
			Documento q = new Documento("Titulo de curso de asesoria de imagen", false);
			Documento r = new Documento("Titulo de curso de estilismo", false);
			Documento s = new Documento("Titulo de Diseñador", true);
			Documento t = new Documento("Titulo de curso de Tejeduria por trama",true);
			Documento u = new Documento("Licenciatura en Quimica ", false);
			Documento v = new Documento("Grado de Ing. Maritima", false);
			Documento w = new Documento("Grado en Ing. Nautica", false);
			Documento l = new Documento("Grado en Tecnologias Marinas", false);
			Documento x = new Documento("Licenciatura en Nutricion", true);
			Documento y = new Documento("Licenciatura en Turismo", true);
			Documento z = new Documento("Licenciatura en Estomatologia", true);
			Documento ab = new Documento("Licencia de maquinista", true);
			Documento ac = new Documento("Grado en Enfermeria", true);
			Documento ad = new Documento("Master en enfermeria", false);
			Documento ae = new Documento("Registro en el colegio oficil de enfermeria", true);
			Documento af = new Documento("Titulo en ciencias de la comunicacion y la audicion", true);
			Documento ag = new Documento("Examen de admision dental", true);

			Sector sector1 = new Sector("Textiles");
			Sector sector2 = new Sector("Educacion");
			Sector sector3 = new Sector("Salud");
			Sector sector5 = new Sector("Alimentacion");
			Sector sector6 = new Sector("Turismo");
			Sector sector7 = new Sector("Construccion");
			Sector sector8 = new Sector("Transporte");


			Rama rama1 = new Rama("Alta costura");
			Rama rama2 = new Rama("Confeccion");
			Rama rama3 = new Rama("Tejeduria");//HASTA AQUI SECTOR TEXTIL

			Rama rama4 = new Rama("Biologia");
			Rama rama11 = new Rama("Historia");
			Rama rama13 = new Rama("Quimica");
			Rama rama14 = new Rama("Fisica");// HASTA AQUI SECTOR EDUCACION

			Rama rama16 = new Rama("Enfermeria");
			Rama rama17 = new Rama("Fonoaudiologia");
			Rama rama21 = new Rama("Odontologia");//HASTA AQUI SECTOR SALUD

			Rama rama28 = new Rama("Dietetica");
			Rama rama29 = new Rama("Tecnologia de los alimentos");
			Rama rama30 = new Rama("Nutricion deportiva"); //HASTA AQUI SECTOR DE ALIMENTACION

			Rama rama31 = new Rama("Servicio de alojamiento");
			Rama rama32 = new Rama("Servicio de guia");
			Rama rama33 = new Rama("Servicio de informacion");//HASTA AQUI SECTOR DEL TURISMO

			Rama rama35 = new Rama("Hidraulica");
			Rama rama36 = new Rama("Vias y transporte");//HASTA AQUI SECTOR DE LA CONSTRUCCION
			Rama rama39 = new Rama("Navegacion maritima");
			Rama rama40 = new Rama("Transporte por vehiculos de motor");
			Rama rama41 = new Rama("Transporte ferroviario"); //HASTA AQUI SECTOR DEL TRANSPORTE




			rama1.addDocumento(q);
			rama1.addDocumento(r);
			rama1.addDocumento(s);
			rama1.addDocumento(t);
			rama1.addDocumento(c);
			rama2.addDocumento(q);
			rama2.addDocumento(r);
			rama2.addDocumento(s);
			rama2.addDocumento(t);
			rama2.addDocumento(c);
			rama3.addDocumento(q);
			rama3.addDocumento(r);
			rama3.addDocumento(s);
			rama3.addDocumento(t);
			rama3.addDocumento(c);
			rama4.addDocumento(p); 
			rama4.addDocumento(n); 
			rama11.addDocumento(o); 
			rama11.addDocumento(n); 
			rama13.addDocumento(u);
			rama13.addDocumento(n);
			rama14.addDocumento(j);
			rama14.addDocumento(n);
			rama16.addDocumento(ac);
			rama16.addDocumento(ad);
			rama16.addDocumento(ae);
			rama17.addDocumento(af);
			rama21.addDocumento(z);
			rama21.addDocumento(ag);
			rama28.addDocumento(x);
			rama29.addDocumento(x);
			rama30.addDocumento(x);
			rama31.addDocumento(y);
			rama32.addDocumento(y);
			rama33.addDocumento(y);
			rama35.addDocumento(k);
			rama35.addDocumento(h);
			rama36.addDocumento(i);
			rama36.addDocumento(h);
			rama39.addDocumento(a);
			rama39.addDocumento(m);
			rama39.addDocumento(v);
			rama39.addDocumento(w);
			rama39.addDocumento(l);
			rama40.addDocumento(c);
			rama40.addDocumento(d);
			rama40.addDocumento(e);
			rama40.addDocumento(f);
			rama40.addDocumento(a);
			rama40.addDocumento(m);
			rama41.addDocumento(ab);
			rama41.addDocumento(c);
			rama41.addDocumento(a);
			rama41.addDocumento(m);

			sector1.addDocumento(c);
			sector2.addDocumento(n);
			sector3.addDocumento(c);
			sector5.addDocumento(x);
			sector6.addDocumento(y);
			sector7.addDocumento(h);
			sector8.addDocumento(c);


			Empresa empresa1 = new Empresa("Ormani Arenado", "Calle 15", "78954123", sector2);
			Empresa empresa2 = new Empresa("Fuctruoso Rodriguez", "Calle Linea", "78257846", sector2);
			Empresa empresa3 = new Empresa("Direccion Municipal de salud", "Calle 25", "78465873", sector3);
			Empresa empresa4 = new Empresa("Heroes del Moncada", "Calle 23", "78752314", sector3);
			Empresa empresa5 = new Empresa("Nax Solutions", "Calle Zapata", "55784127", sector1);
			Empresa empresa6 = new Empresa("BrioAgro", "Calle La Torre", "53565324", sector1);
			Empresa empresa7 = new Empresa("Forever 21", "8 Street", "54562188", sector1);
			Empresa empresa8 = new Empresa("Cuidado con el perro", "Calle F", "54121114", sector1);
			Empresa empresa9 = new Empresa("Nestle", "Calle Constitucion", "56333247", sector5);
			Empresa empresa10 = new Empresa("Unilever", "Calle Mayor", "56477122", sector5);
			Empresa empresa11 = new Empresa("Las Vegas Sands", "Calle San Juan", "78745888", sector6);
			Empresa empresa12 = new Empresa("Carnival", " Calle Sol", "78451236", sector6);
			Empresa empresa13 = new Empresa("Omega CORP", "Calle L", "54117889", sector7);
			Empresa empresa14 = new Empresa("Bases & Raices", "Calle G", "53565324", sector7);
			Empresa empresa15 = new Empresa("Auto Express Oriente", "Calle Iglesia", "54787871", sector8);
			Empresa empresa16 = new Empresa("Fletes Lozmar", "Calle Fuente", "54121233", sector8);

			Oferta oferta1 = new Oferta("12345", 8000, 3, rama2, empresa7);
			Oferta oferta2 = new Oferta("56897", 5000, 2, rama13, empresa1);
			Oferta oferta3 = new Oferta("25314", 6700, 1, rama21, empresa3);
			Oferta oferta4 = new Oferta("78956", 10000, 3, rama1, empresa5);
			Oferta oferta5 = new Oferta("54879", 4560, 2, rama30, empresa10);
			Oferta oferta6 = new Oferta("23145", 7800, 4, rama33, empresa12);
			Oferta oferta7 = new Oferta("02354", 9200, 2, rama35, empresa13);
			Oferta oferta8 = new Oferta("56800", 7960, 3, rama41, empresa15);
			Oferta oferta9 = new Oferta("36589", 11000, 3, rama4, empresa2);
			Oferta oferta10 = new Oferta("02147", 8650, 1, rama16, empresa4);
			Oferta oferta11 = new Oferta("02699", 7000, 4, rama36, empresa14);
			Oferta oferta12 = new Oferta("96587", 9300, 2, rama39, empresa16);


			Candidato candidato1 = new Candidato("90030541233", "Alberto", "Masculino", "Calle Jose Ortega y Gasset, 40", "54587996",
					"Universitario","Ing. civil", 8, rama36);
			Candidato candidato2 = new Candidato("91072954101", "Leanne", "Femenino", "Calle La Loma", "56582331", "Bachiller",
					"Hidraulica", 5, rama35);
			Candidato candidato3 = new Candidato("92102325410", "Jesus", "Masculino","San carlos entre Gacel y Horrutiner", "78545459", 
					"9no grado","chofer", 11, rama40);
			Candidato candidato4 = new Candidato("90112025446", "Amanda", "Femenino", "Santo Domingo", "78411470", "Bachiller",
					"Diseñador de moda", 10, rama2);
			Candidato candidato5 = new Candidato("90080754121", "Daniela", "Femenino", "Calle Las Ninfas", "53522148", "9no grado",
					"Costurera", 12, rama3);
			Candidato candidato6 = new Candidato("9405032692", "Pedro", "Masculino", "Calle 12 entre 51 y 53", "54879215", "Bachiller",
					"Diseñador grafico", 5, rama1);
			Candidato candidato7 = new Candidato("93021125632", "Mario", "Masculino", "Calle Luis de Morales", "56231489", "Universitario",
					"Biologia", 9, rama4);
			Candidato candidato8 = new Candidato("89062032565", "Marta", "Femenino", "Calle Portal de Castilla", "54782377", "Universitario",
					"Ciencias de la nutricion", 15, rama30);
			Candidato candidato9 = new Candidato("89022456985", "Jose", "Masculino", "Calle Francisco Giner", "56654187", "Universitario",
					"Marinero Mercante", 12, rama39);
			Candidato candidato10 = new Candidato("96030524589", "Estefania", "Femenino", "Calle de Santa Rosa", "56589978", "Universitario",
					"Gestion Turistica", 6, rama33);
			Candidato candidato11 = new Candidato("88120365456", "Humberto", "Masculino", "Calle de Santo Domingo", "72665984", "Bachiller",
					"Marinero", 10, rama39);
			Candidato candidato12 = new Candidato("90100232656", "Roberto", "Masculino", "Calle Juarez", "56942200", "Bachiller",
					"Dentista", 11, rama21);
			Candidato candidato13 = new Candidato("91032625811", "Esperanza", "Femenino", "Calle La Cuesta", "58621142", "9no grado",
					"nutricionista", 2, rama28);
			Candidato candidato14 = new Candidato("93080451233", "Pablo", "Masculino", "Calle Independencia", "54522369", "Universitario",
					"Ing. Quimico", 9, rama13);
			Candidato candidato15 = new Candidato("93021425669", "Ernesto", "Masculino", "Calle de Diego de Leon", "72588963", "9no grado",
					"chofer", 11, rama41);
			Candidato candidato16 = new Candidato("90102566532", "Paula", "Femenino", "Calle Grove Street", "76658961", "Bachiller",
					"Costurera", 10, rama2);
			Candidato candidato17 = new Candidato("94050225669", "Rolando", "Masculino", "Calle de Corsega", "72585510", "Universitario",
					"Diseñador grafico", 4, rama2);

			Entrevista entrevista1 = new Entrevista(new Date(2023-1900, 6, 12), candidato1, oferta11);
			Entrevista entrevista2 = new Entrevista(new Date(2023-1900, 5, 11), candidato2, oferta7);
			Entrevista entrevista3 = new Entrevista(new Date(2023-1900, 8, 10), candidato4, oferta1);
			Entrevista entrevista4 = new Entrevista(new Date(2023-1900, 10, 9), candidato7, oferta9);
			Entrevista entrevista5 = new Entrevista(new Date(2023-1900, 11, 7), candidato8, oferta5);
			Entrevista entrevista6 = new Entrevista(new Date(2023-1900, 4, 20), candidato9, oferta12);
			Entrevista entrevista7 = new Entrevista(new Date(2023-1900, 6, 21), candidato6, oferta4);
			Entrevista entrevista8 = new Entrevista(new Date(2023-1900, 5, 22), candidato12, oferta3);
			Entrevista entrevista9 = new Entrevista(new Date(2023-1900, 3, 24), candidato14, oferta2);
			Entrevista entrevista10 = new Entrevista(new Date(2023-1900, 4, 5), candidato15, oferta8);
			Entrevista entrevista11 = new Entrevista(new Date(2023-1900, 4, 6), candidato16, oferta1);
			Entrevista entrevista12 = new Entrevista(new Date(2023-1900, 4, 7), candidato17, oferta1);


			empresa1.addOferta(oferta2);
			empresa2.addOferta(oferta9);
			empresa3.addOferta(oferta3);
			empresa4.addOferta(oferta10);
			empresa5.addOferta(oferta4);
			empresa7.addOferta(oferta1);
			empresa10.addOferta(oferta5);
			empresa12.addOferta(oferta6);
			empresa13.addOferta(oferta7);
			empresa14.addOferta(oferta11);
			empresa15.addOferta(oferta8);
			empresa16.addOferta(oferta12);

			empresa1.addEntrevista(entrevista9);
			empresa2.addEntrevista(entrevista4);
			empresa3.addEntrevista(entrevista8);
			empresa5.addEntrevista(entrevista7);
			empresa7.addEntrevista(entrevista3);
			empresa7.addEntrevista(entrevista11);
			empresa7.addEntrevista(entrevista12);
			empresa10.addEntrevista(entrevista5);
			empresa13.addEntrevista(entrevista2);
			empresa14.addEntrevista(entrevista1);
			empresa15.addEntrevista(entrevista10);
			empresa16.addEntrevista(entrevista6);


			candidato1.addDocumento(h.getDocumento());
			candidato1.addDocumento(i.getDocumento());
			candidato2.addDocumento(c.getDocumento());
			candidato2.addDocumento(k.getDocumento());
			candidato3.addDocumento(b.getDocumento());
			candidato3.addDocumento(d.getDocumento());
			candidato3.addDocumento(e.getDocumento());
			candidato3.addDocumento(f.getDocumento());
			candidato4.addDocumento(c.getDocumento());
			candidato4.addDocumento(s.getDocumento());
			candidato4.addDocumento(r.getDocumento());
			candidato5.addDocumento(b.getDocumento());
			candidato5.addDocumento(t.getDocumento());
			candidato6.addDocumento(c.getDocumento());
			candidato6.addDocumento(q.getDocumento());
			candidato6.addDocumento(r.getDocumento());
			candidato7.addDocumento(n.getDocumento());
			candidato7.addDocumento(p.getDocumento());
			candidato8.addDocumento(x.getDocumento());
			candidato9.addDocumento(a.getDocumento());
			candidato9.addDocumento(m.getDocumento());
			candidato9.addDocumento(v.getDocumento());
			candidato9.addDocumento(w.getDocumento());
			candidato9.addDocumento(l.getDocumento());
			candidato10.addDocumento(y.getDocumento());
			candidato10.addDocumento(m.getDocumento());
			candidato10.addDocumento(a.getDocumento());
			candidato11.addDocumento(l.getDocumento());
			candidato12.addDocumento(z.getDocumento());
			candidato13.addDocumento(x.getDocumento());
			candidato14.addDocumento(u.getDocumento());
			candidato15.addDocumento(b.getDocumento());
			candidato15.addDocumento(e.getDocumento());
			candidato16.addDocumento(c.getDocumento());
			candidato16.addDocumento(t.getDocumento());
			candidato16.addDocumento(r.getDocumento());
			candidato17.addDocumento(s.getDocumento());



			agencia.addEmpresa(empresa1);
			agencia.addEmpresa(empresa2);
			agencia.addEmpresa(empresa3);
			agencia.addEmpresa(empresa4);
			agencia.addEmpresa(empresa5);
			agencia.addEmpresa(empresa6);
			agencia.addEmpresa(empresa7);
			agencia.addEmpresa(empresa8);
			agencia.addEmpresa(empresa9);
			agencia.addEmpresa(empresa10);
			agencia.addEmpresa(empresa11);
			agencia.addEmpresa(empresa12);
			agencia.addEmpresa(empresa13);
			agencia.addEmpresa(empresa14);
			agencia.addEmpresa(empresa15);
			agencia.addEmpresa(empresa16);

			agencia.addCandidato(candidato1);
			agencia.addCandidato(candidato2);
			agencia.addCandidato(candidato3);
			agencia.addCandidato(candidato4);
			agencia.addCandidato(candidato5);
			agencia.addCandidato(candidato6);
			agencia.addCandidato(candidato7);
			agencia.addCandidato(candidato8);
			agencia.addCandidato(candidato9);
			agencia.addCandidato(candidato10);
			agencia.addCandidato(candidato11);
			agencia.addCandidato(candidato12);
			agencia.addCandidato(candidato13);
			agencia.addCandidato(candidato14);
			agencia.addCandidato(candidato15);
			agencia.addCandidato(candidato16);

			agencia.addRama(rama1);
			agencia.addRama(rama2);
			agencia.addRama(rama3);
			agencia.addRama(rama4);
			agencia.addRama(rama11);
			agencia.addRama(rama13);
			agencia.addRama(rama14);
			agencia.addRama(rama17);
			agencia.addRama(rama16);
			agencia.addRama(rama21);
			agencia.addRama(rama28);
			agencia.addRama(rama29);
			agencia.addRama(rama30);
			agencia.addRama(rama31);
			agencia.addRama(rama32);
			agencia.addRama(rama35);
			agencia.addRama(rama36);
			agencia.addRama(rama39);
			agencia.addRama(rama40);
			agencia.addRama(rama41);

			agencia.addSector(sector1);
			agencia.addSector(sector2);
			agencia.addSector(sector3);
			agencia.addSector(sector5);
			agencia.addSector(sector6);
			agencia.addSector(sector7);
			agencia.addSector(sector8);
			agencia.getListaEspecialidades().add(sector1);

		}catch(YaExisteExceptions e){

		}



	}





}