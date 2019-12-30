package dto;

public class AfiliacionResponseDTO
{
    private int total;

    private int correctos;

    private int incorrecto;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCorrectos() {
        return correctos;
    }

    public void setCorrectos(int correctos) {
        this.correctos = correctos;
    }

    public int getIncorrecto() {
        return incorrecto;
    }

    public void setIncorrecto(int incorrecto) {
        this.incorrecto = incorrecto;
    }
}
