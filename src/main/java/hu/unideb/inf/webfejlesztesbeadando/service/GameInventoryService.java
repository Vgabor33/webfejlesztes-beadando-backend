package hu.unideb.inf.webfejlesztesbeadando.service;


import hu.unideb.inf.webfejlesztesbeadando.GameInventoryRepository;
import hu.unideb.inf.webfejlesztesbeadando.model.GameInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class GameInventoryService {

    private final GameInventoryRepository gameInventoryRepository;

    @Autowired
    public GameInventoryService(GameInventoryRepository gameInventoryRepository) { this.gameInventoryRepository = gameInventoryRepository; }

    public List<GameInventory> getGameInventory(){
        return gameInventoryRepository.findAll();
    }

    public void addNewItem(GameInventory gameInventory) {
        gameInventoryRepository.save(gameInventory);
    }

    public void deleteItem(Long itemId){
        boolean exists = gameInventoryRepository.existsById(itemId);
        if(!exists) {
            throw new IllegalStateException("Item with id "+ itemId + " does not exist!");
        }
        gameInventoryRepository.deleteById(itemId);
    }

    @Transactional
    public GameInventory updateItem(Long itemId, String itemName, Integer level, String itemClass, Integer count, Integer rarity){
        GameInventory gameInventory = gameInventoryRepository.findById(itemId)
                .orElseThrow(() -> new IllegalStateException("Item with id "+ itemId + " does not exist!"));

        if (itemName != null && itemName.length() > 0 && !Objects.equals(gameInventory.getItemName(), itemName)){
            gameInventory.setItemName(itemName);
        }
        if (itemClass != null && itemClass.length() > 0 && !Objects.equals(gameInventory.getItemClass(), itemClass)){
            gameInventory.setItemClass(itemClass);
        }
        if (rarity != null && rarity > 0 && !Objects.equals(gameInventory.getRarity(), rarity)){
            gameInventory.setRarity(rarity);
        }
        if (count != null && count > 0 && !Objects.equals(gameInventory.getCount(), count)){
            gameInventory.setCount(count);
        }
        if (level != null && level > 0 && !Objects.equals(gameInventory.getLevel(), level)){
            gameInventory.setLevel(level);
        }
        return gameInventory;
    }
}
