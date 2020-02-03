package domain;


public class DatabaseAdapter implements SaveLoad {

    private SaveLoad DBController;

    public DatabaseAdapter(SaveLoad DBController) {
        this.DBController=DBController;
    }

    @Override
    public void saveGame(String fileName) {
        DBController.saveGame(fileName);

    }

    @Override
    public void loadGame(String fileName) {
        DBController.loadGame(fileName);

    }
}
