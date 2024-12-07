package me.fliqq.questify;

import org.bukkit.plugin.java.JavaPlugin;

public class Questify extends JavaPlugin
{
    @Override
    public void onEnable(){
        messages();
    }
        
    private void messages() {
        getLogger().info("***********");
        getLogger().info("Questify 1.0 enabled");
        getLogger().info("Plugin by Fliqqq");
        getLogger().info("***********");
    }
}
