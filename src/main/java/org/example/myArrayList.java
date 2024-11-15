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
        String answer = "";
        int currentIndex = size;
        for (int i = 0; i < size; i++) {
            if (elements[i] == null) {
                currentIndex = i;
                break;
            }
        }
        if (index < 0 || index >= size || index > currentIndex) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size; i++) {
            if (i == size) {
                answer = elements[i];
            }
            elements = Arrays.copyOf(elements, elements.length + 1);
            elements[i + 1] = elements[i];
        }
        elements[index] = item;
        return answer;
    }

    @Override
    public String set(int index, String item) throws IllegalAccessException {
        int currentIndex = size;
        for (int i = 0; i < size; i++) {
            if (elements[i] == null) {
                currentIndex = i;
                break;
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
        String answer = "";
        if (elements[size - 1].equals(item)) {
            answer = elements[size - 1];
            elements[size - 1] = null;
            return answer;
        }

        for (int i = 0; i < size; i++) {
            if (elements[i].equals(item)) {
                answer = elements[i];
                for (int j = i + 1; j < size; j++) {
                    elements[j - 1] = elements[j];
//                    elements = Arrays.copyOf(elements, elements.length - 1);
                }
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
                return answer;
            }
        }
        throw new RuntimeException();
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size; i > 0; i--) {
            if (elements[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        int currentIndex = size;
        for (int i = 0; i < size; i++) {
            if (elements[i] == null) {
                currentIndex = i;
                break;
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
            } else {
                return counter;
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
        return elements;
    }
}

