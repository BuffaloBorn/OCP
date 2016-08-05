package OCP;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitaly on 03.08.2016.
 */
public class ObjectStreamSample {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Animal> animals = new ArrayList<Animal>();
        animals.add(new Animal("Tommy Tiger", 5, 'T'));
        animals.add(new Animal("Peter Penguin", 8, 'P'));
        File dataFile = new File("Ch06_JavaIOFundamentals\\src\\main\\java\\OCP\\animal.data");
        createAnimalsFile(animals, dataFile);
        System.out.println(getAnimals(dataFile));
        System.out.format("String %d%n", 5);

    }

    private static List<Animal> getAnimals(File dataFile) throws IOException, ClassNotFoundException {
        List<Animal> animals = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {
            while (true) {
                Object o = null;
                try {
                    o = ois.readObject();
                } catch (EOFException e) {
                    break;
                }
                if (o instanceof Animal) {
                    animals.add((Animal) o);
                }
            }
        }
        return animals;
    }

    private static void createAnimalsFile(List<Animal> animals, File dataFile) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))) {
            for (Animal animal : animals) {
                oos.writeObject(animal);
            }
        }
    }
}
