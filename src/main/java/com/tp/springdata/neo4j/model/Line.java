package com.tp.springdata.neo4j.model;

import java.sql.Time;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity(type="LINE_IN")
public class Line extends BaseEntity {

	private String lineName;

	@StartNode
	private Station startingStation;

	@EndNode
	private Station arrivingStation;

	private Time traveledTime;

	private float kmTraveled;

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public Time getTraveledTime() {
		return traveledTime;
	}

	public void setTraveledTime(Time traveledTime) {
		this.traveledTime = traveledTime;
	}

	public float getKmTraveled() {
		return kmTraveled;
	}

	public void setKmTraveled(float kmTraveled) {
		this.kmTraveled = kmTraveled;
	}

	public Station getStartingStation() {
		return startingStation;
	}

	public void setStartingStation(Station startingStation) {
		this.startingStation = startingStation;
	}

	public Station getArrivingStation() {
		return arrivingStation;
	}

	public void setArrivingStation(Station arrivingStation) {
		this.arrivingStation = arrivingStation;
	}

}
