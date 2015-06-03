package fr.treeptik.tpannuaire.runtime;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import fr.treeptik.tpannuaire.exception.ServiceException;
import fr.treeptik.tpannuaire.model.Personne;
import fr.treeptik.tpannuaire.service.PersonneService;
import fr.treeptik.tpannuaire.utils.DateUtils;

public class Runtime {

	public static void main(String[] args) throws ParseException,
			ServiceException, IOException {

		PersonneService personneService = new PersonneService();
		Scanner scanner = new Scanner(System.in);
		String choix = "";
		List<String> choixDisponible = Arrays.asList("1", "2", "3", "4", "5");

		do {
			// on affiche le menu
			afficherMenu();
			choix = scanner.nextLine();
			// si le choix n'est pas disponible on réaffiche le menu
			if (!choixDisponible.contains(choix)) {
				continue;
			}
			// si le choix est égal à 5 on sort
			if (choix.equalsIgnoreCase("5"))
				break;

			switch (choix) {
			case "1":
				System.out.println("Création");
				Personne personne = new Personne();
				System.out.println("Entrez un nom : ");
				personne.setNom(scanner.nextLine());
				System.out.println("Entrez un prenom : ");
				personne.setPrenom(scanner.nextLine());
				System.out
						.println("Entrez une date de naissance (dd/MM/yyyy) : ");
				personne.setDateDeNaissance(DateUtils.stringToDate(scanner
						.nextLine()));
				System.out.println("Entrez un nom de société: ");
				personne.setNomOrganisation(scanner.nextLine());
				System.out.println("Entrez un numéro de téléphone : ");
				personne.setNumeroDeTelephone(scanner.nextLine());
				personne = personneService.create(personne);
				System.out.println(personne + " correctement crée");
				break;
			case "2":
				System.out.println("Liste des personnes");
				for (Personne p : personneService.findAll()) {
					System.out.println(p);
				}
				break;
			case "3":
				System.out.println("Update de la personne");

				System.out
						.println("Entrez de l'id de la personne à mettre à jour : ");
				personne = personneService.find(Integer.parseInt(scanner
						.nextLine()));
				System.out.println("Remplacer le nom " + personne.getNom()
						+ ": ");
				personne.setNom(scanner.nextLine());
				System.out.println("Remplacer le prenom "
						+ personne.getPrenom() + " : ");
				personne.setPrenom(scanner.nextLine());
				System.out
						.println("Remplacer la date de naissance (dd/MM/yyyy) "
								+ DateUtils.dateToString(personne
										.getDateDeNaissance()) + " : ");
				personne.setDateDeNaissance(DateUtils.stringToDate(scanner
						.nextLine()));
				System.out.println("Remplacer le nom de société "
						+ personne.getNomOrganisation() + ": ");
				personne.setNomOrganisation(scanner.nextLine());
				System.out.println("Remplacer le numéro de téléphone"
						+ personne.getNumeroDeTelephone() + " : ");
				personne.setNumeroDeTelephone(scanner.nextLine());

				personne = personneService.update(personne);

				System.out.println(personne + " correctement mise à jour");

				break;
			case "4":
				System.out.println("suppression de la personne");
				System.out
						.println("Entrez de l'id de la personne à supprimer : ");
				personne = personneService.find(Integer.parseInt(scanner
						.nextLine()));
				personneService.remove(personne);
				System.out.println(personne + " correctement supprimée");
				personne = null;
				break;
			}

		} while (!choix.equalsIgnoreCase("5"));

	}

	private static void afficherMenu() {
		System.out.println("MENU");
		System.out.println("Choisir une option : ");
		System.out.println("1- Créer une personne");
		System.out.println("2- Lister les personnes");
		System.out.println("3-Mettre à jour une personne");
		System.out.println("4-Supprimer une personne");
		System.out.println("5-Quit");
	}
	
	

}
