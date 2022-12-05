package util;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.util.ArrayList;

import clase.AgenciaEmpleadora;
import clase.Candidato;
import clase.Documento;
import clase.Entrevista;

public class MetodosUtiles {

	public static void RellenoAutomatico(){

		ArrayList<Documento> documentos = new ArrayList<Documento>();
		documentos.add(new Documento("Pasaporte", true));
		documentos.add(new Documento("Certificado de 9no grado", true));
		documentos.add(new Documento("Certificado de 12 grado", false));
		documentos.add(new Documento("Licencia de camion", false));
		documentos.add(new Documento("licencia de carro", true));
		documentos.add(new Documento("Licencia de guagua", true));

		ArrayList<Documento> doc = new ArrayList<Documento>();
		doc.add(new Documento("Conocerdor de herramientas", true));
		doc.add(new Documento("Certificado de 9no grado", true));
		doc.add(new Documento("Certificado de 12 grado", false));
		doc.add(new Documento("Titulo de ing. mec", false));
		doc.add(new Documento("licencia de carro", true));
		doc.add(new Documento("Licencia de guagua", true));



		AgenciaEmpleadora agencia = AgenciaEmpleadora.CrearInstancia("Specter Litt");
		agencia.addSector("Transporte", documentos);
		agencia.addEmpresa("Google","8 Street", "78965412", agencia.obtenerSector("Transporte"));
		agencia.addRama("Mecanica", doc);
		Candidato candidato1= new Candidato("03102868658", "Francis", "Masculino", "Mazorra", "53565387", "12 grado", "Ing. inf", 5,
				agencia.obtenerRama("Mecanica"));
		agencia.addCandidato(candidato1);
		agencia.obtenerEmpresa("Google").addOferta("12365",5000, 2, agencia.obtenerRama("Mecanica"));
		agencia.obtenerEmpresa("Google").addEntrevista(new Date(2023-1900, 2, 20),
				agencia.getListaCandidatos().get(0),agencia.obtenerEmpresa("Google").getListaOfertas().get(0));
		

	}
	
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
			Character letra=e.getKeyChar();
			if(tamActual>=30){
				e.consume();
				Toolkit x= Toolkit.getDefaultToolkit();
				x.beep();
			}
		}
}