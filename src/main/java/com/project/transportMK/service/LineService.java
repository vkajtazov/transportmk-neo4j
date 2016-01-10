package com.project.transportMK.service;

import java.util.List;

import com.tp.springdata.neo4j.model.Line;
import com.tp.springdata.neo4j.model.Station;

public interface LineService {

	Line create(Line line);

	List<Station> getPath(String start, String end);

}
