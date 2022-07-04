package com.adrianne.api.statesapisprint3.service;

import com.adrianne.api.statesapisprint3.dto.StateDto;
import com.adrianne.api.statesapisprint3.entity.State;
import com.adrianne.api.statesapisprint3.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StateService {
    @Autowired
    StateRepository stateRepository;

    public StateDto addNewState(StateDto state) {
        State savedState = stateRepository.save(new State(state));
        return new StateDto(savedState);
    }

    public Page<StateDto> getAllStates(Pageable filters) {
        Page<State> state = stateRepository.findAll(filters);
        return state.map(StateDto::new);
    }

    public StateDto getStateById(Long id) {
        Optional<State> stateById = stateRepository.findById(id);
        return new StateDto(stateById.get());
    }

    public StateDto updateStateById(Long id, StateDto state) {
        State savedState = stateRepository.save(new State(state));
        return new StateDto(savedState);
    }

    public ResponseEntity<StateDto> deleteStateById(Long id) {
        Optional<State> stateById = stateRepository.findById(id);
        if (stateById.isPresent()) {
            stateRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    public boolean RagionValidation(String region) {
        return region.equalsIgnoreCase("Noth") ||
                region.equalsIgnoreCase("Northeast") ||
                region.equalsIgnoreCase("South") ||
                region.equalsIgnoreCase("Southeast") ||
                region.equalsIgnoreCase("Mid-west");
    }
}
