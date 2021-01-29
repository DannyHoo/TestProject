package com.code.algorithm.interview;

/**
 *
 */
public class mainTest {
    public static void main(String[] args) {
        System.out.println("你好");
        ArrayDictionary arrayDictionary = getArrayDictionary();
        //转化成字符串打印
        String json = arrayDictionary.store();
        System.out.println(json);
        //转化成对象
        ArrayDictionary ad = arrayDictionary.load(json);
        System.out.println(ad.store());

       /* //构建树
        Node node =  getTree();
        //修剪树
        node.sweepNode(node);
        //打印树
        node.output();*/


    }


    private static ArrayDictionary getArrayDictionary() {
        ArrayDictionary arrayDictionary = new ArrayDictionary<String, String>(3);
        arrayDictionary.put(0, "\\\\t1", "\\[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]");
        arrayDictionary.put(0, "=\n;", "v11");
        arrayDictionary.put(1, "k;;;@@;;;2", "I\"love\"working!");
        arrayDictionary.put(1, "k22", "v2 2");
        arrayDictionary.put(2, "k3", "v3");
        arrayDictionary.put(2, "k33", "v33");
        System.out.println("初始化完成");
        return arrayDictionary;
    }


    /*private static Node getTree() {
        Node n1 = new Node("N1");
        Node n2 = new Node("N2");
        Node n3 = new Node("N3");
        Node n4 = new Node("N4");
        Node n5 = new Node("N5");
        Node n6 = new Node("N6");
        Node n7 = new Node("N7");
        Node n8 = new Node("N8");
        Node n9 = new Node("N9");
        Node n10 = new Node("N10");
        Node n11 = new Node("N11");
        Node n12 = new Node("N12");
        n1.getLeafList().add(n2);
        n1.getLeafList().add(n3);
        n1.getLeafList().add(n4);
        n2.getLeafList().add(n5);
        n2.getLeafList().add(n6);
        n3.getLeafList().add(n7);
        n7.getLeafList().add(n9);
        n9.getLeafList().add(n12);
        n4.getLeafList().add(n8);
        n8.getLeafList().add(n10);
        n8.getLeafList().add(n11);

        n12.setFather(n9);
        n9.setFather(n7);
        n7.setFather(n3);
        n3.setFather(n1);

        n5.setFather(n2);
        n6.setFather(n2);
        n2.setFather(n1);

        n10.setFather(n8);
        n11.setFather(n8);

        n8.setFather(n4);
        n4.setFather(n1);

        return n1;

    }*/

    /*public static void shellSort(int[] arr) {
        //希尔排序的增量
        for (int step = arr.length / 2; step > 0; step /= 2) {
            //对一个步长区间进行比较 [step,arr.length)
            for (int i = step; i < arr.length; i++) {
                int value = arr[i];
                int j;
                //对步长区间中具体的元素进行比较
                for (j = i - step; j >= 0 && arr[j] > value; j -= step) {
                    //j为左区间的取值，j+step为右区间与左区间的对应值。
                    arr[j + step] = arr[j];
                }
                //此时step为一个负数，[j + step]为左区间上的初始交换值
                arr[j + step] = value;
            }
        }
    }*/
}
