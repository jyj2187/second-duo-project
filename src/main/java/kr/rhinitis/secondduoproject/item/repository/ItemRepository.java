package kr.rhinitis.secondduoproject.item.repository;

import kr.rhinitis.secondduoproject.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
