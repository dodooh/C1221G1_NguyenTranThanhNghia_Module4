package com.codegym.furama.service;

import com.codegym.furama.model.employee.Position;
import java.util.List;

public interface IPositionService {

    List<Position> findAll();
}
