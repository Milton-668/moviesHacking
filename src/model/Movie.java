package model;

public record Movie(Integer id, String nome, String ano/*, String classifica*/) {

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", ano='" + ano + '\'' +
                '}';
    }
}
