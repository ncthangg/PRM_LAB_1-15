package com.example.myapplication.Lab3;

public class Footballer {
    private String Name;
    private String Description;
    private int AvatarUrl;
    private int FlagUrl;

    public Footballer(int avatarUrl, String name, String description, int flagUrl) {
        AvatarUrl = avatarUrl;
        Name = name;
        Description = description;
        FlagUrl = flagUrl;
    }

    public String getName() {
        return Name;
    }

    public void setTen(String name) {
        this.Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getAvatarUrl() { return AvatarUrl; }

    public void setAvatarUrl(String avatarUrl) { AvatarUrl = Integer.parseInt(avatarUrl); }

    public int getFlagUrl() { return FlagUrl; }
    public void setFlagUrl(String flagUrl) { FlagUrl = Integer.parseInt(flagUrl); }
}
