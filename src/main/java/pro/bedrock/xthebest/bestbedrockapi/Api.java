package pro.bedrock.xthebest.bestbedrockapi;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.awt.*;
import java.util.ArrayList;

public class Api {
    public static String gradientMessage(String message, String start, String end) {
        Color startColor = Color.decode(start);
        Color endColor = Color.decode(end);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            double ratio = (double) i / (double) (message.length() - 1);
            int startRed = startColor.getRed();
            int startGreen = startColor.getGreen();
            int startBlue = startColor.getBlue();
            int endRed = endColor.getRed();
            int endGreen = endColor.getGreen();
            int endBlue = endColor.getBlue();
            int r = (int) (startRed * (1 - ratio) + endRed * ratio);
            int g = (int) (startGreen * (1 - ratio) + endGreen * ratio);
            int b = (int) (startBlue * (1 - ratio) + endBlue * ratio);
            ChatColor color = ChatColor.of(new Color(r, g, b));
            builder.append(color).append(c);
        }
        return builder.toString();
    }

    public ItemStack craftItem(Material material, String displayName, ArrayList<String> loreList) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(displayName);
        itemMeta.setLore(loreList);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public ItemStack craftItem(Material material, String displayName, ArrayList<String> loreList, Enchantment enchantment, int lvlEnchant) {

        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName(displayName);
        itemMeta.setLore(loreList);

        itemMeta.addEnchant(enchantment, lvlEnchant, false);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public void sendAllPlayerMessage(String message) {
        for (Player player : Bukkit.getOnlinePlayers()){
            player.sendMessage(message);
        }
    }
}
