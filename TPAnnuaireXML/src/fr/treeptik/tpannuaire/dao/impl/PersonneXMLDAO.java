package fr.treeptik.tpannuaire.dao.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import fr.treeptik.tpannuaire.dao.PersonneDAO;
import fr.treeptik.tpannuaire.exception.DAOException;
import fr.treeptik.tpannuaire.model.Annuaire;
import fr.treeptik.tpannuaire.model.ObjectFactory;
import fr.treeptik.tpannuaire.model.Personne;

public class PersonneXMLDAO implements PersonneDAO {

	File file = new File("personne.xml");

	private Integer count = null;

	@Override
	public Personne create(Personne personne) throws DAOException {
		Annuaire annuaire = null;
		count = count == null ? this.initCount() : count;
		personne.setId(++count);
		try {
			JAXBContext context = JAXBContext
					.newInstance("fr.treeptik.tpannuaire.model");
			List<Personne> personnes = this.findAll();
			personnes.add(personne);
			Marshaller marshaller = context.createMarshaller();
			ObjectFactory factory = new ObjectFactory();
			annuaire = factory.createAnnuaire();
			annuaire.getPersonne().addAll(personnes);
			marshaller.marshal(annuaire, file);

		} catch (JAXBException e) {
			throw new DAOException("erreur create", e);
		}

		return personne;
	}

	@Override
	public void remove(Personne personne) throws DAOException {
		Annuaire annuaire = null;
		try {
			JAXBContext context = JAXBContext
					.newInstance("fr.treeptik.tpannuaire.model");
			List<Personne> personnes = this.findAll();
			personnes.remove(personne);
			Marshaller marshaller = context.createMarshaller();
			ObjectFactory factory = new ObjectFactory();
			annuaire = factory.createAnnuaire();
			annuaire.getPersonne().addAll(personnes);
			marshaller.marshal(annuaire, file);

		} catch (JAXBException e) {
			throw new DAOException("erreur create", e);
		}

	}

	@Override
	public Personne find(Integer id) throws DAOException {
		try {
			return this.findAll().stream().filter(p -> p.getId() == id)
					.collect(Collectors.toList()).get(0);
		} catch (DAOException e) {
			throw new DAOException("find by id", e);
		}

	}

	@Override
	public List<Personne> findAll() throws DAOException {
		Annuaire annuaire = null;

		try {
			JAXBContext context = JAXBContext
					.newInstance("fr.treeptik.tpannuaire.model");
			if (!file.exists()) {
				file.createNewFile();
				Marshaller marshaller = context.createMarshaller();
				ObjectFactory factory = new ObjectFactory();
				annuaire = factory.createAnnuaire();
				marshaller.marshal(annuaire, file);
				return new ArrayList<Personne>();
			}

			Unmarshaller unmarshaller = context.createUnmarshaller();
			annuaire = (Annuaire) unmarshaller.unmarshal(file);

		} catch (JAXBException | IOException e) {
			throw new DAOException("Erreur create", e);
		}
		return annuaire.getPersonne();
	}

	@Override
	public Personne update(Personne personne) {
		// TODO Auto-generated method stub
		return null;
	}

	private int initCount() throws DAOException {
		try {
			List<Personne> personnes = this.findAll();
			if (!personnes.isEmpty()) {
				return this.findAll().stream().mapToInt(p -> p.getId()).max()
						.getAsInt();
			} else
				return 0;

		} catch (DAOException e) {
			throw new DAOException("erreur init count", e);
		}
	}

}
