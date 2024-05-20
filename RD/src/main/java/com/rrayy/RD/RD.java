package com.rrayy.RD;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class RD extends JavaPlugin implements Listener{
    private int maxdamage = 15;
    public Random random = new Random();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("random damage plugin이 활성화 되었습니다");
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            int damage = random.nextInt(maxdamage);
            e.setDamage(damage);
            Player pl = (Player) e.getEntity();
            pl.sendMessage("방금 "+ChatColor.RED+damage+ChatColor.WHITE+"의 피해를 입으셨습니다");
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("random damage plugin이 비활성화 되었습니다");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if ((sender instanceof Player)){
            maxdamage = Integer.parseInt(args[0]);
            sender.sendMessage("이제 모든 플레이어가 최대 "+maxdamage+"만큼의 데미지를 입습니다.");
        }else sender.sendMessage("해당 명령어는 콘솔에서는 불가능 합니다");
        return false;
    }
}
