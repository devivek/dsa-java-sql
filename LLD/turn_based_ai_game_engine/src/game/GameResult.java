package game;

public class GameResult {
    private Boolean isOver;

    public GameResult(Boolean isOver) {
        this.isOver = isOver;
    }

    public Boolean getIsOver() {
        return isOver;
    }

    public void setIsOver(Boolean over) {
        isOver = over;
    }
}
