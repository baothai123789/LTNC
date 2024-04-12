package com.ltnc.JavaApp.Service.ProfileService.Employee.GetProfileService;

import com.ltnc.JavaApp.Model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public class AbstractGetProfileService<T extends Employee> implements IGetProfileService {
    protected MongoRepository<T,String> modelRepository;
    protected Class<T> type;
    @Override
    public Employee getUserProfile(String id) throws NullPointerException {
        return modelRepository.findById(id).orElseThrow(NullPointerException::new);

    }
    @Override
    public String getType() {
        return type.getSimpleName();
    }
}
