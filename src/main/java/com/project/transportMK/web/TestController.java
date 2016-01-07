package com.project.transportMK.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.EntityPath;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.transportMK.service.LineService;
import com.project.transportMK.service.StationService;
import com.tp.springdata.neo4j.model.BaseEntity;
import com.tp.springdata.neo4j.model.Line;
import com.tp.springdata.neo4j.model.Station;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	StationService stationService;
	@Autowired
	LineService lineService;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public String getCityBusSchedule() {
		return "OK";
	}

	@RequestMapping(value = "create", method = RequestMethod.GET, produces = "application/json")
	public Line create() {
		Station station1 = new Station();
		station1.setStationName("GVG");
		station1 = stationService.create(station1);
		Station station2 = new Station();
		station2.setStationName("SK");
		station2 = stationService.create(station2);
		Station station3 = new Station();
		station3.setStationName("BT");
		station3 = stationService.create(station3);
		Line l = new Line();
		l.setStartingStation(station1);
		l.setArrivingStation(station2);
		Line l1 = new Line();
		l1.setStartingStation(station2);
		l1.setArrivingStation(station3);
		lineService.create(l);
		lineService.create(l1);
		return l;
	}

	@RequestMapping(value = "newcreate", method = RequestMethod.GET, produces = "application/json")
	public Line newCreate() {
		Station station1 = stationService.findByStationName("SK");
		Station station2 = new Station();
		station2.setStationName("BT");
		station2 = stationService.create(station2);
		Line l = new Line();
		l.setStartingStation(station1);
		l.setArrivingStation(station2);
		lineService.create(l);
		return l;
	}

	@RequestMapping(value = "find", method = RequestMethod.GET, produces = "application/json")
	public List<BaseEntity> find() {
		return lineService.getPath("GVG", "BT");
	}

	@RequestMapping(value = "list", method = RequestMethod.GET, produces = "application/json")
	public Station list() {
		Station s = stationService.findByStationName("Gevgelija");
		return stationService.findByStationId(s.getId());
	}
}
