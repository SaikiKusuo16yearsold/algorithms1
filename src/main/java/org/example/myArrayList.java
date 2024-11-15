package org.example;

import java.util.Arrays;

public class myArrayList implements StringList {
    private int size;
    public String[] elements;


    public myArrayList(int size) {
        this.size = size;
        this.elements = new String[size];
    }


    @Override
    public String[] add(String item) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == null) {
                elements[i] = item;
                return elements;
            }
        }
        elements = Arrays.copyOf(elements, elements.length + 1);
        size++;
        elements[elements.length - 1] = item;
        return elements;
    }

    @Override
    public String add(int index, String item) {
        int currentIndex = 0;
        for (int i = 0; i < size; i++) {
            if (elements[i] != null) {
                currentIndex += 1;
            }
        }
        if (index < 0 || index >= size || index > currentIndex) {
            throw new IndexOutOfBoundsException();
        }
        if (currentIndex == size-1) {
            elements = Arrays.copyOf(elements, elements.length + 1);
        }
        for (int i = size-1; i > index; i--) {
            elements[i] = elements[i-1];
//            elements[i + 1] = elements[i];
        }
        elements[index] = item;
        return item;
    }

    @Override
    public String set(int index, String item) throws IllegalAccessException {
        int currentIndex = 0;
        for (int i = 0; i < size; i++) {
            if (elements[i] != null) {
                currentIndex += 1;
            }
        }
        if (index >= 0 && index < size && currentIndex != -1 && currentIndex > index) {
            elements[index] = item;
            return elements[index] = item;
        }
        throw new IllegalAccessException("yt ghfdbkmyj");
    }

    @Override
    public String remove(String item) {
        int currentIndex = size;
        for (int i = 0; i < size; i++) {
            if (elements[i] == item) {
                currentIndex = i;
                break;
            }
        }
        if (currentIndex == size - 1) {
            String answer = elements[currentIndex];
            elements[size - 1] = null;
            return answer;
        }
        String answer = "";
        for (int i = 0; i < size; i++) {
            if (i == currentIndex) {
                answer = elements[i];
                for (int j = i + 1; j < size; j++) {
                    elements[j - 1] = elements[j];
                }
                elements[size - 1] = null;
                return answer;
            }
        }
        throw new RuntimeException();


    }

    @Override
    public String remove(int index) {
        if (index == size - 1) {
            String answer = elements[index];
            elements[size - 1] = null;
            return answer;
        }
        String answer = "";
        for (int i = 0; i < size; i++) {
            if (i == index) {
                answer = elements[i];
                for (int j = i + 1; j < size; j++) {
                    elements[j - 1] = elements[j];
                }
                elements[size - 1] = null;
                return answer;
            }
        }
        throw new RuntimeException();
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == null) {
                continue;
            }
            if (elements[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (elements[i] != null && elements[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i > 0; i--) {
            if (elements[i] != null && elements[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        int currentIndex = 0;
        for (int i = 0; i < size; i++) {
            if (elements[i] != null) {
                currentIndex += 1;
//                break;
            }
        }
        if (index >= 0 && index < size && index < currentIndex) {
            return elements[index];
        } else {
            throw new RuntimeException();
        }
    }


    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new NullPointerException();
        }
        if (otherList instanceof myArrayList) {
            for (int i = 0; i < size; i++) {
                if (elements[i].equals(otherList.get(i))) {
                    return true;
                }
            }
            return false;
        }
        return false;

    }

    @Override
    public int size() {
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (elements[i] != null) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public boolean isEmpty() {
        boolean empty = true;
        for (int i = 0; i < size; i++) {
            if (elements[i] != null) {
                empty = false;
                return empty;
            }
        }
        return empty;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(elements, size); // Возвращаем копию массива
    }

}

