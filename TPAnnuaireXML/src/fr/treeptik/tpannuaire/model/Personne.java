package fr.treeptik.tpannuaire.model;

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.30 at 12:23:16 PM CEST 
//

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="prenom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dateDeNaissance" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="nomOrganisation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numeroDeTelephone" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "id", "nom", "prenom", "dateDeNaissanceXML",
		"nomOrganisation", "numeroDeTelephone" })
@XmlRootElement(name = "personne")
public class Personne {

	protected int id;
	@XmlElement(required = true)
	protected String nom;
	@XmlElement(required = true)
	protected String prenom;

	@XmlTransient
	protected Date dateDeNaissance;
	@XmlElement(required = true)
	protected String nomOrganisation;
	@XmlElement(required = true)
	protected String numeroDeTelephone;

	@XmlElement(required = true)
	@XmlSchemaType(name = "date")
	private XMLGregorianCalendar dateDeNaissanceXML;

	public Personne() {
	}

	public Personne(int id, String nom, String prenom, Date dateDeNaissance,
			String nomOrganisation, String numeroDeTelephone) {

		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.nomOrganisation = nomOrganisation;
		this.numeroDeTelephone = numeroDeTelephone;
	}

	/**
	 * Gets the value of the id property.
	 * 
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 */
	public void setId(int value) {
		this.id = value;
	}

	/**
	 * Gets the value of the nom property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Sets the value of the nom property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNom(String value) {
		this.nom = value;
	}

	/**
	 * Gets the value of the prenom property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Sets the value of the prenom property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPrenom(String value) {
		this.prenom = value;
	}

	/**
	 * Gets the value of the dateDeNaissance property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	/**
	 * Sets the value of the dateDeNaissance property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setDateDeNaissance(Date value) {
		try {
			this.setDateDeNaissanceXML(value);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		this.dateDeNaissance = value;
	}

	/**
	 * Gets the value of the nomOrganisation property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNomOrganisation() {
		return nomOrganisation;
	}

	/**
	 * Sets the value of the nomOrganisation property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNomOrganisation(String value) {
		this.nomOrganisation = value;
	}

	/**
	 * Gets the value of the numeroDeTelephone property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNumeroDeTelephone() {
		return numeroDeTelephone;
	}

	/**
	 * Sets the value of the numeroDeTelephone property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNumeroDeTelephone(String value) {
		this.numeroDeTelephone = value;
	}

	public XMLGregorianCalendar getDateDeNaissanceXML() {

		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(dateDeNaissance);

		try {
			dateDeNaissanceXML = DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(calendar);
		} catch (DatatypeConfigurationException e) {

		}
		return dateDeNaissanceXML;
	}

	public void setDateDeNaissanceXML(Date dateDeNaissance)
			throws DatatypeConfigurationException {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(dateDeNaissance);
		this.dateDeNaissanceXML = DatatypeFactory.newInstance()
				.newXMLGregorianCalendar(calendar);
		;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ ", dateDeNaissance=" + dateDeNaissance + ", nomOrganisation="
				+ nomOrganisation + ", numeroDeTelephone=" + numeroDeTelephone
				+ ", dateDeNaissanceXML=" + dateDeNaissanceXML + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personne other = (Personne) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
