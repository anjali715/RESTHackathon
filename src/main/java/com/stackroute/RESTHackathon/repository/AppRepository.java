package com.stackroute.RESTHackathon.repository;
import org.springframework.data.repository.CrudRepository;
import com.stackroute.RESTHackathon.domain.AppDomain;
public interface AppRepository extends CrudRepository<AppDomain, Integer>{
    
    public AppDomain findById(int id);
    public void delete(int id);
}