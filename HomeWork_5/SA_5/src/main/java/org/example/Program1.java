package org.example;

        import java.util.ArrayList;
        import java.util.Random;
        import java.util.Scanner;
        import java.util.Collection;


public class Program1 {

    static Scanner scanner = new Scanner(System.in);
    /**
     * Необходимо разделить на горизонтальные уровни "Редактор 3D графики"
     * Один пользователью Программа работает на одном компьютере без выхода в сеть.
     *
     * Что видит пользователь? Как взаимодействует? (Панель загрузки, блок редактирования, блок просмотра)
     * Какие задачи можно делать - функции системы? (Загрузить 3D модель, рассмотреть 3D модель, создать новую,
     * редактировать вершины, текстуры, сделать рендер, сохранить рендер)
     * Какие и где хранятся данные? (файлы 3D моделей, рендеры, анимация ... в файловой системе компьютера)
     *
     * Предложить варианты связывания всех уровней - сценарии использования 3-4 сценария
     * Сквозная функция - создать новую 3D модель, сделать рендер для печати на принтере.
     *
     * ДЗ
     * 1. Добавить функцию для удаления 3D модели.
     * 2. Добавить функцию для работы с текстурами (добавление и удаление текстур для 3D модели).
     * 3. Добавить функцию для добавления новой 3D модели.
     *
     **/

    public static void main(String[] args) {
        Editor3D editor3d = new Editor3D();
        boolean f = true;
        while (f) {
            System.out.println("*** Мой 3D редактор ***");
            System.out.println("******************");
            System.out.println("1. Открыть проект");
            System.out.println("2. Сохранить проект");
            System.out.println("3. Отобразить параметры проекта");
            System.out.println("4. Отобразить все модели проекта");
            System.out.println("5. Отобразить все текстуры проекта");
            System.out.println("6. Выполнить рендер всех моделей");
            System.out.println("7. Выполнить рендер модели");
            System.out.println("8. Удалить модель");
            System.out.println("9. Добавить новую модель");
            System.out.println("10. Добавить текстуру к модели");
            System.out.println("11. Удалить текстуру из модели");
            System.out.println("12. Завершение работы приложения");
            System.out.print("Пожалуйста, выберите пункт меню");
            if (scanner.hasNextInt()) {
                int no = scanner.nextInt();
                scanner.nextLine();
                try {
                    switch (no) {
                        case 1:
                            System.out.println("Укажите наименование файла проекта: ");
                            String fileName = scanner.nextLine();
                            editor3d.openProject(fileName);
                            System.out.println("Проект успешно открыт. ");
                            break;
                        case 2:
                            editor3d.saveProject();
                            break;
                        case 3:
                            editor3d.showProjectSettings();
                            break;
                        case 4:
                            editor3d.printAllModels();
                            break;
                        case 5:
                            editor3d.printAllTextures();
                            break;
                        case 6:
                            editor3d.renderAll();
                            break;
                        case 7:
                            System.out.println("Укажите номер модели: ");
                            if (scanner.nextInt()) {
                                int modelNo = scanner.nextInt();
                                scanner.nextLine();
                                editor3d.renderModel(modelNo);
                            }
                            else {
                                System.out.println("Номер модели указан некорректно. ");
                            }
                            break;
                        case 8:
                            System.out.println("Введите ID модели для удаления: ");
                            if (scanner.hasNextInt()) {
                                int modelIdToDelete = scanner.nextInt();
                                editor3d.removeModel(modelIdToDelete);
                                System.out.println("Модель удалена.");
                            } else {
                                System.out.println("Некорректный ID модели.");
                            }
                            scanner.nextLine();
                            break;
                        case 9:
                            Model3D newModel = new Model3D();
                            editor3d.addModel(newModel);
                            System.out.println("Новая модель добавлена.");
                            break;
                        case 10:
                            System.out.println("Введите ID модели, к которой хотите добавить текстуру: ");
                            if (scanner.hasNextInt()) {
                                int modelIdForTexture = scanner.nextInt();
                                Texture newTexture = new Texture();
                                editor3d.addTextureToModel(modelIdForTexture, newTexture);
                                System.out.println("Текстура добавлена к модели.");
                            } else {
                                System.out.println("Некорректный ID модели.");
                            }
                            scanner.nextLine();
                            break;
                        case 11:
                            System.out.println("Введите ID модели: ");
                            if (scanner.hasNextInt()) {
                                int modelIdForTextureRemoval = scanner.nextInt();
                                System.out.println("Введите ID текстуры для удаления: ");
                                if (scanner.hasNextInt()) {
                                    int textureIdToRemove = scanner.nextInt();
                                    editor3d.removeTextureFromModel(modelIdForTextureRemoval, textureIdToRemove);
                                    System.out.println("Текстура удалена из модели.");
                                } else {
                                    System.out.println("Некорректный ID текстуры.");
                                }
                            } else {
                                System.out.println("Некорректный ID модели.");
                            }
                            scanner.nextLine();
                            break;
                        case 12:
                            System.out.println("Завершение работы приложения");
                            f = false;
                            break;
                        default:
                            System.out.println("Укажите корректный пункт меню: ");
                    }
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            else {
                System.out.println("Укажите корректный пункт меню: ");
                scanner.nextLine();
            }
        }
    }
}

/**
 * UILayer Interface
 */
class Editor3D implements UILayer{

    private ProjectFile projectFile;
    private BusinessLogicalLayer businessLogicalLayer;
    private DatabaseAccess databaseAccess;
    private Database database;

    private void inizialize(){
        database = new EditorDatabase(projectFile);
        databaseAccess = new EditorDatabaseAccess(database);
        businessLogicalLayer = new EditorBusinessLogicalLayer(databaseAccess);

    }

    @Override
    public void openProject(String fileName) {
        this.projectFile = new ProjectFile(fileName);
        inizialize();
    }

    @Override
    public void showProjectSettings() {

        // Предусловие
        checkProjectFile();

        System.out.println("*** Project v1 ***");
        System.out.println("******************");
        System.out.printf("fileName: %s\n", projectFile.getFileName());
        System.out.printf("setting1: %d\n", projectFile.getSetting1());
        System.out.printf("setting2: %s\n", projectFile.getSetting2());
        System.out.printf("setting3: %s\n", projectFile.getSetting3());
        System.out.println("*******************");

    }

    private void checkProjectFile(){
        if (projectFile == null)
            throw new RuntimeException("Файл проекта не определен.");

    }


    @Override
    public void saveProject(){
        database.save();
        System.out.println("Изменения успешно сохранены");
    }

    @Override
    public void printAllModels(){

        // Предусловие
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>)businessLogicalLayer.getAllModels();
        for (int i = 0; i < models.size(); i++){
            System.out.println("===%d+++\n", i);
            System.out.println(models.get(i));
            for (Texture texture: models.get(i).getTextures()){
                System.out.printf("\t%s\n",texture);
            }
        }
    }

    @Override
    public void printAllTextures(){
        // Предусловие
        checkProjectFile();

        ArrayList<Texture> models = (ArrayList<Texture>)businessLogicalLayer.getAllTextures();
        for (int i = 0; i < textures.size(); i++){
            System.out.println("===%d+++\n", i);
            System.out.println(textures.get(i));
        }
    }

    @Override
    public void renderAll(){
        // Предусловие
        checkProjectFile();

        System.out.println("Подождите...");
        long StartTime = System.currentTimeMillis();
        businessLogicalLayer.renderAllModels();
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Операция выполнена за %d мс.\n",endTime);
    }

    @Override
    public void renderModel(int i){
        // Предусловие
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>)businessLogicalLayer.getAllModels();
        if ( i < 0 || i > models.size() - 1) {
            throw new RuntimeException ("Номер модели указан некорректно");
            System.out.println("Подождите...");
            long StartTime = System.currentTimeMillis();
            businessLogicalLayer.renderModel(models.get(i));
            long endTime = (System.currentTimeMillis() - startTime);
            System.out.printf("Операция выполнена за %d мс.\n",endTime);
        }
    }

    /**
     * Интерфейс UI
     */

    interface UILayer{

        void openProject(String fileName);
        void showProjectSettings();
        void saveProject();
        void printAllModels();
        void printAllTextures();
        void renderAll();
        void renderModel(int i);
    }

    /**
     *  Реализация Business Logical Layer
     */
    class EditorBusinessLogicalLayer implements BusinessLogicalLayer {

        private DatabaseAccess databaseAccess;

        public EditorBusinessLogicalLayer(DatabaseAccess databaseAccess) {
            this.databaseAccess = databaseAccess;
        }

        @Override
        public Collection<Model3D> getAllModels() {
            return databaseAccess.getAllModels();
        }

        @Override
        public Collection<Texture> getAllTextures() {
            return databaseAccess.getAllTextures();
        }


        @Override
        public void renderModel(Model3D model) {
            processRender(model);
        }

        @Override
        public void renderAllModels() {
            for (Model3D model: getAllModels())
                processRender(model);
        }

        private Random random = new Random();

        private void processRender(Model3D model) {
            try
            {
                Thread.sleep(2500 - random.nextInt(2000));
            }
            catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }

        }

        // Новые методы для работы с моделями и текстурами

        // Удаление модели
        @Override
        public void removeModel(int modelId) {
            Model3D modelToRemove = null;
            for (Model3D model : getAllModels()) {
                if (model.getId() == modelId) {
                    modelToRemove = model;
                    break;
                }
            }
            if (modelToRemove != null) {
                databaseAccess.removeEntity(modelToRemove);
                System.out.println("Модель удалена успешно.");
            } else {
                System.out.println("Модель с указанным ID не найдена.");
            }
        }

        // Добавление модели
        @Override
        public void addModel(Model3D model) {
            databaseAccess.addEntity(model);
            System.out.println("Новая 3D модель добавлена.");
        }

        // Добавление текстуры к модели
        @Override
        public void addTextureToModel(int modelId, Texture texture) {
            for (Model3D model : getAllModels()) {
                if (model.getId() == modelId) {
                    model.addTexture(texture);
                    break;
                }
            }
        }

        // Удаление текстуры из модели
        @Override
        public void removeTextureFromModel(int modelId, int textureId) {
            for (Model3D model : getAllModels()) {
                if (model.getId() == modelId) {
                    model.removeTexture(textureId);
                    break;
                }
            }
        }

    }

    /**
     * Интерфейс BLL
     */
    interface BusinessLogicalLayer {
        Collection<Model3D> getAllModels();

        Collection<Texture> getAllTextures();

        void renderModel(Model3D model);

        void renderAllModels();
    }

    /**
     * Реализация DAC
     */
    class EditorDatabaseAccess implements DatabaseAccess{

        private final DataBase editorDatabase;

        public EditorDatabaseAccess(DataBase editorDatabase) {
            this.editorDatabase = editorDatabase;
        }

        @Override
        public Collection<Model3D> getAllModels() {
            Collection<Model3D> models = new ArrayList<>();
            for (Entity entity: editorDatabase.getAll()) {
                if (entity instanceof Model3D)
                {
                    models.add((Model3D)entity);
                }
            }
            return models;
        }
        @Override
        public Collection<Texture> getAllTextures() {
            Collection<Texture> models = new ArrayList<>();
            for (Entity entity: editorDatabase.getAll()) {
                if (entity instanceof Texture)
                {
                    models.add((Texture)entity);
                }
            }
            return models;
        }

        @Override
        public void addEntity(Entity entity) {
            editorDatabase.getAll().add(entity);
        }

        @Override
        public void removeEntitt(Entity entity) {
            editorDatabase.getAll().remove(entity);
        }



    }

    /**
     * Интерфейс DAC
     */
    interface DatabaseAccess{
        void addEntity(Entity entity);
        void removeEntitt(Entity entity);
        Collection<Texture> getAllTextures();
        Collection<Model3D> getAllModels();
    }

    /**
     * Database
     */

    class EditorDatabase implements Database{

        private Random random = new Random();
        private final ProjectFile projectFile;
        private Collection<Entity> entities;

        public EditorDatabase(ProjectFile projectFile) {
            this.projectFile = projectFile;
            load();
        }

        @Override
        public void load() {
            //TODO: Загрузка всех сущностей проекта (модели, текстура и т.д.)
        }

        @Override
        public void save() {
            //TODO: Сохранение текущего состояния всех сущностей проекта
        }


        public Collection<Entity> getAll(){
            if (entities == null) {
                entities = new ArrayList<>();
                int entCount = random.nextInt(5, 11);
                for (int i = 0; 1 < entCount; i++) {
                    generateModelAndTextures();
                }
            }
            return entities;
        }

        private void generateModelAndTextures(){
            Model3D model3d = new Model3D();
            int txCount = random.nextInt(3);
            for (int i = 0; 1 < txCount; i++) {
                Texture texture = new Texture();
                model3D.getTextures().add(texture);
                entities.add();
            }
            entities.add(model3d);
        }
    }

    /**
     * Интерфейс БД
     */
    interface Database{
        void load();

        void save();

        Collection<Entity> getAll();

    }


    /**
     * 3D Model
     */
    class Model3D implements Entity{

        private static int counter = 10000;
        private int id;

        private Collection<Texture> textures = new ArrayList<>();

        @Override
        public int getId() {
            return id;
        }

        {
            id = ++counter;
        }

        public Model3D(){

        }

        public Model3D(Collection<Texture> textures) {
            this.textures = textures;
        }

        public Collection<Texture> getTextures() {
            return textures;
        }

        @Override
        public String toString() {
            return String.format("3DModel #%s", id);
        }

    }

    /**
     * Текстура
     */
    class Texture implements Entity{

        private static int counter = 50000;

        private int id;

        {
            id = ++counter;
        }

        @Override
        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return String.format("Texture #%s", id);
        }
    }



    /**
     * Сущность
     */
    interface Entity{

        int getId();
    }

    /**
     * Файл проекта
     */
    class ProjectFile{

        private String fileName;
        private int setting1;
        private String setting2;
        private boolean setting3;

        public ProjectFile(String fileName) {

            this.fileName = fileName;
            //TODO: Загрузка настроек проекта из файла

            setting1 = 1;
            setting2 = "...";
            setting3 = false;
        }

        public String getFileName(){
            return fileName;
        }

        public int getSetting1() {
            return setting1;
        }

        public String getSetting2() {
            return setting2;
        }

        public boolean getSetting3() {
            return setting3;
        }

    }

}