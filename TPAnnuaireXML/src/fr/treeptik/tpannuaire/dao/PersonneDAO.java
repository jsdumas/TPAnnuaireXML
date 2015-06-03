package fr.treeptik.tpannuaire.dao;

import java.util.List;

import fr.treeptik.tpannuaire.exception.DAOException;
import fr.treeptik.tpannuaire.model.Personne;

public interface PersonneDAO {

	Personne create(Personne personne) throws DAOException;

	void remove(Personne personne) throws DAOException;

	Personne find(Integer id) throws DAOException;

	List<Personne> findAll() throws DAOException;

	Personne update(Personne personne);
}
