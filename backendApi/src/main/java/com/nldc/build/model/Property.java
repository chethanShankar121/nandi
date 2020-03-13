package com.nldc.build.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROPERTY")
public class Property {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="propertyID")
	private Long propertyID;
	@Column(name="propertyType")
	private String propertyType;
	@Column(name="propertyFor")
	private String propertyFor;
	@Column(name="city")
	private String city;
	@Column(name="street")
	private String street;
	@Column(name="pincode")
	private String pincode;
	@Column(name="area")
	private String area;
	@Column(name="geolocation")
	private String geolocation;
	@Column(name="noOfRooms")
	private int noOfRooms;
	@Column(name="builtArea")
	private int builtArea;
	@Column(name="carpetArea")
	private int carpetArea;
	@Column(name="totalFloors")
	private int totalFloors;
	@Column(name="floorNumber")
	private int floorNumber;
	@Column(name="availableFrom")
	private Date availableFrom;
	@Column(name="ageOfProperty")
	private int ageOfProperty;
	@Column(name="rent")
	private int rent;
	@Column(name="deposit")
	private int deposit;
	@Column(name="maintenance")
	private int maintenance;
	@Column(name="furnishType")
	private int furnishType;
	@Column(name="description")
	private String description;
	@Column(name="preferredTenants")
	private String preferredTenants;
	
	Property(Long propertyID, String propertyType, String propertyFor, String city, String street, String pincode, String area, String geolocation, int noOfRooms, int builtArea, int carpetArea, int totalFloors, int floorNumber, Date availableFrom, int ageOfProperty, int rent, int deposit, int maintenance, int furnishType, String description, String preferredTenants) {
		this.setPropertyID(propertyID);
		this.setPropertyType(propertyType);
		this.setPropertyFor(propertyFor);
		this.setCity(city);
		this.setStreet(street);
		this.setPincode(pincode);
		this.setArea(area);
		this.setGeolocation(geolocation);
		this.setNoOfRooms(noOfRooms);
		this.setBuiltArea(builtArea);
		this.setCarpetArea(carpetArea);
		this.setTotalFloors(totalFloors);
		this.setFloorNumber(floorNumber);
		this.setAvailableFrom(availableFrom);
		this.setAgeOfProperty(ageOfProperty);
		this.setRent(rent);
		this.setDeposit(deposit);
		this.setMaintenance(maintenance);
		this.setFurnishType(furnishType);
		this.setDescription(description);
		this.setPreferredTenants(preferredTenants);
	}
	
	Property(){
		
	}
	
	public Long getPropertyID() {
		return propertyID;
	}
	public void setPropertyID(Long propertyID) {
		this.propertyID = propertyID;
	}
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	public String getPropertyFor() {
		return propertyFor;
	}
	public void setPropertyFor(String propertyFor) {
		this.propertyFor = propertyFor;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getGeolocation() {
		return geolocation;
	}
	public void setGeolocation(String geolocation) {
		this.geolocation = geolocation;
	}
	public int getNoOfRooms() {
		return noOfRooms;
	}
	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}
	public int getBuiltArea() {
		return builtArea;
	}
	public void setBuiltArea(int builtArea) {
		this.builtArea = builtArea;
	}
	public int getCarpetArea() {
		return carpetArea;
	}
	public void setCarpetArea(int carpetArea) {
		this.carpetArea = carpetArea;
	}
	public int getTotalFloors() {
		return totalFloors;
	}
	public void setTotalFloors(int totalFloors) {
		this.totalFloors = totalFloors;
	}
	public int getFloorNumber() {
		return floorNumber;
	}
	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}
	public Date getAvailableFrom() {
		return availableFrom;
	}
	public void setAvailableFrom(Date availableFrom) {
		this.availableFrom = availableFrom;
	}
	public int getAgeOfProperty() {
		return ageOfProperty;
	}
	public void setAgeOfProperty(int ageOfProperty) {
		this.ageOfProperty = ageOfProperty;
	}
	public int getRent() {
		return rent;
	}
	public void setRent(int rent) {
		this.rent = rent;
	}
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	public int getMaintenance() {
		return maintenance;
	}
	public void setMaintenance(int maintenance) {
		this.maintenance = maintenance;
	}
	public int getFurnishType() {
		return furnishType;
	}
	public void setFurnishType(int furnishType) {
		this.furnishType = furnishType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPreferredTenants() {
		return preferredTenants;
	}
	public void setPreferredTenants(String preferredTenants) {
		this.preferredTenants = preferredTenants;
	}       

}
