package com.sity.service.Impl;

import com.sity.model.Publisher;
import com.sity.repository.PublisherRepository;
import com.sity.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<Publisher> fetchAllPublishers(){
        return publisherRepository.findAll();
    }

}
