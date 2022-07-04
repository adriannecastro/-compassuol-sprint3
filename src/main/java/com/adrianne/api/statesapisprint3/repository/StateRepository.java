package com.adrianne.api.statesapisprint3.repository;

import com.adrianne.api.statesapisprint3.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StateRepository extends JpaRepository<State, Long> {

}
