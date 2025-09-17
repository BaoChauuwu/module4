package chaudnb.example.maileco;

public class Mail {
    private String language;
    private int size;
    private String trash;
    private String signature;

    public Mail(String language, int size, String trash, String signature) {
        this.language = language;
        this.size = size;
        this.trash = trash;
        this.signature = signature;
    }

    public Mail() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getTrash() {
        return trash;
    }

    public void setTrash(String trash) {
        this.trash = trash;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "language='" + language + '\'' +
                ", size=" + size +
                ", trash='" + trash + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}
