package com.springframework.services;

import com.springframework.commands.UnitOfMeasureCommand;
import com.springframework.converts.UnitOfMeasureToUnitOfMeasureCommand;
import com.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final UnitOfMeasureToUnitOfMeasureCommand converter;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository, UnitOfMeasureToUnitOfMeasureCommand converter) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.converter = converter;
    }

    @Override
    public Set<UnitOfMeasureCommand> listAllUoms() {
       return StreamSupport.stream(unitOfMeasureRepository.findAll().spliterator(), false)
                .map(converter::convert)
                .collect(Collectors.toSet());
    }
}
