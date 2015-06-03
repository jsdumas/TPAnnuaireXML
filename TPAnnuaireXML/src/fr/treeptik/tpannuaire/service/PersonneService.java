package fr.treeptik.tpannuaire.service;

import java.util.List;

import fr.treeptik.tpannuaire.dao.DAOFactory;
import fr.treeptik.tpannuaire.dao.PersonneDAO;
import fr.treeptik.tpannuaire.exception.DAOException;
import fr.treeptik.tpannuaire.exception.ServiceException;
import fr.treeptik.tpannuaire.model.Personne;

public class PersonneService {

	private PersonneDAO personneDAO = DAOFactory.getPersonneDAO();

	public Personne create(Personne personne) throws ServiceException {
		try {
			return personneDAO.create(personne);
		} catch (DAOException e) {
			throw new ServiceException("erreur service create personne", e);
		}
	}

	public void remove(Personne personne) throws ServiceException {
		try {
			personneDAO.remove(personne);
		} catch (DAOException e) {
			throw new ServiceException("erreur service remove personne", e);
		}
	}

	public Personne find(Integer id) throws ServiceException {
		try {
			return personneDAO.find(id);
		} catch (DAOException e) {
			throw new ServiceException("error find by id", e);
		}
	}

	public List<Personne> findAll() throws ServiceException {
		try {
			return personneDAO.findAll();
		} catch (DAOException e) {
			throw new ServiceException("erreur findall", e);
		}
	}

	public Personne update(Personne personne) {
		return personneDAO.update(personne);
	}
}
