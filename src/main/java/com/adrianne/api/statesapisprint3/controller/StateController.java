package com.adrianne.api.statesapisprint3.controller;

import com.adrianne.api.statesapisprint3.dto.StateDto;
import com.adrianne.api.statesapisprint3.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StateController {

    @Autowired
    private StateService stateService;

    @PostMapping("/states")
    public ResponseEntity<StateDto> createNewState(@RequestBody StateDto state) {
        StateDto stateDto = stateService.addNewState(state);
        return ResponseEntity.status(201).body(stateDto);
    }

    @GetMapping("/states")
    public ResponseEntity<Page<StateDto>> getAllStates(@RequestParam(required = false) String region, Pageable filters) {
        Page<StateDto> stateDto = stateService.getAllStates(filters);
        return ResponseEntity.ok(stateDto);
    }

    @GetMapping("/states/{id}")
    public ResponseEntity<StateDto> findStateById(@PathVariable Long id) {
        return ResponseEntity.ok(stateService.getStateById(id));
    }

    @PutMapping("/states/{id}")
    public ResponseEntity<StateDto> updateStateById(@PathVariable Long id, @RequestBody StateDto state) {
        return ResponseEntity.ok(stateService.updateStateById(id, state));
    }

    @DeleteMapping("/states/{id}")
    public ResponseEntity<StateDto> deleteStateId(@PathVariable Long id) {
        return stateService.deleteStateById(id);
    }
}
