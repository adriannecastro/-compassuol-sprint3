package com.adrianne.api.statesapisprint3.dto;

import com.adrianne.api.statesapisprint3.entity.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateDto {

    private Long id;
    private String name;
    private String region;
    private Integer population;
    private String capital;
    private Double area;

    public StateDto(State savedState) {
        this.id = savedState.getId();
        this.name = savedState.getName();
        this.region = savedState.getRegion();
        this.population = savedState.getPopulation();
        this.capital = savedState.getCapital();
        this.area = savedState.getArea();
    }
}
