package com.project.transportMK.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.graphdb.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.EntityPath;
import org.springframework.stereotype.Service;

import com.project.transportMK.service.LineService;
import com.tp.springdata.neo4j.dao.RelationRepository;
import com.tp.springdata.neo4j.dao.StationRepository;
import com.tp.springdata.neo4j.model.BaseEntity;
import com.tp.springdata.neo4j.model.Line;
import com.tp.springdata.neo4j.model.Station;

@Service
public class LineServiceImpl implements LineService {

	@Autowired
	RelationRepository repository;

	@Autowired
	StationRepository stationRepo;

	@Override
	public Line create(Line line) {
		return repository.save(line);
	}

	@Override
	public List<BaseEntity> getPath(String start, String end) {
		List<BaseEntity> shortestPath = stationRepo.getShortestPath(start, end);
		return shortestPath;
	}

}
