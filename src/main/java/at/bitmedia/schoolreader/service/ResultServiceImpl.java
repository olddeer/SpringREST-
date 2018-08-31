package at.bitmedia.schoolreader.service;

import at.bitmedia.schoolreader.entity.Result;
import at.bitmedia.schoolreader.repositories.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultRepository resultRepository;

    @Override
    public Result findByAudioId(Integer id) {

        return resultRepository.findByAudio_SraId(id);
    }

    @Override
    public List<Result> findAll() {
        return resultRepository.findAll();
    }

    @Override
    public Result findById(int id) {
        return resultRepository.findById(id).get();
    }

    @Override
    public Result insertResult(Result r) {
        return resultRepository.save(r);
    }
}
