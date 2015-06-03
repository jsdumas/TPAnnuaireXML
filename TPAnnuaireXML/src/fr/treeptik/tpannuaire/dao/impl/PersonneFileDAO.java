package fr.treeptik.tpannuaire.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import fr.treeptik.tpannuaire.dao.PersonneDAO;
import fr.treeptik.tpannuaire.exception.DAOException;
import fr.treeptik.tpannuaire.model.Personne;
import fr.treeptik.tpannuaire.utils.DateUtils;

public class PersonneFileDAO implements PersonneDAO {

	File file = new File("personnes.csv");

	private Integer count = null;

	@Override
	public Personne create(Personne personne) throws DAOException {
		FileWriter writer = null;
		count = count == null ? this.initCount() : count;
		personne.setId(++count);
		try {
			writer = new FileWriter(file, true);
			StringBuilder builder = new StringBuilder();
			builder.append(personne.getId());
			builder.append(";");
			builder.append(personne.getNom());
			builder.append(";");
			builder.append(personne.getPrenom());
			builder.append(";");
			builder.append(DateUtils.dateToString(personne.getDateDeNaissance()));
			builder.append(";");
			builder.append(personne.getNomOrganisation());
			builder.append(";");
			builder.append(personne.getNumeroDeTelephone());
			writer.write(builder.toString());
			writer.append("\n");

		} catch (IOException e) {
			throw new DAOException("Erreur creation personne", e);
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				throw new DAOException("Erreur creation personne", e);
			}
		}

		return personne;
	}

	@Override
	public void remove(Personne personne) {
		// TODO Auto-generated method stub

	}

	@Override
	public Personne find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Personne> findAll() throws DAOException {
		List<Personne> personnes = new ArrayList<Personne>();
		FileReader reader = null;
		BufferedReader buffReader = null;
		try {
			reader = new FileReader(file);
			buffReader = new BufferedReader(reader);
			String line = "";
			while (buffReader.ready()) {
				line = buffReader.readLine();
				String[] personneText = line.split(";");
				Personne personne = new Personne(
						Integer.parseInt(personneText[0]), personneText[1],
						personneText[2],
						DateUtils.stringToDate(personneText[3]),
						personneText[4], personneText[5]);
				personnes.add(personne);

			}

		} catch (IOException e) {
			throw new DAOException("erreur findall de type ioexception", e);
		} catch (ParseException e) {
			throw new DAOException("erreur findall de type parse date", e);

		} finally {
			try {
				buffReader.close();
				reader.close();
			} catch (IOException e) {
				throw new DAOException("erreur findall de type ioexception", e);

			}

		}

		return personnes;
	}

	@Override
	public Personne update(Personne personne) {
		// TODO Auto-generated method stub
		return null;
	}

	private int initCount() throws DAOException {
		try {
			return this.findAll().stream().mapToInt(p -> p.getId()).max()
					.getAsInt();
		} catch (DAOException e) {
			throw new DAOException("erreur init count", e);
		}
	}

}
