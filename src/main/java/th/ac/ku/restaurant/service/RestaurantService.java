package th.ac.ku.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.ku.restaurant.model.Restaurant;
import th.ac.ku.restaurant.repository.RestaurantRepository;

import java.util.List;
import java.util.UUID;

// @Service จะคล้ายกับ @RestController Spring จะสร้าง object นี้ให้อัตโนมัติ
// และมีลักษณะเป็น service ที่จะทำงานตลอดเวลาเพื่อให้บริการ
//หน้าที่ controller : รับผิดชอบการ handle user request
//หน้าที่ service  : รับผิดชอบการประมวลผลและจัดการข้อมูล
//หน้าที่ repository  : รับผิดชอบการเชื่อมต่อฐานข้อมูล
@Service
public class RestaurantService {

    //@Autowired Spring จะทำ dependency injection ให้
    //โดยส่ง object ของ RestaurantRepository มาให้ RestaurantService โดยอัตโนมัติ
    @Autowired
    private RestaurantRepository repository;

    public List<Restaurant> getAll() {
        return repository.findAll();
    }

    public Restaurant create(Restaurant restaurant) {
        // save คือ create or update
        repository.save(restaurant);
        return restaurant;
    }

    public Restaurant getRestaurant(int id) {
        return repository.findById(id).get();
    }

    public Restaurant update(int id, Restaurant requestBody){
        Restaurant record = repository.findById(id).get();
        if(requestBody.getName() != null)
            record.setName(requestBody.getName());

        if(requestBody.getAddress() != null)
            record.setAddress(requestBody.getAddress());

        if(requestBody.getPhone() != null)
            record.setPhone(requestBody.getPhone());

        if(requestBody.getNumSeats() > 0)
            record.setNumSeats(requestBody.getNumSeats());

        Restaurant r = repository.save(record);

        return r;
    }

    public Restaurant delete(int id){
        Restaurant record = repository.findById(id).get();
        repository.deleteById(id);
        return record;
    }
}
