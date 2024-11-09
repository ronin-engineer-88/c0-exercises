package src.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.repository.FullNameRepository;
import src.service.IFullNameService;

@Service
public class FullNameServiceImpl implements IFullNameService {

    @Autowired
    private FullNameRepository fullNameRepository;

    @Override
    public void deleteByStatus(String value) {
        fullNameRepository.deleteByStatus(value);
    }
}
