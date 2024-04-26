package com.ltnc.JavaApp.Service.MaintenanceService.Service;
import com.ltnc.JavaApp.Model.MaintenanceHistory;
import com.ltnc.JavaApp.Repository.MaintenanceHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StatByMonthService {
    @Autowired
    private MaintenanceHistoryRepository repository;

    public List<MaintenanceHistory> findMaintenanceInMonth(int year, int month) {
        LocalDate startOfMonth = LocalDate.of(year, month, 1);
        LocalDate endOfMonth = startOfMonth.plusMonths(1).minusDays(1);

        return repository.findByDateBetween(startOfMonth, endOfMonth);
    }
}
