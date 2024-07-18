package ru.irlix.springBoot.repository;

import org.springframework.stereotype.Repository;
import ru.irlix.springBoot.model.Manager;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ManagerRepository {
    private final List<Manager> managerList = new ArrayList<>();
    private Long manager_Id = 1L;

    public List<Manager> getAllManagers() {
        return managerList;
    }

    public Manager getManagerById(Long id) {
        return managerList.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void saveManager(Manager manager) {
            manager.setId(manager_Id++);
            managerList.add(manager);
    }

    public void deleteManager(Long id) {
        managerList.removeIf(m -> m.getId().equals(id));
    }
}



