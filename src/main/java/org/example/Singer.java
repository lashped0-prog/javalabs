package org.example;

public class Singer extends Artist {
    private String voiceType;

    public Singer(String name, int age, String genre, String voiceType) {
        super(name, age, genre);
        this.voiceType = voiceType;
    }

    public String getVoiceType() {
        return voiceType;
    }

    public void setVoiceType(String voiceType) {
        this.voiceType = voiceType;
    }

    @Override
    public void perform() {
        System.out.println(getName() + " поет песню (голос: " + voiceType + ")");
    }

    public void singSong() {
        System.out.println(getName() + " исполняет песню в жанре " + getGenre());
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Тип голоса: " + voiceType);
    }
}
