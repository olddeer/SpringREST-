package at.bitmedia.schoolreader.service;

import at.bitmedia.schoolreader.entity.Result;
import at.bitmedia.schoolreader.repositories.ResultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResultServiceBean implements  ResultService {
   @Autowired
    ResultRepo resultRepo;

    @Override
    public List<Result> findAll() {
        return resultRepo.findAll();
    }

    @Override
    public Result findById(int id) {
        return resultRepo.findById(id).get();
    }

    @Override
    public Result insertResult(Result r) {
        return resultRepo.save(r);
    }
}
