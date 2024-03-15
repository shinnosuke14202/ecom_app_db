package ecom.mobile.app.service.serviceImpl;

import ecom.mobile.app.repository.ItemOrderRepository;
import ecom.mobile.app.service.serviceInterface.ItemOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemOrderServiceImpl implements ItemOrderService {
    @Autowired
    ItemOrderRepository itemOrderRepository;
}
