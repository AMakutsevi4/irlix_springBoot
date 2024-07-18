package ru.irlix.springBoot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.irlix.springBoot.model.Manager;
import ru.irlix.springBoot.repository.ManagerRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ManagerService {

    private final ManagerRepository managerRepo;

    public List<Manager> getAllManagers() {
        return managerRepo.getAllManagers();
    }

    public void saveManager(Manager manager) {
        managerRepo.saveManager(manager);
    }

    public Manager getManagerById(Long id) {
        return managerRepo.getManagerById(id);
    }

    public void deleteManager(Long id) {
        managerRepo.deleteManager(id);
    }
}
