package com.rrayy.RD;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class RD extends JavaPlugin implements Listener{
    public Random random = new Random();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("random damage plugin이 활성화 되었습니다");
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            int damage = random.nextInt(18);
            e.setDamage(damage);
            Player pl = (Player) e.getEntity();
            pl.sendMessage("방금 "+ChatColor.RED+damage+ChatColor.WHITE+"의 피해를 입으셨습니다");
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("random damage plugin이 비활성화 되었습니다");
    }

    /*@Override
    public boolean onCommand( CommandSender sender, Command command, String label, String[] args) {
        if ((sender instanceof Player)){
            Player pl = (Player) sender;
            if (!(haskit.containsKey(pl.getUniqueId().toString()))){
                kitselector.itemSelector(pl);
            } else sender.sendMessage("이미 아이템을 지급 받았습니다!");
            return true;
        }else sender.sendMessage("해당 명령어는 콘솔에서는 불가능 합니다");
        return false;
    }*/
}
