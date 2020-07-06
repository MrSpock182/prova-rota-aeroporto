package io.com.github.mrspock182.route.api.framework.data;

import io.com.github.mrspock182.route.api.core.dto.Airport;
import io.com.github.mrspock182.route.api.core.dto.Destination;
import io.com.github.mrspock182.route.api.core.repository.AirportRepository;
import io.com.github.mrspock182.route.api.exception.BadRequest;
import io.com.github.mrspock182.route.api.exception.InternalServerError;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AirportRepositoryImpl implements AirportRepository {

    private final String file = "src/main/resources/input-routes.csv";

    @Override
    public void save(String airport) {
        List<String> list = getCsvRegisters();
        try(FileWriter writer = new FileWriter(file)) {
            for (String l: list) {
                writer.append(l).append("\n");
            }
            writer.append(airport);
            writer.flush();
        } catch (Exception ex) {
            throw new InternalServerError("Error to writer csv");
        }
    }

    private List<String> getCsvRegisters() {
        try(BufferedReader csvReader = new BufferedReader(new FileReader(file))) {
            String row;
            List<String> list = new ArrayList<>();
            while ((row = csvReader.readLine()) != null) {
                list.add(row);
            }
            return list;
        } catch (Exception ex) {
            throw new InternalServerError("Error to read csv");
        }
    }

    @Override
    public Map<String, Airport> findAll() {
        return readCsv();
    }

    private Map<String, Airport> readCsv() {
        Map<String, Airport> map = new HashMap<>();
        try(BufferedReader csvReader = new BufferedReader(new FileReader(file))) {
            String row;
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                createAirplane(data, map);
            }
            return map;
        } catch (Exception ex) {
            throw new InternalServerError("Error to read csv");
        }
    }

    private void createAirplane(String[] data, Map<String, Airport> map) {
        Airport airport = createAirport(map, data[0]);

        if(existsAirportDestination(airport, data[1])) {
            throw new BadRequest("route exists");
        }

        Destination destination = createDestination(map, data[1], Integer.parseInt(data[2]));
        airport.getDestinations().add(destination);
    }

    private Destination createDestination(Map<String, Airport> map, String to, Integer weight) {
        Airport airport = createAirport(map, to);
        return new Destination(weight, airport);
    }

    private Airport createAirport(Map<String, Airport> map, String from) {
        Airport airport = map.get(from);
        if(airport == null) {
            airport = new Airport(from, new ArrayList<>());
            map.put(from, airport);
        }

        return airport;
    }

    private boolean existsAirportDestination(Airport airport, String to) {
        for (Destination d : airport.getDestinations()) {
            if(d.getAirport().getName().equalsIgnoreCase(to)) {
                return true;
            }
        }
        return false;
    }

}
