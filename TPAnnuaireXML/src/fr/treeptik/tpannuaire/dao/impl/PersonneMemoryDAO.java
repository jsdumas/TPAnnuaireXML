package fr.treeptik.tpannuaire.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.treeptik.tpannuaire.dao.PersonneDAO;
import fr.treeptik.tpannuaire.model.Personne;

public class PersonneMemoryDAO implements PersonneDAO {

	private Map<Integer, Personne> map = new HashMap<Integer, Personne>();

	private int count = 0;

	@Override
	public Personne create(Personne personne) {
		count++;
		personne.setId(count);
		map.put(personne.getId(), personne);
		return map.get(personne.getId());
	}

	@Override
	public void remove(Personne personne) {
		map.remove(personne.getId());

	}

	@Override
	public Personne find(Integer id) {
		return map.get(id);
	}

	@Override
	public List<Personne> findAll() {
		List<Personne> personnes = new ArrayList<Personne>();
		personnes.addAll(map.values());
		return personnes;
	}

	@Override
	public Personne update(Personne personne) {
		map.put(personne.getId(), personne);
		return map.get(personne.getId());
	}

}
