package fr.treeptik.tpannuaire.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import fr.treeptik.tpannuaire.dao.impl.PersonneXMLDAO;


	
	public abstract class DAOFactory {

		private static PersonneDAO personneDAO;

		public static PersonneDAO getPersonneDAO() {
			if(personneDAO==null) {
					personneDAO = new PersonneXMLDAO();
			}
			return personneDAO;
		}
}
