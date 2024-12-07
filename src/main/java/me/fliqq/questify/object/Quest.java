package me.fliqq.questify.object;

import lombok.Getter;

@Getter
public class Quest {
    private String id;
    private String type;
    private int difficulty;
    private int xpCost;
    private int goal;
}
