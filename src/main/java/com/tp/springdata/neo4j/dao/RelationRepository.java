package com.tp.springdata.neo4j.dao;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.tp.springdata.neo4j.model.Line;

public interface RelationRepository extends GraphRepository<Line> {
}
