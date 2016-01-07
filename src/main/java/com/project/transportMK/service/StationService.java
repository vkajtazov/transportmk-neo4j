package com.project.transportMK.service;

import java.util.List;

import com.tp.springdata.neo4j.model.Station;

public interface StationService {

	Station findByStationName(String stationName);

	Station findByStationId(Long stationId);

	Station create(Station station);

	List<Station> findAll();
}
