package model;

public record MovieFull (Integer id, String nome, Integer ano){
    @Override
    public String toString() {
        return "MovieFull{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", ano=" + ano +
                '}';
    }
}
