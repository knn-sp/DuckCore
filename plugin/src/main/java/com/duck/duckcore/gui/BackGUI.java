package com.duck.duckcore.gui;

import com.duck.duckcore.Background;
import com.duck.duckcore.Item;
import com.duck.duckcore.utils.InventoryUtils;
import com.duck.duckcore.utils.ItemStackUtils;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public abstract class BackGUI implements GUI {
    private final Background background;
    private final Inventory previousInventory;
    private final Item backButton;

    public BackGUI(Background background, Inventory previousInventory, Item backButton) {
        this.background = background;
        this.backButton = backButton;
        if (previousInventory == null) {
            this.previousInventory = null;
        } else {
            this.previousInventory = previousInventory.getType() == InventoryType.CHEST ? previousInventory : null;
        }
    }

    @Override
    public void addContent(Inventory inventory) {
        InventoryUtils.fillInventory(inventory, background);
        if (previousInventory != null) {
            inventory.setItem(inventory.getSize() + backButton.slot, ItemStackUtils.makeItem(backButton));
        }
    }

    @Override
    public void onInventoryClick(InventoryClickEvent event) {
        if (previousInventory != null && event.getSlot() == (event.getInventory().getSize() + backButton.slot)) {
            event.getWhoClicked().openInventory(previousInventory);
        }
    }
}
