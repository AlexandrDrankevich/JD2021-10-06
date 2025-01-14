package by.it.ithoitan.jd01_08;

class Runner {
    private static void print(Var var) {
        if (var != null) ;
        System.out.println(var);
    }

    public static void main(String[] args) {
        Var s = new Scalar(3.0);
        Var s2 = new Scalar(4);
        Var v2 = new Vector(new double[]{1, 3});
        Var v3 = new Vector(new double[]{1, 2, 3});
        Var v = new Vector(new double[]{1, 2, 3}); // закомментируйте вектор и/или
        Var m = new Matrix("{{1,2,3}, {4,5,6}, {7,8,9}}");// матрицу, если вы их не реализовали
        Var n1 = new Matrix("{{1,2}, {3,4}}");
        Var n2 = new Matrix("{{4,5}, {7,8}}");
        /* Уровень сложности A (калькулятор) */
        print(s.add(s)); //выведет в консоль 6.0
        print(s.sub(s)); //выведет в консоль 0.0
        print(s.mul(s)); //выведет в консоль 9.0
        print(s.div(s)); //выведет в консоль 1.0
        /* Уровень сложности B (векторные операции) закомментируйте, если не реализовали */
        print(v.add(v));//выведет в консоль {2.0, 4.0, 6.0}
        print(v2.add(v3));
        print(v.mul(s));
        print(v.sub(v)); //выведет в консоль {0.0, 0.0, 0.0}
        print(v.mul(v)); //выведет в консоль 14.0
        print(v.div(v)); //сообщит о невозможности операции
        print(v.div(s));
/* Уровень сложности C (матричные операции и умножение на вектор)
закомментируйте, если не реализовали */
        print(m.add(m)); //{{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}}
        print(n1.add(n2));
        print(m.sub(m)); //{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}}
        print(m.mul(m)); //{{30.0, 36.0, 42.0}, {66.0, 81.0, 96.0}, {102.0, 126.0, 150.0}}
        print(m.mul(v)); //{14.0, 32.0, 50.0}
    }
}
