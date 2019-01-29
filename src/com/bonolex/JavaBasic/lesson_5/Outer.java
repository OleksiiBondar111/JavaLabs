package com.bonolex.JavaBasic.lesson_5;

class Outer {
    private int outerInt;
    private static int count;

    void printOuter() {
        Inner innerObj = new Inner();
        System.out.println(innerObj.inner);
        innerObj.printInner();

    }

    static class Inner {
        private int inner;

        private void printInner() {
            //System.out.println(outerInt);
            System.out.println(count);
            //printOuter();
        }
    }
}

class Test {
    public static void main(String[] args) {
        Outer outer = new Outer();
        //Outer.Inner inner = outer.new Inner();
        Outer.Inner inner = new Outer.Inner();
        outer.printOuter();
    }
}