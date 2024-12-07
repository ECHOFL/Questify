package me.fliqq.questify.manager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.fliqq.questify.Questify;
import me.fliqq.questify.object.Quest;

public class QuestManager {
    private final String[] defaultDescription = {"default quest", "description"};

    private final Questify plugin;
    private List<Quest> availableQuests;   
    private final File file;
    private FileConfiguration config;

    public QuestManager(Questify plugin){
        this.plugin=plugin;
        this.availableQuests=new ArrayList<>();
        this.file=new File(plugin.getDataFolder(), "quests.yml");

        generateQuests();
    
    
    }
    private void generateQuests() {
        if(!file.exists()){
            plugin.saveResource("quests.yml", false);
        }
        config= YamlConfiguration.loadConfiguration(file);

        ConfigurationSection questSection = config.getConfigurationSection("quest-types");
        if(questSection == null ) throw new IllegalStateException("No quests defined in quests.yml");

        for(String questTypeId : questSection.getKeys(false)){
            ConfigurationSection questConfig = questSection.getConfigurationSection(questTypeId);
            if(questConfig == null) continue;
            
            String type = questTypeId;
            String name = questConfig.getString("name", questTypeId);
            String[] description = questConfig.getStringList("description").toArray(new String[0]);
            if(description.length ==0) description=defaultDescription;

            Quest quest = new Quest();
            availableQuests.add(quest);
        } 
    }

    public Quest getQuest(String id){
        for(Quest quest : availableQuests){
            if (quest.getId().equals(id)){
                return quest;
            }
        }
        return null;
    }
    public List<Quest> getAllQuests(){
        return availableQuests;
    }


}
