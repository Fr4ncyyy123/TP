package test.tp;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import test.tp.Commands.TPHere;
import test.tp.Commands.Teleport;

public final class TP extends JavaPlugin {
    public boolean TPA_Variabile;
    private static Player firstCommandSender;
    public String player;

    @Override
    public void onEnable() {
        System.out.println("Plugin TP Abilitato");
        this.getCommand("tp").setExecutor(new Teleport());
        this.getCommand("tphere").setExecutor(new TPHere());
    }

    @Override
    public void onDisable() {
        System.out.println("Plugin TP Disabilitato");
    }
}
