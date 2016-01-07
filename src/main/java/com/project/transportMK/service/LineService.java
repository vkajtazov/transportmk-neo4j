package com.project.transportMK.service;

import java.util.List;

import com.tp.springdata.neo4j.model.BaseEntity;
import com.tp.springdata.neo4j.model.Line;

public interface LineService {

	Line create(Line line);

	List<BaseEntity> getPath(String start, String end);

}
