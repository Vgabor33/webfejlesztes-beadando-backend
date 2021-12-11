package hu.unideb.inf.webfejlesztesbeadando.controller;



import hu.unideb.inf.webfejlesztesbeadando.model.GameInventory;
import hu.unideb.inf.webfejlesztesbeadando.service.GameInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/gameinventory")
public class GameInventoryController {

    private final GameInventoryService gameInventoryService;

    @Autowired
    public GameInventoryController(GameInventoryService gameInventoryService) {
        this.gameInventoryService = gameInventoryService;
    }

    @GetMapping
    public List<GameInventory> getItem(){
        return gameInventoryService.getGameInventory();
    }

    @PostMapping
    public void registerNewItem(@RequestBody GameInventory gameInventory){
        gameInventoryService.addNewItem(gameInventory);
    }

    @DeleteMapping(path ="{itemId}")
    public void deleteItem(@PathVariable("itemId") Long itemId){
        gameInventoryService.deleteItem(itemId);
    }

    @PutMapping(path = "{itemId}")
    public void updateItem(
            @PathVariable("itemId") Long itemId,
            @RequestParam(required = false) String itemName,
            @RequestParam(required = false) Integer rarity,
            @RequestParam(required = false) String itemClass,
            @RequestParam(required = false) Integer count,
            @RequestParam(required = false) Integer level) {
        gameInventoryService.updateInGameHero(itemId, itemName, level, itemClass, count, rarity);
    }
}
