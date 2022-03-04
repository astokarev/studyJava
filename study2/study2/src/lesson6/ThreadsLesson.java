package lesson6;

import java.util.Arrays;

public class ThreadsLesson {

    public static void main(String[] args) {
        firstMethod();
        secondMethod();
    }

    public static void firstMethod() {
        int size = 10_000;
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    public static void secondMethod() {
        int size = 10_000;
        int half = size / 2;
        float[] arr = new float[size];

        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        float[] leftHalf = new float[half];
        float[] rightHalf = new float[half];
        float[] mergedArray = new float[size];

        System.arraycopy(arr, 0, leftHalf, 0, half);
        System.arraycopy(arr, half, rightHalf, 0, half);

        Thread leftCalc = new Thread(()->{
            for (int i = 0; i< half; i++) {
                leftHalf[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        leftCalc.start();
        Thread rightCalc = new Thread(()->{
            for (int i = 0; i< half; i++) {
                rightHalf[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
       rightCalc.start();


        System.arraycopy(leftHalf, 0 , mergedArray, 0, half);
        System.arraycopy(rightHalf, 0 , mergedArray, 0, half);
        // Запускает два потока и параллельно просчитываем каждый малый массив
        // ...
        // Склеиваем малые массивы обратно в один большой
        // ...
        System.out.println("Two thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }
}
