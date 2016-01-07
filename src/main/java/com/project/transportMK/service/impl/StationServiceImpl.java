package com.project.transportMK.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.Result;
import org.springframework.stereotype.Service;

import com.project.transportMK.service.StationService;
import com.tp.springdata.neo4j.dao.StationRepository;
import com.tp.springdata.neo4j.model.Station;

@Service
public class StationServiceImpl implements StationService {

	@Autowired
	StationRepository repository;

	@Override
	public Station findByStationName(String stationName) {
		return repository.findByStationName(stationName);
	}

	@Override
	public Station create(Station station) {
		return repository.save(station);
	}

	@Override
	public Station findByStationId(Long stationId) {
		return repository.findByStationId(stationId);
	}

	@Override
	public List<Station> findAll() {
		Result<Station> stations = repository.findAll();
		ArrayList<Station> result = new ArrayList<Station>();
		for (Station station : stations) {
			result.add(station);
		}
		return result;
	}

}
