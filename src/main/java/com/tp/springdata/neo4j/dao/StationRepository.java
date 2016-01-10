package com.tp.springdata.neo4j.dao;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.tp.springdata.neo4j.model.Station;

public interface StationRepository extends GraphRepository<Station> {

	@Query("MATCH (station:Station {stationName:{stationName}}) RETURN station")
	public Station findByStationName(@Param("stationName") String stationName);

	@Query("MATCH (n) WHERE id(n)={stationId} RETURN n")
	public Station findByStationId(@Param("stationId") Long stationId);

	@Transactional
	@Query("MATCH (departure:Station { stationName:{departureStation} }),(arrival:Station { stationName:{arrivalStation} }), p = shortestPath((departure)-[*]-(arrival))RETURN EXTRACT(node IN nodes(p) | ID(node)) AS ids")
	int[] getShortestPath(@Param("departureStation") String start,
			@Param("arrivalStation") String end);
}
