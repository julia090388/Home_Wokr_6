import java.util.*;

public class Nout {
    private String модель;
    private int объемОЗУ;
    private int объемЖД;
    private String операционнаяСистема;
    private String цвет;


    public Nout(String модель, int объемОЗУ, int объемЖД, String операционнаяСистема, String цвет) {
        this.модель = модель;
        this.объемОЗУ = объемОЗУ;
        this.объемЖД = объемЖД;
        this.операционнаяСистема = операционнаяСистема;
        this.цвет = цвет;
    }



    public String getМодель() {
        return модель;
    }

    public void setМодель(String модель) {
        this.модель = модель;
    }

    public int getОбъемОЗУ() {
        return объемОЗУ;
    }

    public void setОбъемОЗУ(int объемОЗУ) {
        this.объемОЗУ = объемОЗУ;
    }

    public int getОбъемЖД() {
        return объемЖД;
    }

    public void setОбъемЖД(int объемЖД) {
        this.объемЖД = объемЖД;
    }

    public String getОперационнаяСистема() {
        return операционнаяСистема;
    }

    public void setОперационнаяСистема(String операционнаяСистема) {
        this.операционнаяСистема = операционнаяСистема;
    }

    public String getЦвет() {
        return цвет;
    }

    public void setЦвет(String цвет) {
        this.цвет = цвет;
    }

    static Set<Nout> фильтроватьНоутбуки(Set<Nout> ноутбуки, Map<Integer, Object> критерии) {
        Set<Nout> результаты = new HashSet<>();

        for (Nout ноутбук : ноутбуки) {
            boolean соответствуетКритериям = true;

            for (Map.Entry<Integer, Object> entry : критерии.entrySet()) {
                int критерий = entry.getKey();
                Object значение = entry.getValue();

                switch (критерий) {
                    case 1:
                        if (ноутбук.getОбъемОЗУ() < (int) значение) {
                            соответствуетКритериям = false;
                        }
                        break;

                    case 2:
                        if (ноутбук.getОбъемЖД() < (int) значение) {
                            соответствуетКритериям = false;
                        }
                        break;

                    case 3:
                        if (!ноутбук.getОперационнаяСистема().equals(значение)) {
                            соответствуетКритериям = false;
                        }
                        break;

                    case 4:
                        if (!ноутбук.getЦвет().equals(значение)) {
                            соответствуетКритериям = false;
                        }
                        break;
                }
            }

            if (соответствуетКритериям) {
                результаты.add(ноутбук);
            }
        }

        return результаты;
    }
}