import lombok.*;


public class Radio {

    private @Getter  int currentRadioStation;
    private @Getter  int currentVolume;
    private @Getter @Setter int stationAmount;

    public Radio() {
        stationAmount = 10;
    }

    public Radio(int stationAmount) {
        this.stationAmount = stationAmount;
    }

    public void setCurrentRadioStation(int currentRadioStation) {
        if (currentRadioStation < 0) {
            return;
        }
        if (currentRadioStation > stationAmount - 1) {
            return;
        }
        this.currentRadioStation = currentRadioStation;
    }

    public void next() {
        if (currentRadioStation == stationAmount - 1) {
            currentRadioStation = 0;
        } else {
            currentRadioStation++;
        }
    }

    public void prev() {
        if (currentRadioStation == 0) {
            currentRadioStation = stationAmount - 1;
        } else {
            currentRadioStation--;
        }
    }

    public void volumeUp() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    public void volumeDown() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume < 0) {
            currentVolume = 0;
        }
        if (currentVolume > 100) {
            currentVolume = 100;
        }
        this.currentVolume = currentVolume;
    }
}

