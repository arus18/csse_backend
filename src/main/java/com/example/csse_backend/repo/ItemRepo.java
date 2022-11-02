package com.example.csse_backend.repo;
import com.example.csse_backend.entities.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepo extends CrudRepository<Item,Long> {
}
