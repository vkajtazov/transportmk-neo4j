package com.tp.springdata.neo4j.model;

import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class Station extends BaseEntity {

	private String stationName;

	private double stationLatitude;

	private double stationLongitude;

	private String stationName_en;

	@RelatedTo(elementClass = Station.class, type = "LINE_IN", direction = Direction.INCOMING)
	private Set<Station> stations;

	public String getStationName_en() {
		return stationName_en;
	}

	public void setStationName_en(String stationName_en) {
		this.stationName_en = stationName_en;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public double getStationLatitude() {
		return stationLatitude;
	}

	public void setStationLatitude(double stationLatitude) {
		this.stationLatitude = stationLatitude;
	}

	public double getStationLongitude() {
		return stationLongitude;
	}

	public void setStationLongitude(double stationLongitude) {
		this.stationLongitude = stationLongitude;
	}

}
