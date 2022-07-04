package com.adrianne.api.statesapisprint3.entity;

import com.adrianne.api.statesapisprint3.dto.StateDto;

import javax.persistence.*;

@Entity(name = "db_states")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String region;
    private Integer population;
    private String capital;
    private Double area;

    public State() {

    }

    public State(Long id, String name, String region, Integer population, String capital, Double area) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.population = population;
        this.capital = capital;
        this.area = area;
    }

    public State(StateDto state) {
        this.id = state.getId();
        this.name = state.getName();
        this.region = state.getRegion();
        this.population = state.getPopulation();
        this.capital = state.getCapital();
        this.area = state.getArea();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public Integer getPopulation() {
        return population;
    }

    public String getCapital() {
        return capital;
    }

    public Double getArea() {
        return area;
    }
}

