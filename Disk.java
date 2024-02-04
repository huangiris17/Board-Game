public class Disk {
    private char color;

    public Disk(char color) {
        this.color = color;
    }

    public char getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        return Character.toString(this.color);
    }
}