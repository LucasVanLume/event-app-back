package com.eventapp.event_api.services.event;

import com.eventapp.event_api.domain.address.Address;
import com.eventapp.event_api.domain.event.Event;
import com.eventapp.event_api.dto.event.EventRequestDTO;
import com.eventapp.event_api.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address createAddress(EventRequestDTO data, Event event) {
        Address address = new Address();
        address.setEvent(event);
        address.setCep(data.address().cep());
        address.setStreet(data.address().street());
        address.setCity(data.address().city());
        address.setNeighborhood(data.address().neighborhood());

        addressRepository.save(address);
        return address;
    }
}
