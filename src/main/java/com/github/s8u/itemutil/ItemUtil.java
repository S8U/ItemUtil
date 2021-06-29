package com.github.s8u.itemutil;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemUtil {

    public static Material getMaterial(int typeId) {
        for (Material material : Material.values()) {
            if (material.getId() == typeId) return material;
        }

        return null;
    }

    public static ItemStack getItemStack(int typeId) {
        for (Material material : Material.values()) {
            if (material.getId() == typeId) return new ItemStack(material);
        }

        return null;
    }

    public static ItemStack getItemStack(String itemCode) {
        if (!itemCode.contains(":")) {
            return getItemStack(Integer.parseInt(itemCode));
        }

        String[] split = itemCode.split(":");

        int typeId = Integer.parseInt(split[0]);
        short durability = Short.parseShort(split[1]);

        ItemStack item = getItemStack(typeId);
        item.setDurability(durability);

        return item;
    }

    public static String getItemCode(ItemStack item) {
        if (item.getDurability() == 0) {
            return String.valueOf(item.getType().getId());
        } else {
            return item.getType().getId() + ":" + item.getDurability();
        }
    }

    public static ItemStack getSkull(String playerName) {
        ItemStack item = new ItemBuilder(397).durability((short) 3).build();

        ItemMeta meta = item.getItemMeta();
        ((SkullMeta) meta).setOwner(playerName);
        item.setItemMeta(meta);

        return item;
    }

}
