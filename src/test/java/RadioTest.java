import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RadioTest {
    @Test
    ///следующая от станции в середине интервала от 0до9
    public void nextRadioStation() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(6);
        radio.next();
        int expected = 7;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    ///следующая за последней станцией
    public void nextForTheLastRadioStation() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(9);
        radio.next();
        int expected = 0;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    ///переключение на предыдущую станцию в интервале от 0-9
    public void prevRadioStation() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(5);
        radio.prev();
        int expected = 4;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    ////переключение на предыдущую станцию от 0 станции
    public void prev0RadioStation() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(0);
        radio.prev();
        int expected = 9;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    ///возможность выставить номер радиостанции через прямое ее указание
    public void shouldSetRadioStation() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(3);
        int expected = 3;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    ///возможность выставить номер радиостанции через прямое ее указание за пределами диапазона радиостанций от 0 до 9
    public void shouldSetTheRadioStationOutOfRange() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(11);
        int expected = 0;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    ///возможность выставить номер радиостанции через прямое ее указание не входящее в диапозон радиостанций от 0 до 9
    public void shouldSetTheRadioStationOutOfRange1() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(-1);
        int expected = 0;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    /// увелечение громкости в пределах от 0 до 100
    public void shouldVolumeUp() {
        Radio radio = new Radio();
        radio.setCurrentVolume(3);
        radio.volumeUp();
        int expected = 4;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    /// увелечение громкости за пределами лимита громкости 100
    public void shouldVolumeUpMoreThanTheLimit() {
        Radio radio = new Radio();
        radio.setCurrentVolume(101);
        radio.volumeUp();
        int expected = 100;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    /// уменьшение громкости ниже лимита громкости 0
    public void shouldVolumeDownBelowTheMinLimit() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-1);
        radio.volumeDown();
        int expected = 0;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    /// уменьшение громкости в пределах от 0 до 100
    public void shouldVolumeDown() {
        Radio radio = new Radio();
        radio.setCurrentVolume(25);
        radio.volumeDown();
        int expected = 24;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }
}